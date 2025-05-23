package com.tencent.msdk.dns.c.c;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
abstract class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f336227a;

    /* renamed from: b, reason: collision with root package name */
    private final List<c> f336228b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f336227a = -1;
            this.f336228b = Collections.synchronizedList(new ArrayList());
        }
    }

    private void b() {
        com.tencent.msdk.dns.base.log.c.c("changeNetwork call", new Object[0]);
        synchronized (this.f336228b) {
            Iterator<c> it = this.f336228b.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    private boolean c(Context context) {
        if (context == null) {
            return true;
        }
        int d16 = com.tencent.msdk.dns.c.e.e.d(context);
        if (this.f336227a == -1) {
            this.f336227a = d16;
            return false;
        }
        if (this.f336227a != d16) {
            this.f336227a = d16;
            return true;
        }
        return false;
    }

    @Override // com.tencent.msdk.dns.c.c.b
    public synchronized void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        } else {
            if (cVar != null) {
                this.f336228b.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Context context) {
        try {
            if (c(context)) {
                b();
            }
        } catch (Exception e16) {
            com.tencent.msdk.dns.base.log.c.d(e16, "mayChangeNetwork exception occur", new Object[0]);
        }
    }
}
