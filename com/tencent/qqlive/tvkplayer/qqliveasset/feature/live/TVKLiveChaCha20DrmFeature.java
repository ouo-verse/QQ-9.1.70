package com.tencent.qqlive.tvkplayer.qqliveasset.feature.live;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKJsonUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveChaCha20DrmFeature extends TVKLivePlayerFeatureBase {
    public TVKLiveChaCha20DrmFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private boolean isChaCha20Enable() {
        boolean z16;
        boolean z17 = true;
        if (TVKMediaPlayerConfig.PlayerConfig.live_chacha20_enable && TVKMediaPlayerConfig.PlayerConfig.qqlive_asset_player_use_proxy) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !this.mEnable) {
            z17 = false;
        }
        return TVKCapabilityMgr.getInstance().isSupportDrm(3, z17);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature
    public void buildLiveCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        int i3;
        boolean isChaCha20Enable = isChaCha20Enable();
        ITVKLogger iTVKLogger = this.mLogger;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGI: drm capability : chacha20 drmCap : ");
        if (isChaCha20Enable) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(", runtimeEnable:");
        sb5.append(this.mEnable);
        iTVKLogger.info(sb5.toString(), new Object[0]);
        if (isChaCha20Enable) {
            addDrmCapabilities(map, 8);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_DEFAULT;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy() {
        return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.ProxyStrategy getProxyStrategy() {
        return TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_MUST;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeatureRetryPriority getRetryPriority() {
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_CHACHA20_DRM;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo == null) {
            return false;
        }
        return tVKNetVideoInfo.isMatchDrmType(3);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isNeedDisableFeatureForRetry() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isSupportVideoPostProcess() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature
    public void parseLiveCGIResponse(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo, @NonNull JSONObject jSONObject) throws Exception {
        JSONObject jSONObject2 = new JSONObject(tVKLiveVideoInfo.getCryptParamJsonString());
        tVKLiveVideoInfo.setNonce(TVKJsonUtils.optString(jSONObject2, "nonce", ""));
        tVKLiveVideoInfo.setDecKey(TVKJsonUtils.optString(jSONObject2, "deckey", ""));
        tVKLiveVideoInfo.setRandoms(TVKJsonUtils.optString(jSONObject2, "randoms", ""));
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
