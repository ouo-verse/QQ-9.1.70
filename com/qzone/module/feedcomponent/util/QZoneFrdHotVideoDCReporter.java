package com.qzone.module.feedcomponent.util;

import com.qzone.proxy.feedcomponent.model.CircleReportData;
import com.qzone.proxy.feedcomponent.model.ParsedFeedData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J.\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007J6\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/module/feedcomponent/util/QZoneFrdHotVideoDCReporter;", "", "Lcom/qzone/proxy/feedcomponent/model/o;", "parsedFeedData", "", "position", "cardWidth", "", "startExposureTimeMills", "", "reportStartExposure", "exposureCost", "reportEndExposure", "clickTimestamp", "reportClick", "timestamp", "playCost", "videoTotalTime", "reportStopPlayVideo", "", "TAG", "Ljava/lang/String;", "PAGE_ID", "I", "ACTION_TYPE", "CARD_TYPE_VIDEO", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneFrdHotVideoDCReporter {
    private static final int ACTION_TYPE = 810;
    private static final String CARD_TYPE_VIDEO = "1";
    public static final QZoneFrdHotVideoDCReporter INSTANCE = new QZoneFrdHotVideoDCReporter();
    private static final int PAGE_ID = 601;
    private static final String TAG = "QZoneFrdHotVideoDCReporter";

    QZoneFrdHotVideoDCReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportClick$lambda$2(long j3, int i3, ParsedFeedData parsedFeedData) {
        String str;
        Intrinsics.checkNotNullParameter(parsedFeedData, "$parsedFeedData");
        QCircleLpReportDc05507.DataBuilder ext14 = new QCircleLpReportDc05507.DataBuilder().setActionType(ACTION_TYPE).setSubActionType(4).setPageId(601).setExt1("1").setExt3(String.valueOf(j3)).setExt5(String.valueOf(i3)).setExt14(parsedFeedData.getRecommendReason());
        CircleReportData reportData = parsedFeedData.getReportData();
        if (reportData == null || (str = reportData.getSealTransfer()) == null) {
            str = "";
        }
        QCircleLpReportDc05507.report(ext14.setSealTransfer(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportEndExposure$lambda$1(long j3, long j16, int i3, int i16, ParsedFeedData parsedFeedData) {
        String str;
        Intrinsics.checkNotNullParameter(parsedFeedData, "$parsedFeedData");
        QCircleLpReportDc05507.DataBuilder ext14 = new QCircleLpReportDc05507.DataBuilder().setActionType(ACTION_TYPE).setSubActionType(2).setPageId(601).setExt1("1").setExt2(String.valueOf(j3)).setExt4(String.valueOf(j16)).setExt5(String.valueOf(i3)).setExt12(String.valueOf(i16)).setExt14(parsedFeedData.getRecommendReason());
        CircleReportData reportData = parsedFeedData.getReportData();
        if (reportData == null || (str = reportData.getSealTransfer()) == null) {
            str = "";
        }
        QCircleLpReportDc05507.report(ext14.setSealTransfer(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportStartExposure$lambda$0(long j3, int i3, int i16, ParsedFeedData parsedFeedData) {
        String str;
        Intrinsics.checkNotNullParameter(parsedFeedData, "$parsedFeedData");
        QCircleLpReportDc05507.DataBuilder ext14 = new QCircleLpReportDc05507.DataBuilder().setActionType(ACTION_TYPE).setSubActionType(1).setPageId(601).setExt1("1").setExt2(String.valueOf(j3)).setExt5(String.valueOf(i3)).setExt12(String.valueOf(i16)).setExt14(parsedFeedData.getRecommendReason());
        CircleReportData reportData = parsedFeedData.getReportData();
        if (reportData == null || (str = reportData.getSealTransfer()) == null) {
            str = "";
        }
        QCircleLpReportDc05507.report(ext14.setSealTransfer(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportStopPlayVideo$lambda$3(long j3, long j16, int i3, ParsedFeedData parsedFeedData, long j17) {
        String str;
        Intrinsics.checkNotNullParameter(parsedFeedData, "$parsedFeedData");
        QCircleLpReportDc05507.DataBuilder ext14 = new QCircleLpReportDc05507.DataBuilder().setActionType(ACTION_TYPE).setSubActionType(5).setPageId(601).setExt1("1").setExt3(String.valueOf(j3)).setExt4(String.valueOf(j16)).setExt5(String.valueOf(i3)).setExt14(parsedFeedData.getRecommendReason());
        CircleReportData reportData = parsedFeedData.getReportData();
        if (reportData == null || (str = reportData.getSealTransfer()) == null) {
            str = "";
        }
        QCircleLpReportDc05507.report(ext14.setSealTransfer(str).setVideoPlayTime(j16).setVideoTotalTime((int) j17), true);
    }

    public final void reportClick(final ParsedFeedData parsedFeedData, final int position, int cardWidth, final long clickTimestamp) {
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reportClick, feedId=" + parsedFeedData.getFeedId() + ", position=" + position + ", cardWidth=" + cardWidth + ", clickTimestamp=" + clickTimestamp);
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.util.a
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFrdHotVideoDCReporter.reportClick$lambda$2(clickTimestamp, position, parsedFeedData);
            }
        });
    }

    public final void reportEndExposure(final ParsedFeedData parsedFeedData, final int position, final int cardWidth, final long startExposureTimeMills, final long exposureCost) {
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reportEndExposure, feedId=" + parsedFeedData.getFeedId() + ", position=" + position + ", cardWidth=" + cardWidth + ", startExposureTimeMills=" + startExposureTimeMills + ", exposureCost=" + exposureCost);
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.util.c
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFrdHotVideoDCReporter.reportEndExposure$lambda$1(startExposureTimeMills, exposureCost, position, cardWidth, parsedFeedData);
            }
        });
    }

    public final void reportStartExposure(final ParsedFeedData parsedFeedData, final int position, final int cardWidth, final long startExposureTimeMills) {
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reportStartExposure, feedId=" + parsedFeedData.getFeedId() + ", position=" + position + ", cardWidth=" + cardWidth + ", startExposureTimeMills=" + startExposureTimeMills);
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.util.d
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFrdHotVideoDCReporter.reportStartExposure$lambda$0(startExposureTimeMills, position, cardWidth, parsedFeedData);
            }
        });
    }

    public final void reportStopPlayVideo(final ParsedFeedData parsedFeedData, final int position, int cardWidth, final long timestamp, final long playCost, final long videoTotalTime) {
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reportStopVideoPlay, feedId=" + parsedFeedData.getFeedId() + ", position=" + position + ", cardWidth=" + cardWidth + ", timestamp=" + timestamp + ",playCost=" + playCost + ",videoTotalTime=" + videoTotalTime);
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.util.b
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFrdHotVideoDCReporter.reportStopPlayVideo$lambda$3(timestamp, playCost, position, parsedFeedData, videoTotalTime);
            }
        });
    }
}
