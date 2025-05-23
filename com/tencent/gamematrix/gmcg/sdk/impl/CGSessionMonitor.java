package com.tencent.gamematrix.gmcg.sdk.impl;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayPerfInfo;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGNetworkUtil;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.report.CGReporter;
import com.tencent.gamematrix.gmcg.webrtc.CGSessionCtx;
import com.tencent.gamematrix.gmcg.webrtc.DeviceConfig;
import com.tencent.gamematrix.gmcg.webrtc.ReportPerfValue;
import com.tencent.gamematrix.gmcg.webrtc.VideoCodecType;
import com.tencent.gamematrix.gmcg.webrtc.monitor.CGTdmDataReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qzone.remote.ServiceConst;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGSessionMonitor {
    private static final String KEY_REPORT_STATUS = "reportStatus";
    public static long allocEndTimeStamp = -1;
    private static final Set<String> reportFlags = new HashSet();
    private CGReporter bizStatusReporter;
    private final Context mContext;
    private final ReportInfoProvider mReportInfoProvider;
    private final CGSessionCtx mSessionCtx;
    private CGReporter rtcPerfReporter;
    private long startTimeStamp;
    private boolean mEnableTdmReport = false;
    private boolean mTdmInitialized = false;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ReportInfoProvider {
        StatusReportInfo provideSessionMonitorReportInfo();
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class StatusReportInfo {
        public boolean realFree;
        public boolean restart;
        public boolean supportFree;
        public String sessionId = "unknown";
        public String gate = "unknown";

        /* renamed from: ip, reason: collision with root package name */
        public String f107702ip = "unknown";
        public String carrier = "unknown";
        public String errMsg = "";
    }

    CGSessionMonitor(@NonNull Context context, CGSessionCtx cGSessionCtx, ReportInfoProvider reportInfoProvider) {
        this.mContext = context;
        this.mSessionCtx = cGSessionCtx;
        this.mReportInfoProvider = reportInfoProvider;
    }

    private boolean checkBizEventReported(String str) {
        return checkEventReported("Biz", str);
    }

    private boolean checkEventReported(String str, String str2) {
        try {
            if (this.mSessionCtx == null) {
                return false;
            }
            String str3 = str + "-" + str2 + "-" + this.mSessionCtx.pRequestId;
            Set<String> set = reportFlags;
            boolean contains = set.contains(str3);
            if (contains) {
                CGLog.w(str3 + " has reported!");
            } else {
                set.add(str3);
            }
            return contains;
        } catch (Exception e16) {
            CGLog.e("checkEventReported(" + str + ", " + str2 + ") fail: " + e16);
            return false;
        }
    }

    private boolean checkPerfEventReported(String str) {
        return checkEventReported("Perf", str);
    }

    public static CGSessionMonitor create(@NonNull Context context, CGSessionCtx cGSessionCtx, ReportInfoProvider reportInfoProvider) {
        return new CGSessionMonitor(context, cGSessionCtx, reportInfoProvider);
    }

    private Pair[] generatePureCostExts() {
        if (this.startTimeStamp == 0) {
            return null;
        }
        return new Pair[]{Pair.create(5, Integer.valueOf((int) (SystemClock.elapsedRealtime() - this.startTimeStamp)))};
    }

    private boolean isSessionReconnect() {
        StatusReportInfo statusReportInfo;
        ReportInfoProvider reportInfoProvider = this.mReportInfoProvider;
        if (reportInfoProvider != null) {
            statusReportInfo = reportInfoProvider.provideSessionMonitorReportInfo();
        } else {
            statusReportInfo = null;
        }
        if (statusReportInfo != null && statusReportInfo.restart) {
            return true;
        }
        return false;
    }

    private void putBizStatusCommonData(Map<String, String> map) {
        String str;
        String str2;
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx == null) {
            return;
        }
        map.put(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, cGSessionCtx.pBizId);
        map.put("game_id", this.mSessionCtx.pCgGameId);
        map.put("cgidentity", this.mSessionCtx.pUserId);
        map.put(ServiceConst.PARA_SESSION_ID, this.mSessionCtx.pSessionId);
        if (GmCgSdk.isAllTvBiz()) {
            str = "TV";
        } else {
            str = "phone";
        }
        map.put("client_platform", str);
        map.put("client_os_name", "Android");
        map.put("client_os_version", String.valueOf(Build.VERSION.SDK_INT));
        map.put("client_model", this.mSessionCtx.pDeviceModel);
        map.put("client_brand", this.mSessionCtx.pDeviceBrand);
        map.put("ua", "");
        map.put("event_timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("client_sdk_version", "3.0.0.241111110.3.9-SNAPSHOT");
        map.put("client_sdk_type", "AndroidNative");
        if (isSessionReconnect()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        map.put("is_reconnecting", str2);
        map.put("xid", this.mSessionCtx.pXid);
        map.put("oaid", this.mSessionCtx.pOaid);
        map.put("soc", this.mSessionCtx.pSoc);
        map.put("net_type", this.mSessionCtx.getNetworkTypeSymbol());
        int i3 = this.mSessionCtx.pServerEnv;
        if (i3 == 3) {
            i3 = 0;
        }
        map.put("server_env", String.valueOf(i3));
        map.put("client_package_name", CGGlbConfig.getPackageName());
        map.put("device_type", this.mSessionCtx.pCloudGameDeviceType);
        DeviceConfig deviceConfig = this.mSessionCtx.pDeviceConfig;
        if (deviceConfig != null) {
            map.put("device_id", deviceConfig.getDeviceId());
            map.put("cgdevice_resolution", deviceConfig.resolutionWidth + "X" + deviceConfig.resolutionHeight);
            map.put("cgdevice_fps", String.valueOf(deviceConfig.fps));
            map.put("cgdevice_area", deviceConfig.area);
            map.put("cluster", deviceConfig.cluster);
        }
    }

    private void putRtcPerfCommonData(Map<String, String> map) {
        if (this.mSessionCtx == null) {
            return;
        }
        map.put("reportTime", this.formatter.format(new Date()));
        map.put("sessionId", this.mSessionCtx.pSessionId);
        map.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, this.mSessionCtx.pRequestId);
        map.put(Constants.SP_DEVICE_ID, this.mSessionCtx.pDeviceConfig.getDeviceId());
        map.put("gamId", this.mSessionCtx.pCgGameId);
        map.put("bizId", this.mSessionCtx.pBizId);
        map.put("cgidentity", this.mSessionCtx.pUserId);
        map.put("serverType", "xianfeng");
        map.put(DKEngine.GlobalKey.NET_WORK_TYPE, this.mSessionCtx.getNetworkTypeSymbol());
        map.put("packageName", CGGlbConfig.getPackageName());
        map.put(DKEngine.GlobalKey.OS_NAME, "Android");
        map.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
        map.put("deviceModel", this.mSessionCtx.pDeviceModel);
        map.put("videoClarify", this.mSessionCtx.pResolutionType);
        map.put("videoCodec", this.mSessionCtx.pCodecType.mimeType());
        map.put("videoDecoder", this.mSessionCtx.pDecoderType);
        map.put("sdkVersion", "3.0.0.241111110.3.9-SNAPSHOT");
        map.put("xid", this.mSessionCtx.pXid);
        map.put("oaid", this.mSessionCtx.pOaid);
        map.put("soc", this.mSessionCtx.pSoc);
        DeviceConfig deviceConfig = this.mSessionCtx.pDeviceConfig;
        if (deviceConfig != null) {
            map.put("cluster", deviceConfig.cluster);
        }
    }

    private void reportBizStatus(String str, @Nullable Pair<Integer, Integer>[] pairArr, @Nullable Pair<Integer, String>[] pairArr2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", str);
        putBizStatusCommonData(hashMap);
        if (pairArr != null) {
            for (Pair<Integer, Integer> pair : pairArr) {
                if (pair.first != null && pair.second != null) {
                    hashMap.put("int_ext" + pair.first, String.valueOf(pair.second));
                }
            }
        }
        if (pairArr2 != null) {
            for (Pair<Integer, String> pair2 : pairArr2) {
                if (pair2.first != null && pair2.second != null) {
                    hashMap.put("str_ext" + pair2.first, pair2.second);
                }
            }
        }
        CGReporter cGReporter = this.bizStatusReporter;
        if (cGReporter != null) {
            cGReporter.report(hashMap);
        }
    }

    private void reportData(Map<String, String> map) {
        CGReporter cGReporter = this.rtcPerfReporter;
        if (cGReporter != null) {
            cGReporter.report(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkNetworkAvailable() {
        return CGNetworkUtil.isNetworkConnected(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enableTdmReport(boolean z16) {
        this.mEnableTdmReport = z16;
        if (z16) {
            CGTdmDataReport.init(this.mContext.getApplicationContext());
            this.mTdmInitialized = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportAutoLoginCallback(int i3) {
        reportBizStatus("AutoLoginCallback", new Pair[]{Pair.create(1, Integer.valueOf(i3))}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportBeforeP2PConnect() {
        reportBizStatus("BeforeP2PConnect", generatePureCostExts(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallAutoLogin() {
        reportBizStatus("CallAutoLogin", null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallDisconnect() {
        reportBizStatus("CallDisconnect", null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallMergeLaunchCloudGame(boolean z16, boolean z17, boolean z18) {
        reportBizStatus("CallMergeLaunchCloudGame", new Pair[]{Pair.create(1, Integer.valueOf(z16 ? 1 : 0)), Pair.create(2, Integer.valueOf(z17 ? 1 : 0)), Pair.create(3, Integer.valueOf(z18 ? 1 : 0))}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallRelease() {
        reportBizStatus("CallRelease", null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallRestart() {
        reportBizStatus("CallReconnect", null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallStart() {
        Pair<Integer, Integer>[] pairArr;
        int i3;
        int i16 = 1;
        int i17 = 2;
        if (this.mSessionCtx.pHardwareDecode) {
            if (allocEndTimeStamp > 0) {
                pairArr = new Pair[2];
                if (this.mSessionCtx.pCodecType == VideoCodecType.H265) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                pairArr[0] = Pair.create(2, Integer.valueOf(i3));
                pairArr[1] = Pair.create(5, Long.valueOf(SystemClock.elapsedRealtime() - allocEndTimeStamp));
                allocEndTimeStamp = -1L;
            } else {
                pairArr = new Pair[1];
                if (this.mSessionCtx.pCodecType != VideoCodecType.H265) {
                    i16 = 0;
                }
                pairArr[0] = Pair.create(2, Integer.valueOf(i16));
            }
        } else if (allocEndTimeStamp > 0) {
            pairArr = new Pair[2];
            if (this.mSessionCtx.pCodecType == VideoCodecType.H265) {
                i17 = 3;
            }
            pairArr[0] = Pair.create(2, Integer.valueOf(i17));
            pairArr[1] = Pair.create(5, Long.valueOf(SystemClock.elapsedRealtime() - allocEndTimeStamp));
        } else {
            pairArr = new Pair[1];
            if (this.mSessionCtx.pCodecType == VideoCodecType.H265) {
                i17 = 3;
            }
            pairArr[0] = Pair.create(2, Integer.valueOf(i17));
        }
        this.startTimeStamp = SystemClock.elapsedRealtime();
        reportBizStatus("CallStart", pairArr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallSwitchBitrate(int i3, int i16) {
        reportBizStatus("CallSwitchBitrate", new Pair[]{Pair.create(1, Integer.valueOf(i3)), Pair.create(2, Integer.valueOf(i16))}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallSwitchSR(int i3, int i16) {
        reportBizStatus("CallSwitchSR", new Pair[]{Pair.create(1, Integer.valueOf(i3)), Pair.create(2, Integer.valueOf(i16))}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportDataChannelConnected() {
        reportBizStatus("DataChannelConnected", generatePureCostExts(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportError(int i3, String str) {
        reportBizStatus("ErrorHappen", new Pair[]{Pair.create(1, Integer.valueOf(i3))}, new Pair[]{Pair.create(1, str)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportFirstFrameRendered() {
        if (checkBizEventReported("FirstFrameRendered")) {
            return;
        }
        reportBizStatus("FirstFrameRendered", generatePureCostExts(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportMergeLaunchCloudGameCallback(int i3) {
        reportBizStatus("MergeLaunchCloudGameCallback", new Pair[]{Pair.create(1, Integer.valueOf(i3))}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportP2PConnected(String str, String str2) {
        if (checkBizEventReported("P2PConnected")) {
            return;
        }
        reportBizStatus("P2PConnected", generatePureCostExts(), new Pair[]{Pair.create(1, str), Pair.create(2, str2)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportP2PConnecting() {
        reportBizStatus("P2PConnecting", generatePureCostExts(), null);
    }

    void reportPerfValue(GmCgPlayPerfInfo gmCgPlayPerfInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("resolution", gmCgPlayPerfInfo.pVideoFrameWidth + HippyTKDListViewAdapter.X + gmCgPlayPerfInfo.pVideoFrameHeight);
        hashMap.put("videoPacketsReceived", Long.valueOf(gmCgPlayPerfInfo.pVideoPacketsReceived));
        hashMap.put("videoPacketsLost", Integer.valueOf(gmCgPlayPerfInfo.pVideoPacketsLost));
        hashMap.put("videoFramesReceived", Long.valueOf(gmCgPlayPerfInfo.pVideoFramesReceived));
        hashMap.put("videoFramesDecoded", Long.valueOf(gmCgPlayPerfInfo.pVideoFramesDecoded));
        hashMap.put("videoFramesDropped", Long.valueOf(gmCgPlayPerfInfo.pVideoFramesDropped));
        hashMap.put("videoFrameRate", Double.valueOf(gmCgPlayPerfInfo.pVideoFramerate));
        hashMap.put("videoBitrate", Long.valueOf(gmCgPlayPerfInfo.pVideoBitrate));
        hashMap.put("freezeCount", Long.valueOf(gmCgPlayPerfInfo.pVideoFreezeCount));
        hashMap.put("totalFreezesDuration", Double.valueOf(gmCgPlayPerfInfo.pVideoTotalFreezesDuration));
        hashMap.put("perfdogStutter", Double.valueOf(gmCgPlayPerfInfo.pPerfdogStutter));
        hashMap.put("perfdogJankDuration", Double.valueOf(gmCgPlayPerfInfo.pPerfdogJankDuration));
        hashMap.put("perfdogPotentialJankDuration", Double.valueOf(gmCgPlayPerfInfo.pPerfdogPotentialJankDuration));
        hashMap.put("audioPacketsReceived", Long.valueOf(gmCgPlayPerfInfo.pAudioPacketsReceived));
        hashMap.put("audioPacketsLost", Integer.valueOf(gmCgPlayPerfInfo.pAudioPacketsLost));
        hashMap.put("audioBitrate", Long.valueOf(gmCgPlayPerfInfo.pAudioBitrate));
        hashMap.put("rtt", Long.valueOf(gmCgPlayPerfInfo.pVideoRtt));
        hashMap.put("webrtcNetworkBandwidth", Integer.valueOf(gmCgPlayPerfInfo.pWebrtcNetworkBandwidth));
        hashMap.put("networkQuality", Double.valueOf(gmCgPlayPerfInfo.pWebrtcNetworkQuality));
        hashMap.put("nackRate", Double.valueOf(gmCgPlayPerfInfo.pNackRate));
        hashMap.put("fecRate", Double.valueOf(gmCgPlayPerfInfo.pFecRate));
        hashMap.put("recoverRate", Double.valueOf(gmCgPlayPerfInfo.pRecoverRate));
        hashMap.put("lostRateNet", Double.valueOf(gmCgPlayPerfInfo.pLostRateNet));
        hashMap.put("roundTripLatency", Short.valueOf(gmCgPlayPerfInfo.pRoundTripLatency));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportRTCConnectFailed() {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_REPORT_STATUS, "connectFailed");
        putRtcPerfCommonData(hashMap);
        reportData(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportRTCConnected() {
        if (checkPerfEventReported("connected")) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_REPORT_STATUS, "connected");
        putRtcPerfCommonData(hashMap);
        reportData(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportRTCConnecting() {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_REPORT_STATUS, "connecting");
        putRtcPerfCommonData(hashMap);
        reportData(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportRTCFirstFrame() {
        if (checkPerfEventReported("firstFrame")) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_REPORT_STATUS, "firstFrame");
        putRtcPerfCommonData(hashMap);
        reportData(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportRTCStart() {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_REPORT_STATUS, "start");
        putRtcPerfCommonData(hashMap);
        reportData(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportRTCStats(ReportPerfValue reportPerfValue) {
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_REPORT_STATUS, "getStats");
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, String.valueOf(reportPerfValue.playTime));
        hashMap.put("srType", String.valueOf(this.mSessionCtx.pSrType));
        hashMap.put("firstFrameDelay", String.valueOf(reportPerfValue.firstFrameRenderDelay));
        hashMap.put("videoFrameWidth", String.valueOf(reportPerfValue.frameWidth));
        hashMap.put("videoFrameHeight", String.valueOf(reportPerfValue.frameHeight));
        hashMap.put("videoPacketsReceived", String.valueOf(reportPerfValue.packetsReceived));
        hashMap.put("videoPacketsLost", String.valueOf(reportPerfValue.packetsLost));
        hashMap.put("videoFrameReceived", String.valueOf(reportPerfValue.framesReceived));
        hashMap.put("videoFrameDecoded", String.valueOf(reportPerfValue.framesDecoded));
        hashMap.put("videoFrameDropped", String.valueOf(reportPerfValue.framesDropped));
        hashMap.put("pliCount", String.valueOf(reportPerfValue.pliCount));
        hashMap.put("avgVideoDecodeRate", String.valueOf(reportPerfValue.decodeRate));
        hashMap.put("minVideoDecodeRate", String.valueOf(reportPerfValue.minDecodeRate));
        hashMap.put("maxVideoDecodeRate", String.valueOf(reportPerfValue.maxDecodeRate));
        hashMap.put("avgVideoBitrate", String.valueOf(reportPerfValue.videoBitrate));
        hashMap.put("minVideoBitrate", String.valueOf(reportPerfValue.minVideoBitrate));
        hashMap.put("maxVideoBitrate", String.valueOf(reportPerfValue.maxVideoBitrate));
        hashMap.put("freezeCount", String.valueOf(reportPerfValue.freezeCount));
        hashMap.put("freezeDuration", String.valueOf(reportPerfValue.totalFreezesDuration));
        hashMap.put("perfdogStutter", String.valueOf(reportPerfValue.perfdogStutter));
        hashMap.put("perfdogJankDuration", String.valueOf(reportPerfValue.perfdogJankDuration));
        hashMap.put("audioPacketsReceived", String.valueOf(reportPerfValue.audioPacketsReceived));
        hashMap.put("audioPacketsLost", String.valueOf(reportPerfValue.audioPacketsLost));
        hashMap.put("audioBitrate", String.valueOf(reportPerfValue.audioBitrate));
        hashMap.put("localIP", reportPerfValue.localIp);
        hashMap.put("remoteIP", reportPerfValue.remoteIp);
        hashMap.put("rtt", String.valueOf(reportPerfValue.rtt));
        hashMap.put("networkBandwidth", String.valueOf(reportPerfValue.webrtcNetworkBandwidth));
        hashMap.put("networkQuality", String.valueOf(reportPerfValue.webrtcNetworkQuality));
        hashMap.put("nackRate", String.valueOf(reportPerfValue.nackRate));
        hashMap.put("lossRate", String.valueOf(reportPerfValue.lostRateNet));
        hashMap.put("fecRate", String.valueOf(reportPerfValue.fecRate));
        hashMap.put("recoverRate", String.valueOf(reportPerfValue.recoverRate));
        hashMap.put("roundTripLatency", String.valueOf((int) reportPerfValue.roundTripLatency));
        hashMap.put("dataChannelRTT", String.valueOf(reportPerfValue.dataChannelRtt));
        putRtcPerfCommonData(hashMap);
        CGReporter cGReporter = this.rtcPerfReporter;
        if (cGReporter != null) {
            cGReporter.report(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportSessionIdReceived() {
        reportBizStatus("SessionIdReceived", generatePureCostExts(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportTVGamepadStatus(String str, int i3, String str2) {
        if (this.mEnableTdmReport && this.mTdmInitialized) {
            CGTdmDataReport.reportStatusData(this.mSessionCtx, str, i3, str2, false, 0L, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setReporter(CGReporter cGReporter, CGReporter cGReporter2) {
        this.bizStatusReporter = cGReporter;
        this.rtcPerfReporter = cGReporter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportBeforeWebRTCConnect() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCallStop() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportLaunchCostTooLong() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportStartAutoLogin() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportStartWebRTCPlay() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCloudAppStatus(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCodecTypeReported(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportCustomStatus(String str) {
    }
}
