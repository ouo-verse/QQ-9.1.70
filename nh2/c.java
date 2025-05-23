package nh2;

import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface c {
    oh2.b a();

    oh2.a b();

    void c(AppRuntime appRuntime, com.tencent.mobileqq.qqgift.sdk.config.a aVar);

    ph2.a d();

    void destroy();

    oh2.c e();

    IQQGiftRechargeModule f();

    IQQGiftCountDownModule g();

    AppRuntime getAppRuntime();

    a getExtModule(String str);

    com.tencent.mobileqq.qqgift.sdk.config.a getSDKConfig();

    boolean isDestroyed();

    boolean isInited();
}
