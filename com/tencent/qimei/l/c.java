package com.tencent.qimei.l;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.b.d;
import com.tencent.qimei.l.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements com.tencent.qimei.a.b, b.InterfaceC9327b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.qimei.a.a f343341a;

    /* renamed from: b, reason: collision with root package name */
    public b f343342b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f343343c;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = c.this.f343342b;
            if (bVar != null) {
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                bVar.f343338d = bVar.f343337c.bindService(intent, bVar.f343336b, 1);
                if (!bVar.f343338d && bVar.f343335a != null) {
                    com.tencent.qimei.ad.b.b("SI bindService Failed!");
                    ((c) bVar.f343335a).a(bVar);
                    return;
                }
                com.tencent.qimei.ad.b.b("SI bindService Successful!");
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f343343c = new a();
        }
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343341a = aVar;
            this.f343342b = new b(context, this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            d.f343207e.a(this.f343343c);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        b bVar = this.f343342b;
        if (bVar != null && bVar.f343337c != null && bVar.f343338d) {
            try {
                try {
                    bVar.f343337c.unbindService(bVar.f343336b);
                    com.tencent.qimei.ad.b.b("SI unBind Service successful");
                } catch (IllegalArgumentException unused) {
                    com.tencent.qimei.ad.b.b("SI unBind Service exception");
                }
            } finally {
                bVar.f343339e = null;
                bVar.f343338d = false;
            }
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        b bVar = this.f343342b;
        boolean z16 = false;
        if (bVar != null) {
            try {
                if (bVar.f343339e == null) {
                    com.tencent.qimei.ad.b.b("SI Device not support opendeviceid");
                } else {
                    com.tencent.qimei.ad.b.b("SI Device support opendeviceid");
                    z16 = true;
                }
            } catch (Exception unused) {
                com.tencent.qimei.ad.b.b("SI isSupport error, RemoteException!");
            }
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
    
        if (r1 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar) {
        String str;
        StringBuilder sb5;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.qimei.a.a aVar = this.f343341a;
        if (aVar != null) {
            boolean a16 = a();
            String str3 = null;
            String str4 = "";
            if (a()) {
                b bVar2 = this.f343342b;
                Context context = bVar2.f343337c;
                if (context == null) {
                    com.tencent.qimei.ad.b.b("SI Context is null.");
                    throw new IllegalArgumentException("Context is null, must be new SxCore first");
                }
                String packageName = context.getPackageName();
                com.tencent.qimei.ad.b.c("SIapackage\uff1a" + packageName);
                if (packageName == null || packageName.equals("")) {
                    sb5 = new StringBuilder();
                    sb5.append("SI");
                    str2 = " input package is null!";
                } else {
                    try {
                        com.tencent.qimei.l.a aVar2 = bVar2.f343339e;
                        if (aVar2 != null) {
                            str = aVar2.a(packageName);
                            com.tencent.qimei.ad.b.c("SI getAAID Package: " + packageName);
                        }
                    } catch (Exception unused) {
                        sb5 = new StringBuilder();
                        sb5.append("SI");
                        str2 = " geta error, RemoteException!";
                    }
                    str = null;
                }
                sb5.append(str2);
                com.tencent.qimei.ad.b.b(sb5.toString());
                str = null;
            }
            str = "";
            if (a()) {
                b bVar3 = this.f343342b;
                if (bVar3.f343337c == null) {
                    com.tencent.qimei.ad.b.b("SI Context is null.");
                    throw new IllegalArgumentException("Context is null, must be new SxCore first");
                }
                try {
                    com.tencent.qimei.l.a aVar3 = bVar3.f343339e;
                    if (aVar3 != null) {
                        String c16 = aVar3.c();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("SDI");
                        sb6.append(" geto call");
                        com.tencent.qimei.ad.b.b(sb6.toString());
                        str3 = c16;
                    }
                } catch (Exception e16) {
                    com.tencent.qimei.ad.b.b("SI geto error, RemoteException!");
                    e16.printStackTrace();
                }
                if (str3 != null) {
                    str4 = str3;
                }
            }
            aVar.callbackOaid(a16, str, str4, false);
        }
    }
}
