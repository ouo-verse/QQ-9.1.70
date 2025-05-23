package com.tencent.qimei.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.l.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC9327b f343335a;

    /* renamed from: b, reason: collision with root package name */
    public ServiceConnection f343336b;

    /* renamed from: c, reason: collision with root package name */
    public Context f343337c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f343338d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.qimei.l.a f343339e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.qimei.l.a c9326a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                b bVar = b.this;
                int i3 = a.AbstractBinderC9325a.f343333a;
                if (iBinder == null) {
                    c9326a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof com.tencent.qimei.l.a)) {
                        c9326a = (com.tencent.qimei.l.a) queryLocalInterface;
                    }
                    c9326a = new a.AbstractBinderC9325a.C9326a(iBinder);
                }
                bVar.f343339e = c9326a;
                b bVar2 = b.this;
                InterfaceC9327b interfaceC9327b = bVar2.f343335a;
                if (interfaceC9327b != null) {
                    ((c) interfaceC9327b).a(bVar2);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("SI");
                sb5.append(" Service onServiceConnected");
                com.tencent.qimei.ad.b.b(sb5.toString());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            b.this.f343339e = null;
            com.tencent.qimei.ad.b.b("SI Service onServiceDisconnected");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.l.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC9327b {
    }

    public b(Context context, InterfaceC9327b interfaceC9327b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) interfaceC9327b);
            return;
        }
        this.f343335a = null;
        this.f343337c = null;
        this.f343338d = false;
        if (context != null) {
            this.f343337c = context;
            this.f343335a = interfaceC9327b;
            this.f343336b = new a();
            return;
        }
        throw new NullPointerException("Context can not be null.");
    }
}
