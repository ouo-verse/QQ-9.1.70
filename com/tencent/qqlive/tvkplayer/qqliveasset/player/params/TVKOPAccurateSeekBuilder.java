package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPAccurateSeekBuilder implements ITVKOptionalParamBuilder {
    private boolean isAccurateStartForPreview(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        if (tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo() != null && "true".equals(tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_PREVIEW_ACCURATE_START, "true")) && tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo() != null && tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo().isPreview()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        if (isAccurateStartForPreview(tVKQQLiveAssetPlayerContext)) {
            TPOptionalParam<Boolean> buildBoolean = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_START_PLAYING_TIME_ACCURATE_SEEK, true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(buildBoolean);
            return arrayList;
        }
        long startPositionMs = tVKQQLiveAssetPlayerContext.getRuntimeParam().getStartPositionMs();
        if (startPositionMs > 0 && startPositionMs < TVKMediaPlayerConfig.PlayerConfig.position_of_accurate_startpos_ms) {
            TPOptionalParam<Boolean> buildBoolean2 = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_START_PLAYING_TIME_ACCURATE_SEEK, true);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(buildBoolean2);
            return arrayList2;
        }
        if (z16) {
            TPOptionalParam<Boolean> buildBoolean3 = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_START_PLAYING_TIME_ACCURATE_SEEK, true);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(buildBoolean3);
            return arrayList3;
        }
        return Collections.emptyList();
    }
}
