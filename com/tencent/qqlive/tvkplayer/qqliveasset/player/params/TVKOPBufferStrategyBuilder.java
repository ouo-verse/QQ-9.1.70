package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPBufferStrategyBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        int i3 = TVKMediaPlayerConfig.PlayerConfig.vod_buffer_strategy;
        ITVKAsset tVKAsset = tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset();
        if (TVKAssetUtils.isVodAsset(tVKAsset) && i3 != -1) {
            arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_BUFFER_STRATEGY, i3));
        }
        int i16 = TVKMediaPlayerConfig.PlayerConfig.live_buffer_strategy;
        if (TVKAssetUtils.isLiveAsset(tVKAsset) && i16 != -1) {
            arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_BUFFER_STRATEGY, i16));
        }
        return arrayList;
    }
}
