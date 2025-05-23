package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPThreadPriorityBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TPOptionalParam<Integer> buildInt = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_PLAYER_SCHEDULING_THREAD_PRIORITY, TVKMediaPlayerConfig.PlayerConfig.tp_core_work_thread_priority);
        TPOptionalParam<Integer> buildInt2 = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_DEMUXER_THREAD_PRIORITY, TVKMediaPlayerConfig.PlayerConfig.tp_core_demux_thread_priority);
        TPOptionalParam<Integer> buildInt3 = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_VIDEO_DECODER_THREAD_PRIORITY, TVKMediaPlayerConfig.PlayerConfig.tp_core_video_decode_thread_priority);
        TPOptionalParam<Integer> buildInt4 = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_AUDIO_DECODER_THREAD_PRIORITY, TVKMediaPlayerConfig.PlayerConfig.tp_core_audio_decode_thread_priority);
        TPOptionalParam<Integer> buildInt5 = TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_AUDIO_RENDERER_THREAD_PRIORITY, TVKMediaPlayerConfig.PlayerConfig.tp_core_audio_render_thread_priority);
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildInt);
        arrayList.add(buildInt2);
        arrayList.add(buildInt3);
        arrayList.add(buildInt4);
        arrayList.add(buildInt5);
        return arrayList;
    }
}
