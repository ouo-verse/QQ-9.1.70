package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPCustomizedSeiBuilder implements ITVKOptionalParamBuilder {
    private static final String TAG = "TVKPlayer[TVKOPCustomizedSeiBuilder]";

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TVKPlayerVideoInfo playerVideoInfo = tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo();
        if (playerVideoInfo == null) {
            return Collections.emptyList();
        }
        String configMapValue = playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_CUSTOMIZED_SEI_LIST, "");
        if (TextUtils.isEmpty(configMapValue)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            String[] split = configMapValue.split(",");
            int[] iArr = new int[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                iArr[i3] = Integer.decode(split[i3]).intValue();
            }
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, iArr));
        } catch (NumberFormatException unused) {
            TVKLogUtil.w(TAG, "[buildOptionalParamList] Illegal sei list input: " + configMapValue);
        }
        return arrayList;
    }
}
