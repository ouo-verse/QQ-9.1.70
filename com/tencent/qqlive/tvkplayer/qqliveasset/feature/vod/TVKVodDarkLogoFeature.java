package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKDarkLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodDarkLogoFeature extends TVKVodPlayerFeatureBase {
    public TVKVodDarkLogoFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private void parseDarkLogoFlicker(String str, TVKDarkLogoInfo tVKDarkLogoInfo) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            TVKDarkLogoInfo.FlickerInfo flickerInfo = new TVKDarkLogoInfo.FlickerInfo();
            flickerInfo.setDurationMs(jSONObject.optInt("duration"));
            flickerInfo.setGapMs(jSONObject.optInt("gap"));
            flickerInfo.setAlpha(((float) jSONObject.optDouble("opacity")) / 10.0f);
            tVKDarkLogoInfo.setFlickerInfo(flickerInfo);
        } catch (JSONException e16) {
            this.mLogger.info("parseVinfoFlicker has execption:" + e16.toString(), new Object[0]);
            e16.printStackTrace();
        }
    }

    private void parseVinfoViNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "vi".equalsIgnoreCase(item.getNodeName())) {
                NodeList elementsByTagName = ((Element) item).getElementsByTagName("wsd");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    parseVinfoWsdNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
                    return;
                }
                return;
            }
        }
    }

    private void parseVinfoWsdNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        TVKDarkLogoInfo tVKDarkLogoInfo = new TVKDarkLogoInfo();
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if ("st".equalsIgnoreCase(item.getNodeName())) {
                    tVKDarkLogoInfo.setStartTimeMs(TVKUtils.optInt(getFirstChildNodeValue(item), 0));
                } else if ("dr".equalsIgnoreCase(item.getNodeName())) {
                    tVKDarkLogoInfo.setDurationMs(TVKUtils.optInt(getFirstChildNodeValue(item), 0));
                } else if ("es".equalsIgnoreCase(item.getNodeName())) {
                    tVKDarkLogoInfo.setLogo(getFirstChildNodeValue(item));
                } else if ("ot".equalsIgnoreCase(item.getNodeName())) {
                    tVKDarkLogoInfo.setDefaultAlpha(TVKUtils.optFloat(getFirstChildNodeValue(item), 1000.0f) / 10.0f);
                } else if ("u".equalsIgnoreCase(item.getNodeName())) {
                    parseDarkLogoFlicker(getFirstChildNodeValue(item), tVKDarkLogoInfo);
                }
            }
        }
        tVKVodVideoInfo.setDarkLogoInfo(tVKDarkLogoInfo);
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
        if ((tVKNetVideoInfo instanceof TVKVodVideoInfo) && ((TVKVodVideoInfo) tVKNetVideoInfo).getDarkLogoInfo() != null) {
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
        NodeList elementsByTagName = ((Element) node).getElementsByTagName(LinkReportConstant$EventKey.VALUE);
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            parseVinfoViNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
    }
}
