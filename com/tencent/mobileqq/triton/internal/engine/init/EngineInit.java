package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.internal.engine.Engine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.internal.script.CodeCacheSaver;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.utils.AsyncResult;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fJ\u0018\u0010$\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineInit;", "", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/internal/engine/Engine;", "platformConfig", "Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "soLoadStatistics", "", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "(Lcom/tencent/mobileqq/triton/internal/engine/Engine;Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;Ljava/util/List;)V", "afterInitAction", "Lkotlin/Function0;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "getEngineContext", "()Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "engineContextImpl", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;", "engineInitStatistics", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "mCodeCacheSaver", "Lcom/tencent/mobileqq/triton/internal/script/CodeCacheSaver;", "destroyEngineLocked", "doActionAfterInit", "action", "initEngine", "initTTApp", "launchGameLocked", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "notifyOnDestroy", "notifyOnStart", "notifyOnStop", "performLaunchGame", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EngineInit {
    private static final String TAG = "EngineInit";
    private Function0<Unit> afterInitAction;
    private final Engine engine;
    private final EngineContextImpl engineContextImpl;
    private EngineInitStatistic engineInitStatistics;
    private CodeCacheSaver mCodeCacheSaver;
    private final PlatformConfig platformConfig;
    private final List<NativeLibraryLoadStatistic> soLoadStatistics;

    public EngineInit(@NotNull Engine engine, @NotNull PlatformConfig platformConfig, @NotNull List<NativeLibraryLoadStatistic> soLoadStatistics) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        Intrinsics.checkParameterIsNotNull(platformConfig, "platformConfig");
        Intrinsics.checkParameterIsNotNull(soLoadStatistics, "soLoadStatistics");
        this.engine = engine;
        this.platformConfig = platformConfig;
        this.soLoadStatistics = soLoadStatistics;
        this.engineContextImpl = new EngineContextImpl(platformConfig.getContext(), platformConfig.getDebugConfig(), Utils.decorate(platformConfig.getEnginePackage(), platformConfig.getEnableCodeCache()), platformConfig.getEnableCodeCache(), platformConfig.getCodeCacheMode(), platformConfig.getCodeCacheInterval(), platformConfig.getEnableOpenGlEs3(), platformConfig.getWorkerExecutor(), platformConfig.getMainThreadExecutor(), platformConfig.getDownloader());
        initEngine();
    }

    private final void doActionAfterInit(final Function0<Unit> action) {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$doActionAfterInit$actionOnMainThread$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [com.tencent.mobileqq.triton.internal.engine.init.EngineInit$sam$java_lang_Runnable$0] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PlatformConfig platformConfig;
                platformConfig = EngineInit.this.platformConfig;
                Executor mainThreadExecutor = platformConfig.getMainThreadExecutor();
                final Function0 function02 = action;
                if (function02 != null) {
                    function02 = new Runnable() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$sam$java_lang_Runnable$0
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            Intrinsics.checkExpressionValueIsNotNull(Function0.this.invoke(), "invoke(...)");
                        }
                    };
                }
                mainThreadExecutor.execute((Runnable) function02);
            }
        };
        ReentrantLock lock = getEngineContext().getLock();
        lock.lock();
        try {
            if (this.engineInitStatistics == null) {
                this.afterInitAction = function0;
            } else {
                function0.invoke();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ea, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ee, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0087 A[Catch: all -> 0x00ea, TryCatch #1 {all -> 0x00ea, all -> 0x0071, blocks: (B:5:0x0078, B:10:0x0087, B:12:0x008d, B:13:0x0091, B:16:0x009d, B:18:0x00a0, B:19:0x00ac, B:21:0x00b2, B:23:0x00be, B:25:0x00e0, B:33:0x0072, B:3:0x001e), top: B:2:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2 A[Catch: all -> 0x00ea, LOOP:0: B:19:0x00ac->B:21:0x00b2, LOOP_END, TryCatch #1 {all -> 0x00ea, all -> 0x0071, blocks: (B:5:0x0078, B:10:0x0087, B:12:0x008d, B:13:0x0091, B:16:0x009d, B:18:0x00a0, B:19:0x00ac, B:21:0x00b2, B:23:0x00be, B:25:0x00e0, B:33:0x0072, B:3:0x001e), top: B:2:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e0 A[Catch: all -> 0x00ea, TRY_LEAVE, TryCatch #1 {all -> 0x00ea, all -> 0x0071, blocks: (B:5:0x0078, B:10:0x0087, B:12:0x008d, B:13:0x0091, B:16:0x009d, B:18:0x00a0, B:19:0x00ac, B:21:0x00b2, B:23:0x00be, B:25:0x00e0, B:33:0x0072, B:3:0x001e), top: B:2:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initEngine() {
        boolean z16;
        Iterator<T> it;
        List emptyList;
        Function0<Unit> function0;
        getEngineContext().getLifeCycleOwner().observeLifeCycle(EngineLifeCycleLogger.INSTANCE);
        getEngineContext().getLock().lock();
        TritonException tritonException = null;
        try {
            final AsyncResult asyncResult = new AsyncResult();
            getEngineContext().getWorkerExecutor().execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$initEngine$$inlined$withLock$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    AsyncResult.this.run(new Function0<ScriptPlugin>() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$initEngine$$inlined$withLock$lambda$1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final ScriptPlugin invoke() {
                            PlatformConfig platformConfig;
                            platformConfig = this.platformConfig;
                            return platformConfig.getScriptPluginFactory().create(this.getEngineContext().getContext());
                        }
                    });
                }
            });
            EngineContextImpl engineContextImpl = this.engineContextImpl;
            EngineContextImpl engineContextImpl2 = this.engineContextImpl;
            engineContextImpl.setScriptSystem(new ScriptSystem(engineContextImpl2, engineContextImpl2.getScriptPluginWrapper()));
            initTTApp();
            Logger.i$default(TAG, "initEngine created scriptPlugin " + asyncResult, null, 4, null);
            this.engineContextImpl.getScriptPluginWrapper().init(getEngineContext(), (ScriptPlugin) asyncResult.awaitResult());
            th = null;
        } finally {
            th = th;
            this.engineContextImpl.setEngineState(EngineState.INITIALIZED);
            if (th != null) {
            }
            boolean z17 = z16;
            if (th != null) {
            }
            TritonException tritonException2 = tritonException;
            it = this.soLoadStatistics.iterator();
            long j3 = 0;
            while (it.hasNext()) {
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.engineInitStatistics = new EngineInitStatistic(z17, tritonException2, j3, 0L, 0L, 0L, emptyList, this.soLoadStatistics, 0L, 0L, 768, null);
            function0 = this.afterInitAction;
            if (function0 != null) {
            }
        }
        this.engineContextImpl.setEngineState(EngineState.INITIALIZED);
        if (th != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z172 = z16;
        if (th != null) {
            ErrorCodes errorCodes = ErrorCodes.UNKNOWN;
            if (th instanceof TritonException) {
                tritonException = th;
            } else {
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                tritonException = new TritonException(message, errorCodes, th);
            }
        }
        TritonException tritonException22 = tritonException;
        it = this.soLoadStatistics.iterator();
        long j36 = 0;
        while (it.hasNext()) {
            j36 += ((NativeLibraryLoadStatistic) it.next()).getLoadTimeMs();
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.engineInitStatistics = new EngineInitStatistic(z172, tritonException22, j36, 0L, 0L, 0L, emptyList, this.soLoadStatistics, 0L, 0L, 768, null);
        function0 = this.afterInitAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void initTTApp() {
        ReentrantLock lock = getEngineContext().getLock();
        lock.lock();
        try {
            this.engineContextImpl.setTtEngine(new TTEngine(this.platformConfig, getEngineContext(), this.soLoadStatistics));
            getEngineContext().getLifeCycleOwner().observeLifeCycle(new LifeCycle() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$initTTApp$$inlined$withLock$lambda$1
                @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
                public void onDestroy() {
                    LifeCycle.DefaultImpls.onDestroy(this);
                }

                @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
                public void onFirstFrame() {
                    LifeCycle.DefaultImpls.onFirstFrame(this);
                }

                @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
                public void onGameLaunched(@NotNull TritonEngine engine) {
                    Intrinsics.checkParameterIsNotNull(engine, "engine");
                    LifeCycle.DefaultImpls.onGameLaunched(this, engine);
                }

                @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
                public void onStart() {
                    EngineContextImpl engineContextImpl;
                    engineContextImpl = EngineInit.this.engineContextImpl;
                    engineContextImpl.getTtEngine().onResume();
                }

                @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
                public void onStop() {
                    EngineContextImpl engineContextImpl;
                    engineContextImpl = EngineInit.this.engineContextImpl;
                    engineContextImpl.getTtEngine().onPause();
                }
            });
            this.mCodeCacheSaver = new CodeCacheSaver(this.engineContextImpl.getScriptSystem());
            if (getEngineContext().getEnableCodeCache()) {
                CodeCacheSaver codeCacheSaver = this.mCodeCacheSaver;
                if (codeCacheSaver == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCodeCacheSaver");
                }
                getEngineContext().getLifeCycleOwner().observeLifeCycle(codeCacheSaver);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performLaunchGame(GameLaunchParam param, GameLaunchCallback gameLaunchCallback) {
        CodeCacheSaver codeCacheSaver = this.mCodeCacheSaver;
        if (codeCacheSaver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCodeCacheSaver");
        }
        codeCacheSaver.cancelAutoSaving();
        this.engineContextImpl.setGamePackage(Utils.decorate(param.getGamePackage(), this.platformConfig.getEnableCodeCache()));
        this.engineContextImpl.setDataFileSystem(param.getDataFileSystem());
        this.engineContextImpl.setGameView(param.getGameView());
        this.engineContextImpl.setInspectorAgent(param.getInspectorAgent());
        this.engineContextImpl.setMute(param.isMute());
        this.engineContextImpl.getStatisticsManager().getJankTraceLevelHolder().setValue(param.getJankTraceLevel());
        this.engineContextImpl.getEngineData().getUserDataMap().putAll(param.getUserData());
        this.engineContextImpl.getTtEngine().getGameLauncher().launchGame(param, new EngineInit$performLaunchGame$1(this, gameLaunchCallback), new Function0<Unit>() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$performLaunchGame$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                EngineContextImpl engineContextImpl;
                Engine engine;
                engineContextImpl = EngineInit.this.engineContextImpl;
                ScriptPluginWrapper scriptPluginWrapper = engineContextImpl.getScriptPluginWrapper();
                engine = EngineInit.this.engine;
                scriptPluginWrapper.onCreate(engine);
            }
        });
    }

    public final void destroyEngineLocked() {
        TTEngine tTEngine = this.engineContextImpl.get_ttEngine();
        if (tTEngine != null) {
            tTEngine.onDestroy();
        }
    }

    @NotNull
    public final EngineContext getEngineContext() {
        return this.engineContextImpl;
    }

    public final void launchGameLocked(@NotNull final GameLaunchParam param, @NotNull final GameLaunchCallback gameLaunchCallback) {
        Intrinsics.checkParameterIsNotNull(param, "param");
        Intrinsics.checkParameterIsNotNull(gameLaunchCallback, "gameLaunchCallback");
        final long timeStamp = Utils.timeStamp();
        doActionAfterInit(new Function0<Unit>() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$launchGameLocked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final EngineInitStatistic engineInitStatistic;
                Engine engine;
                engineInitStatistic = EngineInit.this.engineInitStatistics;
                if (engineInitStatistic == null) {
                    Intrinsics.throwNpe();
                }
                if (engineInitStatistic.getSuccess()) {
                    EngineInit.this.performLaunchGame(param, gameLaunchCallback);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("launchGameLocked: failed, error=");
                TritonException exception = engineInitStatistic.getException();
                sb5.append(exception != null ? exception.getMessage() : null);
                Logger.e$default("EngineInit", sb5.toString(), null, 4, null);
                engine = EngineInit.this.engine;
                engine.destroy();
                EngineInit.this.getEngineContext().getMainThreadExecutor().execute(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.engine.init.EngineInit$launchGameLocked$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        List emptyList;
                        GameLaunchCallback gameLaunchCallback2 = gameLaunchCallback;
                        TritonException exception2 = engineInitStatistic.getException();
                        long timeStamp2 = Utils.timeStamp() - timeStamp;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        gameLaunchCallback2.onGameLaunched(null, new GameLaunchStatistic(false, exception2, timeStamp2, emptyList, engineInitStatistic));
                    }
                });
            }
        });
    }

    public final void notifyOnDestroy() {
        this.engineContextImpl.setGameView(null);
        this.engineContextImpl.getLifeCycleOwner().notifyOnDestroy();
        this.engineContextImpl.getLifeCycleOwner().clearLifeCycles();
    }

    public final void notifyOnStart() {
        this.engineContextImpl.getLifeCycleOwner().notifyOnStart();
    }

    public final void notifyOnStop() {
        this.engineContextImpl.getLifeCycleOwner().notifyOnStop();
    }
}
