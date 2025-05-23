package com.tencent.qqlive.tvkplayer.qqliveasset.feature.live;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodHdrFeatureUtil;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveHdrVividFeature extends TVKLivePlayerFeatureBase {
    public static final int HDR_LEVEL_1080P_30FPS = 1;
    public static final int HDR_LEVEL_1080P_60FPS = 2;
    public static final int HDR_LEVEL_4K_30FPS = 4;
    public static final int HDR_LEVEL_4K_60FPS = 8;
    private static final int SPVIDEO_HDR_VIVID = 4;

    public TVKLiveHdrVividFeature(@NonNull TVKContext tVKContext) {
        super(tVKContext);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature
    public void buildLiveCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        boolean z16;
        int i3;
        if (TVKMediaPlayerConfig.PlayerConfig.hdr_enable && TVKMediaPlayerConfig.PlayerConfig.enable_live_hdr_vivid && this.mEnable && TVKVodHdrFeatureUtil.doesViewSupportHdr(iTVKFeatureParamGroup)) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isSupportHighQualityVideo = TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(3, z16);
        this.mLogger.info("CGI: support HDR VIVID=" + isSupportHighQualityVideo + ", runtimeEnable=" + this.mEnable, new Object[0]);
        if (isSupportHighQualityVideo) {
            int i16 = 4;
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPVIDEO, String.valueOf(TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_SPVIDEO), 0) | 4));
            int i17 = 8;
            int i18 = (TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(8, true) ? 1 : 0) | 0;
            if (TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(9, true)) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            int i19 = i18 | i3;
            if (!TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(11, true)) {
                i16 = 0;
            }
            int i26 = i19 | i16;
            if (!TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(12, true)) {
                i17 = 0;
            }
            int i27 = i26 | i17;
            this.mLogger.info("CGI: hdrlv=" + i27, new Object[0]);
            map.put(TVKLiveRequestBuilder.RequestParamKey.HDR_LEVEL, String.valueOf(i27));
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_HDR_VIVID;
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
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_HDR_VIVID;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKLiveVideoInfo) || ((TVKLiveVideoInfo) tVKNetVideoInfo).getHeightenType() != 4) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isNeedDisableFeatureForRetry() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isSupportVideoPostProcess() {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKLiveFeature
    public void parseLiveCGIResponse(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo, @NonNull JSONObject jSONObject) throws Exception {
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
