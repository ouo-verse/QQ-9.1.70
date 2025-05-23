package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.List;

/* loaded from: classes23.dex */
interface ITVKOptionalParamBuilder {
    @NonNull
    List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16);
}
