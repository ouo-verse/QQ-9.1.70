package com.tencent.qimei.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements com.tencent.qimei.a.b, b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.qimei.a.a f343243a;

    /* renamed from: b, reason: collision with root package name */
    public String f343244b;

    /* renamed from: c, reason: collision with root package name */
    public String f343245c;

    /* renamed from: d, reason: collision with root package name */
    public d f343246d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f343247e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f343248f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f343249g;

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
            com.tencent.qimei.a.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            c cVar = c.this;
            d dVar = cVar.f343246d;
            if (dVar != null) {
                try {
                    dVar.f343254d = cVar;
                    Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
                    ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    com.tencent.qimei.ad.b.c("HSDID start to bind did service");
                    boolean bindService = dVar.f343252b.bindService(intent2, dVar.f343255e, 1);
                    dVar.f343251a = bindService;
                    if (!bindService && (aVar = ((c) dVar.f343254d).f343243a) != null) {
                        aVar.callbackOaid(false, null, null, false);
                    }
                } catch (Exception unused) {
                    dVar.a(false);
                }
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343244b = "";
        this.f343245c = "";
        this.f343247e = false;
        this.f343248f = false;
        this.f343249g = new a();
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343243a = aVar;
            this.f343246d = new d(context);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IBinder) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            com.tencent.qimei.b.d.f343207e.a(this.f343249g);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f343247e && (dVar = this.f343246d) != null) {
            try {
                if (dVar.f343251a && dVar.f343255e != null && dVar.f343252b != null) {
                    com.tencent.qimei.ad.b.c("HSDID start to unbind did service");
                    dVar.f343251a = false;
                    dVar.f343252b.unbindService(dVar.f343255e);
                }
            } catch (Exception e16) {
                com.tencent.qimei.ad.b.a("HSDID error:" + e16.getMessage());
            }
        }
    }

    public void a(com.tencent.qimei.e.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        try {
            String a16 = aVar.a();
            this.f343244b = a16;
            if (a16 == null) {
                this.f343244b = "";
            }
        } catch (Exception unused) {
        }
        try {
            String f16 = aVar.f();
            this.f343245c = f16;
            if (f16 == null) {
                this.f343245c = "";
            }
        } catch (Exception unused2) {
        }
        try {
            this.f343248f = aVar.b();
        } catch (Exception unused3) {
        }
        this.f343247e = true;
        com.tencent.qimei.a.a aVar2 = this.f343243a;
        if (aVar2 != null) {
            aVar2.callbackOaid(this.f343248f, this.f343245c, this.f343244b, false);
        }
    }
}
