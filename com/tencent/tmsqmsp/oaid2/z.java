package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmsqmsp.oaid2.y;

/* compiled from: P */
/* loaded from: classes26.dex */
public class z {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f380907e = "com.mdid.msa";

    /* renamed from: a, reason: collision with root package name */
    private a0 f380908a;

    /* renamed from: b, reason: collision with root package name */
    private ServiceConnection f380909b;

    /* renamed from: c, reason: collision with root package name */
    private Context f380910c;

    /* renamed from: d, reason: collision with root package name */
    private y f380911d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        a0 f380912d;

        a(a0 a0Var) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) z.this, (Object) a0Var);
            } else {
                this.f380912d = a0Var;
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                z.this.f380911d = y.a.a(iBinder);
                c.a(new b0(z.this.f380911d, this.f380912d));
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                z.this.f380911d = null;
                z.this.f380911d = null;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55698);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public z(Context context, a0 a0Var) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) a0Var);
        } else {
            if (context != null) {
                this.f380910c = context;
                this.f380908a = a0Var;
                this.f380909b = new a(a0Var);
                return;
            }
            throw new NullPointerException("Context can not be null.");
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            y yVar = this.f380911d;
            if (yVar == null) {
                return "";
            }
            return yVar.a();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            y yVar = this.f380911d;
            if (yVar == null) {
                return false;
            }
            return yVar.g();
        } catch (Exception unused) {
            return false;
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        y yVar = this.f380911d;
        if (yVar != null) {
            try {
                yVar.f();
                ServiceConnection serviceConnection = this.f380909b;
                if (serviceConnection != null) {
                    this.f380910c.unbindService(serviceConnection);
                }
            } catch (Exception unused) {
            }
            this.f380909b = null;
            this.f380911d = null;
        }
    }

    public void a(String str) {
        a0 a0Var;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        if (this.f380910c.bindService(intent, this.f380909b, 1) || (a0Var = this.f380908a) == null) {
            return;
        }
        a0Var.b();
    }

    public static boolean a(Context context) {
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), f380907e, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(f380907e, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception unused) {
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            y yVar = this.f380911d;
            return yVar == null ? "" : yVar.d();
        } catch (Exception unused) {
            return "";
        }
    }
}
