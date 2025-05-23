package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPMediaCodecParamsBuilder implements ITVKOptionalParamBuilder {
    private static final int DEFAULT_ENABLE_OPPO_SYSTEM_SR = -1;
    private static final String MEDIA_CODEC_PARAM_OPPO_SR_ENABLE = "vendor.oplus-sr-enable.value";
    private static final String OPPO_DEVICE_MANUFACTURER = "OPPO";

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        if ("OPPO".equals(TVKVcSystemInfo.getManufacturer()) && TVKMediaPlayerConfig.PlayerConfig.enable_oppo_system_sr != -1) {
            Bundle bundle = new Bundle();
            bundle.putInt(MEDIA_CODEC_PARAM_OPPO_SR_ENABLE, TVKMediaPlayerConfig.PlayerConfig.enable_oppo_system_sr);
            ArrayList arrayList = new ArrayList();
            arrayList.add(TPOptionalParam.buildObject(TPOptionalID.OPTIONAL_ID_GLOBAL_OBJECT_MEDIACODEC_PARAMS, bundle));
            return arrayList;
        }
        return Collections.emptyList();
    }
}
