package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPSwitchDataSourceConfigBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TPOptionalParam<Long> buildLong = TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_MIN_LEFT_PACKET_QUEUE_TOTAL_DURATION_MS_FOR_SWITCH_DATA_SOURCE, TVKMediaPlayerConfig.PlayerConfig.min_left_packet_queue_total_duration_ms);
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildLong);
        return arrayList;
    }
}
