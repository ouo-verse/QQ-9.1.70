package com.tencent.mobileqq.minigame.report;

import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/QQGameSubpackageReport;", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "()V", "onSubpackageLoaded", "", "name", "", "statistic", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQGameSubpackageReport implements SubpackageLoadStatisticsCallback {
    private static final int MINI_GAME_LOAD_SUB_PKG = 1009;
    private static final int MINI_GAME_LOAD_SUB_PKG_END = 1010;
    private static final String TAG = "GameSubpackageReport";

    @Override // com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback
    public void onSubpackageLoaded(String name, ScriptLoadStatistic statistic) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(statistic, "statistic");
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1009, null, null, null, 0, "1", 0L, System.currentTimeMillis() - (((statistic.getReadTimeMs() + statistic.getReadCodeCacheTimeMs()) + statistic.getCompileTimeMs()) + statistic.getExecuteTimeMs()), null, null, null, null, null);
        if (statistic.getLoadResult().getIsSuccess()) {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1010, null, "1");
        } else {
            GameLog.getInstance().e(TAG, "load subpackage failed " + name + " " + statistic);
        }
        statistic.getLoadResult();
        ScriptLoadResult scriptLoadResult = ScriptLoadResult.FAIL_INVALID_STATE;
    }
}
