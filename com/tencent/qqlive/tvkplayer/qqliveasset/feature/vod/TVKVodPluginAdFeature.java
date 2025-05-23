package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.AdReportParamsKey;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
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
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes23.dex */
public class TVKVodPluginAdFeature extends TVKVodPlayerFeatureBase {
    private static final Comparator<TVKNetVideoInfo.PluginAdInfo> ADDOTS_COMPARATOR = new Comparator<TVKNetVideoInfo.PluginAdInfo>() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod.TVKVodPluginAdFeature.1
        @Override // java.util.Comparator
        public int compare(TVKNetVideoInfo.PluginAdInfo pluginAdInfo, TVKNetVideoInfo.PluginAdInfo pluginAdInfo2) {
            return pluginAdInfo.getStartTimeSec() - pluginAdInfo2.getStartTimeSec() > 0.0d ? 1 : -1;
        }
    };
    private boolean mIsFirstRequestForThisPlay;
    private TVKNetVideoInfo mLastNetVideoInfo;

    /* loaded from: classes23.dex */
    public static class TVKVodPluginAdFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
        private final boolean mIsDlna;
        private final boolean mIsFirstRequestForThisPlay;
        private final TVKVodVideoInfo mVodVideoInfo;

        public TVKVodPluginAdFeatureParam(TVKVodVideoInfo tVKVodVideoInfo, boolean z16, boolean z17) {
            this.mVodVideoInfo = tVKVodVideoInfo;
            this.mIsFirstRequestForThisPlay = z16;
            this.mIsDlna = z17;
        }

        public TVKVodVideoInfo getVodVideoInfo() {
            return this.mVodVideoInfo;
        }

        public boolean isDlna() {
            return this.mIsDlna;
        }

        public boolean isFirstRequestForThisPlay() {
            return this.mIsFirstRequestForThisPlay;
        }
    }

    public TVKVodPluginAdFeature(TVKContext tVKContext) {
        super(tVKContext);
        this.mIsFirstRequestForThisPlay = false;
    }

    private String findPluginAdInfo(TVKVodPluginAdFeatureParam tVKVodPluginAdFeatureParam) {
        if (tVKVodPluginAdFeatureParam == null || tVKVodPluginAdFeatureParam.getVodVideoInfo() == null || tVKVodPluginAdFeatureParam.getVodVideoInfo().getAdInfo() == null || tVKVodPluginAdFeatureParam.getVodVideoInfo().getAdInfo().getPluginAdInfos() == null || tVKVodPluginAdFeatureParam.getVodVideoInfo().getAdInfo().getPluginAdInfos().isEmpty()) {
            return "";
        }
        return tVKVodPluginAdFeatureParam.getVodVideoInfo().getAdInfo().getPluginAdInfosJson();
    }

    private String getAdSessionId(TVKVodPluginAdFeatureParam tVKVodPluginAdFeatureParam) {
        if (tVKVodPluginAdFeatureParam == null || tVKVodPluginAdFeatureParam.getVodVideoInfo() == null) {
            return null;
        }
        return tVKVodPluginAdFeatureParam.getVodVideoInfo().getAdsid();
    }

    private boolean hasPluginAdInfoChanged(TVKNetVideoInfo tVKNetVideoInfo, TVKNetVideoInfo tVKNetVideoInfo2) {
        String str;
        String str2 = "";
        if (tVKNetVideoInfo == null || tVKNetVideoInfo.getAdInfo() == null) {
            str = "";
        } else {
            str = tVKNetVideoInfo.getAdInfo().getPluginAdInfosJson();
        }
        if (tVKNetVideoInfo2 != null && tVKNetVideoInfo2.getAdInfo() != null) {
            str2 = tVKNetVideoInfo2.getAdInfo().getPluginAdInfosJson();
        }
        if ((!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2))) {
            return false;
        }
        return true;
    }

    private void parseVInfoAdNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        if (tVKVodVideoInfo.getAdInfo() == null) {
            tVKVodVideoInfo.setAdInfo(new TVKNetVideoInfo.AdInfo());
        }
        TVKNetVideoInfo.AdInfo adInfo = tVKVodVideoInfo.getAdInfo();
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if (item.getNodeName().equalsIgnoreCase(TVKCommonParamEnum.REQ_PARAM_KEY_AD_SESSION_ID)) {
                    tVKVodVideoInfo.setAdsid(getFirstChildNodeValue(item));
                    adInfo.setSessionId(getFirstChildNodeValue(item));
                } else if (item.getNodeName().equalsIgnoreCase(TVKCommonParamEnum.REQ_PARAM_KEY_AD_PINFO)) {
                    parseVInfoPluginAdJson(adInfo, getFirstChildNodeValue(item));
                }
            }
        }
        Collections.sort(adInfo.getPluginAdInfos(), ADDOTS_COMPARATOR);
    }

    private void parseVInfoPluginAdJson(TVKNetVideoInfo.AdInfo adInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            adInfo.setPluginAdInfosJson(str);
            JSONArray jSONArray = new JSONObject(str).getJSONArray("plugin_info");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.optInt("optype") == 2) {
                    TVKNetVideoInfo.PluginAdInfo pluginAdInfo = new TVKNetVideoInfo.PluginAdInfo();
                    pluginAdInfo.setVid(jSONObject.optString(AdReportParamsKey.AD_VID));
                    pluginAdInfo.setOptType(jSONObject.optInt("optype"));
                    pluginAdInfo.setCid(jSONObject.optString("cid"));
                    pluginAdInfo.setStartTimeSec(jSONObject.optDouble("ad_time"));
                    pluginAdInfo.setOffsetTimeSec(jSONObject.optDouble("ad_offset_time"));
                    pluginAdInfo.setDurationSec(jSONObject.optDouble("ad_dura"));
                    pluginAdInfo.setSlotIndex(jSONObject.optInt("slot_index"));
                    adInfo.addPluginAdInfo(pluginAdInfo);
                }
            }
        } catch (JSONException unused) {
            adInfo.setPluginAdInfosJson("");
            adInfo.getPluginAdInfos().clear();
        }
    }

    private void parseVinfoViNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "vi".equalsIgnoreCase(item.getNodeName())) {
                NodeList elementsByTagName = ((Element) item).getElementsByTagName("ad");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    parseVInfoAdNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
                    return;
                }
                return;
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        TVKVodPluginAdFeatureParam tVKVodPluginAdFeatureParam;
        boolean z16;
        if (iTVKFeatureParamGroup == null) {
            tVKVodPluginAdFeatureParam = null;
        } else {
            tVKVodPluginAdFeatureParam = (TVKVodPluginAdFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKVodPluginAdFeatureParam.class);
        }
        int i3 = 1;
        if (tVKVodPluginAdFeatureParam != null && tVKVodPluginAdFeatureParam.isFirstRequestForThisPlay()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsFirstRequestForThisPlay = z16;
        if (tVKVodPluginAdFeatureParam != null) {
            this.mLastNetVideoInfo = tVKVodPluginAdFeatureParam.getVodVideoInfo();
        }
        if (tVKVodPluginAdFeatureParam != null && tVKVodPluginAdFeatureParam.isDlna()) {
            return;
        }
        if (!(tVKCGIRequestParam.getVideoInfo().getAsset() instanceof TVKOnlineSimulatedLiveAsset) && TPDataTransportMgr.isNativeInit()) {
            if (TVKMediaPlayerConfig.PlayerConfig.enable_hls_plugin_ad) {
                i3 = 3;
            }
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_AD_CAP, String.valueOf(i3));
        }
        String findPluginAdInfo = findPluginAdInfo(tVKVodPluginAdFeatureParam);
        if (!TextUtils.isEmpty(findPluginAdInfo)) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_AD_PINFO, findPluginAdInfo);
        }
        String adSessionId = getAdSessionId(tVKVodPluginAdFeatureParam);
        if (!TextUtils.isEmpty(adSessionId)) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_AD_SESSION_ID, adSessionId);
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
        if (tVKNetVideoInfo == null || tVKNetVideoInfo.getAdInfo() == null || tVKNetVideoInfo.getAdInfo().getPluginAdInfos() == null || tVKNetVideoInfo.getAdInfo().getPluginAdInfos().isEmpty()) {
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
        if (!isMatchFeature(tVKPlayerRuntimeParam.getNetVideoInfo())) {
            return;
        }
        if (this.mIsFirstRequestForThisPlay) {
            tVKPlayerRuntimeParam.setStartPositionMs(TVKPositionTransformUtils.adjustSkipStartPositionForPluginAd(tVKPlayerRuntimeParam.getStartPositionMs(), tVKPlayerRuntimeParam.getNetVideoInfo()));
        }
        long videoDurationMs = tVKPlayerRuntimeParam.getVideoDurationMs();
        Iterator<TVKNetVideoInfo.PluginAdInfo> it = tVKPlayerRuntimeParam.getNetVideoInfo().getAdInfo().getPluginAdInfos().iterator();
        while (it.hasNext()) {
            videoDurationMs = (long) (videoDurationMs + (it.next().getDurationSec() * 1000.0d));
        }
        tVKPlayerRuntimeParam.setVideoDurationMs(videoDurationMs);
    }
}
