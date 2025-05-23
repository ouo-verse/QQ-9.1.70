package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPDrmConfigBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        if (TVKMediaPlayerConfig.PlayerConfig.enable_feitian_drm_report) {
            arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_DRM_EVENT_TRACKING, true));
        }
        ArrayList arrayList2 = new ArrayList();
        if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.widevine_l1_model_black_list)) {
            arrayList2.add(0);
        }
        if (!TVKMediaPlayerConfig.PlayerConfig.china_drm_2_0_l1_enable) {
            arrayList2.add(3);
        }
        if (!arrayList2.isEmpty()) {
            int size = arrayList2.size();
            int[] iArr = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = ((Integer) arrayList2.get(i3)).intValue();
            }
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_DRM_TYPE_FOR_DISABLE_SECURE_COMPONENT, iArr));
        }
        if (TVKMediaPlayerConfig.PlayerConfig.enable_use_drm_decoder_until_first_encrypted_packet) {
            arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_USE_DRM_DECODER_UNTIL_FIRST_ENCRYPTED_PACKET, true));
        }
        return arrayList;
    }
}
