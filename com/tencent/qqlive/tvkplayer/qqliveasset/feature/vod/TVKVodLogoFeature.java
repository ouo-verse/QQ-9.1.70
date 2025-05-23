package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tl.h;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodLogoFeature extends TVKVodPlayerFeatureBase {
    public TVKVodLogoFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private void parseLogoPositionNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            boolean z16 = true;
            if (item.getNodeType() == 1 && "li".equalsIgnoreCase(item.getNodeName())) {
                TVKNetVideoInfo.LogoPositionInfo logoPositionInfo = new TVKNetVideoInfo.LogoPositionInfo();
                logoPositionInfo.setLogoX(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, HippyTKDListViewAdapter.X), 0));
                logoPositionInfo.setLogoY(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "y"), 0));
                logoPositionInfo.setLogoWidth(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "w"), 0));
                logoPositionInfo.setLogoHeight(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, h.F), 0));
                if (TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "show"), 0) != 1) {
                    z16 = false;
                }
                logoPositionInfo.setLogShow(z16);
                tVKVodVideoInfo.setLogoPositionInfo(logoPositionInfo);
            }
        }
    }

    private void parseVinfoViNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "vi".equalsIgnoreCase(item.getNodeName())) {
                Element element = (Element) item;
                NodeList elementsByTagName = element.getElementsByTagName("wl");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    parseVinfoWlNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
                }
                NodeList elementsByTagName2 = element.getElementsByTagName("ll");
                if (elementsByTagName2 != null && elementsByTagName2.getLength() > 0) {
                    parseLogoPositionNode(tVKVodVideoInfo, elementsByTagName2.item(0).getChildNodes());
                    return;
                }
                return;
            }
        }
    }

    private void parseVinfoWlNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if ("wi".equalsIgnoreCase(item.getNodeName())) {
                    TVKLogoInfo tVKLogoInfo = new TVKLogoInfo();
                    tVKLogoInfo.setId(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "id"), 0));
                    tVKLogoInfo.setX(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, HippyTKDListViewAdapter.X), 0));
                    tVKLogoInfo.setY(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "y"), 0));
                    tVKLogoInfo.setHeight(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, h.F), 0));
                    tVKLogoInfo.setWidth(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "w"), 0));
                    tVKLogoInfo.setVideoMinSideSize(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "rw"), 0));
                    tVKLogoInfo.setAlpha(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "a"), 100));
                    tVKLogoInfo.setMd5(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "md5"));
                    tVKLogoInfo.setLogoUrl(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "url"));
                    tVKLogoInfo.setLogoHttpsUrl(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "surl"));
                    tVKLogoInfo.setShow(true);
                    tVKVodVideoInfo.addLogoInfo(tVKLogoInfo);
                } else if ("action".equalsIgnoreCase(item.getNodeName())) {
                    tVKVodVideoInfo.setVodLogoActionUrl(getFirstChildNodeValue(item));
                } else if ("animation".equalsIgnoreCase(item.getNodeName())) {
                    tVKVodVideoInfo.setVodAnimationUrl(getFirstChildNodeValue(item));
                }
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_LOGO_TAG, String.valueOf(2));
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
        if (tVKNetVideoInfo == null) {
            return false;
        }
        if (tVKNetVideoInfo.getLogoList().size() == 0 && TextUtils.isEmpty(tVKNetVideoInfo.getVodLogoActionUrl()) && tVKNetVideoInfo.getLogoPositionInfo() == null) {
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
    }
}
