package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPDolbyVisionDVMAConfigBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        boolean z17;
        if (TVKAssetUtils.isVodAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset()) && tVKQQLiveAssetPlayerContext.getRuntimeParam().isDolbyVision() && TVKCapabilityMgr.getInstance().isSupportDolbyVisionSoftRender()) {
            z17 = true;
        } else {
            z17 = false;
        }
        TPOptionalParam<Boolean> buildBoolean = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, z17);
        TPOptionalParam<Boolean> buildBoolean2 = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_DISABLE_MEDIACODEC_DOLBY_VISION_COMPONENT, z17);
        TPOptionalParam<Boolean> buildBoolean3 = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_VIDEO_ENABLE_MEDIACODEC_RELEASE_OUTPUT_BUFFER_WITH_TIMESTAMP, z17);
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildBoolean);
        arrayList.add(buildBoolean2);
        arrayList.add(buildBoolean3);
        return arrayList;
    }
}
