package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPAudioTrackConfigBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TPOptionalParam<Integer> buildInt = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_AUDIOTRACK_GET_LATENCY_STRATEGY, TVKMediaPlayerConfig.PlayerConfig.audio_track_get_latency_strategy);
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildInt);
        arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_AUDIO_TRACK_WRITE_STUCK_FALLBACK, TVKMediaPlayerConfig.PlayerConfig.enable_audio_track_write_stuck_fallback));
        return arrayList;
    }
}
