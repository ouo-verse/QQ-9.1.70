package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.w3c.dom.Node;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodVvcFeature extends TVKVodPlayerFeatureBase {
    public TVKVodVvcFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private int getSpVvcLevel() {
        if (!this.mEnable) {
            this.mLogger.info("getSpVvcLevel, mEnable = false, return 0", new Object[0]);
            return 0;
        }
        return TVKCapabilityMgr.getInstance().getVideoCodecCgiLevel(4);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        int spVvcLevel = getSpVvcLevel();
        this.mLogger.info("CGI: spvvc:" + spVvcLevel + ", runtimeEnable:" + this.mEnable, new Object[0]);
        map.put("spvvc", String.valueOf(spVvcLevel));
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_VVC;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy() {
        return TVKPlayerFeatureUtils.getPlayerStrategyFromConfig(TVKMediaPlayerConfig.PlayerConfig.vvc_player);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.ProxyStrategy getProxyStrategy() {
        return TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeatureRetryPriority getRetryPriority() {
        if (TVKMediaPlayerConfig.PlayerConfig.is_need_retry_after_vvc_failed) {
            return ITVKPlayerFeature.FeatureRetryPriority.RETRY_VVC;
        }
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_NONE;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKPlayerFeatureUtils.getVideoDecoderStrategyFromConfig(TVKMediaPlayerConfig.PlayerConfig.vvc_player);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo == null) {
            return false;
        }
        return tVKNetVideoInfo.isVvc();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isNeedDisableFeatureForRetry() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isSupportVideoPostProcess() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void parseVodCGIResponse(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Node node) throws Exception {
        boolean z16;
        TVKNetVideoInfo.DefnInfo curDefinition = tVKVodVideoInfo.getCurDefinition();
        if (curDefinition != null) {
            if (curDefinition.getVideoCodec() == 20) {
                z16 = true;
            } else {
                z16 = false;
            }
            tVKVodVideoInfo.setIsVvc(z16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
