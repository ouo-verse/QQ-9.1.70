package com.tencent.mobileqq.triton.internal.engine;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0012\u0010 \u001a\u00020!X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020%X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u0004\u0018\u00010)X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u0004\u0018\u000107X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0012\u0010<\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010\tR\u0014\u0010>\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u001dR\u0012\u0010?\u001a\u00020@X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0012\u0010C\u001a\u00020DX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0012\u0010G\u001a\u00020HX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u001a\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0LX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010OR\u0012\u0010P\u001a\u00020QX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010SR\u0012\u0010T\u001a\u00020UX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010WR\u0012\u0010X\u001a\u00020YX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R\u0012\u0010\\\u001a\u00020HX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010J\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "", "codeCacheInterval", "", "getCodeCacheInterval", "()J", "codeCacheMode", "", "getCodeCacheMode", "()I", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "getDebugConfig", "()Lcom/tencent/mobileqq/triton/model/DebugConfig;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "enableCodeCache", "", "getEnableCodeCache", "()Z", "enableOpenGlEs3", "getEnableOpenGlEs3", "engineData", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "getEngineData", "()Lcom/tencent/mobileqq/triton/engine/EngineData;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "engineState", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getEngineState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "setEngineState", "(Lcom/tencent/mobileqq/triton/engine/EngineState;)V", "fontBitmapManager", "Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "getFontBitmapManager", "()Lcom/tencent/mobileqq/triton/font/FontBitmapManager;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "setGameView", "(Lcom/tencent/mobileqq/triton/view/GameView;)V", "id", "getId", "isAlive", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "getLifeCycleOwner", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "getMainThreadExecutor", "()Ljava/util/concurrent/Executor;", "screenShotCallbackHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "getScreenShotCallbackHolder", "()Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "getScriptSystem", "()Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "statisticsManager", "Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/internal/engine/StatisticsManagerImpl;", "ttEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "getTtEngine", "()Lcom/tencent/mobileqq/triton/engine/TTEngine;", "workerExecutor", "getWorkerExecutor", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface EngineContext {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        public static boolean isAlive(EngineContext engineContext) {
            if (engineContext.getEngineState() != EngineState.DESTROYED) {
                return true;
            }
            return false;
        }
    }

    long getCodeCacheInterval();

    int getCodeCacheMode();

    @NotNull
    Context getContext();

    @NotNull
    GameDataFileSystem getDataFileSystem();

    @NotNull
    DebugConfig getDebugConfig();

    @NotNull
    Downloader getDownloader();

    boolean getEnableCodeCache();

    boolean getEnableOpenGlEs3();

    @NotNull
    EngineData getEngineData();

    @NotNull
    EnginePackage getEnginePackage();

    @Nullable
    EngineState getEngineState();

    @NotNull
    FontBitmapManager getFontBitmapManager();

    @NotNull
    GamePackage getGamePackage();

    @Nullable
    GameView getGameView();

    int getId();

    @NotNull
    LifeCycleOwner getLifeCycleOwner();

    @NotNull
    ReentrantLock getLock();

    @NotNull
    Executor getMainThreadExecutor();

    @NotNull
    ValueHolder<ScreenShotCallback> getScreenShotCallbackHolder();

    @NotNull
    ScriptSystem getScriptSystem();

    @NotNull
    StatisticsManagerImpl getStatisticsManager();

    @NotNull
    TTEngine getTtEngine();

    @NotNull
    Executor getWorkerExecutor();

    boolean isAlive();

    void setEngineState(@Nullable EngineState engineState);

    void setGameView(@Nullable GameView gameView);
}
