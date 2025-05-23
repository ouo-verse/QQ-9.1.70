package com.tencent.qimei.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.g.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f343281a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.g.a f343282b;

    /* renamed from: c, reason: collision with root package name */
    public ServiceConnection f343283c;

    /* renamed from: d, reason: collision with root package name */
    public b f343284d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.qimei.g.a c9321a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                c cVar = c.this;
                int i3 = a.AbstractBinderC9320a.f343275a;
                if (iBinder == null) {
                    c9321a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof com.tencent.qimei.g.a)) {
                        c9321a = (com.tencent.qimei.g.a) queryLocalInterface;
                    }
                    c9321a = new a.AbstractBinderC9320a.C9321a(iBinder);
                }
                cVar.f343282b = c9321a;
                c cVar2 = c.this;
                b bVar = cVar2.f343284d;
                if (bVar != null) {
                    ((com.tencent.qimei.g.b) bVar).a(cVar2);
                }
                c.this.b("Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            c cVar = c.this;
            cVar.f343282b = null;
            cVar.b("Service onServiceDisconnected");
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
    }

    public c(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f343281a = null;
        this.f343284d = null;
        if (context != null) {
            this.f343281a = context;
            this.f343284d = bVar;
            this.f343283c = new a();
            return;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        com.tencent.qimei.ad.b.a("LXOP " + str);
    }

    public final void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        com.tencent.qimei.ad.b.c("LXOP " + str);
    }
}
