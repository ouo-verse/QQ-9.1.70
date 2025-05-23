package com.tencent.superplayer.report;

import com.tencent.mobileqq.videoplatform.QAReport;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.d;
import com.tencent.tmediacodec.TCodecManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes26.dex */
public class SPReportEvent {
    public static final int PLATFORM_ANDROID = 1;
    public static final int PLAYER_TYPE_SUPER = 100;
    public static final int PLAYER_TYPE_TVK = 200;
    public static final int PREPLAY_FINISHED_AND_NO_SHOWED = 3;
    public static final int PREPLAY_FINISHED_AND_SHOWED = 1;
    public static final int PREPLAY_NO = 0;
    public static final int PREPLAY_NOT_FINISHED_AND_NO_SHOWED = 4;
    public static final int PREPLAY_NOT_FINISHED_AND_SHOWED = 2;
    private static final String TAG = "SPReportEvent";
    public int appId;
    public String audioCodec;
    public boolean audioCodecEnable;
    public String audioCodecJson;
    public boolean audioCodecReused;
    public long audioTotalCodecDuration;
    public int avgHttpSpeed;
    public int avgP2PSpeed;
    public int avgPcdnSpeed;
    public float bitrate;
    public String cdnIP;
    public String codecErrorCodeList;
    public String codecErrorMsgList;
    public String codecMimeType;
    public String configExt;
    public int connectedPeerCount;
    public int connectedUploadPeerCount;
    public String deviceInfoJson;
    public int directPunchCount;
    public int directPunchOkCount;
    public int downloadHolesCount;
    public long duration;
    public int enableP2P;
    public String errCode;
    public String errDetailInfo;
    public long fileSize;
    public String flowId;
    public boolean hadSeek;
    public boolean hadStart;
    public int hardwareLevel;
    public int hasSeedTimes;
    public String headerClientIP;
    public String headerResType;
    public String headerServerIP;
    public String headerUUID;
    public int height;
    public int hitDownload;
    public int httpDownloadCompleteCnt;
    public int httpDownloadFailCnt;
    public long httpDownloadSize;
    public long httpRepeatedSize;
    public boolean isDownloadByQuic;
    public boolean isDownloadByQuicPlaintext;
    public boolean isEnableDownloadProxy;
    public boolean isEnableQuicConnectionMigration;
    public boolean isEnableQuicPlaintext;
    public int loopCount;
    public int maxUploadSpeed;
    public int natType;
    public boolean optionEnableP2P;
    public boolean optionEnablePcdn;
    public long p2pDownloadSize;
    public int p2pFlag;
    public long p2pRepeatedSize;
    public int p2pUploadSpeed;
    public int pcdnDownloadFailCount;
    public long pcdnDownloadSize;
    public int pcdnDownloadSuccessCount;
    public int pcdnErrorCount;
    public int pcdnErrorSize;
    public long pcdnRepeatedSize;
    public int pcdnRequestCount;
    public long pcdnRequestSize;
    public String pcdnStopReason;
    public long playDuration;
    public long prepareDuration;
    public int punchCount;
    public int punchOkCount;
    public int querySeedOkTimes;
    public int querySeedTimes;
    public int quicCongestionType;
    public int quicDownloadCompleteCnt;
    public int quicDownloadFailCnt;
    public int quicEnableMode;
    public long realPrepareDuration;
    public long realRenderDuration;
    public long renderDuration;
    public int sceneId;
    public int screenHeight;
    public int screenWidth;
    public String sdkVersion;
    public int secondBufferCount;
    public long secondBufferDuration;
    public int seekBufferCount;
    public int seekBufferDuration;
    public int seekCount;
    public int seekDuration;
    public float seekPercent;
    public float seekStartPercent;
    public long seekStartTime;
    public long startPosition;
    public long stopPosition;
    public int totalBufferCount;
    public long totalBufferDuration;
    public long totalDownloadedSize;
    public int totalSeedCount;
    public String url;
    public String vid;
    public String videoCodec;
    public boolean videoCodecEnable;
    public String videoCodecJson;
    public boolean videoCodecReused;
    public String videoFormat;
    public String videoProfile;
    public int videoSource;
    public long videoTotalCodecDuration;
    public int width;
    public boolean isDisableSample = false;
    public List<Integer> httpSpeed = new ArrayList();
    public List<Integer> pcdnSpeed = new ArrayList();
    public List<Integer> p2pSpeed = new ArrayList();
    public Set<Integer> pcdnStopReasonSet = new ConcurrentSkipListSet();
    public final CopyOnWriteArraySet<String> headerUUIDSet = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<String> headerResTypeSet = new CopyOnWriteArraySet<>();
    public long visibleStartPrepareTime = 0;
    public long startPrepareTime = 0;
    public long lastPlayPosition = 0;
    public int platform = 1;
    public boolean success = true;
    public int prePlay = 0;
    public int videoFrameCheckCode = -1;
    public String hdrSupport = "notSupport";
    public boolean isTVKPlayer = false;
    public Map<String, String> extReportData = new HashMap();
    public String extDebugInfo = "";
    public float avgDropFrameRate = 0.0f;
    public int dropFrameTimes = 0;
    public int videoDecoderType = 0;
    public String lastCDNErrorCode = "";
    public int playerType = 0;
    public long firstAudioPacketOffset = 0;
    public long firstVideoPacketOffset = 0;

