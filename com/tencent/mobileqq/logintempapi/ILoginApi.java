package com.tencent.mobileqq.logintempapi;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import f72.b;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILoginApi extends QRouteApi {
    void checkA1Error(Activity activity, AppRuntime appRuntime, String str, String str2, String str3, b bVar);

    Object getFaceBitmap(AppRuntime appRuntime, String str, byte b16, boolean z16, boolean z17);

    boolean handleLoginFailedByThirdPartyLogin(QBaseActivity qBaseActivity, byte[] bArr, String str, String str2);

    boolean handleNTLoginFailByThirdPartyLogin(QBaseActivity qBaseActivity, int i3, String str, String str2);

    void preloadThirdService();

    void reportWtUpgrade();
}
