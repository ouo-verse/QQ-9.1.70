package com.tencent.thumbplayer.report.reportv2;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;

/* loaded from: classes26.dex */
public interface ITPPlayerInfoGetter {
    @NonNull
    TPDynamicStatisticParams getDynamicStatisticParams(boolean z16);

    @NonNull
    TPGeneralPlayFlowParams getGeneralPlayFlowParams();
}
