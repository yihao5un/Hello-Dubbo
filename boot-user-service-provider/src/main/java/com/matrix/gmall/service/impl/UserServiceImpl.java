package com.matrix.gmall.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.matrix.gmall.bean.UserAddress;
import com.matrix.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * 只写实现类就可以 接口在gmall-interface中 pom中导入gmall-interface
 *
 * @author yihaosun
 */
// 注意这个注解是Dubbo的注解 -> 暴露的服务
@Service
@Component
public class UserServiceImpl implements UserService {

    @HystrixCommand // 处理容错异常
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl.....1...");
        // TODO Auto-generated method stub
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-1111111", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-2222222", "N");
		/*try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return Arrays.asList(address1, address2);
    }
}
