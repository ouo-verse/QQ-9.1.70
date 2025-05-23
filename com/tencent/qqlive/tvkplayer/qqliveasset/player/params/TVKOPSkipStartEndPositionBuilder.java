package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPSkipStartEndPositionBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TVKPlayerRuntimeParam runtimeParam = tVKQQLiveAssetPlayerContext.getRuntimeParam();
        TPOptionalParam<Long> buildLong = TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS, runtimeParam.getLastPositionMs());
        TPOptionalParam<Long> buildLong2 = TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_SKIP_END_TIME_MS, runtimeParam.getSkipEndPositionMs());
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildLong);
        arrayList.add(buildLong2);
        return arrayList;
    }
}
