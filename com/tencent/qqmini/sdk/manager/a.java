package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.GamePkgIPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.raft.measure.utils.MeasureConst;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\t\fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqmini/sdk/manager/a;", "", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "gameConfig", "", "ignoreProcess", "Lcom/tencent/qqmini/sdk/manager/a$b;", "listener", "", "a", "Landroid/os/Bundle;", "data", "b", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f348143a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqmini/sdk/manager/a$a;", "Lcom/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback$Stub;", "", MeasureConst.SLI_TYPE_SUCCESS, "Landroid/os/Bundle;", "bundle", "", "onCmdResult", "Lcom/tencent/qqmini/sdk/manager/a$b;", "d", "Lcom/tencent/qqmini/sdk/manager/a$b;", "listener", "<init>", "(Lcom/tencent/qqmini/sdk/manager/a$b;)V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.sdk.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class BinderC9417a extends MiniCmdCallback.Stub {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final b listener;

        public BinderC9417a(@NotNull b listener) {
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            this.listener = listener;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
        public void onCmdResult(boolean succ, @Nullable Bundle bundle) {
            if (succ && bundle != null) {
                int i3 = bundle.getInt(GamePkgIPCConst.KEY_CMD, -1);
                if (i3 == 1) {
                    this.listener.onProgress(bundle.getFloat(GamePkgIPCConst.KEY_PROGRESS), bundle.getLong(GamePkgIPCConst.KEY_TOTAL_FILE_SIZE));
                    return;
                } else {
                    if (i3 == 3) {
                        this.listener.onSuccess();
                        return;
                    }
                    if (i3 == 2) {
                        String msg2 = bundle.getString(GamePkgIPCConst.KEY_ERROR_MSG, "unknown");
                        b bVar = this.listener;
                        Intrinsics.checkExpressionValueIsNotNull(msg2, "msg");
                        bVar.onFail(msg2);
                        return;
                    }
                    QMLog.e("GamePkgLoader", "unSupport cmd=" + i3);
                    return;
                }
            }
            this.listener.onFail("IPC call fail");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqmini/sdk/manager/a$b;", "", "", "progress", "", "totalFileSize", "", "onProgress", "onSuccess", "", "errorMsg", "onFail", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public interface b {
        void onFail(@NotNull String errorMsg);

        void onProgress(float progress, long totalFileSize);

        void onSuccess();
    }

    a() {
    }

    @JvmStatic
    public static final void a(@NotNull MiniAppInfo gameConfig, boolean ignoreProcess, @NotNull b listener) {
        Intrinsics.checkParameterIsNotNull(gameConfig, "gameConfig");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        Bundle bundle = new Bundle();
        bundle.putParcelable(GamePkgIPCConst.KEY_GAME_CONFIG, gameConfig);
        bundle.putBoolean(GamePkgIPCConst.KEY_IGNORE_PROGRESS, ignoreProcess);
        AppLoaderFactory g16 = AppLoaderFactory.g();
        Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
        if (g16.isMainProcess()) {
            f348143a.b(bundle, listener);
        } else {
            AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_DOWNLOAD_GAME_PKG, bundle, new BinderC9417a(listener));
        }
    }

    private final void b(Bundle data, b listener) {
        CmdProxy cmdProxy = (CmdProxy) ProxyManager.get(CmdProxy.class);
        if (cmdProxy == null) {
            listener.onFail("get cmdProxy null");
        } else {
            cmdProxy.handleMiniAppCmd(IPCConst.CMD_DOWNLOAD_GAME_PKG, data, new BinderC9417a(listener));
        }
    }
}
