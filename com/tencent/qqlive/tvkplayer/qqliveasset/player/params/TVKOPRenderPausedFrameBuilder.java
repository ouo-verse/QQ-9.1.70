package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPRenderPausedFrameBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_RENDER_FIRST_VIDEO_FRAME_WHEN_PAUSED_AND_SURFACE_SWITCH, TVKMediaPlayerConfig.PlayerConfig.enable_first_frame_render_when_paused));
        return arrayList;
    }
}
