package com.tencent.mobileqq.triton.engine;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\tH'J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "", "onFirstFrame", "", "statics", "Lcom/tencent/mobileqq/triton/statistic/FirstFrameStatistic;", "onGameLaunched", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "onV8OOM", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface GameLaunchCallback {
    @MainThread
    void onFirstFrame(@NotNull FirstFrameStatistic statics);

    @MainThread
    void onGameLaunched(@Nullable TritonEngine engine, @NotNull GameLaunchStatistic statics);

    void onV8OOM();
}
