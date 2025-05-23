package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKPositionTransformUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodEmbeddedAdDotFeature extends TVKVodPlayerFeatureBase {
    private static final Comparator<TVKNetVideoInfo.EmbeddedAdDot> ADDOTS_COMPARATOR = new Comparator<TVKNetVideoInfo.EmbeddedAdDot>() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodEmbeddedAdDotFeature.1
        @Override // java.util.Comparator
        public int compare(TVKNetVideoInfo.EmbeddedAdDot embeddedAdDot, TVKNetVideoInfo.EmbeddedAdDot embeddedAdDot2) {
            return embeddedAdDot.getStartTimeMs() - embeddedAdDot2.getStartTimeMs();
        }
    };
    private static final String REQ_DISABLE_VVIP = "0";
    private static final String REQ_ENABLE_VVIP = "1";
    private boolean mIsFirstRequestForThisPlay;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKVodEmbeddedAdDotFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
        private final boolean mIsFirstRequestForThisPlay;

        public TVKVodEmbeddedAdDotFeatureParam(boolean z16) {
            this.mIsFirstRequestForThisPlay = z16;
        }

        public boolean isFirstRequestForThisPlay() {
            return this.mIsFirstRequestForThisPlay;
        }
    }

    public TVKVodEmbeddedAdDotFeature(TVKContext tVKContext) {
        super(tVKContext);
        this.mIsFirstRequestForThisPlay = false;
    }

    private boolean isFirstRequestForThisPlay(ITVKFeatureParamGroup iTVKFeatureParamGroup) {
        TVKVodEmbeddedAdDotFeatureParam tVKVodEmbeddedAdDotFeatureParam;
        if (iTVKFeatureParamGroup == null) {
            tVKVodEmbeddedAdDotFeatureParam = null;
        } else {
            tVKVodEmbeddedAdDotFeatureParam = (TVKVodEmbeddedAdDotFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKVodEmbeddedAdDotFeatureParam.class);
        }
        if (tVKVodEmbeddedAdDotFeatureParam == null) {
            return false;
        }
        return tVKVodEmbeddedAdDotFeatureParam.isFirstRequestForThisPlay();
    }

    private void parseVInfoEmbeddedAdDotsJson(String str, TVKVodVideoInfo tVKVodVideoInfo) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("dot_time");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                TVKNetVideoInfo.EmbeddedAdDot embeddedAdDot = new TVKNetVideoInfo.EmbeddedAdDot();
                embeddedAdDot.setStartTimeMs(jSONObject.optInt("start_time"));
                embeddedAdDot.setEndTimeMs(jSONObject.optInt("end_time"));
                embeddedAdDot.setAdDurationMs(embeddedAdDot.getEndTimeMs() - embeddedAdDot.getStartTimeMs());
                tVKVodVideoInfo.addEmbeddedAdDot(embeddedAdDot);
            }
            Collections.sort(tVKVodVideoInfo.getEmbeddedAdDotList(), ADDOTS_COMPARATOR);
        } catch (JSONException unused) {
            tVKVodVideoInfo.getEmbeddedAdDotList().clear();
        }
    }

    private void parseVinfoViNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "vi".equalsIgnoreCase(item.getNodeName())) {
                tVKVodVideoInfo.setPureVid(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "purevid"));
                parseVInfoEmbeddedAdDotsJson(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "dotinfo"), tVKVodVideoInfo);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        String str;
        this.mIsFirstRequestForThisPlay = isFirstRequestForThisPlay(iTVKFeatureParamGroup);
        if (TVKMediaPlayerConfig.PlayerConfig.vod_vvip_enable) {
            str = "1";
        } else {
            str = "0";
        }
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPVVPAY, str);
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
        if (tVKNetVideoInfo == null || tVKNetVideoInfo.getEmbeddedAdDotList() == null || tVKNetVideoInfo.getEmbeddedAdDotList().isEmpty()) {
            return false;
        }
        return true;
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
        NodeList elementsByTagName = ((Element) node).getElementsByTagName(LinkReportConstant$EventKey.VALUE);
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            parseVinfoViNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        if (isMatchFeature(tVKPlayerRuntimeParam.getNetVideoInfo()) && this.mIsFirstRequestForThisPlay) {
            tVKPlayerRuntimeParam.setStartPositionMs(TVKPositionTransformUtils.adjustSkipStartPositionForEmbeddedAd(tVKPlayerRuntimeParam.getStartPositionMs(), tVKPlayerRuntimeParam.getNetVideoInfo()));
            tVKPlayerRuntimeParam.setSkipEndPositionMs(TVKPositionTransformUtils.adjustSkipEndPositionForEmbeddedAd(tVKPlayerRuntimeParam.getSkipEndPositionMs(), tVKPlayerRuntimeParam.getNetVideoInfo()));
        }
    }
}
