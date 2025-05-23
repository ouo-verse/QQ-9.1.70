package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
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
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.w3c.dom.Node;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodDolbyVisionFeature extends TVKVodPlayerFeatureBase {
    private static final int DEFNPAYVER_SUPPORT_DOLBY = 4;
    private static final int SPVIDEO_DOLBYVISION = 64;
    private static final int SPVIDEO_DOLBYVISION_FFMP4 = 16;
    private static final int SPVIDEO_DOLBYVISION_SDR = 32;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKVodDolbyVisionFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
        private long mCurPositionSec;

        public TVKVodDolbyVisionFeatureParam(long j3) {
            this.mCurPositionSec = j3;
        }

        public long getCurPositionSec() {
            return this.mCurPositionSec;
        }
    }

    public TVKVodDolbyVisionFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private long getCurPositionSec(ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        TVKVodDolbyVisionFeatureParam tVKVodDolbyVisionFeatureParam;
        if (iTVKFeatureParamGroup == null) {
            tVKVodDolbyVisionFeatureParam = null;
        } else {
            tVKVodDolbyVisionFeatureParam = (TVKVodDolbyVisionFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKVodDolbyVisionFeatureParam.class);
        }
        if (tVKVodDolbyVisionFeatureParam != null) {
            return tVKVodDolbyVisionFeatureParam.getCurPositionSec();
        }
        return 0L;
    }

    private int getDolbyDecodeCode() {
        int i3;
        if (TVKTPCapability.isSupportDolbyVision()) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (TVKCapabilityMgr.getInstance().isSupportDolbyVisionSoftRender()) {
            return i3 | 1;
        }
        return i3;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        boolean z16;
        if (TVKMediaPlayerConfig.PlayerConfig.enable_dolby_preview) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_ATIME, String.valueOf(getCurPositionSec(iTVKFeatureParamGroup)));
        }
        if (TVKMediaPlayerConfig.PlayerConfig.is_support_dolby_vision) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_DEFN_PAYVER, String.valueOf(TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_DEFN_PAYVER), 0) | 4));
        }
        if (TVKMediaPlayerConfig.PlayerConfig.is_support_dolby_vision && TVKMediaPlayerConfig.PlayerConfig.enable_hevc) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(6, z16)) {
            this.mLogger.info("CGI: dolbyvision capability:64", new Object[0]);
            addSpvideoCapability(map, 64);
        }
        if (TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(4, z16)) {
            this.mLogger.info("CGI: dolbyvision capability:16", new Object[0]);
            addSpvideoCapability(map, 16);
        }
        if (TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(5, z16)) {
            this.mLogger.info("CGI: dolbyvision capability:32", new Object[0]);
            addSpvideoCapability(map, 32);
        }
        int optInt = TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_DOLBY_DECODE), 0);
        if (z16) {
            optInt |= getDolbyDecodeCode();
        }
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_DOLBY_DECODE, String.valueOf(optInt));
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_DOLBY_VISION;
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
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_DOLBY_VISION;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_ONLY;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        boolean z16;
        if (tVKNetVideoInfo != null && tVKNetVideoInfo.getCurDefinition() != null) {
            TVKNetVideoInfo.DefnInfo curDefinition = tVKNetVideoInfo.getCurDefinition();
            if (TVKDefinitionType.DEFINITION_TYPE_DOLBYVISION.equals(curDefinition.getDefn()) && curDefinition.getVideoCodec() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.mLogger.info("match TVKVodDolbyVisionFeature, videoCode:" + curDefinition.getVideoCodec(), new Object[0]);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isNeedDisableFeatureForRetry() {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isSupportVideoPostProcess() {
        return TVKCapabilityMgr.getInstance().isSupportDolbyVisionSoftRender();
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void parseVodCGIResponse(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Node node) throws Exception {
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
