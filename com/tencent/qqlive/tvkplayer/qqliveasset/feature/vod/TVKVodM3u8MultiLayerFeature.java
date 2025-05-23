package com.tencent.qqlive.tvkplayer.qqliveasset.feature.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import java.util.Map;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodM3u8MultiLayerFeature extends TVKVodPlayerFeatureBase {
    private static final int SUPPORT_M3U8_MULTI_LAYER = 1;
    private static final int SUPPORT_MASTER_M3U8_AVS = 32;
    private static final int SUPPORT_MASTER_M3U8_AVS_SIGNAL_SUBTITLE_AUDIO = 16;
    private static final int SUPPORT_MASTER_M3U8_URL = 2;

    public TVKVodM3u8MultiLayerFeature(TVKContext tVKContext) {
        super(tVKContext);
    }

    private String getM3u8Content(@NonNull TVKVodVideoInfo tVKVodVideoInfo) {
        TVKVodVideoInfo.DirectM3u8Info masterM3u8Info = tVKVodVideoInfo.getMasterM3u8Info();
        if (masterM3u8Info != null && !TextUtils.isEmpty(masterM3u8Info.getM3u8Content())) {
            return masterM3u8Info.getM3u8Content();
        }
        return tVKVodVideoInfo.getM3u8();
    }

    private void parseDirectM3u8Node(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull NodeList nodeList) {
        TVKVodVideoInfo.DirectM3u8Info directM3u8Info = new TVKVodVideoInfo.DirectM3u8Info();
        boolean z16 = false;
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if ("master".equalsIgnoreCase(item.getNodeName())) {
                    directM3u8Info.setM3u8Content(getFirstChildNodeValue(item));
                } else if (TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID.equalsIgnoreCase(item.getNodeName())) {
                    directM3u8Info.setKeyId(getFirstChildNodeValue(item));
                } else if ("masterurl".equalsIgnoreCase(item.getNodeName())) {
                    directM3u8Info.setM3u8Url(getFirstChildNodeValue(item));
                } else if ("audiolist".equalsIgnoreCase(item.getNodeName())) {
                    tVKVodVideoInfo.addAudioM3u8Info(parseM3u8Node(item.getChildNodes()));
                } else if ("videolist".equalsIgnoreCase(item.getNodeName())) {
                    tVKVodVideoInfo.addVideoM3u8Info(parseM3u8Node(item.getChildNodes()));
                } else if ("captionlist".equalsIgnoreCase(item.getNodeName())) {
                    tVKVodVideoInfo.addSubTitleM3u8Info(parseM3u8Node(item.getChildNodes()));
                }
                z16 = true;
            }
        }
        if (z16) {
            tVKVodVideoInfo.setMasterM3u8Info(directM3u8Info);
        }
    }

    @Nullable
    private TVKVodVideoInfo.DirectM3u8Info parseM3u8Node(NodeList nodeList) {
        if (nodeList == null) {
            return null;
        }
        TVKVodVideoInfo.DirectM3u8Info directM3u8Info = new TVKVodVideoInfo.DirectM3u8Info();
        for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
            Node item = nodeList.item(i3);
            if (item.getNodeType() == 1) {
                if (TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8.equalsIgnoreCase(item.getNodeName())) {
                    directM3u8Info.setM3u8Content(getFirstChildNodeValue(item));
                } else if (TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_KEYID.equalsIgnoreCase(item.getNodeName())) {
                    directM3u8Info.setKeyId(getFirstChildNodeValue(item));
                }
            }
        }
        return directM3u8Info;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature
    public void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map) {
        boolean z16;
        int i3;
        int i16;
        int i17 = 1;
        int i18 = 0;
        if (TVKMediaPlayerConfig.PlayerConfig.vod_m3u8_multi_layer_parse_enable && TVKMediaPlayerConfig.PlayerConfig.qqlive_asset_player_use_proxy) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !TPDataTransportMgr.isNativeInit()) {
            i17 = 0;
        }
        if (TVKMediaPlayerConfig.PlayerConfig.is_support_vod_master_m3u8_url_enable) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        int i19 = i3 | i17;
        if (TVKMediaPlayerConfig.PlayerConfig.vod_avs_signal_subtitle_audio_enable) {
            i16 = 16;
        } else {
            i16 = 0;
        }
        int i26 = i19 | i16;
        if (TVKMediaPlayerConfig.PlayerConfig.vod_avs_enable) {
            i18 = 32;
        }
        int i27 = i26 | i18;
        if (i27 > 0) {
            map.put(TVKCommonParamEnum.REQ_PARAM_KEY_M3U8_MULTI_LAYER_TAG, String.valueOf(i27));
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority getPlayerAndDecoderChoosePriority() {
        return ITVKPlayerFeature.FeaturePlayerAndDecoderChoosePriority.PLAYER_AND_DECODER_CHOOSE_DEFAULT;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public TVKStrategyEnum.PlayerStrategy getPlayerChooseStrategy() {
        return TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY;
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
        if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
            TVKVodVideoInfo tVKVodVideoInfo = (TVKVodVideoInfo) tVKNetVideoInfo;
            if (tVKVodVideoInfo.getMasterM3u8Info() != null) {
                this.mLogger.info("match TVKVodM3u8MultiLayerFeature, masterM3u8:" + tVKVodVideoInfo.getMasterM3u8Info().getM3u8Content(), new Object[0]);
                return true;
            }
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
        int i3 = 0;
        while (true) {
            if (i3 >= childNodes.getLength()) {
                break;
            }
            Node item = childNodes.item(i3);
            if (item.getNodeType() == 1 && "play".equalsIgnoreCase(item.getNodeName())) {
                parseDirectM3u8Node(tVKVodVideoInfo, item.getChildNodes());
                break;
            }
            i3++;
        }
        tVKVodVideoInfo.setM3u8(getM3u8Content(tVKVodVideoInfo));
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature
    public void processOnCGISuccess(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam) {
    }
}
