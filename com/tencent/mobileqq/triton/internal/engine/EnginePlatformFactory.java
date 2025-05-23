package com.tencent.mobileqq.triton.internal.engine;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jp\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/EnginePlatformFactory;", "Lcom/tencent/mobileqq/triton/TritonPlatform$Builder$TritonPlatformFactory;", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/triton/TritonPlatform;", "context", "Landroid/content/Context;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "codeCacheMode", "", "codeCacheInterval", "", "enableOpenGlEs3", "enablePreloadEngine", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EnginePlatformFactory implements TritonPlatform.Builder.TritonPlatformFactory {
    @Override // com.tencent.mobileqq.triton.TritonPlatform.Builder.TritonPlatformFactory
    @NotNull
    public TritonPlatform create(@NotNull Context context, @NotNull LogDelegate logger, @NotNull DebugConfig debugConfig, @NotNull ScriptPluginFactory scriptPlugin, @NotNull EnginePackage enginePackage, boolean enableCodeCache, int codeCacheMode, long codeCacheInterval, boolean enableOpenGlEs3, boolean enablePreloadEngine, @NotNull Executor workerExecutor, @NotNull Executor mainThreadExecutor, @NotNull Downloader downloader) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        Intrinsics.checkParameterIsNotNull(debugConfig, "debugConfig");
        Intrinsics.checkParameterIsNotNull(scriptPlugin, "scriptPlugin");
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        Intrinsics.checkParameterIsNotNull(workerExecutor, "workerExecutor");
        Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkParameterIsNotNull(downloader, "downloader");
        return new EnginePlatform(new PlatformConfig(context, logger, scriptPlugin, debugConfig, enginePackage, enableCodeCache, codeCacheMode, codeCacheInterval, enableOpenGlEs3, enablePreloadEngine, workerExecutor, mainThreadExecutor, downloader));
    }
}
