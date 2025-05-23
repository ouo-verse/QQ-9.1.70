package com.tencent.biz.richframework.video.rfw.player.report;

import android.os.Build;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoReporter {
    private static int sBaseUniqueId;
    private static long sFinalUniqueId;
    private static long sSeqUniqueId;
    private List<QQCircleReport$SingleDcData> mVideoEvents = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class SingleHolder {
        public static final RFWVideoReporter INSTANCE = new RFWVideoReporter();
    }

    RFWVideoReporter() {
    }

    private static void assembleVideoInfo(RFWPlayerReportInfo rFWPlayerReportInfo, List<FeedCloudCommon$Entry> list) {
        if (rFWPlayerReportInfo == null) {
            return;
        }
        for (Map.Entry<String, String> entry : rFWPlayerReportInfo.getReportElement().entrySet()) {
            list.add(QCircleReportHelper.newEntry(entry.getKey(), entry.getValue()));
        }
    }

    public static List<byte[]> convertSingleDcDataListToByteList(List<QQCircleReport$SingleDcData> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<QQCircleReport$SingleDcData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toByteArray());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<FeedCloudCommon$Entry> createBaseVideoEntries(long j3, String str, RFWPlayerReportInfo rFWPlayerReportInfo) {
        ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("host_uin", String.valueOf(RFWApplication.getAccountId())), QCircleReportHelper.newEntry("qua", QUA.getQUA3()), QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType()), QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("event_id", str), QCircleReportHelper.newEntry("mobile_type", DeviceInfoMonitor.getModel() + "_" + Build.VERSION.RELEASE), QCircleReportHelper.newEntry("version", ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName()), QCircleReportHelper.newEntry("platform", "AND"), QCircleReportHelper.newEntry("video_play_id", String.valueOf(j3)), QCircleReportHelper.newEntry("unique_id", String.valueOf(obtainUniqueId()))));
        assembleVideoInfo(rFWPlayerReportInfo, arrayList);
        return arrayList;
    }

    public static void generateVideoPlayId() {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) << 32;
        int i3 = sBaseUniqueId;
        sFinalUniqueId = currentTimeMillis | i3;
        sBaseUniqueId = i3 + 1;
    }

    public static RFWVideoReporter getInstance() {
        return SingleHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$report$0(int i3, RFWPlayerReportInfo rFWPlayerReportInfo, long j3, String str, List list) {
        QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
        qQCircleReport$SingleDcData.dcid.set(i3);
        if (rFWPlayerReportInfo == null) {
            QLog.w("RFWVideoReporter", 1, "reportVideoEvent feed is null");
            return;
        }
        qQCircleReport$SingleDcData.report_data.addAll(createBaseVideoEntries(j3, str, rFWPlayerReportInfo));
        if (list != null && !list.isEmpty()) {
            qQCircleReport$SingleDcData.report_data.addAll(list);
        }
        this.mVideoEvents.add(qQCircleReport$SingleDcData);
    }

    public static long obtainUniqueId() {
        long j3 = sSeqUniqueId;
        sSeqUniqueId = 1 + j3;
        return j3;
    }

    public static long obtainVideoPlayId() {
        return sFinalUniqueId;
    }

    public void flush() {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.report.RFWVideoReporter.2
            @Override // java.lang.Runnable
            public void run() {
                if (RFWVideoReporter.this.mVideoEvents != null) {
                    QLog.d("RFWVideoReporter", 1, "flushVideoReportEvents event size:" + RFWVideoReporter.this.mVideoEvents.size());
                    QCircleReporter.getInstance().flushVideoReportByByte(RFWVideoReporter.convertSingleDcDataListToByteList(new ArrayList(RFWVideoReporter.this.mVideoEvents)));
                    RFWVideoReporter.this.mVideoEvents.clear();
                }
            }
        });
    }

    public void report(final long j3, final String str, final int i3, final RFWPlayerReportInfo rFWPlayerReportInfo, final List<FeedCloudCommon$Entry> list) {
        if (QCircleQualityReporter.isSimpleReport(true)) {
            QLog.d("RFWVideoReporter", 4, "report miss hit Sample,direct return!");
        } else {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.report.a
                @Override // java.lang.Runnable
                public final void run() {
                    RFWVideoReporter.this.lambda$report$0(i3, rFWPlayerReportInfo, j3, str, list);
                }
            });
        }
    }

    public void report(final long j3, final String str, final RFWPlayerReportInfo rFWPlayerReportInfo, final List<FeedCloudCommon$Entry> list) {
        if (QCircleQualityReporter.isSimpleReport(true)) {
            QLog.d("RFWVideoReporter", 4, "report miss hit Sample,direct return!");
        } else {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.report.RFWVideoReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                    qQCircleReport$SingleDcData.dcid.set(5530);
                    RFWPlayerReportInfo rFWPlayerReportInfo2 = rFWPlayerReportInfo;
                    if (rFWPlayerReportInfo2 == null) {
                        QLog.w("RFWVideoReporter", 1, "reportVideoEvent feed is null");
                        return;
                    }
                    qQCircleReport$SingleDcData.report_data.addAll(RFWVideoReporter.createBaseVideoEntries(j3, str, rFWPlayerReportInfo2));
                    List list2 = list;
                    if (list2 != null && !list2.isEmpty()) {
                        qQCircleReport$SingleDcData.report_data.addAll(list);
                    }
                    RFWVideoReporter.this.mVideoEvents.add(qQCircleReport$SingleDcData);
                }
            });
        }
    }
}
