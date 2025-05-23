package com.tencent.qimei.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements com.tencent.qimei.a.b, c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public b f343296a;

    /* renamed from: b, reason: collision with root package name */
    public Context f343297b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.qimei.a.a f343298c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f343299d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            com.tencent.qimei.a.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            e eVar = e.this;
            b bVar = eVar.f343296a;
            if (bVar != null) {
                String a16 = com.tencent.qimei.a.c.a(eVar.f343297b);
                Intent intent = new Intent();
                intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
                intent.setAction("com.bun.msa.action.bindto.service");
                intent.putExtra("com.bun.msa.param.pkgname", a16);
                if (!bVar.f343290c.bindService(intent, bVar.f343289b, 1) && (cVar = bVar.f343288a) != null && (aVar = ((e) cVar).f343298c) != null) {
                    aVar.callbackOaid(false, "", "", false);
                    return;
                }
                return;
            }
            com.tencent.qimei.a.a aVar2 = eVar.f343298c;
            if (aVar2 != null) {
                aVar2.callbackOaid(false, "", "", false);
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f343299d = new a();
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        b bVar = this.f343296a;
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.qimei.b.d.f343207e.a(this.f343299d);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        com.tencent.qimei.h.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        b bVar = this.f343296a;
        if (bVar != null && (aVar = bVar.f343291d) != null) {
            try {
                aVar.i();
                ServiceConnection serviceConnection = bVar.f343289b;
                if (serviceConnection != null) {
                    bVar.f343290c.unbindService(serviceConnection);
                }
            } catch (Exception unused) {
            }
            bVar.f343289b = null;
            bVar.f343291d = null;
        }
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        boolean z16 = false;
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.mdid.msa", 0);
            z16 = true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (z16) {
            String a16 = com.tencent.qimei.a.c.a(context);
            if (!TextUtils.isEmpty(a16)) {
                Intent intent = new Intent();
                intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                intent.setAction("com.bun.msa.action.start.service");
                intent.putExtra("com.bun.msa.param.pkgname", a16);
                try {
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    context.startService(intent);
                } catch (Exception unused2) {
                }
            }
            this.f343296a = new b(context, this);
        }
        this.f343298c = aVar;
        this.f343297b = context;
    }
}
