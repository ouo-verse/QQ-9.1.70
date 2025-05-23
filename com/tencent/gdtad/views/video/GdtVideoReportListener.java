package com.tencent.gdtad.views.video;

import com.tencent.gdtad.statistics.GdtImpressionReporter;

/* compiled from: P */
/* loaded from: classes6.dex */
interface GdtVideoReportListener {
    void onCompleted(GdtVideoData gdtVideoData, GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo);

    void onError(GdtVideoData gdtVideoData, long j3, GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo);

    void onStarted(GdtVideoData gdtVideoData, long j3);

    void onStopped(GdtVideoData gdtVideoData, long j3, GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo);
}
