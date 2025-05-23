package com.tencent.mobileqq.login.api;

import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILoginReporter extends QRouteApi {
    @LoginReportConstants.LoginScene
    int getLoginEntranceForReport();

    String getLoginUinForReport();

    void reportLoginDevLockVerify(DevlockInfo devlockInfo);

    void reportLoginDevLockVerifyEnd(boolean z16);

    void reportLoginFinish(boolean z16, String str);

    void reportLoginPageExposure(@LoginReportConstants.LoginScene int i3, int i16);

    void reportLoginPuzzleVerify();

    void reportLoginShowMsgTab();

    void reportLoginStart(@LoginReportConstants.LoginScene int i3, int i16, String str);

    void reportWechatLoginBinding();
}
