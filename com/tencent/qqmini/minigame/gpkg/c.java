package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.GamePkgIPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\"\u0010\u0018\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0007\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/c;", "", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "Ljava/io/File;", "b", "Lcom/tencent/qqmini/sdk/launcher/model/MiniGamePluginInfo;", "pluginInfo", "c", "", "e", "d", "gamePkgDir", "f", "pluginDir", "g", "subPkgDir", h.F, "Lcom/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback;", "callback", "isSuccess", "Landroid/os/Bundle;", "data", "", "i", "", "errorMsg", "a", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f346451a = new c();

    c() {
    }

    @JvmStatic
    @NotNull
    public static final Bundle a(@NotNull String errorMsg) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        Bundle bundle = new Bundle();
        bundle.putInt(GamePkgIPCConst.KEY_CMD, 2);
        bundle.putString(GamePkgIPCConst.KEY_ERROR_MSG, errorMsg);
        return bundle;
    }

    @JvmStatic
    @NotNull
    public static final File b(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        return new File(ApkgManager.getApkgFolderPath(miniAppInfo));
    }

    @JvmStatic
    @NotNull
    public static final File c(@NotNull MiniGamePluginInfo pluginInfo) {
        Intrinsics.checkParameterIsNotNull(pluginInfo, "pluginInfo");
        return new File(ApkgManager.getGpkgPluginFolderPath(pluginInfo));
    }

    @JvmStatic
    public static final boolean d(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        if (miniAppInfo.verType == 3) {
            return false;
        }
        if (miniAppInfo.isSupportOffline && miniAppInfo.launchParam.scene != 1011) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean e(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        if (!f(b(miniAppInfo))) {
            return false;
        }
        MiniGamePluginInfo miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
        if (miniGamePluginInfo != null) {
            return g(c(miniGamePluginInfo));
        }
        return true;
    }

    @JvmStatic
    public static final boolean f(@NotNull File gamePkgDir) {
        Intrinsics.checkParameterIsNotNull(gamePkgDir, "gamePkgDir");
        if (gamePkgDir.exists() && gamePkgDir.isDirectory()) {
            return new File(gamePkgDir, "game.js").exists();
        }
        return false;
    }

    @JvmStatic
    public static final boolean g(@NotNull File pluginDir) {
        Intrinsics.checkParameterIsNotNull(pluginDir, "pluginDir");
        if (pluginDir.exists() && pluginDir.isDirectory()) {
            return new File(pluginDir, "plugin.js").exists();
        }
        return false;
    }

    @JvmStatic
    public static final boolean h(@NotNull File subPkgDir) {
        Intrinsics.checkParameterIsNotNull(subPkgDir, "subPkgDir");
        if (subPkgDir.exists() && subPkgDir.isDirectory()) {
            return new File(subPkgDir, "game.js").exists();
        }
        return false;
    }

    @JvmStatic
    public static final void i(@Nullable MiniCmdCallback callback, boolean isSuccess, @NotNull Bundle data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (callback == null) {
            return;
        }
        try {
            IBinder asBinder = callback.asBinder();
            Intrinsics.checkExpressionValueIsNotNull(asBinder, "callback.asBinder()");
            if (!asBinder.isBinderAlive()) {
                QMLog.w("GamePkgUtil", "game process may die, callback is invalid.");
            } else {
                callback.onCmdResult(isSuccess, data);
            }
        } catch (RemoteException e16) {
            QMLog.e("GamePkgUtil", "safeCallback: failed", e16);
        }
    }
}
