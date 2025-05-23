package com.tencent.mobileqq.triton.internal.engine.init;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 w2\u00020\u0001:\u0001wBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u000e\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020/X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R(\u00106\u001a\u0004\u0018\u0001052\b\u00104\u001a\u0004\u0018\u0001058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020<X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010\u001eR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010,\"\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020WX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020[X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0014\u0010\u0011\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u001c\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0aX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020f\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020pX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010rR$\u0010s\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u00168V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bt\u0010\u0018\"\u0004\bu\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bv\u0010_\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "context", "Landroid/content/Context;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "codeCacheMode", "", "codeCacheInterval", "", "enableOpenGlEs3", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "(Landroid/content/Context;Lcom/tencent/mobileqq/triton/model/DebugConfig;Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;ZIJZLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/utils/Downloader;)V", "_ttEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "get_ttEngine", "()Lcom/tencent/mobileqq/triton/engine/TTEngine;", "set_ttEngine", "(Lcom/tencent/mobileqq/triton/engine/TTEngine;)V", "getCodeCacheInterval", "()J", "getCodeCacheMode", "()I", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "setDataFileSystem", "(Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;)V", "getDebugConfig", "()Lcom/tencent/mobileqq/triton/model/DebugConfig;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "getEnableCodeCache", "()Z", "getEnableOpenGlEs3", "engineData", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineDataImpl;", "getEngineData", "()Lcom/tencent/mobileqq/triton/internal/engine/init/EngineDataImpl;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "value", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "engineState", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "setEngineState", "(Lcom/tencent/mobileqq/triton/engine/EngineState;)V", "fontBitmapManager", "Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "getFontBitmapManager", "()Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "setGamePackage", "(Lcom/tencent/mobileqq/triton/filesystem/GamePackage;)V", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "setGameView", "(Lcom/tencent/mobileqq/triton/view/GameView;)V", "id", "getId", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "setInspectorAgent", "(Lcom/tencent/mobileqq/triton/script/InspectorAgent;)V", "isMute", "setMute", "(Z)V", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/engine/init/LifeCycleOwnerImpl;", "getLifeCycleOwner", "()Lcom/tencent/mobileqq/triton/internal/engine/init/LifeCycleOwnerImpl;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "getMainThreadExecutor", "()Ljava/util/concurrent/Executor;", "screenShotCallbackHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "getScreenShotCallbackHolder", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "scriptPluginWrapper", "Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptPluginWrapper;", "getScriptPluginWrapper", "()Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptPluginWrapper;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "getScriptSystem", "()Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "setScriptSystem", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;)V", "statisticsManager", "Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "ttEngine", "getTtEngine", "setTtEngine", "getWorkerExecutor", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EngineContextImpl implements EngineContext {
    private static final AtomicInteger engineIdCounter = new AtomicInteger();

    @Nullable
    private TTEngine _ttEngine;
    private final long codeCacheInterval;
    private final int codeCacheMode;

    @NotNull
    private final Context context;

    @NotNull
    public GameDataFileSystem dataFileSystem;

    @NotNull
    private final DebugConfig debugConfig;

    @NotNull
    private final Downloader downloader;
    private final boolean enableCodeCache;
    private final boolean enableOpenGlEs3;

    @NotNull
    private final EngineDataImpl engineData;

    @NotNull
    private final EnginePackage enginePackage;

    @NotNull
    private final FontBitmapManager fontBitmapManager;

    @NotNull
    public GamePackage gamePackage;

    @Nullable
    private GameView gameView;
    private final int id;

    @Nullable
    private InspectorAgent inspectorAgent;
    private boolean isMute;

    @NotNull
    private final LifeCycleOwnerImpl lifeCycleOwner;

    @NotNull
    private final ReentrantLock lock;

    @NotNull
    private final Executor mainThreadExecutor;

    @NotNull
    private final ValueHolder<ScreenShotCallback> screenShotCallbackHolder;

    @NotNull
    private final ScriptPluginWrapper scriptPluginWrapper;

    @NotNull
    public ScriptSystem scriptSystem;

    @NotNull
    private final StatisticsManagerImpl statisticsManager;

    @NotNull
    private final Executor workerExecutor;

    public EngineContextImpl(@NotNull Context context, @NotNull DebugConfig debugConfig, @NotNull EnginePackage enginePackage, boolean z16, int i3, long j3, boolean z17, @NotNull Executor workerExecutor, @NotNull Executor mainThreadExecutor, @NotNull Downloader downloader) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(debugConfig, "debugConfig");
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        Intrinsics.checkParameterIsNotNull(workerExecutor, "workerExecutor");
        Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkParameterIsNotNull(downloader, "downloader");
        this.context = context;
        this.debugConfig = debugConfig;
        this.enginePackage = enginePackage;
        this.enableCodeCache = z16;
        this.codeCacheMode = i3;
        this.codeCacheInterval = j3;
        this.enableOpenGlEs3 = z17;
        this.workerExecutor = workerExecutor;
        this.mainThreadExecutor = mainThreadExecutor;
        this.downloader = downloader;
        this.lock = new ReentrantLock();
        this.id = engineIdCounter.incrementAndGet();
        this.scriptPluginWrapper = new ScriptPluginWrapper();
        this.engineData = new EngineDataImpl(this);
        this.lifeCycleOwner = new LifeCycleOwnerImpl();
        this.fontBitmapManager = new FontBitmapManager();
        this.statisticsManager = new StatisticsManagerImpl(getLifeCycleOwner(), getLock());
        this.screenShotCallbackHolder = new ValueHolder<>(null, getLifeCycleOwner(), getLock());
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public long getCodeCacheInterval() {
        return this.codeCacheInterval;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public int getCodeCacheMode() {
        return this.codeCacheMode;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public Context getContext() {
        return this.context;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public GameDataFileSystem getDataFileSystem() {
        GameDataFileSystem gameDataFileSystem = this.dataFileSystem;
        if (gameDataFileSystem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataFileSystem");
        }
        return gameDataFileSystem;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public DebugConfig getDebugConfig() {
        return this.debugConfig;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public Downloader getDownloader() {
        return this.downloader;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public boolean getEnableCodeCache() {
        return this.enableCodeCache;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public boolean getEnableOpenGlEs3() {
        return this.enableOpenGlEs3;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public EnginePackage getEnginePackage() {
        return this.enginePackage;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @Nullable
    public EngineState getEngineState() {
        return getLifeCycleOwner().getEngineState();
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public FontBitmapManager getFontBitmapManager() {
        return this.fontBitmapManager;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public GamePackage getGamePackage() {
        GamePackage gamePackage = this.gamePackage;
        if (gamePackage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gamePackage");
        }
        return gamePackage;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @Nullable
    public GameView getGameView() {
        return this.gameView;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public int getId() {
        return this.id;
    }

    @Nullable
    public final InspectorAgent getInspectorAgent() {
        return this.inspectorAgent;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public ReentrantLock getLock() {
        return this.lock;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public ValueHolder<ScreenShotCallback> getScreenShotCallbackHolder() {
        return this.screenShotCallbackHolder;
    }

    @NotNull
    public final ScriptPluginWrapper getScriptPluginWrapper() {
        return this.scriptPluginWrapper;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public ScriptSystem getScriptSystem() {
        ScriptSystem scriptSystem = this.scriptSystem;
        if (scriptSystem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scriptSystem");
        }
        return scriptSystem;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public StatisticsManagerImpl getStatisticsManager() {
        return this.statisticsManager;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public TTEngine getTtEngine() {
        TTEngine tTEngine = this._ttEngine;
        if (tTEngine == null) {
            Intrinsics.throwNpe();
        }
        return tTEngine;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public Executor getWorkerExecutor() {
        return this.workerExecutor;
    }

    @Nullable
    public final TTEngine get_ttEngine() {
        return this._ttEngine;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public boolean isAlive() {
        return EngineContext.DefaultImpls.isAlive(this);
    }

    /* renamed from: isMute, reason: from getter */
    public final boolean getIsMute() {
        return this.isMute;
    }

    public void setDataFileSystem(@NotNull GameDataFileSystem gameDataFileSystem) {
        Intrinsics.checkParameterIsNotNull(gameDataFileSystem, "<set-?>");
        this.dataFileSystem = gameDataFileSystem;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public void setEngineState(@Nullable EngineState engineState) {
        getLifeCycleOwner().setEngineState(engineState);
    }

    public void setGamePackage(@NotNull GamePackage gamePackage) {
        Intrinsics.checkParameterIsNotNull(gamePackage, "<set-?>");
        this.gamePackage = gamePackage;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    public void setGameView(@Nullable GameView gameView) {
        this.gameView = gameView;
    }

    public final void setInspectorAgent(@Nullable InspectorAgent inspectorAgent) {
        this.inspectorAgent = inspectorAgent;
    }

    public final void setMute(boolean z16) {
        this.isMute = z16;
    }

    public void setScriptSystem(@NotNull ScriptSystem scriptSystem) {
        Intrinsics.checkParameterIsNotNull(scriptSystem, "<set-?>");
        this.scriptSystem = scriptSystem;
    }

    public void setTtEngine(@NotNull TTEngine value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this._ttEngine = value;
    }

    public final void set_ttEngine(@Nullable TTEngine tTEngine) {
        this._ttEngine = tTEngine;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public EngineDataImpl getEngineData() {
        return this.engineData;
    }

    @Override // com.tencent.mobileqq.triton.internal.engine.EngineContext
    @NotNull
    public LifeCycleOwnerImpl getLifeCycleOwner() {
        return this.lifeCycleOwner;
    }
}
