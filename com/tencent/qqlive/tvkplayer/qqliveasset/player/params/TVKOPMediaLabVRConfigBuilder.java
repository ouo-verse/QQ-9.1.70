package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPMediaLabVRConfigBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        boolean z17;
        if (tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo() == null) {
            return Collections.emptyList();
        }
        if (tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo().getMediaLabVR() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (TVKMediaPlayerConfig.PlayerConfig.enable_medialab_vr && z17) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_DEMUXER_TYPE, new int[]{0}));
            arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_KEEP_ORIGINAL_PTS, true));
            return arrayList;
        }
        return Collections.emptyList();
    }
}
