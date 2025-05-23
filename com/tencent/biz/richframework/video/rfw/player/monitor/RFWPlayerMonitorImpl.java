package com.tencent.biz.richframework.video.rfw.player.monitor;

import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.ASEngineQualityReport;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes5.dex */
public class RFWPlayerMonitorImpl implements IRFWPlayerMonitor {
    private static volatile IRFWPlayerMonitor INSTANCE;
    private static final Map<Integer, String> mDeviceInfo;
    private boolean isPrintDropFrameFlag = false;
    private long mDropFrameTotal = 0;
    private AtomicIntegerArray mAtomicDropFrames = new AtomicIntegerArray(100);

    /* loaded from: classes5.dex */
    public static final class PlayerReportInfoEntity {

        /* renamed from: s1, reason: collision with root package name */
        public String f95532s1 = "";

        /* renamed from: s2, reason: collision with root package name */
        public String f95533s2 = "";

        /* renamed from: s3, reason: collision with root package name */
        public String f95534s3 = "";
    }

    /* loaded from: classes5.dex */
    public static final class VideoInfoEntity {

        /* renamed from: v1, reason: collision with root package name */
        public String f95535v1 = "";

        /* renamed from: v2, reason: collision with root package name */
        public String f95536v2 = "";
        public String v3 = "";
    }

    static {
        HashMap hashMap = new HashMap();
        mDeviceInfo = hashMap;
        hashMap.put(1, "dev_level_low");
        hashMap.put(2, "dev_level_medium");
        hashMap.put(3, "dev_level_high");
    }

    private int calculateDropFrameRate() {
        if (this.mAtomicDropFrames == null) {
            return 0;
        }
        long j3 = 0;
        long j16 = 0;
        for (int i3 = 0; i3 < this.mAtomicDropFrames.length(); i3++) {
            j3 += this.mAtomicDropFrames.get(i3);
            j16 += r8 * i3;
        }
        this.mDropFrameTotal = j3;
        if (j16 <= 0) {
            return 0;
        }
        return (int) (j16 / j3);
    }

    private void clearDropFrameCensus() {
        this.mAtomicDropFrames = new AtomicIntegerArray(100);
        this.isPrintDropFrameFlag = false;
        this.mDropFrameTotal = 0L;
    }

    private String getDeviceInfoTag() {
        return mDeviceInfo.get(Integer.valueOf(QCircleDeviceInfoUtils.getLevel()));
    }

    private void handlePlayerReport(final RFWPlayerReportInfo rFWPlayerReportInfo, final String str) {
        boolean z16 = true;
        if (QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_qqcircle_player_enabled_drop_frame", 1) != 1) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        QFSAsyncUtils.executeSub(new QFSAsyncUtils.Callback<Void, Void>() { // from class: com.tencent.biz.richframework.video.rfw.player.monitor.RFWPlayerMonitorImpl.1
            @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
            public Void doBackgroundAction(Void... voidArr) {
                try {
                    RFWPlayerMonitorImpl.this.syncHandleReport(rFWPlayerReportInfo, str);
                    return null;
                } catch (Throwable th5) {
                    RFWLog.e("QCirclePlayerMonitorImpl", RFWLog.USR, "[handlePlayerReport] report fail, error: ", th5);
                    return null;
                }
            }
        }, new Void[0]);
    }

    public static IRFWPlayerMonitor instance() {
        if (INSTANCE == null) {
            synchronized (RFWPlayerMonitorImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RFWPlayerMonitorImpl();
                }
            }
        }
        return INSTANCE;
    }

    private void onPlayerDropFrame(long j3, long j16) {
        AtomicIntegerArray atomicIntegerArray;
        if (j3 < 0 || j3 >= 100 || (atomicIntegerArray = this.mAtomicDropFrames) == null) {
            return;
        }
        int i3 = (int) j3;
        int i16 = atomicIntegerArray.get(i3);
        this.mAtomicDropFrames.set(i3, i16 + 1);
        if (!this.isPrintDropFrameFlag || i16 == 0) {
            RFWLog.d("QCirclePlayerMonitorImpl", RFWLog.USR, "[onPlayerDropFrame] arg1: " + j3 + " | arg2: " + j16);
            this.isPrintDropFrameFlag = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncHandleReport(RFWPlayerReportInfo rFWPlayerReportInfo, String str) {
        int calculateDropFrameRate = calculateDropFrameRate();
        if (calculateDropFrameRate == 0) {
            return;
        }
        String deviceInfoTag = getDeviceInfoTag();
        PlayerReportInfoEntity playerReportInfoEntity = new PlayerReportInfoEntity();
        playerReportInfoEntity.f95532s1 = deviceInfoTag;
        String json = RFWJsonBinder.getInstance().toJson(playerReportInfoEntity);
        String feedId = rFWPlayerReportInfo.getFeedId();
        String videoId = rFWPlayerReportInfo.getVideoId();
        VideoInfoEntity videoInfoEntity = new VideoInfoEntity();
        videoInfoEntity.f95535v1 = feedId;
        videoInfoEntity.f95536v2 = videoId;
        String json2 = RFWJsonBinder.getInstance().toJson(videoInfoEntity);
        RFWLog.d("QCirclePlayerMonitorImpl", RFWLog.USR, "[syncHandleReport] reportVideoDropFrameRate: " + calculateDropFrameRate + " | mDropFrameTotal: " + this.mDropFrameTotal + " | ext2: " + json + " | ext3: " + json2 + " | feedId: " + feedId + " | videoId: " + videoId + " | playUrl: " + str + " | mAtomicDropFrames: " + this.mAtomicDropFrames.toString());
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId(ASEngineQualityReport.EVENT_PLAYER_DROP_FRAME).setTimeCost(String.valueOf(calculateDropFrameRate)).setExt1(String.valueOf(this.mDropFrameTotal)).setExt2(json).setExt3(json2));
        clearDropFrameCensus();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.monitor.IRFWPlayerMonitor
    public void handleInfo(int i3, long j3, long j16, Object obj) {
        if (i3 == 252) {
            onPlayerDropFrame(j3, j16);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.monitor.IRFWPlayerMonitor
    public void handleReport(RFWPlayerReportInfo rFWPlayerReportInfo, String str) {
        handlePlayerReport(rFWPlayerReportInfo, str);
    }
}
