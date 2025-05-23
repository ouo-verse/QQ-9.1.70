package com.tencent.mobileqq.mini.api.report;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniReport extends QRouteApi {
    void doCrashReport(@NonNull String str, @NonNull String str2, String str3, boolean z16, String str4, String str5, String str6, int i3, long j3);

    String getCrashReportAppInfo();
}
