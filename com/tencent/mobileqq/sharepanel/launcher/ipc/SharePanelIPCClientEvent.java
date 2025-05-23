package com.tencent.mobileqq.sharepanel.launcher.ipc;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "action", "", "params", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "getAction", "()Ljava/lang/String;", "getParams", "()Landroid/os/Bundle;", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SharePanelIPCClientEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String action;

    @NotNull
    private final Bundle params;

    public SharePanelIPCClientEvent(@NotNull String action, @NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) action, (Object) params);
        } else {
            this.action = action;
            this.params = params;
        }
    }

    @NotNull
    public final String getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.action;
    }

    @NotNull
    public final Bundle getParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bundle) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.params;
    }
}
