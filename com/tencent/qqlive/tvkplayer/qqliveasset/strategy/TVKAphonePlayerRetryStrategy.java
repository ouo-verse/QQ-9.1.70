package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeature;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.api.ITVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerRetryStrategy;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKAphonePlayerRetryStrategy extends TVKPlayerRetryStrategyBase {
    private static final List<Integer> NEED_RETRY_ERROR_TYPE;

    static {
        ArrayList arrayList = new ArrayList();
        NEED_RETRY_ERROR_TYPE = arrayList;
        arrayList.add(2000);
        arrayList.add(2001);
        arrayList.add(1100);
        arrayList.add(1101);
        arrayList.add(1102);
        arrayList.add(1200);
        arrayList.add(1210);
        arrayList.add(1211);
        arrayList.add(Integer.valueOf(TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_VIDEO_NOT_SUPPORT));
        arrayList.add(1221);
        arrayList.add(Integer.valueOf(TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_NOT_SUPPORT));
        arrayList.add(Integer.valueOf(TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM));
    }

    public TVKAphonePlayerRetryStrategy(@NonNull TVKPlayerInputParam tVKPlayerInputParam, @NonNull TVKPlayerRuntimeParam tVKPlayerRuntimeParam, @NonNull ITVKPlayerFeatureGroup iTVKPlayerFeatureGroup) {
        super(tVKPlayerInputParam, tVKPlayerRuntimeParam, iTVKPlayerFeatureGroup);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKPlayerRetryStrategyBase
    protected ITVKPlayerRetryStrategy.RetryActionRet getRetryActionWithError(int i3, int i16, List<ITVKPlayerFeature> list) {
        if (i3 != TVKCommonErrorCodeUtil.MODULE.VIDEO_FX_ERR && !NEED_RETRY_ERROR_TYPE.contains(Integer.valueOf(i16))) {
            return new ITVKPlayerRetryStrategy.RetryActionRet(1, null);
        }
        ITVKFeatureBase findNeedDisableFeatureForRetry = findNeedDisableFeatureForRetry(this.mRuntimeParam.getNetVideoInfo(), list);
        if (findNeedDisableFeatureForRetry != null) {
            return new ITVKPlayerRetryStrategy.RetryActionRet(3, findNeedDisableFeatureForRetry);
        }
        String definitionForPlayerErrorRetry = getDefinitionForPlayerErrorRetry();
        if (definitionForPlayerErrorRetry != null) {
            return new ITVKPlayerRetryStrategy.RetryActionRet(2, definitionForPlayerErrorRetry);
        }
        return new ITVKPlayerRetryStrategy.RetryActionRet(1, null);
    }
}
