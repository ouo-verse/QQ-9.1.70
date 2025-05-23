package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPVideoCaptureBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TVKPlayerVideoInfo playerVideoInfo = tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo();
        if (playerVideoInfo == null) {
            return Collections.emptyList();
        }
        if (playerVideoInfo.isVideoCaptureMode()) {
            TPOptionalParam<Integer> buildInt = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_VIDEO_PIXEL_FORMAT, 37);
            TPOptionalParam<int[]> buildQueueInt = TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_VIDEO_RENDERER_TYPE, new int[]{-1});
            TPOptionalParam<int[]> buildQueueInt2 = TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_AUDIO_RENDERER_TYPE, new int[]{-1});
            TPOptionalParam<Boolean> buildBoolean = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_AV_SYNC, false);
            TPOptionalParam<Boolean> buildBoolean2 = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_VIDEO_FRAME_CALLBACK, true);
            TPOptionalParam<Integer> buildInt2 = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_BUFFER_STRATEGY, 0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(buildInt);
            arrayList.add(buildQueueInt);
            arrayList.add(buildQueueInt2);
            arrayList.add(buildBoolean);
            arrayList.add(buildBoolean2);
            arrayList.add(buildInt2);
            return arrayList;
        }
        return Collections.emptyList();
    }
}
