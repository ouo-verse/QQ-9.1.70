package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.w3c.dom.Node;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodChinaDrm20Feature extends TVKVodPlayerFeatureBase {
    public TVKVodChinaDrm20Feature(TVKContext tVKContext) {
        super(tVKContext);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        boolean z16;
        int i3;
        if (TVKMediaPlayerConfig.PlayerConfig.china_drm_2_0_enable && !(tVKCGIRequestParam.getVideoInfo().getAsset() instanceof TVKOnlineSimulatedLiveAsset)) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isSupportDrm = TVKCapabilityMgr.getInstance().isSupportDrm(5, z16);
        ITVKLogger iTVKLogger = this.mLogger;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGI: drm capability : chinaDrm2_0 drmCap : ");
        if (isSupportDrm) {
            i3 = 128;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(", runtimeEnable:");
        sb5.append(this.mEnable);
        iTVKLogger.info(sb5.toString(), new Object[0]);
        if (isSupportDrm) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_DRM, String.valueOf(TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_DRM), 0) | 128));
            if (Build.VERSION.SDK_INT >= 24 && TVKMediaPlayerConfig.PlayerConfig.enable_multi_drm_for_china_drm_2_0) {
                map.put(TVKCommonParamEnum.REQ_PARAM_KEY_MULTI_DRM, String.valueOf(TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_MULTI_DRM), 0) | 128));
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_CHINA_DRM_2_0;
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
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_CHINA_DRM_2_0;
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
        return tVKNetVideoInfo.isMatchDrmType(7);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isNeedDisableFeatureForRetry() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isSupportVideoPostProcess() {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void parseVodCGIResponse(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Node node) throws Exception {
        TVKVodDrmFeatureUtils.parseVodCGIResponse(tVKVodVideoInfo, node);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
