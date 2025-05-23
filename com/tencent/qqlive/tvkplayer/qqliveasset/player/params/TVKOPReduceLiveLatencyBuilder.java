package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPReduceLiveLatencyBuilder implements ITVKOptionalParamBuilder {
    private void addReduceLatencyConfig(List<TPOptionalParam<?>> list, TVKLiveVideoInfo tVKLiveVideoInfo) {
        list.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BEGIN_REDUCE_LATENCY_BUFFER_PACKET_DURATION_MS, tVKLiveVideoInfo.getStartReduceLatencyBufferSizeSec() * 1000.0f));
        list.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFER_PACKET_TOTAL_DURATION_MS, tVKLiveVideoInfo.getStopReduceLatencyBufferSizeSec() * 1000.0f));
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (!(netVideoInfo instanceof TVKLiveVideoInfo)) {
            return Collections.emptyList();
        }
        TVKLiveVideoInfo tVKLiveVideoInfo = (TVKLiveVideoInfo) netVideoInfo;
        if (tVKLiveVideoInfo.getReduceLatencyAction() == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int intValue = tVKLiveVideoInfo.getReduceLatencyAction().intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue == 2) {
                    arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_INT_REDUCE_LIVE_LATENCY_ACTION, 2L));
                    addReduceLatencyConfig(arrayList, tVKLiveVideoInfo);
                }
            } else {
                arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_REDUCE_LIVE_LATENCY_ACTION, 1));
                arrayList.add(TPOptionalParam.buildFloat(TPOptionalID.OPTIONAL_ID_BEFORE_FLOAT_REDUCE_LATENCY_SPEED_UP_RATE, tVKLiveVideoInfo.getSpeedUpRate()));
                addReduceLatencyConfig(arrayList, tVKLiveVideoInfo);
            }
        } else {
            arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_REDUCE_LIVE_LATENCY_ACTION, 0));
        }
        return arrayList;
    }
}
