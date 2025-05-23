package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPDropFrameBuilder implements ITVKOptionalParamBuilder {
    private static boolean isAV1(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo != null && netVideoInfo.getCurDefinition() != null && netVideoInfo.getCurDefinition().getVideoCodec() == 26) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        boolean z17 = TVKMediaPlayerConfig.PlayerConfig.enable_drop_frame_by_screen_refresh_rate;
        boolean z18 = TVKMediaPlayerConfig.PlayerConfig.enable_video_adaptive_framerate;
        float f16 = TVKMediaPlayerConfig.PlayerConfig.high_frame_drop_rate_threshold;
        float f17 = TVKMediaPlayerConfig.PlayerConfig.low_frame_rate_threshold;
        if (isAV1(tVKQQLiveAssetPlayerContext)) {
            z17 = TVKMediaPlayerConfig.PlayerConfig.av1_enable_drop_frame_by_screen_refresh_rate;
            z18 = TVKMediaPlayerConfig.PlayerConfig.av1_enable_video_adaptive_framerate;
            f16 = TVKMediaPlayerConfig.PlayerConfig.av1_high_frame_drop_rate_threshold;
            f17 = TVKMediaPlayerConfig.PlayerConfig.av1_low_frame_rate_threshold;
        }
        TPOptionalParam<Long> buildLong = TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_VIDEO_RENDER_MONITOR_PERIOD_MS, TVKMediaPlayerConfig.PlayerConfig.render_monitor_period_ms);
        TPOptionalParam<Float> buildFloat = TPOptionalParam.buildFloat(TPOptionalID.OPTIONAL_ID_BEFORE_FLOAT_VIDEO_HIGH_FRAME_DROP_RATE_THRESHOLD, f16);
        TPOptionalParam<Float> buildFloat2 = TPOptionalParam.buildFloat(TPOptionalID.OPTIONAL_ID_BEFORE_FLOAT_VIDEO_LOW_FRAMERATE_THRESHOLD, f17);
        TPOptionalParam<Boolean> buildBoolean = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_DROP_FRAME_BY_REFRESH_RATE, z17);
        TPOptionalParam<Boolean> buildBoolean2 = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_VIDEO_ADAPTIVE_FRAMERATE, z18);
        arrayList.add(buildLong);
        arrayList.add(buildFloat);
        arrayList.add(buildFloat2);
        arrayList.add(buildBoolean);
        arrayList.add(buildBoolean2);
        return arrayList;
    }
}
