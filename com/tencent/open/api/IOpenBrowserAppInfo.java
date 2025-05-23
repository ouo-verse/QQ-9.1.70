package com.tencent.open.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IOpenBrowserAppInfo extends QRouteApi {
    @NonNull
    String getBrowserAppPackage(AppRuntime appRuntime, String str);

    @NonNull
    String getBrowserAppSign(AppRuntime appRuntime, String str);
}
