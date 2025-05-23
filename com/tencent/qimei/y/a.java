package com.tencent.qimei.y;

import android.net.ConnectivityManager;
import android.net.Network;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends ConnectivityManager.NetworkCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f343428a;

    public a(b bVar) {
        this.f343428a = bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(@NonNull Network network) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
            return;
        }
        if (!this.f343428a.f343433d) {
            this.f343428a.f343433d = true;
            com.tencent.qimei.ad.c.b("QM", "current network switched to the available state", new Object[0]);
            Iterator<c> it = this.f343428a.f343430a.keySet().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(@NonNull Network network) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f343428a.f343433d = false;
            com.tencent.qimei.ad.c.b("QM", "current network lost", new Object[0]);
            Iterator<c> it = this.f343428a.f343430a.keySet().iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) network);
    }
}
