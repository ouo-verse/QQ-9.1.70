package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.internal.engine.Engine;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/triton/internal/engine/init/EngineInit$performLaunchGame$1", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "onFirstFrame", "", "statics", "Lcom/tencent/mobileqq/triton/statistic/FirstFrameStatistic;", "onGameLaunched", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "onV8OOM", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EngineInit$performLaunchGame$1 implements GameLaunchCallback {
    final /* synthetic */ GameLaunchCallback $gameLaunchCallback;
    final /* synthetic */ EngineInit this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineInit$performLaunchGame$1(EngineInit engineInit, GameLaunchCallback gameLaunchCallback) {
        this.this$0 = engineInit;
        this.$gameLaunchCallback = gameLaunchCallback;
    }

    @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
    public void onFirstFrame(@NotNull final FirstFrameStatistic statics) {
        PlatformConfig platformConfig;
        Intrinsics.checkParameterIsNotNull(statics, "statics");
        platformConfig = this.this$0.platformConfig;
        platformConfig.getMainThreadExecutor().execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$performLaunchGame$1$onFirstFrame$1
            @Override // java.lang.Runnable
            public final void run() {
                EngineContextImpl engineContextImpl;
                EngineInit$performLaunchGame$1.this.$gameLaunchCallback.onFirstFrame(statics);
                engineContextImpl = EngineInit$performLaunchGame$1.this.this$0.engineContextImpl;
                engineContextImpl.getLifeCycleOwner().notifyOnFirstFrame();
            }
        });
    }

    @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
    public void onGameLaunched(@Nullable TritonEngine engine, @NotNull final GameLaunchStatistic statics) {
        PlatformConfig platformConfig;
        Intrinsics.checkParameterIsNotNull(statics, "statics");
        platformConfig = this.this$0.platformConfig;
        platformConfig.getMainThreadExecutor().execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$performLaunchGame$1$onGameLaunched$1
            @Override // java.lang.Runnable
            public final void run() {
                Engine engine2;
                Engine engine3;
                EngineContextImpl engineContextImpl;
                Engine engine4;
                EngineInit$performLaunchGame$1.this.this$0.getEngineContext().setEngineState(EngineState.STOPPED);
                if (statics.getSuccess()) {
                    engineContextImpl = EngineInit$performLaunchGame$1.this.this$0.engineContextImpl;
                    LifeCycleOwnerImpl lifeCycleOwner = engineContextImpl.getLifeCycleOwner();
                    engine4 = EngineInit$performLaunchGame$1.this.this$0.engine;
                    lifeCycleOwner.notifyOnGameLaunched(engine4);
                } else {
                    engine2 = EngineInit$performLaunchGame$1.this.this$0.engine;
                    engine2.destroy();
                }
                GameLaunchCallback gameLaunchCallback = EngineInit$performLaunchGame$1.this.$gameLaunchCallback;
                if (statics.getSuccess()) {
                    engine3 = EngineInit$performLaunchGame$1.this.this$0.engine;
                } else {
                    engine3 = null;
                }
                gameLaunchCallback.onGameLaunched(engine3, statics);
            }
        });
    }

    @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
    public void onV8OOM() {
        this.$gameLaunchCallback.onV8OOM();
    }
}
