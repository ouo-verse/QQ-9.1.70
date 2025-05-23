package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPAudioFrameCallbackBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TVKPlayerVideoInfo playerVideoInfo = tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo();
        if (playerVideoInfo == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_AUDIO_FRAME_CALLBACK, TVKUtils.optBoolean(playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_ENABLE_AUDIO_FRAME_CALLBACK, ""), false)));
        String configMapValue = playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_AUDIO_FRAME_CALLBACK_SAMPLE_FORMAT, "");
        if (!TextUtils.isEmpty(configMapValue)) {
            arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_SAMPLE_FORMAT, TVKUtils.optInt(configMapValue, -1)));
        }
        String configMapValue2 = playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_AUDIO_FRAME_CALLBACK_CHANNEL_LAYOUT, "");
        if (!TextUtils.isEmpty(configMapValue2)) {
            arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_OUT_AUDIO_CHANNEL_LAYOUT, TVKUtils.optLong(configMapValue2, 0L)));
        }
        String configMapValue3 = playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_AUDIO_FRAME_CALLBACK_SAMPLE_RATE_HZ, "");
        if (!TextUtils.isEmpty(configMapValue3)) {
            arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_SAMPLE_RATE_HZ, TVKUtils.optInt(configMapValue3, 0)));
        }
        String configMapValue4 = playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_AUDIO_FRAME_CALLBACK_SIZE_BYTE, "");
        if (!TextUtils.isEmpty(configMapValue4)) {
            arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_OUT_AUDIO_FRAME_SIZE_BYTE, TVKUtils.optInt(configMapValue4, 0)));
        }
        return arrayList;
    }
}
