package com.tencent.mobileqq.mini.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameService extends QRouteApi {
    @Nullable
    String getCrashReportExtAppId();

    @Nullable
    Integer getCrashReportExtState();
}
