package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
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
public class TVKVodHdr10Feature extends TVKVodPlayerFeatureBase {
    private static final int SPVIDEO_HDR10 = 4;

    public TVKVodHdr10Feature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private void buildHdrFps(@NonNull Map<String, String> map, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (TVKMediaPlayerConfig.PlayerConfig.zhencaishiting_enable && TVKMediaPlayerConfig.PlayerConfig.zhencaishiting_vod_enable) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPSFRHDR, String.valueOf(getHdrFpsLevel(tVKPlayerVideoInfo)));
        }
    }

    private int convertToHdrFpsLevel(int i3) {
        if (i3 == 120) {
            return 300;
        }
        if (i3 == 90) {
            return 250;
        }
        if (i3 == 60) {
            return 200;
        }
        if (i3 == 30) {
            return 100;
        }
        return 0;
    }

    private int getHdrFpsLevel(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        int i3;
        int requestFps = getRequestFps(tVKPlayerVideoInfo);
        int maxFrameRate = TVKTPCapability.getMaxFrameRate(172);
        if (maxFrameRate < requestFps) {
            i3 = maxFrameRate;
        } else {
            i3 = requestFps;
        }
        this.mLogger.info("CGI: \u8bf7\u6c42\u5e27\u7387\uff1a" + requestFps + ", \u6700\u5927\u5e27\u7387\uff1a" + maxFrameRate + ", \u6700\u7ec8\u5e27\u7387\uff1a" + i3, new Object[0]);
        if (!TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.zhencaishiting_video_force_framerate__list)) {
            requestFps = i3;
        }
        this.mLogger.info("CGI: \u81fb\u5f69\u89c6\u542c\u5e27\u7387\uff1a" + requestFps, new Object[0]);
        return convertToHdrFpsLevel(requestFps);
    }

    private boolean isSupportHdr10(ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        boolean z16;
        if (TVKMediaPlayerConfig.PlayerConfig.hdr_enable && TVKMediaPlayerConfig.PlayerConfig.hdr10_decode_enable) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && TVKVodHdrFeatureUtil.doesViewSupportHdr(iTVKFeatureParamGroup)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        boolean isSupportHighQualityVideo = TVKCapabilityMgr.getInstance().isSupportHighQualityVideo(1, isSupportHdr10(iTVKFeatureParamGroup));
        this.mLogger.info("CGI: supportHDR10=" + isSupportHighQualityVideo, new Object[0]);
        if (isSupportHighQualityVideo) {
            addSpvideoCapability(map, 4);
            buildHdrFps(map, tVKCGIRequestParam.getVideoInfo());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_HDR10;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy() {
        return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.ProxyStrategy getProxyStrategy() {
        return TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_AUTO;
    }

    protected int getRequestFps(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        int optInt = TVKUtils.optInt(tVKPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_FRAME_RATE, ""), 0);
        if (optInt >= 100) {
            return 120;
        }
        if (optInt >= 80) {
            return 90;
        }
        if (optInt >= 48) {
            return 60;
        }
        return 30;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeatureRetryPriority getRetryPriority() {
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_HDR10;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo == null || tVKNetVideoInfo.getCurDefinition() == null) {
            return false;
        }
        TVKNetVideoInfo.DefnInfo curDefinition = tVKNetVideoInfo.getCurDefinition();
        if (!"hdr10".equals(curDefinition.getDefn()) || curDefinition.getVideoCodec() != 3) {
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

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void parseVodCGIResponse(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Node node) throws Exception {
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
