package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppRuntime;

/* compiled from: P */
@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IAccountApi extends QRouteApi {
    void checkAccountIdentity(AppRuntime appRuntime, int i3, com.tencent.mobileqq.identification.a aVar, f fVar);

    void clearAccountIdentityStatus(String str);

    boolean isIdentityFirstInit();

    void onAccountLoginOrSwitch();

    void onActivityDestroy(Activity activity);

    void onActivityResume(Activity activity);

    void onBackgroundSwitch();

    void onConversationResume();

    void onForegroundSwitch();

    void onPreloadEveryLogin();

    void release();

    void setForegroundANRBugfixSwitch(boolean z16);
}
