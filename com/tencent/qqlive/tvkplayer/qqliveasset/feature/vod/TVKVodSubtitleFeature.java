package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKSubtitleTrackVinfo;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodSubtitleFeature extends TVKVodPlayerFeatureBase {
    private static final int NO_SOFT_SUBTITLE_IF_HAVE_HARD_SUBTITLE = 1;
    private static final int SELECTED_SUBTITLE = 1;
    private static final int SUPPORT_MULTI_SUBTITLE_SEPARATE = 1;
    private static final int SUPPORT_VTT_SUBTITLE = 1;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKSubtitleTrackFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
        private final String mSubtitleLangId;

        public TVKSubtitleTrackFeatureParam(String str) {
            this.mSubtitleLangId = str;
        }

        public String getSubtitleLangId() {
            return this.mSubtitleLangId;
        }
    }

    public TVKVodSubtitleFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private void addSubtitleMediaTrack(@NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        String name;
        boolean z16;
        TVKVodVideoInfo tVKVodVideoInfo = (TVKVodVideoInfo) tVKPlayerRuntimeParam.getNetVideoInfo();
        String selectedSubtitleTrack = getSelectedSubtitleTrack(tVKPlayerRuntimeParam);
        TVKNetVideoInfo.SubTitle curSubtitle = tVKVodVideoInfo.getCurSubtitle();
        if (TextUtils.isEmpty(selectedSubtitleTrack) && curSubtitle != null) {
            selectedSubtitleTrack = curSubtitle.getName();
        }
        ITVKLogger iTVKLogger = this.mLogger;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addSubtitleMediaTrack, selectedName:");
        sb5.append(selectedSubtitleTrack);
        sb5.append(", cgi curSubtitle:");
        if (curSubtitle == null) {
            name = "";
        } else {
            name = curSubtitle.getName();
        }
        sb5.append(name);
        iTVKLogger.info(sb5.toString(), new Object[0]);
        tVKPlayerRuntimeParam.removeAllCgiReturnTrackInfoByTrackType(3);
        Iterator<TVKNetVideoInfo.SubTitle> it = tVKVodVideoInfo.getSubTitleList().iterator();
        while (it.hasNext()) {
            TVKNetVideoInfo.SubTitle next = it.next();
            if (TextUtils.isEmpty(next.getName())) {
                this.mLogger.info("subtitle name is empty.", new Object[0]);
            } else {
                TVKSubtitleTrackVinfo tVKSubtitleTrackVinfo = new TVKSubtitleTrackVinfo();
                tVKSubtitleTrackVinfo.setTrackType(3);
                tVKSubtitleTrackVinfo.setTrackName(next.getName());
                tVKSubtitleTrackVinfo.setSubTitle(next);
                if (tVKVodVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_DL_PROXY) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                tVKSubtitleTrackVinfo.setOffline(z16);
                if (!TextUtils.isEmpty(selectedSubtitleTrack) && tVKSubtitleTrackVinfo.getTrackName().equals(selectedSubtitleTrack)) {
                    tVKSubtitleTrackVinfo.setSelected(true);
                    tVKVodVideoInfo.setCurSubtitle(next);
                } else {
                    tVKSubtitleTrackVinfo.setSelected(false);
                }
                tVKPlayerRuntimeParam.addTrackInfo(tVKSubtitleTrackVinfo);
            }
        }
    }

    private String getSelectedSubtitleTrack(@NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        for (TVKTrackInfo tVKTrackInfo : tVKPlayerRuntimeParam.getTrackInfoList()) {
            if (tVKTrackInfo.getTrackType() == 3 && tVKTrackInfo.isSelected()) {
                return tVKTrackInfo.getTrackName();
            }
        }
        return "";
    }

    private void parseIsAVS(@NonNull Node node, @NonNull TVKNetVideoInfo.SubTitle subTitle) {
        if (TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(node, "isavs"), 0) == 1) {
            subTitle.setIsAvsSeparate(true);
        } else {
            subTitle.setIsAvsSeparate(false);
        }
    }

    private void parseVinfoSflNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        if (nodeList == null) {
            return;
        }
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && "fi".equalsIgnoreCase(item.getNodeName())) {
                TVKNetVideoInfo.SubTitle subTitle = new TVKNetVideoInfo.SubTitle();
                subTitle.setName(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "name"));
                subTitle.setKeyId(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID));
                subTitle.setLang(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "lang"));
                subTitle.setCaptionTopHPercent(TVKUtils.optFloat(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "captionTopHPercent"), 0.0f));
                subTitle.setCaptionBottomHPercent(TVKUtils.optFloat(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "captionBottomHPercent"), 0.0f));
                subTitle.setSubtitleType(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "captionType"), 0));
                subTitle.setLangId(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "langId"), 0));
                subTitle.setM3u8(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8));
                int optInt = TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "selected"), 0);
                parseIsAVS(item, subTitle);
                ArrayList arrayList = new ArrayList();
                arrayList.add(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "url"));
                subTitle.setUrlList(arrayList);
                if (optInt == 1) {
                    tVKVodVideoInfo.setCurSubtitle(subTitle);
                }
                tVKVodVideoInfo.addSubTitle(subTitle);
            }
        }
    }

    private ArrayList<String> parseVinfoUrlListNode(NodeList nodeList) {
        if (nodeList == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1 && SensorJsPlugin.SENSOR_INTERVAL_UI.equalsIgnoreCase(item.getNodeName())) {
                arrayList.add(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "url"));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        TVKSubtitleTrackFeatureParam tVKSubtitleTrackFeatureParam;
        if (!TVKMediaPlayerConfig.PlayerConfig.is_use_subtitle || TVKUtils.optBoolean(tVKCGIRequestParam.getVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_DISABLE_SOFT_SUBTITLE, ""), false) || (tVKCGIRequestParam.getVideoInfo().getAsset() instanceof TVKOnlineSimulatedLiveAsset)) {
            return;
        }
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_SPSRT, String.valueOf(1));
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPCAPTIONTRACK, String.valueOf(1));
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPCAPTIONTYPE, String.valueOf(1));
        if (iTVKFeatureParamGroup == null) {
            tVKSubtitleTrackFeatureParam = null;
        } else {
            tVKSubtitleTrackFeatureParam = (TVKSubtitleTrackFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKSubtitleTrackFeatureParam.class);
        }
        String configMapValue = tVKCGIRequestParam.getVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_SUBTITLE_LANGUAGE_ID, "");
        if (tVKSubtitleTrackFeatureParam != null) {
            configMapValue = tVKSubtitleTrackFeatureParam.getSubtitleLangId();
        }
        if (!TextUtils.isEmpty(configMapValue)) {
            map.put("lang_code", configMapValue);
        }
        if (TVKMediaPlayerConfig.PlayerConfig.enable_subtitle_track_direct_m3u8_output) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPHLS, String.valueOf(TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_SPHLS), 0) | 4));
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
        if (tVKNetVideoInfo != null && !tVKNetVideoInfo.getSubTitleList().isEmpty()) {
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
        NodeList elementsByTagName = ((Element) node).getElementsByTagName("sfl");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            parseVinfoSflNode(tVKVodVideoInfo, elementsByTagName.item(0).getChildNodes());
            if (tVKVodVideoInfo.getCurSubtitle() == null && !tVKVodVideoInfo.getSubTitleList().isEmpty()) {
                tVKVodVideoInfo.setCurSubtitle(tVKVodVideoInfo.getSubTitleList().get(0));
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        if (tVKPlayerRuntimeParam.getNetVideoInfo() == null) {
            return;
        }
        addSubtitleMediaTrack(tVKPlayerRuntimeParam);
    }
}
