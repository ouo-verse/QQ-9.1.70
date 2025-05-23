package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/minigame/report/GameSubpackageReport;", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "()V", "onSubpackageLoaded", "", "name", "", "statistic", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class GameSubpackageReport implements SubpackageLoadStatisticsCallback {
    private static final int MINI_GAME_LOAD_SUB_PKG = 1009;
    private static final int MINI_GAME_LOAD_SUB_PKG_END = 1010;
    private static final String TAG = "GameSubpackageReport";

    @Override // com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback
    public void onSubpackageLoaded(@NotNull String name, @NotNull ScriptLoadStatistic statistic) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(statistic, "statistic");
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 1009, System.currentTimeMillis() - (((statistic.getReadTimeMs() + statistic.getReadCodeCacheTimeMs()) + statistic.getCompileTimeMs()) + statistic.getExecuteTimeMs()), null, null, null, 0, "1", 0L, null, null, null, null, null);
        if (statistic.getLoadResult().getIsSuccess()) {
            MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 1010, (String) null, "1");
        } else {
            QMLog.e(TAG, "load subpackage failed " + name + TokenParser.SP + statistic);
        }
        statistic.getLoadResult();
        ScriptLoadResult scriptLoadResult = ScriptLoadResult.FAIL_INVALID_STATE;
    }
}
