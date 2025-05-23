package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import java.util.ArrayList;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodMultiAudioTrackFeature extends TVKVodPlayerFeatureBase {
    private static final int CHACHA20_SUPPORT_EXTERNAL_AUDIOTRACK = 16;
    private static final String ORIGINAL_AUDIO_TRACK_NAME = "tvk_original_audio_track_name";
    private static final int SELECTED_AUDIOTRACK = 1;
    private static final int SUPPORT_ALL_EXTERNAL_AUDIOTRACK_WITH_URL = 8;
    private static final int SUPPORT_MULTI_AUDIOTRACK = 1;
    private static final int SUPPORT_PROVIDE_INTERNAL_AUDIOTRACK_INFO = 4;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKAudioTrackFeatureParam implements ITVKFeatureBase.ITVKFeatureParam {
        private final String mAudioTrack;
        private final long mCurPositionSec;

        public TVKAudioTrackFeatureParam(String str, long j3) {
            this.mAudioTrack = str;
            this.mCurPositionSec = j3;
        }

        public String getAudioTrack() {
            return this.mAudioTrack;
        }

        public long getCurPositionSec() {
            return this.mCurPositionSec;
        }
    }

    public TVKVodMultiAudioTrackFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private void addAudioMediaTrack(TVKPlayerInputParam tVKPlayerInputParam, TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        boolean z16;
        TVKNetVideoInfo.AudioTrackInfo curAudioTrack = tVKPlayerRuntimeParam.getNetVideoInfo().getCurAudioTrack();
        boolean z17 = false;
        for (TVKNetVideoInfo.AudioTrackInfo audioTrackInfo : tVKPlayerRuntimeParam.getNetVideoInfo().getAudioTrackList()) {
            if (TextUtils.isEmpty(audioTrackInfo.getAudioTrack())) {
                this.mLogger.info("audio name is empty.", new Object[0]);
            } else {
                TVKAudioTrackVinfo tVKAudioTrackVinfo = new TVKAudioTrackVinfo();
                tVKAudioTrackVinfo.setTrackType(2);
                tVKAudioTrackVinfo.setTrackName(audioTrackInfo.getAudioShowName());
                tVKAudioTrackVinfo.setAudioTrackInfo(audioTrackInfo);
                if (tVKPlayerRuntimeParam.getNetVideoInfo().getFromType() == TVKVideoInfoFromType.FROM_TYPE_DL_PROXY) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                tVKAudioTrackVinfo.setOffline(z16);
                if (curAudioTrack != null && tVKAudioTrackVinfo.getTrackName().equals(curAudioTrack.getAudioShowName())) {
                    tVKAudioTrackVinfo.setSelected(true);
                    z17 = true;
                } else {
                    tVKAudioTrackVinfo.setSelected(false);
                }
                tVKPlayerRuntimeParam.addTrackInfo(tVKAudioTrackVinfo);
            }
        }
        if (!"true".equals(tVKPlayerInputParam.getPlayerVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_ENABLE_VOD_INTERNAL_AUDIO_TRACK, "true"))) {
            TVKAudioTrackVinfo tVKAudioTrackVinfo2 = new TVKAudioTrackVinfo();
            tVKAudioTrackVinfo2.setTrackType(2);
            tVKAudioTrackVinfo2.setTrackName(ORIGINAL_AUDIO_TRACK_NAME);
            tVKAudioTrackVinfo2.setSelected(!z17);
            tVKAudioTrackVinfo2.setAudioTrackInfo(new TVKNetVideoInfo.AudioTrackInfo());
            tVKAudioTrackVinfo2.getAudioTrackInfo().setTrackType(1);
            tVKPlayerRuntimeParam.addTrackInfo(tVKAudioTrackVinfo2);
        }
    }

    private void parseIsAVS(@NonNull Node node, @NonNull TVKNetVideoInfo.AudioTrackInfo audioTrackInfo) {
        if (TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(node, "isavs"), 0) == 1) {
            audioTrackInfo.setIsAvsSeparate(true);
        } else {
            audioTrackInfo.setIsAvsSeparate(false);
        }
    }

    private void parseVinfoAlNode(@NonNull TVKVodVideoInfo tVKVodVideoInfo, NodeList nodeList) {
        int i3;
        boolean z16;
        if (nodeList == null) {
            return;
        }
        for (int i16 = 0; i16 < nodeList.getLength(); i16++) {
            Node item = nodeList.item(i16);
            if (item.getNodeType() == 1) {
                TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = new TVKNetVideoInfo.AudioTrackInfo();
                if ("ai".equalsIgnoreCase(item.getNodeName())) {
                    audioTrackInfo.setFormatId(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "id"), 0));
                    audioTrackInfo.setAction(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "action"));
                    audioTrackInfo.setAudioType(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "audio"), 0));
                    if (TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "lmt"), 0) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    audioTrackInfo.setVipOnly(z16);
                    audioTrackInfo.setKeyId(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID));
                    audioTrackInfo.setAudioShowName(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "name"));
                    audioTrackInfo.setAudioPrePlayTimeSec(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "preview"), 0));
                    audioTrackInfo.setAudioTrack(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "track"));
                    audioTrackInfo.setTrackType(TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "type"), 0));
                    audioTrackInfo.setM3u8(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8));
                    i3 = TVKUtils.optInt(TVKVodPlayerFeatureBase.getElementsTagNameStringValue(item, "sl"), 0);
                    parseIsAVS(item, audioTrackInfo);
                    NodeList elementsByTagName = ((Element) item).getElementsByTagName("ul");
                    if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                        audioTrackInfo.setAudioUrlList(parseVinfoUINode(elementsByTagName.item(0).getChildNodes()));
                    }
                } else {
                    i3 = 0;
                }
                if (!TextUtils.isEmpty(audioTrackInfo.getAudioShowName())) {
                    tVKVodVideoInfo.addAudioTrack(audioTrackInfo);
                }
                if (i3 == 1) {
                    tVKVodVideoInfo.setCurAudioTrack(audioTrackInfo);
                }
            }
        }
    }

    private ArrayList<String> parseVinfoUINode(NodeList nodeList) {
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
        int i3;
        TVKAudioTrackFeatureParam tVKAudioTrackFeatureParam;
        long j3;
        if (!TVKMediaPlayerConfig.PlayerConfig.is_support_multi_audiotrack || (tVKCGIRequestParam.getVideoInfo().getAsset() instanceof TVKOnlineSimulatedLiveAsset)) {
            return;
        }
        if (TVKUtils.optBoolean(tVKCGIRequestParam.getVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_ENABLE_VOD_INTERNAL_AUDIO_TRACK, "true"), false)) {
            i3 = 13;
        } else {
            i3 = 9;
        }
        if (TVKMediaPlayerConfig.PlayerConfig.chacha20_support_external_audiotrack) {
            i3 |= 16;
        }
        map.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_SPAU_TAG, String.valueOf(i3));
        if (iTVKFeatureParamGroup == null) {
            tVKAudioTrackFeatureParam = null;
        } else {
            tVKAudioTrackFeatureParam = (TVKAudioTrackFeatureParam) iTVKFeatureParamGroup.getFeatureParamByClass(TVKAudioTrackFeatureParam.class);
        }
        String configMapValue = tVKCGIRequestParam.getVideoInfo().getConfigMapValue("track", "");
        if (tVKAudioTrackFeatureParam != null) {
            configMapValue = tVKAudioTrackFeatureParam.getAudioTrack();
            j3 = tVKAudioTrackFeatureParam.getCurPositionSec();
        } else {
            j3 = 0;
        }
        if (!TextUtils.isEmpty(configMapValue)) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_INNER_ATIME, String.valueOf(j3));
            map.put("track", configMapValue);
        }
        if (TVKMediaPlayerConfig.PlayerConfig.enable_audio_track_direct_m3u8_output) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_SPHLS, String.valueOf(TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_SPHLS), 0) | 8));
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
        if (tVKNetVideoInfo != null && tVKNetVideoInfo.getAudioTrackList() != null && !tVKNetVideoInfo.getAudioTrackList().isEmpty()) {
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
        for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
            Node item = childNodes.item(i3);
            if (item.getNodeType() == 1 && "al".equalsIgnoreCase(item.getNodeName())) {
                parseVinfoAlNode(tVKVodVideoInfo, item.getChildNodes());
                return;
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
        if (tVKPlayerRuntimeParam.getNetVideoInfo() == null) {
            return;
        }
        tVKPlayerRuntimeParam.removeAllCgiReturnTrackInfoByTrackType(2);
        addAudioMediaTrack(tVKPlayerInputParam, tVKPlayerRuntimeParam);
    }
}
