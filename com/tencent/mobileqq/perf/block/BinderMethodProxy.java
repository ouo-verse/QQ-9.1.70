package com.tencent.mobileqq.perf.block;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import eipc.EIPCClient;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/perf/block/BinderMethodProxy;", "", "()V", "callServer", "Leipc/EIPCResult;", "client", "Leipc/EIPCClient;", "module", "", "action", "params", "Landroid/os/Bundle;", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class BinderMethodProxy {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final BinderMethodProxy INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new BinderMethodProxy();
        }
    }

    BinderMethodProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final EIPCResult callServer(@NotNull EIPCClient client, @Nullable String module, @Nullable String action, @Nullable Bundle params) {
        Intrinsics.checkNotNullParameter(client, "client");
        MainBlockMethodMonitor.onMethodStart();
        EIPCResult callServer = client.callServer(module, action, params);
        MainBlockMethodMonitor.onMethodEnd();
        return callServer;
    }
}
