package com.tencent.offline.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
class OfflineUtils$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String[] f339493d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Context f339494e;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.f339493d.length; i3++) {
            d.a(c.f(this.f339493d[i3]) + this.f339493d[i3]);
            d.a(c.a(this.f339493d[i3]) + this.f339493d[i3]);
            d.b(c.k(this.f339493d[i3]) + this.f339493d[i3] + ".zip");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("offline_last_up_");
            sb5.append(this.f339493d[i3]);
            com.tencent.hy.common.store.a.g(sb5.toString(), 0L);
            com.tencent.offline.component.update.a.a(this.f339494e, this.f339493d[i3], 0);
        }
    }
}
