package com.tencent.mobileqq.triton.internal.model;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u0019J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\rH\u00c6\u0003J\t\u00103\u001a\u00020\u0015H\u00c6\u0003J\t\u00104\u001a\u00020\u0015H\u00c6\u0003J\t\u00105\u001a\u00020\u0018H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0007H\u00c6\u0003J\t\u00108\u001a\u00020\tH\u00c6\u0003J\t\u00109\u001a\u00020\u000bH\u00c6\u0003J\t\u0010:\u001a\u00020\rH\u00c6\u0003J\t\u0010;\u001a\u00020\u000fH\u00c6\u0003J\t\u0010<\u001a\u00020\u0011H\u00c6\u0003J\t\u0010=\u001a\u00020\rH\u00c6\u0003J\u008b\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u00c6\u0001J\u0013\u0010?\u001a\u00020\r2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010A\u001a\u00020\u000fH\u00d6\u0001J\t\u0010B\u001a\u00020CH\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0012\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0013\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010-\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/model/PlatformConfig;", "", "context", "Landroid/content/Context;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "scriptPluginFactory", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "codeCacheMode", "", "codeCacheInterval", "", "enableOpenGlEs3", "enablePreloadEngine", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "(Landroid/content/Context;Lcom/tencent/mobileqq/triton/utils/LogDelegate;Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;Lcom/tencent/mobileqq/triton/model/DebugConfig;Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;ZIJZZLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/utils/Downloader;)V", "getCodeCacheInterval", "()J", "getCodeCacheMode", "()I", "getContext", "()Landroid/content/Context;", "getDebugConfig", "()Lcom/tencent/mobileqq/triton/model/DebugConfig;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "getEnableCodeCache", "()Z", "getEnableOpenGlEs3", "getEnablePreloadEngine", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getLogger", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "getMainThreadExecutor", "()Ljava/util/concurrent/Executor;", "getScriptPluginFactory", "()Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "getWorkerExecutor", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class PlatformConfig {
    private final long codeCacheInterval;
    private final int codeCacheMode;

    @NotNull
    private final Context context;

    @NotNull
    private final DebugConfig debugConfig;

    @NotNull
    private final Downloader downloader;
    private final boolean enableCodeCache;
    private final boolean enableOpenGlEs3;
    private final boolean enablePreloadEngine;

    @NotNull
    private final EnginePackage enginePackage;

    @NotNull
    private final LogDelegate logger;

    @NotNull
    private final Executor mainThreadExecutor;

    @NotNull
    private final ScriptPluginFactory scriptPluginFactory;

    @NotNull
    private final Executor workerExecutor;

    public PlatformConfig(@NotNull Context context, @NotNull LogDelegate logger, @NotNull ScriptPluginFactory scriptPluginFactory, @NotNull DebugConfig debugConfig, @NotNull EnginePackage enginePackage, boolean z16, int i3, long j3, boolean z17, boolean z18, @NotNull Executor workerExecutor, @NotNull Executor mainThreadExecutor, @NotNull Downloader downloader) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        Intrinsics.checkParameterIsNotNull(scriptPluginFactory, "scriptPluginFactory");
        Intrinsics.checkParameterIsNotNull(debugConfig, "debugConfig");
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        Intrinsics.checkParameterIsNotNull(workerExecutor, "workerExecutor");
        Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkParameterIsNotNull(downloader, "downloader");
        this.context = context;
        this.logger = logger;
        this.scriptPluginFactory = scriptPluginFactory;
        this.debugConfig = debugConfig;
        this.enginePackage = enginePackage;
        this.enableCodeCache = z16;
        this.codeCacheMode = i3;
        this.codeCacheInterval = j3;
        this.enableOpenGlEs3 = z17;
        this.enablePreloadEngine = z18;
        this.workerExecutor = workerExecutor;
        this.mainThreadExecutor = mainThreadExecutor;
        this.downloader = downloader;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getEnablePreloadEngine() {
        return this.enablePreloadEngine;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final Executor getWorkerExecutor() {
        return this.workerExecutor;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final Downloader getDownloader() {
        return this.downloader;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final LogDelegate getLogger() {
        return this.logger;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final ScriptPluginFactory getScriptPluginFactory() {
        return this.scriptPluginFactory;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final DebugConfig getDebugConfig() {
        return this.debugConfig;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final EnginePackage getEnginePackage() {
        return this.enginePackage;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getEnableCodeCache() {
        return this.enableCodeCache;
    }

    /* renamed from: component7, reason: from getter */
    public final int getCodeCacheMode() {
        return this.codeCacheMode;
    }

    /* renamed from: component8, reason: from getter */
    public final long getCodeCacheInterval() {
        return this.codeCacheInterval;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getEnableOpenGlEs3() {
        return this.enableOpenGlEs3;
    }

    @NotNull
    public final PlatformConfig copy(@NotNull Context context, @NotNull LogDelegate logger, @NotNull ScriptPluginFactory scriptPluginFactory, @NotNull DebugConfig debugConfig, @NotNull EnginePackage enginePackage, boolean enableCodeCache, int codeCacheMode, long codeCacheInterval, boolean enableOpenGlEs3, boolean enablePreloadEngine, @NotNull Executor workerExecutor, @NotNull Executor mainThreadExecutor, @NotNull Downloader downloader) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        Intrinsics.checkParameterIsNotNull(scriptPluginFactory, "scriptPluginFactory");
        Intrinsics.checkParameterIsNotNull(debugConfig, "debugConfig");
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        Intrinsics.checkParameterIsNotNull(workerExecutor, "workerExecutor");
        Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkParameterIsNotNull(downloader, "downloader");
        return new PlatformConfig(context, logger, scriptPluginFactory, debugConfig, enginePackage, enableCodeCache, codeCacheMode, codeCacheInterval, enableOpenGlEs3, enablePreloadEngine, workerExecutor, mainThreadExecutor, downloader);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PlatformConfig) {
                PlatformConfig platformConfig = (PlatformConfig) other;
                if (!Intrinsics.areEqual(this.context, platformConfig.context) || !Intrinsics.areEqual(this.logger, platformConfig.logger) || !Intrinsics.areEqual(this.scriptPluginFactory, platformConfig.scriptPluginFactory) || !Intrinsics.areEqual(this.debugConfig, platformConfig.debugConfig) || !Intrinsics.areEqual(this.enginePackage, platformConfig.enginePackage) || this.enableCodeCache != platformConfig.enableCodeCache || this.codeCacheMode != platformConfig.codeCacheMode || this.codeCacheInterval != platformConfig.codeCacheInterval || this.enableOpenGlEs3 != platformConfig.enableOpenGlEs3 || this.enablePreloadEngine != platformConfig.enablePreloadEngine || !Intrinsics.areEqual(this.workerExecutor, platformConfig.workerExecutor) || !Intrinsics.areEqual(this.mainThreadExecutor, platformConfig.mainThreadExecutor) || !Intrinsics.areEqual(this.downloader, platformConfig.downloader)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getCodeCacheInterval() {
        return this.codeCacheInterval;
    }

    public final int getCodeCacheMode() {
        return this.codeCacheMode;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final DebugConfig getDebugConfig() {
        return this.debugConfig;
    }

    @NotNull
    public final Downloader getDownloader() {
        return this.downloader;
    }

    public final boolean getEnableCodeCache() {
        return this.enableCodeCache;
    }

    public final boolean getEnableOpenGlEs3() {
        return this.enableOpenGlEs3;
    }

    public final boolean getEnablePreloadEngine() {
        return this.enablePreloadEngine;
    }

    @NotNull
    public final EnginePackage getEnginePackage() {
        return this.enginePackage;
    }

    @NotNull
    public final LogDelegate getLogger() {
        return this.logger;
    }

    @NotNull
    public final Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }

    @NotNull
    public final ScriptPluginFactory getScriptPluginFactory() {
        return this.scriptPluginFactory;
    }

    @NotNull
    public final Executor getWorkerExecutor() {
        return this.workerExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        Context context = this.context;
        int i28 = 0;
        if (context != null) {
            i3 = context.hashCode();
        } else {
            i3 = 0;
        }
        int i29 = i3 * 31;
        LogDelegate logDelegate = this.logger;
        if (logDelegate != null) {
            i16 = logDelegate.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        ScriptPluginFactory scriptPluginFactory = this.scriptPluginFactory;
        if (scriptPluginFactory != null) {
            i17 = scriptPluginFactory.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (i36 + i17) * 31;
        DebugConfig debugConfig = this.debugConfig;
        if (debugConfig != null) {
            i18 = debugConfig.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        EnginePackage enginePackage = this.enginePackage;
        if (enginePackage != null) {
            i19 = enginePackage.hashCode();
        } else {
            i19 = 0;
        }
        int i39 = (i38 + i19) * 31;
        boolean z16 = this.enableCodeCache;
        int i46 = 1;
        int i47 = z16;
        if (z16 != 0) {
            i47 = 1;
        }
        int i48 = (((i39 + i47) * 31) + this.codeCacheMode) * 31;
        long j3 = this.codeCacheInterval;
        int i49 = (i48 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        boolean z17 = this.enableOpenGlEs3;
        int i56 = z17;
        if (z17 != 0) {
            i56 = 1;
        }
        int i57 = (i49 + i56) * 31;
        boolean z18 = this.enablePreloadEngine;
        if (!z18) {
            i46 = z18 ? 1 : 0;
        }
        int i58 = (i57 + i46) * 31;
        Executor executor = this.workerExecutor;
        if (executor != null) {
            i26 = executor.hashCode();
        } else {
            i26 = 0;
        }
        int i59 = (i58 + i26) * 31;
        Executor executor2 = this.mainThreadExecutor;
        if (executor2 != null) {
            i27 = executor2.hashCode();
        } else {
            i27 = 0;
        }
        int i65 = (i59 + i27) * 31;
        Downloader downloader = this.downloader;
        if (downloader != null) {
            i28 = downloader.hashCode();
        }
        return i65 + i28;
    }

    @NotNull
    public String toString() {
        return "PlatformConfig(context=" + this.context + ", logger=" + this.logger + ", scriptPluginFactory=" + this.scriptPluginFactory + ", debugConfig=" + this.debugConfig + ", enginePackage=" + this.enginePackage + ", enableCodeCache=" + this.enableCodeCache + ", codeCacheMode=" + this.codeCacheMode + ", codeCacheInterval=" + this.codeCacheInterval + ", enableOpenGlEs3=" + this.enableOpenGlEs3 + ", enablePreloadEngine=" + this.enablePreloadEngine + ", workerExecutor=" + this.workerExecutor + ", mainThreadExecutor=" + this.mainThreadExecutor + ", downloader=" + this.downloader + ")";
    }
}
