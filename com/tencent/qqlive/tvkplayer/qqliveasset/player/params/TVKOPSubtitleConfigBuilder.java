package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.subtitle.TVKSubtitleRenderParams;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer;
import com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.TVKSubtitleUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPSubtitleConfigBuilder implements ITVKOptionalParamBuilder {
    public void applyNewSubtitlePostProcessConfig(List<TPOptionalParam<?>> list) {
        if (TVKMediaPlayerConfig.PlayerConfig.enable_new_subtitle_postprocess) {
            list.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_NEW_SUBTITLE_POSTPROCESS, true));
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TVKSubtitleRenderParams renderParam;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_SUBTITLE_DATA_TYPE, 1));
        arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_SUBTITLE_DATA_CALLBACK, true));
        ITVKSubtitleRenderer subtitleRenderer = tVKQQLiveAssetPlayerContext.getSubtitleRenderer();
        if ((subtitleRenderer instanceof ITVKSubtitleRendererController) && (renderParam = ((ITVKSubtitleRendererController) subtitleRenderer).getRenderParam()) != null) {
            arrayList.add(TPOptionalParam.buildObject(TPOptionalID.OPTIONAL_ID_GLOBAL_OBJECT_SUBTITLE_RENDER_PARAMS, TVKSubtitleUtils.generateTPSubtitleRenderParams(renderParam)));
        }
        applyNewSubtitlePostProcessConfig(arrayList);
        return arrayList;
    }
}
