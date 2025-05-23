package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.w3c.dom.Node;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodDolbyAudioFeature extends TVKVodPlayerFeatureBase {
    public TVKVodDolbyAudioFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        boolean z16 = TVKMediaPlayerConfig.PlayerConfig.is_support_dolby_audio;
        int optInt = TVKUtils.optInt(map.get("spaudio"), 0);
        if (z16 && TVKTPCapability.isSupportDolbyAudio()) {
            optInt = optInt | 2 | 4 | 8;
        }
        if (TVKCapabilityMgr.getInstance().isSupportAudioEffect(5, z16)) {
            optInt |= 16;
        }
        if (TVKCapabilityMgr.getInstance().isSupportAudioEffect(6, z16)) {
            optInt |= 32;
        }
        map.put("spaudio", String.valueOf(optInt));
        int optInt2 = TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_DOLBY_DECODE), 0);
        if (z16 && TVKTPCapability.isSupportHardDecodeDolbyAudio()) {
            optInt2 = optInt2 | 8 | 32;
        }
        if (z16 && TVKTPCapability.isSupportSoftDecodeDolbyAudio()) {
            optInt2 = optInt2 | 4 | 16;
        }
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_DOLBY_DECODE, String.valueOf(optInt2));
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_DOLBY_AUDIO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy() {
        return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.ProxyStrategy getProxyStrategy() {
        return TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeatureRetryPriority getRetryPriority() {
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_NONE;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        int audioType;
        boolean z16;
        boolean z17;
        boolean z18;
        if (tVKNetVideoInfo != null && tVKNetVideoInfo.getCurDefinition() != null) {
            if (tVKNetVideoInfo.getCurAudioTrack() == null) {
                audioType = tVKNetVideoInfo.getCurDefinition().getAudioCodec();
            } else {
                audioType = tVKNetVideoInfo.getCurAudioTrack().getAudioType();
            }
            if (audioType == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && audioType != 3) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17 && audioType != 4) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isNeedDisableFeatureForRetry() {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isSupportVideoPostProcess() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void parseVodCGIResponse(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Node node) throws Exception {
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
