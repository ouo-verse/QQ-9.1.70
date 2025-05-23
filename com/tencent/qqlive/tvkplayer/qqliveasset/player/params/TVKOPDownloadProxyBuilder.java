package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPDownloadProxyBuilder implements ITVKOptionalParamBuilder {
    private static final String TAG = "TPOPDownloadProxyBuilder";

    private void addDownloadProxyOptionalParams(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, List<TPOptionalParam<?>> list) {
        TVKPlayerInputParam inputParam = tVKQQLiveAssetPlayerContext.getInputParam();
        list.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_USE_DOWNLOAD_PROXY, true));
        list.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK, inputParam.isAdaptiveDefinition()));
        if (tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo() != null) {
            list.add(TPOptionalParam.buildLong("optional_id_global_long_adaptive_limit_bitrate_range_max", tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo().getMaxBitrate()));
        }
        list.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_ADAPTIVE_LIMIT_BITRATE_RANGE_MIN, 0L));
        Integer adaptiveMode = tVKQQLiveAssetPlayerContext.getInputParam().getAdaptiveMode();
        if (adaptiveMode != null) {
            list.add(TPOptionalParam.buildInt(TPDataTransportEnum.TASK_OPTIONAL_CONFIG_PARAM_INT_ADAPTIVE_MODE, adaptiveMode.intValue()));
        }
    }

    private TVKStrategyEnum.ProxyStrategy getProxyStrategy(List<ITVKPlayerFeature> list, TVKNetVideoInfo tVKNetVideoInfo) {
        TVKStrategyEnum.ProxyStrategy proxyStrategy = TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_AUTO;
        Iterator<ITVKPlayerFeature> it = list.iterator();
        while (it.hasNext()) {
            TVKStrategyEnum.ProxyStrategy proxyStrategy2 = TVKPlayerFeatureUtils.getProxyStrategy(it.next(), tVKNetVideoInfo);
            if (proxyStrategy2 == TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_MUST_NONE) {
                return proxyStrategy2;
            }
            if (proxyStrategy2 == TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_MUST) {
                proxyStrategy = proxyStrategy2;
            }
        }
        return proxyStrategy;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        List<ITVKPlayerFeature> livePlayerFeatureList;
        ITVKAsset tVKAsset = tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset();
        if (!TVKAssetUtils.isQQLiveAsset(tVKAsset)) {
            TVKLogUtil.w(TAG, "not qqLiveAssetPlay");
            return Collections.emptyList();
        }
        ITVKPlayerFeatureGroup featureGroup = tVKQQLiveAssetPlayerContext.getFeatureGroup();
        if (TVKAssetUtils.isVodAsset(tVKAsset)) {
            livePlayerFeatureList = featureGroup.getVodPlayerFeatureList();
        } else {
            livePlayerFeatureList = featureGroup.getLivePlayerFeatureList();
        }
        TVKStrategyEnum.ProxyStrategy proxyStrategy = getProxyStrategy(livePlayerFeatureList, tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo());
        ArrayList arrayList = new ArrayList();
        if (TVKMediaPlayerConfig.PlayerConfig.qqlive_asset_player_use_proxy && proxyStrategy != TVKStrategyEnum.ProxyStrategy.PROXY_STRATEGY_MUST_NONE && !tVKQQLiveAssetPlayerContext.getRuntimeParam().disableDataTransport()) {
            addDownloadProxyOptionalParams(tVKQQLiveAssetPlayerContext, arrayList);
        } else {
            arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_USE_DOWNLOAD_PROXY, false));
        }
        return arrayList;
    }
}
