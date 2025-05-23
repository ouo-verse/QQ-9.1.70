package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPBufferConfigBuilder implements ITVKOptionalParamBuilder {
    private static long choosePlayerBufferSizeStrategy(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        int i3;
        TVKPlayerVideoInfo playerVideoInfo = tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo();
        if (playerVideoInfo != null && 1 == TVKUtils.optInt(playerVideoInfo.getConfigMapValue("min_buffer_mode", ""), 0)) {
            i3 = TVKMediaPlayerConfig.PlayerConfig.buffer_pool_min_size;
        } else if (TVKAssetUtils.isLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset())) {
            i3 = TVKMediaPlayerConfig.PlayerConfig.buffer_pool_liveStreaming;
        } else {
            return getVodPlayerBufferSize(tVKQQLiveAssetPlayerContext.getRuntimeParam().getMediaFormat());
        }
        return i3;
    }

    private static long getVodPlayerBufferSize(int i3) {
        int i16;
        if (i3 != 4 && i3 != 5) {
            i16 = TVKMediaPlayerConfig.PlayerConfig.buffer_pool_avgSize;
        } else {
            i16 = TVKMediaPlayerConfig.PlayerConfig.buffer_pool_higSize;
        }
        return i16;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        int i3;
        ArrayList arrayList = new ArrayList();
        TVKPlayerVideoInfo playerVideoInfo = tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo();
        long choosePlayerBufferSizeStrategy = choosePlayerBufferSizeStrategy(tVKQQLiveAssetPlayerContext);
        if (choosePlayerBufferSizeStrategy > 0) {
            arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFER_PACKET_TOTAL_DURATION_MS, choosePlayerBufferSizeStrategy));
        }
        if (playerVideoInfo != null && TVKAssetUtils.isLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset())) {
            i3 = TVKMediaPlayerConfig.PlayerConfig.prepare_buffer_size_livestreaming;
        } else {
            i3 = TVKMediaPlayerConfig.PlayerConfig.prepare_buffer_size_vod;
        }
        long j3 = i3;
        if (j3 > 0) {
            arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_PREPARE_PACKET_TOTAL_DURATION_MS, j3));
        }
        int i16 = TVKMediaPlayerConfig.PlayerConfig.least_buffer_size_for_seeking;
        if (i16 > 0) {
            arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_FOR_PLAYBACK_MS, i16));
        }
        arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFERING_FILTER_THRESHOLD_MS, TVKMediaPlayerConfig.PlayerConfig.buffering_filter_threshold_ms));
        return arrayList;
    }
}
