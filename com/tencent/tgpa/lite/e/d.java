package com.tencent.tgpa.lite.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tgpa.lite.e.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f375922a;

    /* renamed from: b, reason: collision with root package name */
    private j f375923b;

    /* renamed from: c, reason: collision with root package name */
    private ServiceConnection f375924c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            Log.d("TGPA_MID", "Common Service onServiceConnected");
            try {
                c a16 = c.a.a(iBinder);
                if (a16 != null && d.this.f375923b != null) {
                    d.this.f375923b.a(a16.c());
                }
            } catch (Throwable unused) {
                com.tencent.tgpa.lite.g.h.b("Common Service get id exception.", new Object[0]);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                com.tencent.tgpa.lite.g.h.d("Common Service onServiceDisconnected", new Object[0]);
            }
        }
    }

    public d(Context context, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jVar);
            return;
        }
        this.f375924c = new a();
        this.f375922a = context;
        this.f375923b = jVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Context context = this.f375922a;
        if (context == null) {
            com.tencent.tgpa.lite.g.h.b("Common ID Service bind failed, context is null!", new Object[0]);
            return;
        }
        if (!a(context)) {
            com.tencent.tgpa.lite.g.h.d("Common ID Service not supported", new Object[0]);
            return;
        }
        String c16 = com.tencent.tgpa.lite.g.a.c();
        a(this.f375922a, c16);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", c16);
        if (this.f375922a.bindService(intent, this.f375924c, 1)) {
            com.tencent.tgpa.lite.g.h.c("Common ID Service bind ok!", new Object[0]);
        } else {
            com.tencent.tgpa.lite.g.h.b("Common ID Service bind failed!", new Object[0]);
        }
    }

    private static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) == null) {
                com.tencent.tgpa.lite.g.h.b("start msa kl service error", new Object[0]);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            com.tencent.tgpa.lite.g.h.b("start msa kl service exception.", new Object[0]);
        }
    }

    private static boolean a(Context context) {
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.mdid.msa", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
