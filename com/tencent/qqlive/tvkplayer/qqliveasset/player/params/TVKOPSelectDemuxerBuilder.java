package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPSelectDemuxerBuilder implements ITVKOptionalParamBuilder {
    private boolean isLiveFlv(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKLiveVideoInfo) || ((TVKLiveVideoInfo) tVKNetVideoInfo).getStream() != 1) {
            return false;
        }
        return true;
    }

    private boolean isUrlFlvNeedVideoSizeChangedCallBack(TVKPlayerVideoInfo tVKPlayerVideoInfo, ITVKAsset iTVKAsset) {
        if (iTVKAsset == null || iTVKAsset.getAssetType() != 2 || tVKPlayerVideoInfo == null || TVKUtils.optInt(tVKPlayerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_URL_FLV_VIDEO_SIZE_CHANGED, ""), 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        TVKPlayerInputParam inputParam = tVKQQLiveAssetPlayerContext.getInputParam();
        TVKPlayerRuntimeParam runtimeParam = tVKQQLiveAssetPlayerContext.getRuntimeParam();
        if (!isUrlFlvNeedVideoSizeChangedCallBack(inputParam.getPlayerVideoInfo(), runtimeParam.getTVKAsset()) && !isLiveFlv(runtimeParam.getNetVideoInfo())) {
            return Collections.emptyList();
        }
        arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_DEMUXER_TYPE, new int[]{1}));
        return arrayList;
    }
}
