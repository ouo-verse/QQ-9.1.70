package com.tencent.mobileqq.triton.internal.engine;

import android.view.Surface;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.engine.ScreenRecordCallback;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.internal.engine.init.EngineInit;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.screenrecord.Recordable;
import com.tencent.mobileqq.triton.screenrecord.RecordableGameView;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.mobileqq.triton.view.GameView;
import java.io.File;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J \u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u00101\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u00102\u001a\u00020\u001bH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\b\u00104\u001a\u00020\u001bH\u0016J\b\u00105\u001a\u00020\u001bH\u0016J\u0010\u00106\u001a\u00020\u001b2\u0006\u0010.\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "Lcom/tencent/mobileqq/triton/TritonEngine;", "platformConfig", "Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "soLoadStatistics", "", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "(Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;Ljava/util/List;)V", "context", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "getContext$Triton_release", "()Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "data", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "getData", "()Lcom/tencent/mobileqq/triton/engine/EngineData;", "engineInit", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineInit;", "state", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "statisticsManager", "Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "destroy", "", "isScreenRecordReady", "", "launchGame", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "observeLifeCycle", "lifeCycle", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onInputSurfaceReady", "surface", "Landroid/view/Surface;", "onScreenRecordRelease", "prepareScreenRecord", "recordAudio", "outputPath", "Ljava/io/File;", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenRecordCallback;", "removeLifeCycleObserver", "replaceGameView", "start", "startScreenRecord", "stop", "stopScreenRecord", "takeScreenShot", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "toString", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class Engine implements TritonEngine {

    @NotNull
    private final EngineContext context;
    private final EngineInit engineInit;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EngineState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EngineState.INITIALIZED.ordinal()] = 1;
            iArr[EngineState.DESTROYED.ordinal()] = 2;
        }
    }

    public Engine(@NotNull PlatformConfig platformConfig, @NotNull List<NativeLibraryLoadStatistic> soLoadStatistics) {
        Intrinsics.checkParameterIsNotNull(platformConfig, "platformConfig");
        Intrinsics.checkParameterIsNotNull(soLoadStatistics, "soLoadStatistics");
        EngineInit engineInit = new EngineInit(this, platformConfig, soLoadStatistics);
        this.engineInit = engineInit;
        this.context = engineInit.getEngineContext();
    }

    private final GameLaunchParam replaceGameView(GameLaunchParam param) {
        return new GameLaunchParam(param.getGamePackage(), param.getDataFileSystem(), RecordableGameView.INSTANCE.wrap(this.context, param.getGameView()), param.getInspectorAgent(), param.getJankTraceLevel(), param.getUserData(), param.isMute(), param.isWebgl2Enable());
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void destroy() {
        ReentrantLock lock = this.context.getLock();
        lock.lock();
        try {
            EngineState state = getState();
            EngineState engineState = EngineState.DESTROYED;
            if (state != engineState) {
                this.context.setEngineState(engineState);
                this.engineInit.notifyOnDestroy();
                this.engineInit.destroyEngineLocked();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    @NotNull
    /* renamed from: getContext$Triton_release, reason: from getter */
    public final EngineContext getContext() {
        return this.context;
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    @NotNull
    public EngineData getData() {
        ReentrantLock lock = this.context.getLock();
        lock.lock();
        try {
            return this.context.getEngineData();
        } finally {
            lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    @NotNull
    public EngineState getState() {
        EngineState engineState = this.context.getEngineState();
        if (engineState != null) {
            return engineState;
        }
        throw new IllegalStateException("engine is initializing");
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    @NotNull
    public StatisticsManager getStatisticsManager() {
        ReentrantLock lock = this.context.getLock();
        lock.lock();
        try {
            return this.context.getStatisticsManager();
        } finally {
            lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public boolean isScreenRecordReady() {
        GameView gameView = this.context.getGameView();
        if (!(gameView instanceof Recordable)) {
            gameView = null;
        }
        Recordable recordable = (Recordable) gameView;
        if (recordable != null) {
            return recordable.isRecordReady();
        }
        return false;
    }

    public final void launchGame(@NotNull GameLaunchParam param, @NotNull GameLaunchCallback gameLaunchCallback) {
        Intrinsics.checkParameterIsNotNull(param, "param");
        Intrinsics.checkParameterIsNotNull(gameLaunchCallback, "gameLaunchCallback");
        GameLaunchParam replaceGameView = replaceGameView(param);
        ReentrantLock lock = this.context.getLock();
        lock.lock();
        try {
            EngineState engineState = this.context.getEngineState();
            if (engineState != null) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[engineState.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        throw new IllegalStateException("engine is destroyed");
                    }
                } else {
                    this.engineInit.launchGameLocked(replaceGameView, gameLaunchCallback);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
            throw new IllegalStateException("already launched");
        } finally {
            lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void observeLifeCycle(@NotNull LifeCycle lifeCycle) {
        Intrinsics.checkParameterIsNotNull(lifeCycle, "lifeCycle");
        this.context.getLifeCycleOwner().observeLifeCycle(lifeCycle);
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void onInputSurfaceReady(@NotNull Surface surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        if (isScreenRecordReady()) {
            GameView gameView = this.context.getGameView();
            if (!(gameView instanceof Recordable)) {
                gameView = null;
            }
            Recordable recordable = (Recordable) gameView;
            if (recordable != null) {
                recordable.onInputSurfaceReady(surface);
            }
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void onScreenRecordRelease() {
        if (!isScreenRecordReady()) {
            GameView gameView = this.context.getGameView();
            if (!(gameView instanceof Recordable)) {
                gameView = null;
            }
            Recordable recordable = (Recordable) gameView;
            if (recordable != null) {
                recordable.releaseRecording();
            }
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void prepareScreenRecord(boolean recordAudio, @NotNull File outputPath, @NotNull ScreenRecordCallback callback) {
        Intrinsics.checkParameterIsNotNull(outputPath, "outputPath");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (!isScreenRecordReady()) {
            GameView gameView = this.context.getGameView();
            if (!(gameView instanceof Recordable)) {
                gameView = null;
            }
            Recordable recordable = (Recordable) gameView;
            if (recordable != null) {
                recordable.prepareRecording(recordAudio, outputPath, callback);
            }
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void removeLifeCycleObserver(@NotNull LifeCycle lifeCycle) {
        Intrinsics.checkParameterIsNotNull(lifeCycle, "lifeCycle");
        this.context.getLifeCycleOwner().removeLifeCycleObserver(lifeCycle);
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void start() {
        ReentrantLock lock = this.context.getLock();
        lock.lock();
        try {
            if (getState() == EngineState.STOPPED) {
                this.context.setEngineState(EngineState.STARTED);
                this.engineInit.notifyOnStart();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void startScreenRecord() {
        if (isScreenRecordReady()) {
            GameView gameView = this.context.getGameView();
            if (!(gameView instanceof Recordable)) {
                gameView = null;
            }
            Recordable recordable = (Recordable) gameView;
            if (recordable != null) {
                recordable.startRecording();
            }
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void stop() {
        ReentrantLock lock = this.context.getLock();
        lock.lock();
        try {
            if (getState() == EngineState.STARTED) {
                this.context.setEngineState(EngineState.STOPPED);
                this.engineInit.notifyOnStop();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void stopScreenRecord() {
        if (isScreenRecordReady()) {
            GameView gameView = this.context.getGameView();
            if (!(gameView instanceof Recordable)) {
                gameView = null;
            }
            Recordable recordable = (Recordable) gameView;
            if (recordable != null) {
                recordable.stopRecording();
            }
        }
    }

    @Override // com.tencent.mobileqq.triton.TritonEngine
    public void takeScreenShot(@NotNull ScreenShotCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        ReentrantLock lock = this.context.getLock();
        lock.lock();
        try {
            this.context.getScreenShotCallbackHolder().setValue(callback);
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    @NotNull
    public String toString() {
        return super.toString() + " [" + this.context.getId() + "] (name=" + this.context.getGamePackage().getName() + ", appId=" + this.context.getGamePackage().getId() + ", enginePackageVersion=" + this.context.getEnginePackage().getVersion() + ')';
    }
}
