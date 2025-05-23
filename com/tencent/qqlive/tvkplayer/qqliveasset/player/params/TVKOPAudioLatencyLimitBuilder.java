package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPAudioLatencyLimitBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        long j3 = TVKMediaPlayerConfig.PlayerConfig.non_bluetooth_latency_threshold_ms;
        if ("HUAWEI".equals(TVKVcSystemInfo.getManufacturer())) {
            j3 = TVKMediaPlayerConfig.PlayerConfig.non_bluetooth_latency_threshold_ms_for_huawei;
        }
        arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_AUDIO_NON_BLUETOOTH_MAX_LIMIT_LATENCY_MS, j3));
        arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_AUDIO_BLUETOOTH_MAX_LIMIT_LATENCY_MS, TVKMediaPlayerConfig.PlayerConfig.bluetooth_latency_threshold_ms));
        return arrayList;
    }
}
