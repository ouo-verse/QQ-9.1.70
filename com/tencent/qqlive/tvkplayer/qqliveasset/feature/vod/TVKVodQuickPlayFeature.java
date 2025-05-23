package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import androidx.annotation.NonNull;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodQuickPlayAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
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

/* loaded from: classes23.dex */
public class TVKVodQuickPlayFeature extends TVKVodPlayerFeatureBase {
    public TVKVodQuickPlayFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private long getPosMsForHasHistory(boolean z16, long j3, long j16) {
        if (z16 && j3 == 0 && j16 != 0) {
            return j16;
        }
        return j3;
    }

    private void handleQuickPlaySkipStartPosition(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        TVKVodQuickPlayFeature tVKVodQuickPlayFeature;
        long j3;
        if ("true".equals(tVKPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_FORCE_USE_APP_SKIP_START_END, ""))) {
            return;
        }
        boolean equals = tVKPlayerVideoInfo.getConfigMapValue("historyVid", "").equals(tVKPlayerRuntimeParam.getNetVideoInfo().getVid());
        boolean equals2 = "true".equals(tVKPlayerVideoInfo.getConfigMapValue("skip_start_end", ""));
        long startPositionMs = tVKPlayerRuntimeParam.getStartPositionMs();
        long skipEndPositionMs = tVKPlayerRuntimeParam.getSkipEndPositionMs();
        long startPositionSec = r2.getStartPositionSec() * 1000;
        long skipEndPositionSec = r2.getSkipEndPositionSec() * 1000;
        if (equals) {
            startPositionSec = getPosMsForHasHistory(equals2, startPositionMs, startPositionSec);
            j3 = getPosMsForHasHistory(equals2, skipEndPositionMs, skipEndPositionSec);
            tVKVodQuickPlayFeature = this;
        } else {
            if (!equals2) {
                startPositionSec = 0;
            }
            if (!equals2) {
                skipEndPositionSec = 0;
            }
            tVKVodQuickPlayFeature = this;
            j3 = skipEndPositionSec;
        }
        tVKVodQuickPlayFeature.mLogger.info("dealStartSkipPositionForQuickPlay, hasHistoryVid=" + equals + ", useServerTime=" + equals2 + ", startPosMs=" + startPositionSec + ", skipEndPosMs=" + j3, new Object[0]);
        tVKPlayerRuntimeParam.setStartPositionMs(startPositionSec);
        tVKPlayerRuntimeParam.setSkipEndPositionMs(j3);
    }

    private void parseVinfoViNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "vi".equalsIgnoreCase(item.getNodeName())) {
                if (TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "isprevid"), 0) == 1) {
                    z16 = true;
                }
                tVKVodVideoInfo.setQuickPlay(z16);
                return;
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        ITVKAsset asset = tVKCGIRequestParam.getAsset();
        if (asset.getAssetType() == 524288) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_PREVID_TYPE, "0");
            map.put("previd", ((TVKOnlineVodQuickPlayAsset) asset).getPrevid());
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
        if ((tVKNetVideoInfo instanceof TVKVodVideoInfo) && ((TVKVodVideoInfo) tVKNetVideoInfo).isQuickPlay()) {
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
        boolean z16;
        boolean z17;
        String str;
        TVKNetVideoInfo netVideoInfo = tVKPlayerRuntimeParam.getNetVideoInfo();
        ITVKAsset tVKAsset = tVKPlayerRuntimeParam.getTVKAsset();
        if ((netVideoInfo instanceof TVKVodVideoInfo) && ((TVKVodVideoInfo) netVideoInfo).isQuickPlay()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (tVKAsset != null && tVKAsset.getAssetType() == 524288) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && !z16) {
            tVKPlayerRuntimeParam.setQuickPlayWithOfflineResource(false);
            return;
        }
        String vid = netVideoInfo.getVid();
        if (netVideoInfo instanceof TVKVodVideoInfo) {
            str = ((TVKVodVideoInfo) netVideoInfo).getCid();
        } else {
            str = "";
        }
        tVKPlayerRuntimeParam.setTVKAsset(TVKAssetFactory.createOnlineVodVidAsset(vid, str));
        if (netVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_DL_PROXY) {
            tVKPlayerRuntimeParam.setQuickPlayWithOfflineResource(true);
            TVKOnlineVodVidAsset tVKOnlineVodVidAsset = (TVKOnlineVodVidAsset) tVKPlayerRuntimeParam.getTVKAsset();
            tVKPlayerRuntimeParam.setTVKAsset(TVKAssetFactory.createOfflineVodVidAsset(tVKOnlineVodVidAsset.getVid(), tVKOnlineVodVidAsset.getCid(), 0));
            return;
        }
        handleQuickPlaySkipStartPosition(tVKPlayerInputParam.getPlayerVideoInfo(), tVKPlayerRuntimeParam);
    }
}
