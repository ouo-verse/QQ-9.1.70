package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.LoginResult;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILoginFailedCommonSceneHandlerApi extends QRouteApi {
    boolean handleLoginErrorInfo(QBaseActivity qBaseActivity, byte[] bArr, h hVar);

    boolean handleNTLoginErrorInfo(QBaseActivity qBaseActivity, LoginResult loginResult, h hVar);

    void reportLoginSuccess(AppRuntime appRuntime, Object obj, String str);

    void reportWebNotifyFinishVerify(AppRuntime appRuntime, Object obj, String str);
}
