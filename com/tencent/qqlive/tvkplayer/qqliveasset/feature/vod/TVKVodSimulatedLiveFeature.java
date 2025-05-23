package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import androidx.annotation.NonNull;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKSimulatedLivePrevidGenerator;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodSimulatedLiveFeature extends TVKVodPlayerFeatureBase {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKSimulatedLiveFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
        private String mChid;

        public TVKSimulatedLiveFeatureParam(String str) {
            this.mChid = str;
        }

        public String getChid() {
            return this.mChid;
        }
    }

    public TVKVodSimulatedLiveFeature(@NonNull TVKContext tVKContext) {
        super(tVKContext);
    }

    private void parsePseudolive(TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        TVKVodVideoInfo.SimulatedLiveInfo simulatedLiveInfo = new TVKVodVideoInfo.SimulatedLiveInfo();
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if ("ext".equalsIgnoreCase(item.getNodeName())) {
                    simulatedLiveInfo.setExtInfo(getFirstChildNodeValue(item));
                } else if ("chid".equalsIgnoreCase(item.getNodeName())) {
                    simulatedLiveInfo.setChid(getFirstChildNodeValue(item));
                } else if ("curplaypositions".equalsIgnoreCase(item.getNodeName())) {
                    simulatedLiveInfo.setCurrentPositionSec(TVKUtils.optLong(getFirstChildNodeValue(item), 0L));
                } else if ("playvidlist".equalsIgnoreCase(item.getNodeName())) {
                    simulatedLiveInfo.addVid(getFirstChildNodeValue(item));
                }
            }
        }
        tVKVodVideoInfo.setSimulatedLiveInfo(simulatedLiveInfo);
    }

    private void parseVi(TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "vi".equalsIgnoreCase(item.getNodeName())) {
                NodeList elementsByTagName = ((Element) item).getElementsByTagName("pseudolive");
                if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                    parsePseudolive(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
                    return;
                }
                return;
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        TVKSimulatedLiveFeatureParam tVKSimulatedLiveFeatureParam;
        ITVKAsset asset = tVKCGIRequestParam.getVideoInfo().getAsset();
        if (!(asset instanceof TVKOnlineSimulatedLiveAsset)) {
            return;
        }
        HashMap hashMap = new HashMap();
        ITVKAsset asset2 = tVKCGIRequestParam.getAsset();
        if (asset2.getAssetType() == 1048576) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_PREVID_TYPE, "1");
            map.put("previd", TVKSimulatedLivePrevidGenerator.generate((TVKOnlineSimulatedLiveAsset) asset2));
        } else if (asset2.getAssetType() == 131072) {
            hashMap.put("preload", "1");
        }
        hashMap.put("pid", ((TVKOnlineSimulatedLiveAsset) asset).getPid());
        if (iTVKFeatureParamGroup == null) {
            tVKSimulatedLiveFeatureParam = null;
        } else {
            tVKSimulatedLiveFeatureParam = (TVKSimulatedLiveFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKSimulatedLiveFeatureParam.class);
        }
        if (tVKSimulatedLiveFeatureParam != null) {
            hashMap.put("chid", tVKSimulatedLiveFeatureParam.getChid());
        }
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_MEDIA_SCENE, TVKHttpUtils.encodeParamsToStringForUrlEncoding(hashMap, "UTF-8"));
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_PLAY_CONTROL, String.valueOf(TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_PLAY_CONTROL), 0) | 1));
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
        return ITVKPlayerFeature.FeatureRetryPriority.RETRY_NONE;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.VideoDecoderStrategy getVideoDecoderChooseStrategy() {
        return TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public boolean isMatchFeature(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            return false;
        }
        return !((TVKVodVideoInfo) tVKNetVideoInfo).getSimulatedLiveInfo().getVidList().isEmpty();
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
            parseVi(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        if (!(tVKPlayerInputParam.getPlayerVideoInfo().getAsset() instanceof TVKOnlineSimulatedLiveAsset)) {
            return;
        }
        tVKPlayerRuntimeParam.setStartPositionMs(tVKPlayerRuntimeParam.getNetVideoInfo().getStartPositionSec() * 1000);
        if (tVKPlayerRuntimeParam.getNetVideoInfo().isPreview()) {
            tVKPlayerRuntimeParam.setSkipEndPositionMs(0L);
        } else {
            tVKPlayerRuntimeParam.setSkipEndPositionMs(tVKPlayerRuntimeParam.getNetVideoInfo().getSkipEndPositionSec() * 1000);
        }
    }
}
