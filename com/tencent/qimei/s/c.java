package com.tencent.qimei.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final b f343363a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f343364b;

    public c(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f343363a = bVar;
            this.f343364b = com.tencent.qimei.ap.d.c().e();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        try {
            str = intent.getAction();
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
            str = null;
        }
        if (str != null && str.equals(a.f343361a) && (bVar = this.f343363a) != null) {
            ((com.tencent.qimei.ai.d) bVar).b();
        }
    }
}
