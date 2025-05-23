package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.internal.engine.init.PlatformNativeLibraryLoader;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform;", "Lcom/tencent/mobileqq/triton/TritonPlatform;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "(Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;)V", "nativeLibraryLoadStatistics", "", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "preloadingTask", "Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask;", "doCreateEngine", "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "launchGame", "", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "preloadNewEngine", "PreloadingTask", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EnginePlatform implements TritonPlatform {
    private final PlatformConfig config;
    private final List<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics;
    private PreloadingTask preloadingTask;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform$PreloadingTask;", "", "(Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatform;)V", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "getEngine", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public final class PreloadingTask {

        @NotNull
        private final ValueHolder<Engine> engine = ValueHolder.INSTANCE.just(null);

        public PreloadingTask() {
            EnginePlatform.this.config.getWorkerExecutor().execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.engine.EnginePlatform.PreloadingTask.1
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadingTask.this.getEngine().setValue(EnginePlatform.this.doCreateEngine());
                }
            });
        }

        @NotNull
        public final ValueHolder<Engine> getEngine() {
            return this.engine;
        }
    }

    public EnginePlatform(@NotNull PlatformConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        this.config = config;
        Logger.init(config.getLogger());
        this.nativeLibraryLoadStatistics = PlatformNativeLibraryLoader.INSTANCE.loadEngineNativeLibrary(config.getEnginePackage());
        preloadNewEngine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Engine doCreateEngine() {
        return new Engine(this.config, this.nativeLibraryLoadStatistics);
    }

    private final void preloadNewEngine() {
        synchronized (this) {
            if (this.config.getEnablePreloadEngine() && this.preloadingTask == null) {
                this.preloadingTask = new PreloadingTask();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonPlatform
    public void launchGame(@NotNull final GameLaunchParam param, @NotNull final GameLaunchCallback gameLaunchCallback) {
        PreloadingTask preloadingTask;
        Intrinsics.checkParameterIsNotNull(param, "param");
        Intrinsics.checkParameterIsNotNull(gameLaunchCallback, "gameLaunchCallback");
        synchronized (this) {
            preloadingTask = this.preloadingTask;
            if (preloadingTask != null) {
                this.preloadingTask = null;
            } else {
                preloadingTask = new PreloadingTask();
            }
        }
        preloadingTask.getEngine().observe(new Function1<Engine, Unit>() { // from class: com.tencent.mobileqq.triton.internal.engine.EnginePlatform$launchGame$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Engine engine) {
                invoke2(engine);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Engine engine) {
                if (engine != null) {
                    engine.launchGame(GameLaunchParam.this, gameLaunchCallback);
                }
            }
        });
    }
}
