package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKPositionTransformUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes23.dex */
public class TVKVodPreviewPlayFeature extends TVKVodPlayerFeatureBase {
    private static final int SUPPORT_MIDDLE_PREVIEW = 1;

    /* loaded from: classes23.dex */
    public static class TVKVodPreviewPlayParam implements ITVKFeatureBase.ITVKFeatureParam {
        private final long mSkipStartPositionMs;

        public TVKVodPreviewPlayParam(long j3) {
            this.mSkipStartPositionMs = j3;
        }

        public long getSkipStartPositionMs() {
            return this.mSkipStartPositionMs;
        }
    }

    public TVKVodPreviewPlayFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private void dealPreviewDurationSec(@NonNull TVKVodVideoInfo tVKVodVideoInfo, long j3, long j16) {
        if (tVKVodVideoInfo.isPreview()) {
            tVKVodVideoInfo.setPreviewDurationSec(j3);
            tVKVodVideoInfo.setPreviewStartPositionSec(j16);
        } else {
            tVKVodVideoInfo.setPreviewDurationSec(tVKVodVideoInfo.getDurationSec());
        }
    }

    private void dealStartSkipPositionForPreview(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        if (tVKPlayerInputParam.getPlayerVideoInfo() != null && !TextUtils.equals(tVKPlayerInputParam.getPlayerVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_DISABLE_START_POSITION_CORRECTION, ""), "true")) {
            tVKPlayerRuntimeParam.setStartPositionMs(TVKPositionTransformUtils.adjustSkipStartPositionForVodPreview(tVKPlayerRuntimeParam.getStartPositionMs(), tVKPlayerRuntimeParam.getNetVideoInfo()));
        }
        tVKPlayerRuntimeParam.setSkipEndPositionMs(TVKPositionTransformUtils.adjustSkipEndPositionForVodPreview(tVKPlayerRuntimeParam.getSkipEndPositionMs(), tVKPlayerRuntimeParam.getNetVideoInfo()));
        this.mLogger.info("position adjusted for preview: start=" + tVKPlayerRuntimeParam.getStartPositionMs() + ", end=" + tVKPlayerRuntimeParam.getSkipEndPositionMs(), new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        TVKVodPreviewPlayParam tVKVodPreviewPlayParam;
        long j3;
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_PREVIEW_TYPE, String.valueOf(1));
        if (iTVKFeatureParamGroup == null) {
            tVKVodPreviewPlayParam = null;
        } else {
            tVKVodPreviewPlayParam = (TVKVodPreviewPlayParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKVodPreviewPlayParam.class);
        }
        if (tVKVodPreviewPlayParam != null) {
            j3 = tVKVodPreviewPlayParam.getSkipStartPositionMs() / 1000;
            this.mLogger.info("CGI: vod preview play aTime:" + j3, new Object[0]);
        } else {
            j3 = 0;
        }
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_ATIME, String.valueOf(j3));
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
        if (tVKNetVideoInfo != null && tVKNetVideoInfo.isPreview()) {
            return true;
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
        NodeList childNodes = node.getChildNodes();
        long j3 = 0;
        long j16 = 0;
        for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
            Node item = childNodes.item(i3);
            if (item.getNodeType() == 1) {
                if ("preview".equalsIgnoreCase(item.getNodeName())) {
                    j3 = TVKUtils.optLong(getFirstChildNodeValue(item), 0L);
                } else if ("startpreview".equalsIgnoreCase(item.getNodeName())) {
                    j16 = TVKUtils.optLong(getFirstChildNodeValue(item), 0L);
                }
            }
        }
        dealPreviewDurationSec(tVKVodVideoInfo, j3, j16);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        if (!isMatchFeature(tVKPlayerRuntimeParam.getNetVideoInfo())) {
            return;
        }
        dealStartSkipPositionForPreview(tVKPlayerInputParam, tVKPlayerRuntimeParam);
    }
}
