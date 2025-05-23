package com.tencent.qimei.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.h.a;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public c f343288a;

    /* renamed from: b, reason: collision with root package name */
    public ServiceConnection f343289b;

    /* renamed from: c, reason: collision with root package name */
    public Context f343290c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.qimei.h.a f343291d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public c f343292a;

        public a(b bVar, c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, bVar, cVar);
            } else {
                this.f343292a = cVar;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.qimei.h.a c9323a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                b bVar = b.this;
                int i3 = a.AbstractBinderC9322a.f343286a;
                if (iBinder == null) {
                    c9323a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof com.tencent.qimei.h.a)) {
                        c9323a = (com.tencent.qimei.h.a) queryLocalInterface;
                    }
                    c9323a = new a.AbstractBinderC9322a.C9323a(iBinder);
                }
                bVar.f343291d = c9323a;
                com.tencent.qimei.b.d dVar = com.tencent.qimei.b.d.f343207e;
                com.tencent.qimei.b.c cVar = new com.tencent.qimei.b.c(dVar, new d(b.this.f343291d, this.f343292a));
                ExecutorService executorService = dVar.f343209b;
                if (executorService != null) {
                    try {
                        executorService.execute(cVar);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                b.this.f343291d = null;
            }
        }
    }

    public b(Context context, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) cVar);
        } else {
            if (context != null) {
                this.f343290c = context;
                this.f343288a = cVar;
                this.f343289b = new a(this, cVar);
                return;
            }
            throw new NullPointerException("Context can not be null.");
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            com.tencent.qimei.h.a aVar = this.f343291d;
            if (aVar == null) {
                return false;
            }
            return aVar.d();
        } catch (Exception unused) {
            return false;
        }
    }
}
