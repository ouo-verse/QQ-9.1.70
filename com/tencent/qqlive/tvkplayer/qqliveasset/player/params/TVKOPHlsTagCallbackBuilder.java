package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPHlsTagCallbackBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        String[] splitStringToArray = TVKUtils.splitStringToArray(TVKMediaPlayerConfig.PlayerConfig.live_hls_tag_array_list, ",");
        if (splitStringToArray.length > 0) {
            TPOptionalParam<String[]> buildQueueString = TPOptionalParam.buildQueueString(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_STRING_HLS_TAG_CALLBACK, splitStringToArray);
            ArrayList arrayList = new ArrayList();
            arrayList.add(buildQueueString);
            return arrayList;
        }
        return Collections.emptyList();
    }
}
