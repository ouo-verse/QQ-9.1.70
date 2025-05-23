package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.triton.statistic.FrameCallback;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqmini/minigame/report/GameFrameReport;", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "appId", "", "(Ljava/lang/String;)V", "onFrameBegin", "", "frameTimeNanos", "", "firstFrame", "", "onFrameEnd", "frameDurationNanos", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class GameFrameReport implements FrameCallback {
    private final String appId;

    public GameFrameReport(@NotNull String appId) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        this.appId = appId;
    }

    @Override // com.tencent.mobileqq.triton.statistic.FrameCallback
    public void onFrameBegin(long frameTimeNanos, boolean firstFrame) {
        MiniProgramLpReportDC04902.reportGameStart(this.appId);
        MiniGamePerformanceStatics miniGamePerformanceStatics = MiniGamePerformanceStatics.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(miniGamePerformanceStatics, "MiniGamePerformanceStatics.getInstance()");
        miniGamePerformanceStatics.getJankStatistics().e(frameTimeNanos, firstFrame);
    }

    @Override // com.tencent.mobileqq.triton.statistic.FrameCallback
    public void onFrameEnd(long frameTimeNanos, long frameDurationNanos) {
        MiniProgramLpReportDC04902.accumulateDrawFrameDuration(TimeUnit.NANOSECONDS.toMillis(frameDurationNanos));
    }
}
