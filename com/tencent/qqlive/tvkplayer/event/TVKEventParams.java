package com.tencent.qqlive.tvkplayer.event;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.TVKAudioEffectType;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.TVKVideoFxType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public class TVKEventParams {
    public static final int PLAYER_RENDER_EFFECT_COLOR_BLINDNESS = 2;
    public static final int PLAYER_RENDER_EFFECT_HDR10_ENHANCE = 4;
    public static final int PLAYER_RENDER_EFFECT_SUPER_RESOLUTION = 1;
    public static final int PLAYER_RENDER_EFFECT_UNKNOWN = 0;
    public static final int PLAYER_SWITCH_DEFINITION_MODE_REOPEN = 2;
    public static final int PLAYER_SWITCH_DEFINITION_MODE_SEAMLESS = 1;
    public static final int REPORT_FREE_TYPE_CHINA_MOBILE = 30;
    public static final int REPORT_FREE_TYPE_NONE = 0;
    public static final int REPORT_FREE_TYPE_TELECOM = 20;
    public static final int REPORT_FREE_TYPE_UNICOM_DAWANG = 12;
    public static final int REPORT_FREE_TYPE_UNICOM_MONTHLY_PAYMENT = 10;
    public static final int REPORT_FREE_TYPE_UNICOM_XIAOWANG = 11;

    /* loaded from: classes23.dex */
    public static class AbTestParam {
        public Map<String, Integer> abTestInfo;
    }

    /* loaded from: classes23.dex */
    public static class AdCgiResponseInfo {
        public long mDuration;
        public String mFormat;
        public int mIndex;
        public String mVid;
    }

    /* loaded from: classes23.dex */
    public static class AdCgiResponseParam {
        public ArrayList<AdCgiResponseInfo> adCgiResponseInfos;
        public long mAdDurationMs;
        public int mAdType;
        public String mErrorCode;
        public String mIp;
    }

    /* loaded from: classes23.dex */
    public static class AdPlayFinishParam {
        public String errorCode;
        public int mAdType;
        public long mPlayedTimeMs;
    }

    /* loaded from: classes23.dex */
    public static class AudioEffectInfoParam {
        public List<TVKAudioEffectType> audioEffectTypes;
    }

    /* loaded from: classes23.dex */
    public static class CgiHandleResponseSuccess {
        public String requestHost;
        public int retryCount;
        public boolean useLocalCache;
    }

    /* loaded from: classes23.dex */
    public static class CreatePlayerDoneParam {
        public String mErrorCode;
        public int mPlayerType;
        public String mReason;
    }

    /* loaded from: classes23.dex */
    public static class DownLoadProtocolInfo {
        public String protocolName;
        public String protocolVersion;
    }

    /* loaded from: classes23.dex */
    public static class GetVInfoRequestParam {
    }

    /* loaded from: classes23.dex */
    public static class GetVInfoResponseParam {

        @Nullable
        public ITVKAsset asset;

        @Nullable
        public TVKError errorInfo;

        @Nullable
        public TVKPlayerVideoInfo playerVideoInfo;

        @Nullable
        public TVKNetVideoInfo videoInfo;
    }

    /* loaded from: classes23.dex */
    public static class InitPlayerParam {
        public long initAssetPlayerEndTimeMs;
        public long initAssetPlayerStartTimeMs;
        public long initPlayerEndTimeMs;
        public long initPlayerStartTimeMs;
    }

    /* loaded from: classes23.dex */
    public static class OnPreparedParam {
        public long durationMs;
    }

    /* loaded from: classes23.dex */
    public static class OpenMediaParam {
        public String mDefinition;
        public String mFlowId;
        public TVKPlayerVideoInfo mPlayerVideoInfo;
        public long mSkipEndPositionMs;
        public long mSkipStartPositionMs;
        public String mSourceUrl;
        public TVKUserInfo mUserInfo;
    }

    /* loaded from: classes23.dex */
    public static class PlayErrorParam {

        @NonNull
        private final AdPlayFinishParam adPlayFinishParam;

        @NonNull
        private final TVKError errorInfo;

        public PlayErrorParam(@NonNull TVKError tVKError, @NonNull AdPlayFinishParam adPlayFinishParam) {
            this.errorInfo = tVKError;
            this.adPlayFinishParam = adPlayFinishParam;
        }

        @NonNull
        public AdPlayFinishParam getAdPlayFinishParam() {
            return this.adPlayFinishParam;
        }

        @NonNull
        public TVKError getErrorInfo() {
            return this.errorInfo;
        }
    }

    /* loaded from: classes23.dex */
    public static class PreAdParam {
        public long occurrenceTimeMs;
    }

    /* loaded from: classes23.dex */
    public static class StartBufferingParam {
    }

    /* loaded from: classes23.dex */
    public static class StartPlayParam {
        public boolean isFirstStart = false;
    }

    /* loaded from: classes23.dex */
    public static class StartSeekParam {
        public long mSeekFromPositionMs;
        public long mSeekToPositionMs;
    }

    /* loaded from: classes23.dex */
    public static class StopPlayParam {
        public AdPlayFinishParam adPlayFinishParam;
    }

    /* loaded from: classes23.dex */
    public static class SubtitleLoadEndParam {
        public String errorCode;
    }

    /* loaded from: classes23.dex */
    public static class SwitchAudioTrackDoneParam {
        public String audioTrack;
    }

    /* loaded from: classes23.dex */
    public static class SwitchCDNEventParam {
        public String cdnIp;
        public String cdnUIp;
        public String errorStr;
        public String url;

        public String toString() {
            return "url" + this.url + ", cdnUIp:" + this.cdnUIp + ", cdnIp:" + this.cdnIp + ", errorStr:" + this.errorStr;
        }
    }

    /* loaded from: classes23.dex */
    public static class SwitchDefinitionParam {
        public boolean isAuto;
        public int switchDefinitionType;
    }

    /* loaded from: classes23.dex */
    public static class UpdateVideoViewEventParam {
        public boolean isUseSurfaceView;
        public ViewGroup viewGroup;
    }

    /* loaded from: classes23.dex */
    public static class VideoPostProcessInfoParam {
        public List<TVKVideoFxType> videoPostProcessType;
    }
}
