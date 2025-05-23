package com.tencent.qqperf.reporter.api.impl;

import com.tencent.qqperf.reporter.api.IDownloaderReporter;
import com.tencent.qqperf.reporter.flow.a;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DownloaderReporterImpl implements IDownloaderReporter {
    @Override // com.tencent.qqperf.reporter.api.IDownloaderReporter
    public void downloaderReport(String str, String str2) {
        a.a(str, str2);
    }

    @Override // com.tencent.qqperf.reporter.api.IDownloaderReporter
    public void downloaderReport(String str, String str2, long j3) {
        a.b(str, str2, j3);
    }
}
