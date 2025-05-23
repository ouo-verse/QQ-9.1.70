package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1DecodeStrategy;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1Strategy;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import cooperation.qqcircle.report.ASEngineQualityReport;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import org.json.JSONObject;
import uq3.k;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerFrameDropInterceptor extends RFWPlayerBaseInterceptor {
    private long mCurrentDecodeType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class AV1WhiteListRunnable implements Runnable {
        AV1WhiteListRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RFWPlayerAV1DecodeStrategy.g();
        }
    }

    public RFWPlayerFrameDropInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    private String getAv1DeviceInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("model", QCircleDeviceInfoUtils.getMobileModel());
            jSONObject.put("cpu", QCircleDeviceInfoUtils.getCupHardWARE());
            jSONObject.put("cupNum", QCircleDeviceInfoUtils.getCupNum());
            jSONObject.put("cpuFrequency", QCircleDeviceInfoUtils.getCpuFrequency());
            jSONObject.put("level", QCircleVideoDeviceInfoUtils.getVideoDeviceLevel());
            String jSONObject2 = jSONObject.toString();
            QLog.d(getTag(), RFWLog.USR, "report av1 deviceInfo:" + jSONObject2);
            return jSONObject.toString();
        } catch (Exception e16) {
            RFWLog.d(getTag(), RFWLog.USR, e16);
            return "";
        }
    }

    private long getBackRate() {
        if (QCircleVideoDeviceInfoUtils.getVideoDeviceLevel() == 1) {
            return o.L(5L);
        }
        return o.K(5L);
    }

    private int getDeviceMaxAv1BadCastCount() {
        if (QCircleVideoDeviceInfoUtils.getVideoDeviceLevel() == 1) {
            return o.Y(2);
        }
        return o.Z(3);
    }

    private void initAV1WhiteList() {
        RFWThreadManager.getInstance().execOnSubThread(new AV1WhiteListRunnable(), 5000L);
    }

    private void notifyDropFrameReportFront(RFWPlayer rFWPlayer, int i3, long j3) {
        if (rFWPlayer == null) {
            RFWLog.d("RFWPlayerFrameDropInterceptor", RFWLog.USR, "[notifyDropFrameReportFront] player should not be null.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("dropFrame");
        feedCloudCommon$Entry.value.set(String.valueOf(i3));
        FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry2.key.set(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME);
        feedCloudCommon$Entry2.value.set(String.valueOf(j3));
        arrayList.add(feedCloudCommon$Entry);
        arrayList.add(feedCloudCommon$Entry2);
        RFWPlayerListenerDispatchUtils.notifyReportFront(this.mPlayerOptions, rFWPlayer.getVideoPlayId(), "video_drop_frame_event", arrayList);
    }

    private void onDecodeTypeInfo(long j3) {
        this.mCurrentDecodeType = j3;
        if (j3 == 101) {
            RFWLog.d(getTag(), RFWLog.CLR, "onDecodeTypeInfo: \u8f6f\u89e3");
        } else if (j3 == 102) {
            RFWLog.d(getTag(), RFWLog.CLR, "onDecodeTypeInfo: \u786c\u89e3");
        }
    }

    private void recordAV1BadCase() {
        k a16 = k.a();
        String str = RFWPlayerAV1Strategy.KEY_AV1_BADE_CASE_COUNT;
        int e16 = a16.e(str, 0) + 1;
        k.a().m(str, e16);
        if (e16 >= getDeviceMaxAv1BadCastCount()) {
            ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId(ASEngineQualityReport.EVENT_PLAYER_AV1_BACK).setExt1(getAv1DeviceInfo()));
        }
        RFWLog.d(getTag(), RFWLog.CLR, "recordAV1BadCase:" + e16);
    }

    private void reportAV1Hit() {
        ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId(ASEngineQualityReport.EVENT_PLAYER_AV1_HIT).setExt1(getAv1DeviceInfo()));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.beforeOpenMedia(superPlayerOption, iSuperPlayer);
        long l16 = uq3.c.l1();
        boolean q16 = uq3.c.q();
        superPlayerOption.dropFrameDetectTimeMs = l16;
        superPlayerOption.enableDropFrameDetect = q16;
        QLog.d(getTag(), 2, "beforeOpenMedia:|detectTimeMs:" + l16 + "|enableDetect:" + q16);
    }

    public long getDecodeType() {
        return this.mCurrentDecodeType;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onInfo(int i3, long j3, long j16, Object obj) {
        super.onInfo(i3, j3, j16, obj);
        if (i3 == 115) {
            onDecodeTypeInfo(j3);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int i3) {
        super.onRelease(i3);
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRealPlayer() != null && this.mPlayer.getRealPlayer().getReportProvider() != null) {
            if (!RFWVideoUtils.isAV1(this.mPlayerOptions.getRealPlayBean())) {
                RFWLog.d(getTag(), RFWLog.USR, "onRelease not av1 return");
                return;
            }
            int avgDropFrameRate = (int) (this.mPlayer.getRealPlayer().getReportProvider().getAvgDropFrameRate() * 100.0f);
            RFWLog.d(getTag(), RFWLog.USR, "mDropFrameRate:" + avgDropFrameRate);
            if (getTargetInterceptor(RFWPlayerPerfReportInterceptor.class) == null) {
                return;
            }
            long videoSoloPlayTime = ((RFWPlayerPerfReportInterceptor) getTargetInterceptor(RFWPlayerPerfReportInterceptor.class)).getVideoSoloPlayTime();
            notifyDropFrameReportFront(this.mPlayer, avgDropFrameRate, videoSoloPlayTime);
            if (videoSoloPlayTime < uq3.c.k1()) {
                RFWLog.d(getTag(), RFWLog.USR, "onRelease playtime return :" + videoSoloPlayTime);
                return;
            }
            if (avgDropFrameRate <= getBackRate()) {
                RFWLog.d(getTag(), RFWLog.USR, "mDropFrameRate not over min rate:" + avgDropFrameRate);
                return;
            }
            recordAV1BadCase();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        if (RFWVideoUtils.isAV1(this.mPlayerOptions.getRealPlayBean())) {
            reportAV1Hit();
            RFWLog.d(getTag(), RFWLog.CLR, "start av1 ");
        }
        initAV1WhiteList();
    }
}
