package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QAReport {
    static IPatchRedirector $redirector_ = null;
    public static final String LOG_TAG = "[VideoPlatForm]QAReport";
    public static final String REPORT_EVENT_NAME = "actVideoSDKPlay";
    public static final String REPORT_KEY_AUDIO_BITRATE = "param_audioBitRate";
    public static final String REPORT_KEY_AUDIO_CHANNELS = "param_audioChannels";
    public static final String REPORT_KEY_AUDIO_CODEC = "param_audioCodec";
    public static final String REPORT_KEY_AUDIO_PROFILE = "param_audioProfile";
    public static final String REPORT_KEY_AUDIO_SAMPLERATE = "param_audioSampleRate";
    public static final String REPORT_KEY_BUFF_COUNT = "param_buffCount";
    public static final String REPORT_KEY_BUFF_TOTAL_COMSUME = "param_buffTotalConsume";
    public static final String REPORT_KEY_BUSI_TPYE = "param_busiType";
    public static final String REPORT_KEY_CONTAINER_FORMAT = "param_containerFormat";
    public static final String REPORT_KEY_DECODE_FF_COST = "param_decodeFFCost";
    public static final String REPORT_KEY_ERR_CODE = "param_errCode";
    public static final String REPORT_KEY_ERR_INFO = "param_errInfo";
    public static final String REPORT_KEY_ERR_MODULE = "param_errModule";
    public static final String REPORT_KEY_ERR_TYPE = "param_errType";
    public static final String REPORT_KEY_FILE_ID = "param_fileID";
    public static final String REPORT_KEY_FILE_SIZE = "param_fileSize";
    public static final String REPORT_KEY_FIRST_BUFF_COMSUME = "param_firstBuffConsume";
    public static final String REPORT_KEY_FIST_DECODE = "param_firsDecode";
    public static final String REPORT_KEY_HA_ERRO = "param_haErro";
    public static final String REPORT_KEY_HA_STRATEGY = "param_haStrategy";
    public static final String REPORT_KEY_IS_LOOP = "param_isLoop";
    public static final String REPORT_KEY_IS_MEDIACODEC = "param_ismediacodec";
    public static final String REPORT_KEY_IS_MUTE = "param_isMute";
    public static final String REPORT_KEY_LAST_DECODE = "param_lastDecode";
    public static final String REPORT_KEY_PLAYER_TYPE = "param_playerType";
    public static final String REPORT_KEY_PLAY_TYPE = "param_playType";
    public static final String REPORT_KEY_PLAY_URL = "param_playUrl";
    public static final String REPORT_KEY_SKIP_FRAMES_COUNT = "param_skipFramesCount";
    public static final String REPORT_KEY_SKIP_LOT_FRAMES = "param_skipLotFrame";
    public static final String REPORT_KEY_SUCCESSED = "param_isSuccessed";
    public static final String REPORT_KEY_TOTAL_PLAY_TIME = "param_totalPlayTime";
    public static final String REPORT_KEY_VIDEO_BITRATE = "param_videoBitRate";
    public static final String REPORT_KEY_VIDEO_CODEC = "param_videoCodec";
    public static final String REPORT_KEY_VIDEO_DURATION = "param_videoDuration";
    public static final String REPORT_KEY_VIDEO_HEIGHT = "param_videoHeight";
    public static final String REPORT_KEY_VIDEO_PROFILE = "param_videoProfile";
    public static final String REPORT_KEY_VIDEO_WIDTH = "param_videoWidth";
    public static final String REPORT_PLAYER_VER = "param_playerVer";
    public long audioBitRate;
    public int audioChannels;
    public String audioCodec;
    public String audioProfile;
    public long audioSampleRate;
    public long bufferCount;
    public String containerFormat;
    public long decodeFirstFrameCost;
    public int dwErrCode;
    public int errCode;
    public String errDetailInfo;
    public int errModule;
    public int errType;
    public long fileSize;
    public long firstBuffConsume;
    public long firstRenderTime;
    public int firstTryDecoderMode;
    public int haStrategyReturnCode;
    public boolean hasStarted;
    public int isMediaCodec;
    public boolean isSkipLotsOfFrames;
    public boolean isSuccessed;
    public int lastTryDecoderMode;
    public long openPlayerTime;
    public int playerHaErrorCode;
    public int playerType;
    public String playerVersion;
    public int skipFramesTotalCount;
    public long startPlayTime;
    public long stopPlayTime;
    public long totalBufferingDuration;
    public long totalPlayTime;
    public long videoBitRate;
    public String videoCodec;
    public long videoDuration;
    public int videoHeight;
    public VideoPlayParam videoPlayParam;
    public String videoProfile;
    public int videoWidth;

    public QAReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.firstTryDecoderMode = -1;
        this.lastTryDecoderMode = -1;
        this.haStrategyReturnCode = -1;
        this.playerHaErrorCode = -1;
    }

    private void addVideoInfo(HashMap<String, String> hashMap) {
        String str;
        VideoPlayParam videoPlayParam = this.videoPlayParam;
        if (videoPlayParam != null) {
            String str2 = videoPlayParam.mFileID;
            String str3 = videoPlayParam.mSceneName;
            boolean z16 = videoPlayParam.mIsLocal;
            int i3 = !z16 ? 1 : 0;
            if (z16) {
                str = videoPlayParam.mVideoPath;
            } else {
                String[] strArr = videoPlayParam.mUrls;
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                } else {
                    str = "";
                }
            }
            boolean z17 = videoPlayParam.mIsLoop;
            boolean z18 = videoPlayParam.mIsMute;
            this.fileSize = videoPlayParam.mFileSize;
            hashMap.put(REPORT_KEY_FILE_ID, str2);
            hashMap.put(REPORT_KEY_PLAY_TYPE, String.valueOf(i3));
            hashMap.put(REPORT_KEY_IS_LOOP, String.valueOf(z17 ? 1 : 0));
            hashMap.put(REPORT_KEY_IS_MUTE, String.valueOf(z18 ? 1 : 0));
            if (str3 != null) {
                hashMap.put("param_busiType", str3);
            }
            hashMap.put(REPORT_KEY_PLAY_URL, str);
        }
    }

    public synchronized void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16 && !this.hasStarted) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        addVideoInfo(hashMap);
        this.stopPlayTime = System.currentTimeMillis();
        String sDKVersion = SuperPlayerSDKMgr.getSDKVersion();
        this.playerVersion = sDKVersion;
        this.isSuccessed = z16;
        long j3 = this.startPlayTime;
        if (j3 > 0) {
            long j16 = this.stopPlayTime;
            if (j16 > 0) {
                this.totalPlayTime = j16 - j3;
            }
        }
        long j17 = this.openPlayerTime;
        if (j17 > 0) {
            long j18 = this.firstRenderTime;
            if (j18 > 0) {
                this.firstBuffConsume = j18 - j17;
            }
        }
        hashMap.put(REPORT_PLAYER_VER, sDKVersion);
        hashMap.put(REPORT_KEY_SUCCESSED, String.valueOf(this.isSuccessed));
        hashMap.put(REPORT_KEY_ERR_CODE, String.valueOf(this.errCode));
        hashMap.put(REPORT_KEY_ERR_MODULE, String.valueOf(this.errModule));
        hashMap.put(REPORT_KEY_ERR_TYPE, String.valueOf(this.errType));
        hashMap.put(REPORT_KEY_ERR_INFO, this.errDetailInfo);
        hashMap.put(REPORT_KEY_FIRST_BUFF_COMSUME, String.valueOf(this.firstBuffConsume));
        hashMap.put(REPORT_KEY_BUFF_COUNT, String.valueOf(this.bufferCount));
        hashMap.put(REPORT_KEY_BUFF_TOTAL_COMSUME, String.valueOf(this.totalBufferingDuration));
        hashMap.put(REPORT_KEY_SKIP_LOT_FRAMES, String.valueOf(this.isSkipLotsOfFrames));
        hashMap.put(REPORT_KEY_SKIP_FRAMES_COUNT, String.valueOf(this.skipFramesTotalCount));
        hashMap.put(REPORT_KEY_PLAYER_TYPE, String.valueOf(this.playerType));
        hashMap.put(REPORT_KEY_FIST_DECODE, String.valueOf(this.firstTryDecoderMode));
        hashMap.put(REPORT_KEY_LAST_DECODE, String.valueOf(this.lastTryDecoderMode));
        hashMap.put(REPORT_KEY_HA_STRATEGY, String.valueOf(this.haStrategyReturnCode));
        hashMap.put(REPORT_KEY_HA_ERRO, String.valueOf(this.playerHaErrorCode));
        hashMap.put("param_videoDuration", String.valueOf(this.videoDuration));
        hashMap.put(REPORT_KEY_VIDEO_CODEC, this.videoCodec);
        hashMap.put(REPORT_KEY_VIDEO_PROFILE, this.videoProfile);
        hashMap.put(REPORT_KEY_VIDEO_BITRATE, String.valueOf(this.videoBitRate));
        hashMap.put(REPORT_KEY_AUDIO_CODEC, this.audioCodec);
        hashMap.put(REPORT_KEY_AUDIO_PROFILE, this.audioProfile);
        hashMap.put(REPORT_KEY_AUDIO_SAMPLERATE, String.valueOf(this.audioSampleRate));
        hashMap.put(REPORT_KEY_AUDIO_CHANNELS, String.valueOf(this.audioChannels));
        hashMap.put(REPORT_KEY_AUDIO_BITRATE, String.valueOf(this.audioBitRate));
        hashMap.put(REPORT_KEY_TOTAL_PLAY_TIME, String.valueOf(this.totalPlayTime));
        hashMap.put(REPORT_KEY_FILE_SIZE, String.valueOf(this.fileSize));
        hashMap.put(REPORT_KEY_DECODE_FF_COST, String.valueOf(this.decodeFirstFrameCost));
        hashMap.put(REPORT_KEY_VIDEO_HEIGHT, String.valueOf(this.videoHeight));
        hashMap.put(REPORT_KEY_VIDEO_WIDTH, String.valueOf(this.videoWidth));
        hashMap.put(REPORT_KEY_CONTAINER_FORMAT, this.containerFormat);
        hashMap.put(REPORT_KEY_IS_MEDIACODEC, String.valueOf(this.isMediaCodec));
        ReportUtil.report(null, REPORT_EVENT_NAME, this.isSuccessed, 0L, 0L, hashMap, "");
    }
}
