package com.tencent.mobileqq.qqlive.api.login;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveModuleLogin extends IQQLiveModule {
    LoginInfo getLoginInfo();

    LoginRequest getLoginRequest();

    int getLoginStatus();

    LiveUserInfo getUserInfo();

    boolean isLogined();

    void login(LoginRequest loginRequest, IQQLiveLoginCallback iQQLiveLoginCallback);

    void reLogin(LoginRequest loginRequest, IQQLiveLoginCallback iQQLiveLoginCallback);

    void registerLoginStateCallback(IQQLiveLoginCallback iQQLiveLoginCallback);

    void unregisterLoginStateCallback(IQQLiveLoginCallback iQQLiveLoginCallback);
}
