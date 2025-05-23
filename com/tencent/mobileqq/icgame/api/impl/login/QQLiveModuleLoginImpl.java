package com.tencent.mobileqq.icgame.api.impl.login;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import r32.b;
import w22.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveModuleLoginImpl implements IQQLiveModuleLogin {
    private final b loginLogic = new b();

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.loginLogic.destroy();
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public LoginInfo getLoginInfo() {
        return this.loginLogic.getLoginInfo();
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public LoginRequest getLoginRequest() {
        return this.loginLogic.getLoginRequest();
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public int getLoginStatus() {
        return this.loginLogic.getLoginStatus();
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public LiveUserInfo getUserInfo() {
        return this.loginLogic.getUserInfo();
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.loginLogic.init(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public boolean isLogined() {
        return this.loginLogic.isLogined();
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public void login(LoginRequest loginRequest, a aVar) {
        this.loginLogic.login(loginRequest, aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public void registerLoginStateCallback(a aVar) {
        this.loginLogic.registerLoginStateCallback(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        this.loginLogic.reset();
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public void unregisterLoginStateCallback(a aVar) {
        this.loginLogic.unregisterLoginStateCallback(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public void updateUserInfo(LiveUserInfo liveUserInfo) {
        this.loginLogic.updateUserInfo(liveUserInfo);
    }
}
