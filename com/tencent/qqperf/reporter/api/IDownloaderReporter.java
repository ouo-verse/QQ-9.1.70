package com.tencent.qqperf.reporter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IDownloaderReporter extends QRouteApi {
    void downloaderReport(String str, String str2);

    void downloaderReport(String str, String str2, long j3);
}
