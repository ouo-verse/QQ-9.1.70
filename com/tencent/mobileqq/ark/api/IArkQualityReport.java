package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkQualityReport extends QRouteApi {
    void reportAppSSOResult(AppRuntime appRuntime, String str, String str2, boolean z16, int i3);

    void reportScriptError(AppRuntime appRuntime, String str, String str2);
}