    /* loaded from: classes26.dex */
    public static class ConfigExtKey {
        public static final String PLAYER_CONFIG_EXT = "playerConfigExt";
    }

    public void collectData() {
        float f16;
        float f17 = ((float) this.duration) / 1000.0f;
        float f18 = 0.0f;
        if (f17 != 0.0f) {
            this.bitrate = ((((float) this.fileSize) / 1024.0f) * 8.0f) / f17;
        }
        this.avgHttpSpeed = d.a(this.httpSpeed);
        this.avgPcdnSpeed = d.a(this.pcdnSpeed);
        this.avgP2PSpeed = d.a(this.p2pSpeed);
        StringBuilder sb5 = new StringBuilder();
        Iterator<Integer> it = this.pcdnStopReasonSet.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        this.pcdnStopReason = sb5.toString();
        int i3 = this.prePlay;
        if (i3 == 0) {
            this.prepareDuration = this.realPrepareDuration;
            this.renderDuration = this.realRenderDuration;
        } else if (i3 == 2) {
            long j3 = this.visibleStartPrepareTime - this.startPrepareTime;
            this.prepareDuration = this.realPrepareDuration - j3;
            this.renderDuration = this.realRenderDuration - j3;
            if (j3 < 0) {
                LogUtil.e(TAG, "doBeforeReport prePlayOffsetDuration error, for prePlayOffsetDuration < 0");
            }
        } else if (i3 == 1) {
            this.prepareDuration = 0L;
            this.renderDuration = 0L;
        }
        this.totalBufferDuration = this.realPrepareDuration + this.secondBufferDuration;
        this.totalBufferCount = this.secondBufferCount + 1;
        this.playDuration += this.stopPosition - this.lastPlayPosition;
        long j16 = this.duration;
        if (j16 != 0) {
            f16 = (this.seekDuration * 1.0f) / ((float) j16);
        } else {
            f16 = 0.0f;
        }
        this.seekPercent = f16;
        if (j16 != 0) {
            f18 = (((float) this.seekStartTime) * 1.0f) / ((float) j16);
        }
        this.seekStartPercent = f18;
        this.headerUUID = CommonUtil.c(this.headerUUIDSet);
        this.headerResType = CommonUtil.c(this.headerResTypeSet);
    }

