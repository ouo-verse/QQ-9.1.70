package com.tencent.thumbplayer.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.impl.ITPInnerPlayer;
import com.tencent.thumbplayer.report.reportv2.ITPPlayerInfoGetter;

/* loaded from: classes26.dex */
public class TPPlayerInfoGetterImpl implements ITPPlayerInfoGetter {
    private static final String TAG = "TPPlayerInfoGetterImpl";
    private ITPInnerPlayer mPlayer;

    public TPPlayerInfoGetterImpl(@Nullable ITPInnerPlayer iTPInnerPlayer) {
        this.mPlayer = iTPInnerPlayer;
    }

    @Override // com.tencent.thumbplayer.report.reportv2.ITPPlayerInfoGetter
    @NonNull
    public TPDynamicStatisticParams getDynamicStatisticParams(boolean z16) {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayer;
        if (iTPInnerPlayer == null) {
            TPLogUtil.e(TAG, "mPlayer is null, return default dynamic statistic params");
            return new TPDynamicStatisticParams();
        }
        TPDynamicStatisticParams dynamicStatisticParams = iTPInnerPlayer.getDynamicStatisticParams(z16);
        if (dynamicStatisticParams == null) {
            TPLogUtil.e(TAG, "cannot get params from core, return default dynamic statistic params");
            return new TPDynamicStatisticParams();
        }
        return dynamicStatisticParams;
    }

    @Override // com.tencent.thumbplayer.report.reportv2.ITPPlayerInfoGetter
    @NonNull
    public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
        ITPInnerPlayer iTPInnerPlayer = this.mPlayer;
        if (iTPInnerPlayer == null) {
            TPLogUtil.e(TAG, "mPlayer is null, return default general play flow params");
            return new TPGeneralPlayFlowParams();
        }
        TPGeneralPlayFlowParams generalPlayFlowParams = iTPInnerPlayer.getGeneralPlayFlowParams();
        if (generalPlayFlowParams == null) {
            TPLogUtil.e(TAG, "cannot get params from core, return default general play flow params");
            return new TPGeneralPlayFlowParams();
        }
        return generalPlayFlowParams;
    }
}
