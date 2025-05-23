package com.tencent.qqlive.tvkplayer.qqliveasset.feature;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;

/* loaded from: classes23.dex */
public class TVKPlayerFeatureUtils {
    public static TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy(@NonNull ITVKPlayerFeature iTVKPlayerFeature, TVKNetVideoInfo tVKNetVideoInfo) {
        if (iTVKPlayerFeature.isMatchFeature(tVKNetVideoInfo)) {
            return iTVKPlayerFeature.getPlayerChooseStrategy();
        }
        return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
    }

    public static TVKStrategyEnum.PlayerStrategy getPlayerStrategyFromConfig(String str) {
        if (TVKPlayerMsg.PLAYER_CHOICE_SYSTEM.equalsIgnoreCase(str)) {
            return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SYSTEM_ONLY;
        }
        if (TVKPlayerMsg.PLAYER_CHOICE_SELF_SOFT.equalsIgnoreCase(str)) {
            return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
        }
        if ("self".equalsIgnoreCase(str)) {
            return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
        }
        return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
    }

    public static TVKStrategyEnum.ProxyStrategy getProxyStrategy(@NonNull ITVKPlayerFeature iTVKPlayerFeature, TVKNetVideoInfo tVKNetVideoInfo) {
        if (iTVKPlayerFeature.isMatchFeature(tVKNetVideoInfo)) {
            return iTVKPlayerFeature.getProxyStrategy();
        }
        return TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_AUTO;
    }

    public static TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy(@NonNull ITVKPlayerFeature iTVKPlayerFeature, TVKNetVideoInfo tVKNetVideoInfo) {
        if (iTVKPlayerFeature.isMatchFeature(tVKNetVideoInfo)) {
            return iTVKPlayerFeature.getVideoDecoderChooseStrategy();
        }
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    public static TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderStrategyFromConfig(String str) {
        if ("self".equalsIgnoreCase(str)) {
            return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_FIRST;
        }
        if (TVKPlayerMsg.PLAYER_CHOICE_SELF_SOFT.equalsIgnoreCase(str)) {
            return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_ONLY;
        }
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    public static boolean isNeedDisableFeatureForRetry(@NonNull ITVKPlayerFeature iTVKPlayerFeature, TVKNetVideoInfo tVKNetVideoInfo) {
        if (iTVKPlayerFeature.isMatchFeature(tVKNetVideoInfo)) {
            return iTVKPlayerFeature.isNeedDisableFeatureForRetry();
        }
        return false;
    }

    public static boolean isSupportVideoPostProcess(@NonNull ITVKPlayerFeature iTVKPlayerFeature, TVKNetVideoInfo tVKNetVideoInfo) {
        if (iTVKPlayerFeature.isMatchFeature(tVKNetVideoInfo)) {
            return iTVKPlayerFeature.isSupportVideoPostProcess();
        }
        return true;
    }
}