    public Map<String, String> getDataMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("param_appId", String.valueOf(this.appId));
        linkedHashMap.put("param_sceneId", String.valueOf(this.sceneId));
        linkedHashMap.put("param_packagename", SuperPlayerSDKMgr.getContext() == null ? "" : SuperPlayerSDKMgr.getContext().getPackageName());
        linkedHashMap.put("param_uin", SuperPlayerSDKMgr.getUid());
        linkedHashMap.put("param_videoSource", String.valueOf(this.videoSource));
        linkedHashMap.put("param_vid", this.vid);
        linkedHashMap.put("param_url", this.url);
        linkedHashMap.put("param_width", String.valueOf(this.width));
        linkedHashMap.put("param_height", String.valueOf(this.height));
        linkedHashMap.put(QAReport.REPORT_KEY_FILE_SIZE, String.valueOf(this.fileSize));
        linkedHashMap.put("param_duration", String.valueOf(this.duration));
        linkedHashMap.put("param_bitrate", String.valueOf(this.bitrate));
        linkedHashMap.put("param_videoFormat", String.valueOf(this.videoFormat));
        linkedHashMap.put(QAReport.REPORT_KEY_VIDEO_CODEC, this.videoCodec);
        linkedHashMap.put(QAReport.REPORT_KEY_VIDEO_PROFILE, this.videoProfile);
        linkedHashMap.put("param_codecMimeType", this.codecMimeType);
        linkedHashMap.put("param_platform", String.valueOf(this.platform));
        linkedHashMap.put("param_hardwareLevel", String.valueOf(this.hardwareLevel));
        linkedHashMap.put("param_deviceInfoJson", this.deviceInfoJson);
        linkedHashMap.put("param_screenWidth", String.valueOf(this.screenWidth));
        linkedHashMap.put("param_screenHeight", String.valueOf(this.screenHeight));
        linkedHashMap.put("param_sdkVersion", this.sdkVersion);
        linkedHashMap.put("param_flowId", this.flowId);
        linkedHashMap.put("param_configExt", this.configExt);
        linkedHashMap.put("param_success", String.valueOf(this.success));
        linkedHashMap.put(QAReport.REPORT_KEY_ERR_CODE, this.errCode);
        linkedHashMap.put("param_errDetailInfo", this.errDetailInfo);
        linkedHashMap.put("param_prePlay", String.valueOf(this.prePlay));
        linkedHashMap.put("param_totalBufferDuration", String.valueOf(this.totalBufferDuration));
        linkedHashMap.put("param_totalBufferCount", String.valueOf(this.totalBufferCount));
        linkedHashMap.put("param_startPosition", String.valueOf(this.startPosition));
        linkedHashMap.put("param_stopPosition", String.valueOf(this.stopPosition));
        linkedHashMap.put("param_prepareDuration", String.valueOf(this.prepareDuration));
        linkedHashMap.put("param_renderDuration", String.valueOf(this.renderDuration));
        linkedHashMap.put("param_realPrepareDuration", String.valueOf(this.realPrepareDuration));
        linkedHashMap.put("param_realRenderDuration", String.valueOf(this.realRenderDuration));
        linkedHashMap.put("param_videoCodecEnable", String.valueOf(this.videoCodecEnable));
        linkedHashMap.put("param_videoCodecReused", String.valueOf(this.videoCodecReused));
        linkedHashMap.put("param_videoTotalCodecDuration", String.valueOf(this.videoTotalCodecDuration));
        linkedHashMap.put("param_videoCodecJson", String.valueOf(this.videoCodecJson));
        linkedHashMap.put("param_audioCodecEnable", String.valueOf(this.audioCodecEnable));
        linkedHashMap.put("param_audioCodecReused", String.valueOf(this.audioCodecReused));
        linkedHashMap.put("param_audioTotalCodecDuration", String.valueOf(this.audioTotalCodecDuration));
        linkedHashMap.put("param_audioCodecJson", String.valueOf(this.audioCodecJson));
        linkedHashMap.put("param_codecErrorCodeList", String.valueOf(this.codecErrorCodeList));
        linkedHashMap.put("param_codecErrorMsgList", String.valueOf(this.codecErrorMsgList));
        linkedHashMap.put("param_secondBufferDuration", String.valueOf(this.secondBufferDuration));
        linkedHashMap.put("param_secondBufferCount", String.valueOf(this.secondBufferCount));
        linkedHashMap.put("param_videoFrameCheckCode", String.valueOf(this.videoFrameCheckCode));
        linkedHashMap.put("param_codecErasePolicy", String.valueOf(TCodecManager.getInstance().getReusePolicy().eraseType.ordinal()));
        linkedHashMap.put("param_playDuration", String.valueOf(this.playDuration));
        linkedHashMap.put("param_hadStart", String.valueOf(this.hadStart));
        linkedHashMap.put("param_hadSeek", String.valueOf(this.hadSeek));
        linkedHashMap.put("param_quicEnableMode", String.valueOf(this.quicEnableMode));
        linkedHashMap.put("param_isEnableQuicPlaintext", String.valueOf(this.isEnableQuicPlaintext));
        linkedHashMap.put("param_isEnableQuicConnectionMigration", String.valueOf(this.isEnableQuicConnectionMigration));
        linkedHashMap.put("param_quicCongestionType", String.valueOf(this.quicCongestionType));
        linkedHashMap.put("param_isDownloadByQuic", String.valueOf(this.isDownloadByQuic));
        linkedHashMap.put("param_quicDownloadCompleteCnt", String.valueOf(this.quicDownloadCompleteCnt));
        linkedHashMap.put("param_quicDownloadFailCnt", String.valueOf(this.quicDownloadFailCnt));
        linkedHashMap.put("param_httpDownloadCompleteCnt", String.valueOf(this.httpDownloadCompleteCnt));
        linkedHashMap.put("param_httpDownloadFailCnt", String.valueOf(this.httpDownloadFailCnt));
        linkedHashMap.put("param_isDownloadByQuicPlaintext", String.valueOf(this.isDownloadByQuicPlaintext));
        linkedHashMap.put("param_headerServerIP", String.valueOf(this.headerServerIP));
        linkedHashMap.put("param_headerClientIP", String.valueOf(this.headerClientIP));
        linkedHashMap.put("param_CDNIP", String.valueOf(this.cdnIP));
        linkedHashMap.put("param_headerUUID", this.headerUUID);
        linkedHashMap.put("param_headerResType", this.headerResType);
        linkedHashMap.put("param_isEnableDownloadProxy", String.valueOf(this.isEnableDownloadProxy));
        linkedHashMap.put("param_seekCount", String.valueOf(this.seekCount));
        linkedHashMap.put("param_seekBufferCount", String.valueOf(this.seekBufferCount));
        linkedHashMap.put("param_seekBufferDuration", String.valueOf(this.seekBufferDuration));
        linkedHashMap.put("param_seekDuration", String.valueOf(this.seekDuration));
        linkedHashMap.put("param_seekPercent", String.valueOf(this.seekPercent));
        linkedHashMap.put("param_seekStartPercent", String.valueOf(this.seekStartPercent));
        linkedHashMap.put("param_hdrSupport", String.valueOf(this.hdrSupport));
        linkedHashMap.put(QAReport.REPORT_KEY_PLAYER_TYPE, String.valueOf(this.playerType));
        linkedHashMap.put("param_totalDownloadedSize", String.valueOf(this.totalDownloadedSize));
        linkedHashMap.put("param_httpDownloadSize", String.valueOf(this.httpDownloadSize));
        linkedHashMap.put("param_httpRepeatedSize", String.valueOf(this.httpRepeatedSize));
        linkedHashMap.put("param_pcdnDownloadSize", String.valueOf(this.pcdnDownloadSize));
        linkedHashMap.put("param_pcdnRepeatedSize", String.valueOf(this.pcdnRepeatedSize));
        linkedHashMap.put("param_p2pDownloadSize", String.valueOf(this.p2pDownloadSize));
        linkedHashMap.put("param_p2pRepeatedSize", String.valueOf(this.p2pRepeatedSize));
        linkedHashMap.put("param_totalDownloadedSize", String.valueOf(this.totalDownloadedSize));
        linkedHashMap.put("param_httpDownloadSize", String.valueOf(this.httpDownloadSize));
        linkedHashMap.put("param_httpRepeatedSize", String.valueOf(this.httpRepeatedSize));
        linkedHashMap.put("param_pcdnDownloadSize", String.valueOf(this.pcdnDownloadSize));
        linkedHashMap.put("param_pcdnRepeatedSize", String.valueOf(this.pcdnRepeatedSize));
        linkedHashMap.put("param_p2pDownloadSize", String.valueOf(this.p2pDownloadSize));
        linkedHashMap.put("param_p2pRepeatedSize", String.valueOf(this.p2pRepeatedSize));
        linkedHashMap.put("param_pcdnRequestSize", String.valueOf(this.pcdnRequestSize));
        linkedHashMap.put("param_pcdnRequestCount", String.valueOf(this.pcdnRequestCount));
        linkedHashMap.put("param_pcdnDownloadFailCount", String.valueOf(this.pcdnDownloadFailCount));
        linkedHashMap.put("param_pcdnDownloadSuccessCount", String.valueOf(this.pcdnDownloadSuccessCount));
        linkedHashMap.put("param_avgHttpSpeed", String.valueOf(this.avgHttpSpeed));
        linkedHashMap.put("param_avgPcdnSpeed", String.valueOf(this.avgPcdnSpeed));
        linkedHashMap.put("param_avgP2PSpeed", String.valueOf(this.avgP2PSpeed));
        linkedHashMap.put("param_pcdnErrorCount", String.valueOf(this.pcdnErrorCount));
        linkedHashMap.put("param_pcdnErrorSize", String.valueOf(this.pcdnErrorSize));
        linkedHashMap.put("param_pcdnStopReason", this.pcdnStopReason);
        linkedHashMap.put("param_natType", String.valueOf(this.natType));
        linkedHashMap.put("param_p2pFlag", String.valueOf(this.p2pFlag));
        linkedHashMap.put("param_maxUploadSpeed", String.valueOf(this.maxUploadSpeed));
        linkedHashMap.put("param_punchCount", String.valueOf(this.punchCount));
        linkedHashMap.put("param_punchOkCount", String.valueOf(this.punchOkCount));
        linkedHashMap.put("param_directPunchCount", String.valueOf(this.directPunchCount));
        linkedHashMap.put("param_directPunchOkCount", String.valueOf(this.directPunchOkCount));
        linkedHashMap.put("param_querySeedTimes", String.valueOf(this.querySeedTimes));
        linkedHashMap.put("param_querySeedOkTimes", String.valueOf(this.querySeedOkTimes));
        linkedHashMap.put("param_hasSeedTimes", String.valueOf(this.hasSeedTimes));
        linkedHashMap.put("param_totalSeedCount", String.valueOf(this.totalSeedCount));
        linkedHashMap.put("param_connectedPeerCount", String.valueOf(this.connectedPeerCount));
        linkedHashMap.put("param_connectedUploadPeerCount", String.valueOf(this.connectedUploadPeerCount));
        linkedHashMap.put("param_p2pUploadSpeed", String.valueOf(this.p2pUploadSpeed));
        linkedHashMap.put("param_loop_count", String.valueOf(this.loopCount));
        linkedHashMap.put("param_enableP2P", this.optionEnableP2P ? "1" : "0");
        linkedHashMap.put("param_enablePcdn", this.optionEnablePcdn ? "1" : "0");
        linkedHashMap.put(QAReport.REPORT_KEY_AUDIO_CODEC, this.audioCodec);
        linkedHashMap.put("param_DownloadHolesCount", String.valueOf(this.downloadHolesCount));
        linkedHashMap.put("param_isHitCache", String.valueOf(this.hitDownload));
        linkedHashMap.put("param_avgDropFrameRate", String.valueOf(this.avgDropFrameRate));
        linkedHashMap.put("param_dropFrameTimes", String.valueOf(this.dropFrameTimes));
        linkedHashMap.put("param_videoDecoderType", String.valueOf(this.videoDecoderType));
        linkedHashMap.put("param_lastCDNErrorCode", String.valueOf(this.lastCDNErrorCode));
        linkedHashMap.put("param_firstAudioPacketOffset", String.valueOf(this.firstAudioPacketOffset));
        linkedHashMap.put("param_firstVideoPacketOffset", String.valueOf(this.firstVideoPacketOffset));
        for (Map.Entry<String, String> entry : this.extReportData.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public String getEventName() {
        return "actSuperPlayer";
    }
}
