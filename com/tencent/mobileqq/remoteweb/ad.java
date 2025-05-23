package com.tencent.mobileqq.remoteweb;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.remoteweb.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/ad;", "Lcom/tencent/mobileqq/remoteweb/a;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class ad implements a {
    static IPatchRedirector $redirector_;

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.a
    public void onFailed(@NotNull String str, int i3, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
        } else {
            a.C8510a.a(this, str, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.a
    public void onReportTimeCost(@NotNull String str, @NotNull RemoteWebTimeCost remoteWebTimeCost, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, remoteWebTimeCost, Long.valueOf(j3));
        } else {
            a.C8510a.b(this, str, remoteWebTimeCost, j3);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.a
    public void onServiceConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            a.C8510a.c(this);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.a
    public void onServiceDisconnected(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            a.C8510a.d(this, j3);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.a
    public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            a.C8510a.e(this, str, remoteWebViewEvent);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) remoteWebViewEvent);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.a
    public void onWebViewEvent(@NotNull String str, @NotNull RemoteWebViewEvent remoteWebViewEvent, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            a.C8510a.f(this, str, remoteWebViewEvent, bundle);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, remoteWebViewEvent, bundle);
        }
    }
}
