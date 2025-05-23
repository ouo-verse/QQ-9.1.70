package com.tencent.qimei.g;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.b.d;
import com.tencent.qimei.g.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements com.tencent.qimei.a.b, c.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public c f343277a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.a.a f343278b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f343279c;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            c cVar = b.this.f343277a;
            if (cVar != null) {
                Intent intent = new Intent();
                intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
                if (cVar.f343281a.bindService(intent, cVar.f343283c, 1)) {
                    str = "bindService Successful!";
                } else {
                    c.b bVar = cVar.f343284d;
                    if (bVar != null) {
                        ((b) bVar).a(cVar);
                    }
                    str = "bindService Failed!!!";
                }
                cVar.b(str);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f343279c = new a();
        }
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343278b = aVar;
            this.f343277a = new c(context, this);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        c cVar = this.f343277a;
        if (cVar == null) {
            return false;
        }
        try {
            if (cVar.f343282b == null) {
                return false;
            }
            cVar.b("Device support opendeviceid");
            return cVar.f343282b.a();
        } catch (Exception unused) {
            cVar.a("isSupport error, RemoteException!");
            return false;
        }
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            d.f343207e.a(this.f343279c);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c cVar = this.f343277a;
        if (cVar != null) {
            try {
                cVar.f343281a.unbindService(cVar.f343283c);
                cVar.b("unBind Service successful");
            } catch (IllegalArgumentException unused) {
                cVar.a("unBind Service exception");
            }
            cVar.f343282b = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        String str;
        com.tencent.qimei.g.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!b()) {
            return "";
        }
        c cVar = this.f343277a;
        Context context = cVar.f343281a;
        if (context == null) {
            cVar.b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        cVar.b("liufeng, getAAID package\uff1a" + packageName);
        if (packageName == null || packageName.equals("")) {
            cVar.b("input package is null!");
        } else {
            try {
                aVar = cVar.f343282b;
            } catch (Exception unused) {
                cVar.a("getAAID error, RemoteException!");
            }
            if (aVar != null) {
                str = aVar.c(packageName);
                return str != null ? "" : str;
            }
        }
        str = null;
        if (str != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r4 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(c cVar) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
            return;
        }
        try {
            com.tencent.qimei.a.a aVar = this.f343278b;
            if (aVar != null) {
                boolean b17 = b();
                String a16 = a();
                if (b()) {
                    c cVar2 = this.f343277a;
                    if (cVar2.f343281a == null) {
                        cVar2.a("Context is null.");
                        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
                    }
                    try {
                        com.tencent.qimei.g.a aVar2 = cVar2.f343282b;
                        b16 = aVar2 != null ? aVar2.b() : null;
                    } catch (Exception e16) {
                        cVar2.a("getOAID error, RemoteException!");
                        e16.printStackTrace();
                    }
                }
                b16 = "";
                aVar.callbackOaid(b17, a16, b16, false);
            }
        } catch (Throwable unused) {
            com.tencent.qimei.a.a aVar3 = this.f343278b;
            if (aVar3 != null) {
                aVar3.callbackOaid(false, "", "", false);
            }
        }
    }
}
