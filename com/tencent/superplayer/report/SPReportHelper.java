package com.tencent.superplayer.report;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodVidAsset;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.HardwareUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.utils.c;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPMediaCodecExceptionInfo;
import com.tencent.thumbplayer.api.common.TPMediaCodecReadyInfo;
import com.tencent.thumbplayer.api.common.TPPropertyID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class SPReportHelper implements ISPReporter {
    public static final String KEY_DEBUG_INFO = "debug_info";
    private static final int MAX_HEASER_SET_SIZE = 30;
    public static final String SEPARATOR = ";";
    private static final String TAG = "SPReportHelper";
    private SPReportEvent mEvent;
    private ISuperPlayer mPlayer;
    private SuperPlayerVideoInfo mVideoInfo;
    public static final AtomicLong GLOBAL_HTTP_BANDWIDTH = new AtomicLong();
    public static final AtomicLong GLOBAL_PCDN_BANDWIDTH = new AtomicLong();
    public static final AtomicLong GLOBAL_P2P_BANDWIDTH = new AtomicLong();
    public static final AtomicLong GLOBAL_HTTP_ERROR_COUNT = new AtomicLong();
    public static int[] dropFrameReportSceneId = null;
    private static final String[] HTTP_CONNECT_ERROR_CODE = {"14010003", "14010005", "14010006", "14010007", "14010009", "14010010"};
    private long mStartBufferTime = 0;
    private boolean mIsPrePlay = false;
    private boolean mPrepared = false;
    private boolean mHasReported = false;
    private boolean mPrePlayViewShowCalled = false;
    private Map<String, Object> mConfigMap = new ConcurrentHashMap();
    private boolean mHasStartSeek = false;
    private boolean mHasStop = false;
    private long mLastHttpDownloadSize = 0;
    private long mLastPcdnDownloadSize = 0;
    private long mLastP2pDownloadSize = 0;
    private long mLiveStartTimestamp = 0;
    private int totalDropFrameDuration = 0;

    private String appendBySeparator(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str + str3 + str2;
    }

    private void checkAndWarning() {
        if (this.mIsPrePlay && !this.mPrePlayViewShowCalled) {
            LogUtil.w(TAG, "Player is prePlay, but prePlayViewShow not called.");
        }
    }

    private boolean checkHttpConnectError(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : HTTP_CONNECT_ERROR_CODE) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collectDownloadProgressData(TPDownloadProgressInfo tPDownloadProgressInfo) {
        if (tPDownloadProgressInfo != null) {
            this.mEvent.fileSize = Math.max(tPDownloadProgressInfo.getFileTotalBytes(), this.mEvent.fileSize);
            this.mEvent.totalDownloadedSize = Math.max(tPDownloadProgressInfo.getDownloadBytes(), this.mEvent.totalDownloadedSize);
            try {
                JSONObject jSONObject = new JSONObject(tPDownloadProgressInfo.getExtraInfo());
                this.mEvent.hitDownload = jSONObject.optInt("hitDownloaded");
                this.mEvent.httpDownloadSize = Math.max(jSONObject.optLong("HttpDownloadSize"), this.mEvent.httpDownloadSize);
                this.mEvent.httpRepeatedSize = Math.max(jSONObject.optLong("HttpRepeatedSize"), this.mEvent.httpRepeatedSize);
                this.mEvent.pcdnDownloadSize = Math.max(jSONObject.optLong("PcdnDownloadSize"), this.mEvent.pcdnDownloadSize);
                this.mEvent.pcdnRepeatedSize = Math.max(jSONObject.optLong("PcdnRepeatedSize"), this.mEvent.pcdnRepeatedSize);
                this.mEvent.p2pDownloadSize = Math.max(jSONObject.optLong("P2PDownloadSize"), this.mEvent.p2pDownloadSize);
                this.mEvent.p2pRepeatedSize = Math.max(jSONObject.optLong("P2PRepeatedSize"), this.mEvent.p2pRepeatedSize);
                this.mEvent.pcdnRequestSize = Math.max(jSONObject.optLong("pcdnRequestSize"), this.mEvent.pcdnRequestSize);
                this.mEvent.pcdnRequestCount = Math.max(jSONObject.optInt("pcdnRequestCount"), this.mEvent.pcdnRequestCount);
                this.mEvent.enableP2P = jSONObject.optInt("enableP2P");
                this.mEvent.natType = jSONObject.optInt("natType");
                this.mEvent.p2pFlag = jSONObject.optInt("p2pFlag");
                this.mEvent.maxUploadSpeed = Math.max(jSONObject.optInt("maxP2PUploadSpeed"), this.mEvent.maxUploadSpeed);
                this.mEvent.punchCount = Math.max(jSONObject.optInt("punchCount"), this.mEvent.punchCount);
                this.mEvent.punchOkCount = Math.max(jSONObject.optInt("punchOkCount"), this.mEvent.punchOkCount);
                this.mEvent.directPunchCount = Math.max(jSONObject.optInt("directPunchCount"), this.mEvent.directPunchCount);
                this.mEvent.directPunchOkCount = Math.max(jSONObject.optInt("directPunchOkCount"), this.mEvent.directPunchOkCount);
                this.mEvent.querySeedTimes = Math.max(jSONObject.optInt("qrySeedTimes"), this.mEvent.querySeedTimes);
                this.mEvent.querySeedOkTimes = Math.max(jSONObject.optInt("qrySeedOkTimes"), this.mEvent.querySeedOkTimes);
                this.mEvent.hasSeedTimes = Math.max(jSONObject.optInt("hasSeedTimes"), this.mEvent.hasSeedTimes);
                this.mEvent.totalSeedCount = Math.max(jSONObject.optInt("totalSeedCount"), this.mEvent.totalSeedCount);
                this.mEvent.connectedPeerCount = Math.max(jSONObject.optInt("connectedPeerNum"), this.mEvent.connectedPeerCount);
                this.mEvent.httpDownloadFailCnt = Math.max(jSONObject.optInt("httpFailedTimes"), this.mEvent.httpDownloadFailCnt);
                this.mEvent.connectedUploadPeerCount = Math.max(jSONObject.optInt("uploadPeerNum"), this.mEvent.connectedUploadPeerCount);
                this.mEvent.p2pUploadSpeed = Math.max(jSONObject.optInt("globalP2PUploadSpeed"), this.mEvent.p2pUploadSpeed);
                this.mEvent.pcdnDownloadFailCount = Math.max(jSONObject.optInt("pcdnDownloadFailCount"), this.mEvent.pcdnDownloadFailCount);
                this.mEvent.pcdnDownloadSuccessCount = Math.max(jSONObject.optInt("pcdnDownloadSuccessCount"), this.mEvent.pcdnDownloadSuccessCount);
                this.mEvent.downloadHolesCount = Math.max(jSONObject.optInt("downloadHolesCount"), this.mEvent.downloadHolesCount);
                int optInt = jSONObject.optInt("lastHttpSpeed");
                if (optInt > 0) {
                    this.mEvent.httpSpeed.add(Integer.valueOf(optInt));
                }
                int optInt2 = jSONObject.optInt("lastPcdnSpeed");
                if (optInt2 > 0) {
                    this.mEvent.pcdnSpeed.add(Integer.valueOf(optInt2));
                }
                int optInt3 = jSONObject.optInt("lastP2PSpeed");
                if (optInt3 > 0) {
                    this.mEvent.p2pSpeed.add(Integer.valueOf(optInt3));
                }
                GLOBAL_HTTP_BANDWIDTH.addAndGet(this.mEvent.httpDownloadSize - this.mLastHttpDownloadSize);
                GLOBAL_PCDN_BANDWIDTH.addAndGet(this.mEvent.pcdnDownloadSize - this.mLastPcdnDownloadSize);
                GLOBAL_P2P_BANDWIDTH.addAndGet(this.mEvent.p2pDownloadSize - this.mLastP2pDownloadSize);
                SPReportEvent sPReportEvent = this.mEvent;
                this.mLastHttpDownloadSize = sPReportEvent.httpDownloadSize;
                this.mLastPcdnDownloadSize = sPReportEvent.pcdnDownloadSize;
                this.mLastP2pDownloadSize = sPReportEvent.p2pDownloadSize;
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initComplexData() {
        this.mEvent.hardwareLevel = HardwareUtil.judgeDeviceLevel(SuperPlayerSDKMgr.getContext());
        this.mEvent.deviceInfoJson = HardwareUtil.getDeviceInfoJson();
        this.mEvent.screenWidth = com.tencent.superplayer.utils.b.b();
        this.mEvent.screenHeight = com.tencent.superplayer.utils.b.a();
        this.mEvent.hdrSupport = c.a();
    }

    private void prepareDataSync() {
        long currentPositionMs = this.mPlayer.getCurrentPositionMs();
        SPReportEvent sPReportEvent = this.mEvent;
        if (currentPositionMs <= 0) {
            currentPositionMs = sPReportEvent.stopPosition;
        }
        sPReportEvent.stopPosition = currentPositionMs;
        if (!this.mConfigMap.isEmpty()) {
            this.mEvent.configExt = new JSONObject(this.mConfigMap).toString();
        }
        SuperPlayerVideoInfo superPlayerVideoInfo = this.mVideoInfo;
        if (superPlayerVideoInfo != null && CommonUtil.l(superPlayerVideoInfo.getFormat())) {
            if (this.mLiveStartTimestamp != 0) {
                this.mEvent.playDuration = System.currentTimeMillis() - this.mLiveStartTimestamp;
            } else {
                this.mEvent.playDuration = 0L;
            }
        }
        SPReportEvent sPReportEvent2 = this.mEvent;
        sPReportEvent2.playDuration += sPReportEvent2.stopPosition - sPReportEvent2.lastPlayPosition;
        sPReportEvent2.avgDropFrameRate = getAvgDropFrameRate();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void addConfigExt(String str, Object obj) {
        this.mConfigMap.put(str, obj);
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void addExtReportData(String str, String str2) {
        if (str.equals(KEY_DEBUG_INFO)) {
            this.mEvent.extDebugInfo = str2;
        } else {
            this.mEvent.extReportData.put(str, str2);
        }
    }

    @Override // com.tencent.superplayer.report.ISPReportProvider
    public float getAvgDropFrameRate() {
        long currentPositionMs;
        if (this.mHasReported) {
            currentPositionMs = this.mEvent.playDuration;
        } else {
            currentPositionMs = (this.mEvent.playDuration + this.mPlayer.getCurrentPositionMs()) - this.mEvent.lastPlayPosition;
        }
        if (currentPositionMs > 0) {
            return this.totalDropFrameDuration / ((float) currentPositionMs);
        }
        return 0.0f;
    }

    public SPReportEvent getEvent() {
        return this.mEvent;
    }

    @Override // com.tencent.superplayer.report.ISPReportProvider
    public Map<String, String> getReportInfo() {
        return this.mEvent.getDataMap();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void init(ISuperPlayer iSuperPlayer, int i3) {
        this.mPlayer = iSuperPlayer;
        SPReportEvent sPReportEvent = new SPReportEvent();
        this.mEvent = sPReportEvent;
        sPReportEvent.appId = SuperPlayerSDKMgr.getPlatform();
        SPReportEvent sPReportEvent2 = this.mEvent;
        sPReportEvent2.sceneId = i3;
        sPReportEvent2.sdkVersion = SuperPlayerSDKMgr.getSDKVersion();
        ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.report.SPReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                SPReportHelper.this.initComplexData();
            }
        });
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onCDNInfoUpdate(TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo) {
        SPReportEvent sPReportEvent = this.mEvent;
        String str = tPCDNURLInfo.errorStr;
        sPReportEvent.lastCDNErrorCode = str;
        if (checkHttpConnectError(str)) {
            GLOBAL_HTTP_ERROR_COUNT.addAndGet(1L);
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onCodecReuseInfo(TPMediaCodecReadyInfo tPMediaCodecReadyInfo) {
        if (tPMediaCodecReadyInfo != null && tPMediaCodecReadyInfo.getMediaType() == 0) {
            String msg2 = tPMediaCodecReadyInfo.getMsg();
            this.mEvent.videoCodecJson = msg2;
            try {
                JSONObject jSONObject = new JSONObject(msg2);
                this.mEvent.videoCodecEnable = jSONObject.optBoolean("reuseEnable");
                this.mEvent.videoCodecReused = jSONObject.optBoolean("isReuse");
                this.mEvent.videoTotalCodecDuration = jSONObject.optInt("totalCodec");
            } catch (Throwable th5) {
                LogUtil.e(TAG, "onCodecReuseInfo error:" + th5.getMessage());
            }
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onCodecReuseInfoException(TPMediaCodecExceptionInfo tPMediaCodecExceptionInfo) {
        if (tPMediaCodecExceptionInfo.getMediaType() == 0) {
            try {
                LogUtil.e(TAG, "codec error:" + tPMediaCodecExceptionInfo.getMsg());
                String optString = new JSONObject(tPMediaCodecExceptionInfo.getMsg()).optString("errorCode");
                SPReportEvent sPReportEvent = this.mEvent;
                sPReportEvent.codecErrorCodeList = appendBySeparator(sPReportEvent.codecErrorCodeList, optString, ";");
                SPReportEvent sPReportEvent2 = this.mEvent;
                sPReportEvent2.codecErrorMsgList = appendBySeparator(sPReportEvent2.codecErrorMsgList, tPMediaCodecExceptionInfo.getMsg(), ";");
            } catch (Throwable unused) {
                LogUtil.e(TAG, "onCodecReuseInfo error for jsonObject:" + tPMediaCodecExceptionInfo.getMsg());
            }
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onCurrentLoopEnd() {
        SPReportEvent sPReportEvent = this.mEvent;
        long j3 = sPReportEvent.playDuration;
        long durationMs = this.mPlayer.getDurationMs();
        SPReportEvent sPReportEvent2 = this.mEvent;
        sPReportEvent.playDuration = j3 + (durationMs - sPReportEvent2.lastPlayPosition);
        sPReportEvent2.lastPlayPosition = 0L;
        sPReportEvent2.loopCount++;
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onDownloadProgressUpdate(final TPDownloadProgressInfo tPDownloadProgressInfo) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.report.SPReportHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    SPReportHelper.this.collectDownloadProgressData(tPDownloadProgressInfo);
                }
            });
        } else {
            collectDownloadProgressData(tPDownloadProgressInfo);
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onDropFrame(float f16, SuperPlayerOption superPlayerOption) {
        this.totalDropFrameDuration += (int) (f16 * ((float) superPlayerOption.dropFrameDetectTimeMs));
        this.mEvent.dropFrameTimes++;
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onError(String str, String str2) {
        SPReportEvent sPReportEvent = this.mEvent;
        sPReportEvent.errCode = str;
        sPReportEvent.errDetailInfo = str2;
        long currentPositionMs = this.mPlayer.getCurrentPositionMs();
        SPReportEvent sPReportEvent2 = this.mEvent;
        if (currentPositionMs <= 0) {
            currentPositionMs = sPReportEvent2.stopPosition;
        }
        sPReportEvent2.stopPosition = currentPositionMs;
        sPReportEvent2.success = false;
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onFirstAudioFrameRendered() {
        final SPReportEvent sPReportEvent = this.mEvent;
        ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.report.SPReportHelper.3
            @Override // java.lang.Runnable
            public void run() {
                String property = SPReportHelper.this.mPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_FIRST_AUDIO_PACKET_OFFSET);
                if (TextUtils.isEmpty(property)) {
                    return;
                }
                sPReportEvent.firstAudioPacketOffset = Long.parseLong(property);
            }
        });
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onFirstVideoFrameRendered() {
        SPReportEvent sPReportEvent = this.mEvent;
        if (sPReportEvent.realRenderDuration == 0 && sPReportEvent.startPrepareTime != 0) {
            sPReportEvent.realRenderDuration = SystemClock.uptimeMillis() - this.mEvent.startPrepareTime;
        }
        final SPReportEvent sPReportEvent2 = this.mEvent;
        ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.report.SPReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                String property = SPReportHelper.this.mPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_FIRST_VIDEO_PACKET_OFFSET);
                if (TextUtils.isEmpty(property)) {
                    return;
                }
                sPReportEvent2.firstVideoPacketOffset = Long.parseLong(property);
            }
        });
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onMediaInfoReady(MediaInfo mediaInfo) {
        if (mediaInfo != null) {
            LogUtil.d(TAG, "onMediaInfoReady:" + mediaInfo);
            this.mEvent.videoFormat = mediaInfo.getContainerFormat();
            this.mEvent.videoCodec = mediaInfo.getVideoCodec();
            this.mEvent.videoProfile = mediaInfo.getVideoProfile();
            this.mEvent.codecMimeType = mediaInfo.getCodecMimeType();
            this.mEvent.audioCodec = mediaInfo.getAudioCodec();
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onOpenMediaPlayer(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        this.mHasReported = false;
        this.mHasStop = false;
        this.mVideoInfo = superPlayerVideoInfo;
        if (superPlayerOption != null) {
            addExtReportData(superPlayerOption.toReportMap());
            boolean z16 = superPlayerOption.isPrePlay;
            this.mIsPrePlay = z16;
            if (z16) {
                this.mEvent.prePlay = 4;
            }
            SPReportEvent sPReportEvent = this.mEvent;
            SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
            sPReportEvent.quicEnableMode = superPlayerDownOption.quicEnableMode;
            sPReportEvent.isEnableQuicPlaintext = superPlayerDownOption.enableQuicPlaintext;
            sPReportEvent.isEnableQuicConnectionMigration = superPlayerDownOption.enableQuicConnectionMigration;
            sPReportEvent.quicCongestionType = superPlayerDownOption.quicCongestionType;
            sPReportEvent.optionEnableP2P = superPlayerDownOption.enableP2P;
            sPReportEvent.optionEnablePcdn = superPlayerDownOption.enablePcdn;
            sPReportEvent.isDisableSample = superPlayerOption.disableSuperSample;
        }
        this.mEvent.isEnableDownloadProxy = CommonUtil.k(superPlayerVideoInfo, superPlayerOption);
        SPReportEvent sPReportEvent2 = this.mEvent;
        sPReportEvent2.isTVKPlayer = false;
        sPReportEvent2.videoSource = superPlayerVideoInfo.getVideoSource();
        this.mEvent.vid = superPlayerVideoInfo.getVid();
        this.mEvent.url = superPlayerVideoInfo.getPlayUrl();
        SPReportEvent sPReportEvent3 = this.mEvent;
        sPReportEvent3.startPosition = j3;
        sPReportEvent3.playDuration = 0L;
        sPReportEvent3.lastPlayPosition = j3;
        this.mLiveStartTimestamp = 0L;
        sPReportEvent3.startPrepareTime = SystemClock.uptimeMillis();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onOpenTVKPlayer(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, long j3) {
        this.mHasReported = false;
        this.mHasStop = false;
        SPReportEvent sPReportEvent = this.mEvent;
        sPReportEvent.isTVKPlayer = true;
        sPReportEvent.videoSource = 1;
        if (tVKPlayerVideoInfo.getAsset() instanceof TVKOnlineVodVidAsset) {
            this.mEvent.vid = ((TVKOnlineVodVidAsset) tVKPlayerVideoInfo.getAsset()).getVid();
        }
        SPReportEvent sPReportEvent2 = this.mEvent;
        sPReportEvent2.startPosition = j3;
        sPReportEvent2.playDuration = 0L;
        sPReportEvent2.lastPlayPosition = j3;
        this.mLiveStartTimestamp = 0L;
        sPReportEvent2.startPrepareTime = SystemClock.uptimeMillis();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onOpenTVKPlayerByUrl(String str, long j3) {
        this.mHasReported = false;
        this.mHasStop = false;
        SPReportEvent sPReportEvent = this.mEvent;
        sPReportEvent.isTVKPlayer = true;
        sPReportEvent.videoSource = 2;
        sPReportEvent.url = str;
        sPReportEvent.startPosition = j3;
        sPReportEvent.playDuration = 0L;
        sPReportEvent.lastPlayPosition = j3;
        this.mLiveStartTimestamp = 0L;
        sPReportEvent.startPrepareTime = SystemClock.uptimeMillis();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onPcdnDownloadFailed(String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("failLength");
                if (optInt > 0) {
                    this.mEvent.pcdnStopReasonSet.add(Integer.valueOf(jSONObject.optInt("stopReason")));
                    if (jSONObject.optInt("isError") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        SPReportEvent sPReportEvent = this.mEvent;
                        sPReportEvent.pcdnErrorCount++;
                        sPReportEvent.pcdnErrorSize += optInt;
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onPlayerTypeChanged(long j3) {
        int i3;
        SPReportEvent sPReportEvent = this.mEvent;
        if (sPReportEvent.isTVKPlayer) {
            i3 = 200;
        } else {
            i3 = 100;
        }
        sPReportEvent.playerType = (int) (i3 + j3);
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onPrePlayViewShow() {
        if (!this.mIsPrePlay) {
            return;
        }
        this.mPrePlayViewShowCalled = true;
        if (this.mPrepared) {
            this.mEvent.prePlay = 1;
        } else {
            this.mEvent.prePlay = 2;
        }
        this.mEvent.visibleStartPrepareTime = SystemClock.uptimeMillis();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onPrepared() {
        this.mPrepared = true;
        this.mEvent.width = this.mPlayer.getVideoWidth();
        this.mEvent.height = this.mPlayer.getVideoHeight();
        this.mEvent.duration = this.mPlayer.getDurationMs();
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer instanceof SuperPlayerMgr) {
            this.mEvent.flowId = ((SuperPlayerMgr) iSuperPlayer).getFlowId();
        }
        MediaInfo mediaInfo = this.mPlayer.getMediaInfo();
        if (mediaInfo != null) {
            this.mEvent.videoFormat = mediaInfo.getContainerFormat();
            this.mEvent.videoCodec = mediaInfo.getVideoCodec();
            this.mEvent.videoProfile = mediaInfo.getVideoProfile();
            this.mEvent.codecMimeType = mediaInfo.getCodecMimeType();
            this.mEvent.audioCodec = mediaInfo.getAudioCodec();
        }
        SPReportEvent sPReportEvent = this.mEvent;
        if (sPReportEvent.realPrepareDuration == 0 && sPReportEvent.startPrepareTime != 0) {
            sPReportEvent.realPrepareDuration = SystemClock.uptimeMillis() - this.mEvent.startPrepareTime;
        }
        if (this.mIsPrePlay && !this.mPrePlayViewShowCalled) {
            this.mEvent.prePlay = 3;
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onQuicInfoUpdate(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("isDownloadByQuic")) {
                this.mEvent.isDownloadByQuic = true;
            }
            if (jSONObject.has("downloadComplete")) {
                String string = jSONObject.getString("downloadComplete");
                if (TextUtils.equals(string, "quic")) {
                    this.mEvent.quicDownloadCompleteCnt++;
                } else if (TextUtils.equals(string, "http")) {
                    this.mEvent.httpDownloadCompleteCnt++;
                }
            }
            if (jSONObject.has("downloadFailed")) {
                String string2 = jSONObject.getString("downloadFailed");
                if (TextUtils.equals(string2, "quic")) {
                    this.mEvent.quicDownloadFailCnt++;
                } else if (TextUtils.equals(string2, "http")) {
                    this.mEvent.httpDownloadFailCnt++;
                }
            }
            if (jSONObject.has("isDownloadByQuicPlaintext")) {
                this.mEvent.isDownloadByQuicPlaintext = TextUtils.equals("true", jSONObject.getString("isDownloadByQuicPlaintext"));
            }
            if (jSONObject.has("ServerIP")) {
                this.mEvent.headerServerIP = jSONObject.optString("ServerIP");
            }
            if (jSONObject.has("ClientIP")) {
                this.mEvent.headerClientIP = jSONObject.optString("ClientIP");
            }
            if (jSONObject.has("CDNIP")) {
                this.mEvent.cdnIP = jSONObject.optString("CDNIP");
            }
            if (!TextUtils.isEmpty(jSONObject.optString(HttpMsg.CDN_LOG_UUID)) && this.mEvent.headerUUIDSet.size() <= 30) {
                String optString = jSONObject.optString(HttpMsg.CDN_LOG_UUID);
                if (optString.contains(" ")) {
                    optString = optString.substring(0, optString.indexOf(" "));
                }
                this.mEvent.headerUUIDSet.add(optString);
            }
            if (!TextUtils.isEmpty(jSONObject.optString("X-CDN-RES-TYPE")) && this.mEvent.headerResTypeSet.size() <= 30) {
                this.mEvent.headerResTypeSet.add(jSONObject.optString("X-CDN-RES-TYPE"));
            }
        } catch (JSONException unused) {
            LogUtil.e(TAG, "onQuicInfoUpdate error for jsonObject:" + str);
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onRelease() {
        report();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onSeek(long j3, long j16) {
        SPReportEvent sPReportEvent = this.mEvent;
        sPReportEvent.playDuration += j3 - sPReportEvent.lastPlayPosition;
        sPReportEvent.hadSeek = true;
        sPReportEvent.seekCount++;
        sPReportEvent.seekDuration = (int) (sPReportEvent.seekDuration + Math.abs(j16 - j3));
        SPReportEvent sPReportEvent2 = this.mEvent;
        if (sPReportEvent2.seekStartTime == 0) {
            sPReportEvent2.seekStartTime = j3;
        }
        this.mHasStartSeek = true;
        sPReportEvent2.lastPlayPosition = j16;
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onSeekComplete() {
        this.mHasStartSeek = false;
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onStart() {
        this.mEvent.hadStart = true;
        SuperPlayerVideoInfo superPlayerVideoInfo = this.mVideoInfo;
        if (superPlayerVideoInfo != null && CommonUtil.l(superPlayerVideoInfo.getFormat())) {
            this.mLiveStartTimestamp = System.currentTimeMillis();
        }
        if (this.mIsPrePlay) {
            SPReportEvent sPReportEvent = this.mEvent;
            if (sPReportEvent.prePlay != 2) {
                sPReportEvent.prePlay = 1;
            }
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onStop() {
        this.mHasStop = true;
        report();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onVideoBufferEnd() {
        long j3;
        if (this.mStartBufferTime != 0) {
            j3 = SystemClock.uptimeMillis() - this.mStartBufferTime;
            this.mEvent.secondBufferDuration += j3;
        } else {
            j3 = 0;
        }
        SPReportEvent sPReportEvent = this.mEvent;
        sPReportEvent.secondBufferCount++;
        this.mStartBufferTime = 0L;
        if (this.mHasStartSeek) {
            sPReportEvent.seekBufferCount++;
            sPReportEvent.seekBufferDuration = (int) (sPReportEvent.seekBufferDuration + j3);
        }
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onVideoBufferStart() {
        this.mStartBufferTime = SystemClock.uptimeMillis();
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onVideoDecoderTypeChanged(long j3) {
        this.mEvent.videoDecoderType = (int) j3;
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void onVideoFrameCheckResult(int i3) {
        this.mEvent.videoFrameCheckCode = i3;
    }

    public void report() {
        if (this.mHasReported) {
            LogUtil.d(TAG, "report ignore for has reported.");
            return;
        }
        this.mHasReported = true;
        prepareDataSync();
        checkAndWarning();
        final SPReportEvent sPReportEvent = this.mEvent;
        ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.report.SPReportHelper.5
            @Override // java.lang.Runnable
            public void run() {
                sPReportEvent.collectData();
                SPBeaconReporter.report(sPReportEvent.getEventName(), sPReportEvent.getDataMap(), sPReportEvent.isDisableSample);
            }
        });
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public synchronized void reset() {
        report();
        this.mStartBufferTime = 0L;
        this.mIsPrePlay = false;
        this.mPrepared = false;
        this.mPrePlayViewShowCalled = false;
        this.mLiveStartTimestamp = 0L;
        this.mLastHttpDownloadSize = 0L;
        this.mLastPcdnDownloadSize = 0L;
        this.mLastP2pDownloadSize = 0L;
        this.totalDropFrameDuration = 0;
        init(this.mPlayer, this.mEvent.sceneId);
    }

    @Override // com.tencent.superplayer.report.ISPReporter
    public void addExtReportData(Map<String, String> map) {
        this.mEvent.extReportData.putAll(map);
    }
}
