package com.tencent.gdtad.views.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoReportListenerImp implements GdtVideoReportListener {
    private static final String TAG = "GdtVideoStatistics";
    private int playScene;
    private long startPositionMillis = -1;

    public GdtVideoReportListenerImp(int i3) {
        this.playScene = i3;
    }

    private void report(@Nullable GdtVideoData gdtVideoData, long j3, @NonNull GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo) {
        boolean z16;
        if (gdtVideoData == null) {
            GdtLog.e(TAG, "return data == null error");
            return;
        }
        if (!gdtVideoReportInfo.isErrorInfo()) {
            long j16 = this.startPositionMillis;
            if (j16 != -1 && j3 != 0) {
                if (j16 > j3) {
                    GdtLog.e(TAG, "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
                    this.startPositionMillis = 0L;
                }
            } else {
                GdtLog.e(TAG, "return startPositionMillis =-1");
                return;
            }
        } else if (this.startPositionMillis == -1) {
            this.startPositionMillis = 0L;
        }
        GdtLog.i(TAG, "report start:" + this.startPositionMillis + " end:" + j3);
        GdtAd ad5 = gdtVideoData.getAd();
        long j17 = this.startPositionMillis;
        if (j3 == gdtVideoData.getDurationMillis()) {
            z16 = true;
        } else {
            z16 = false;
        }
        GdtImpressionReporter.report(ad5, j17, j3, z16, this.playScene, gdtVideoReportInfo);
        gdtVideoReportInfo.resetFinishType();
        gdtVideoReportInfo.resetErrorType();
        this.startPositionMillis = -1L;
    }

    private void reportError(GdtVideoData gdtVideoData, long j3, @NonNull GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo) {
        report(gdtVideoData, j3, gdtVideoReportInfo);
    }

    private void reportSuccess(GdtVideoData gdtVideoData, long j3, @NonNull GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo) {
        gdtVideoReportInfo.resetErrorType();
        report(gdtVideoData, j3, gdtVideoReportInfo);
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoReportListener
    public void onCompleted(@Nullable GdtVideoData gdtVideoData, @NonNull GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo) {
        GdtLog.i(TAG, "onCompleted start:" + this.startPositionMillis);
        if (gdtVideoData == null) {
            return;
        }
        reportSuccess(gdtVideoData, gdtVideoData.getDurationMillis(), gdtVideoReportInfo);
        if (gdtVideoData.isLoop()) {
            gdtVideoReportInfo.setPlayType(14);
        } else {
            gdtVideoReportInfo.setPlayType(13);
        }
        if (gdtVideoData.isLoop()) {
            this.startPositionMillis = 0L;
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoReportListener
    public void onError(GdtVideoData gdtVideoData, long j3, @NonNull GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo) {
        GdtLog.i(TAG, "onError");
        reportError(gdtVideoData, j3, gdtVideoReportInfo);
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoReportListener
    public void onStarted(GdtVideoData gdtVideoData, long j3) {
        if (this.startPositionMillis <= 0) {
            this.startPositionMillis = j3;
        }
        GdtLog.i(TAG, "onStarted start:" + this.startPositionMillis);
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoReportListener
    public void onStopped(GdtVideoData gdtVideoData, long j3, @NonNull GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo) {
        GdtLog.i(TAG, "onStopped start:" + this.startPositionMillis + " end:" + j3);
        reportSuccess(gdtVideoData, j3, gdtVideoReportInfo);
        this.startPositionMillis = j3;
    }
}
