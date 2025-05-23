package com.tencent.mobileqq.icgame.api.login;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import w22.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveModuleLogin extends IQQLiveModule {
    LoginInfo getLoginInfo();

    LoginRequest getLoginRequest();

    int getLoginStatus();

    LiveUserInfo getUserInfo();

    boolean isLogined();

    void login(LoginRequest loginRequest, a aVar);

    void registerLoginStateCallback(a aVar);

    void unregisterLoginStateCallback(a aVar);

    void updateUserInfo(LiveUserInfo liveUserInfo);
}
