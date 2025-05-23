package com.tencent.qqmini.minigame.api;

import android.content.Context;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.exception.TritonPlatformInitTwiceException;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.qqmini.minigame.task.e;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.utils.d;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import hu3.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/minigame/api/TritonPlatformManager;", "", "()V", "TAG", "", "platform", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "webAudioSoPath", "getTritonPlatform", "context", "Landroid/content/Context;", "enginePackage", "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "getWebAudioSoPath", "setWebAudioSoPath", "", "path", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class TritonPlatformManager {
    private static final String TAG = "TritonPlatformManager";
    private static TritonPlatform platform;
    public static final TritonPlatformManager INSTANCE = new TritonPlatformManager();
    private static volatile String webAudioSoPath = "";

    TritonPlatformManager() {
    }

    public static final /* synthetic */ TritonPlatform access$getPlatform$p(TritonPlatformManager tritonPlatformManager) {
        TritonPlatform tritonPlatform = platform;
        if (tritonPlatform == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platform");
        }
        return tritonPlatform;
    }

    @JvmStatic
    @NotNull
    public static final synchronized TritonPlatform getTritonPlatform(@NotNull Context context, @NotNull MiniEnginePackage enginePackage) throws TritonInitException {
        TritonPlatform tritonPlatform;
        synchronized (TritonPlatformManager.class) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
            if (platform == null) {
                try {
                    TritonPlatform.Builder context2 = new TritonPlatform.Builder().context(context);
                    Object obj = ProxyManager.get(MiniAppProxy.class);
                    Intrinsics.checkExpressionValueIsNotNull(obj, "ProxyManager.get(MiniAppProxy::class.java)");
                    boolean isDebugVersion = ((MiniAppProxy) obj).isDebugVersion();
                    long gamePresentDetectInterval = GameWnsUtils.getGamePresentDetectInterval();
                    long noPresentDurationLimit = GameWnsUtils.getNoPresentDurationLimit();
                    int frameNoChangeLimit = GameWnsUtils.getFrameNoChangeLimit();
                    int noPresentTouchLimit = GameWnsUtils.getNoPresentTouchLimit();
                    a aVar = a.f406343a;
                    platform = context2.debugConfig(new DebugConfig(isDebugVersion, gamePresentDetectInterval, noPresentDurationLimit, frameNoChangeLimit, noPresentTouchLimit, aVar.a(), aVar.b())).enableCodeCache(GameWnsUtils.getGameEnableCodeCache()).codeCacheMode(2).codeCacheInterval(60000L).enableOpenGlEs3(GameWnsUtils.enableOpengles3()).enginePackage(enginePackage).logger(new d()).scriptPluginFactory(MiniScriptPluginFactory.INSTANCE).mainThreadExecutor(ThreadPools.getMainThreadExecutor()).workerExecutor(ThreadPools.getComputationThreadPool()).downloader(MiniDownloader.INSTANCE).build();
                } catch (TritonPlatformInitTwiceException e16) {
                    GameLog.getInstance().e(TAG, "exception in init TritonPlatform", e16);
                    platform = e16.getPreviouslyBuiltPlatform();
                }
            }
            tritonPlatform = platform;
            if (tritonPlatform == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platform");
            }
        }
        return tritonPlatform;
    }

    @JvmStatic
    @NotNull
    public static final String getWebAudioSoPath() {
        boolean z16;
        if (webAudioSoPath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            e.f346742a.a();
        } else {
            com.tencent.qqmini.sdk.utils.d.f348364a.a(webAudioSoPath);
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "getWebAudioSoPath: path=" + webAudioSoPath);
        }
        return webAudioSoPath;
    }

    public final void setWebAudioSoPath(@NotNull String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        webAudioSoPath = path;
    }
}
