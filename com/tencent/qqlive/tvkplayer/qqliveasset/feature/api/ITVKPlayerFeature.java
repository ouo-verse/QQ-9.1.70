package com.tencent.qqlive.tvkplayer.qqliveasset.feature.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;

/* loaded from: classes23.dex */
public interface ITVKPlayerFeature {

    /* loaded from: classes23.dex */
    public enum FeaturePlayerAndDecoderChoosePriority {
        PLAYER_AND_DECODER_CHOOSE_DOLBY_VISION,
        PLAYER_AND_DECODER_CHOOSE_DOLBY_AUDIO,
        PLAYER_AND_DECODER_CHOOSE_AUDIO_VIVID,
        PLAYER_AND_DECODER_CHOOSE_CHINA_DRM_2_0,
        PLAYER_AND_DECODER_CHOOSE_SELF_CHINA_DRM,
        PLAYER_AND_DECODER_CHOOSE_WIDEVINE_DRM,
        PLAYER_AND_DECODER_CHOOSE_UNITEND_DRM,
        PLAYER_AND_DECODER_CHOOSE_RTMP,
        PLAYER_AND_DECODER_CHOOSE_FLV,
        PLAYER_AND_DECODER_CHOOSE_HDR_VIVID,
        PLAYER_AND_DECODER_CHOOSE_UHD_HIGH_FPS_HDR_VIVID,
        PLAYER_AND_DECODER_CHOOSE_HDR10,
        PLAYER_AND_DECODER_CHOOSE_AVS3,
        PLAYER_AND_DECODER_CHOOSE_HEVC,
        PLAYER_AND_DECODER_CHOOSE_VVC,
        PLAYER_AND_DECODER_CHOOSE_AV1,
        PLAYER_AND_DECODER_CHOOSE_DEFAULT
    }

    /* loaded from: classes23.dex */
    public enum FeatureRetryPriority {
        RETRY_DOLBY_VISION,
        RETRY_CHINA_DRM_2_0,
        RETRY_SELF_CHINA_DRM,
        RETRY_WIDEVINE_DRM,
        RETRY_CHACHA20_DRM,
        RETRY_UNITEND_DRM,
        RETRY_RTMP,
        RETRY_FLV,
        RETRY_HDR_VIVID,
        RETRY_UHD_HIGH_FPS_HDR_VIVID,
        RETRY_HDR10,
        RETRY_AVS3,
        RETRY_HEVC,
        RETRY_VVC,
        RETRY_AV1,
        RETRY_NONE
    }

    FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority();

    TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy();

    TVKStrategyEnum.ProxyStrategy getProxyStrategy();

    FeatureRetryPriority getRetryPriority();

    TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy();

    boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo);

    boolean isNeedDisableFeatureForRetry();

    boolean isSupportVideoPostProcess();

    void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam);
}
