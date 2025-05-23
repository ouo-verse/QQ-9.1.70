package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmsqmsp.oaid2.q0;

/* compiled from: P */
/* loaded from: classes26.dex */
public class r0 {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f380868e = "SDI";

    /* renamed from: f, reason: collision with root package name */
    public static String f380869f = "SI";

    /* renamed from: a, reason: collision with root package name */
    public b f380870a;

    /* renamed from: b, reason: collision with root package name */
    private ServiceConnection f380871b;

    /* renamed from: c, reason: collision with root package name */
    private Context f380872c;

    /* renamed from: d, reason: collision with root package name */
    public q0 f380873d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r0.this);
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
                r0.this.f380873d = q0.a.a(iBinder);
                r0 r0Var = r0.this;
                b bVar = r0Var.f380870a;
                if (bVar != null) {
                    bVar.a(r0Var);
                }
                t0.b(r0.f380869f + " Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            r0.this.f380873d = null;
            t0.b(r0.f380869f + " Service onServiceDisconnected");
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void a(r0 r0Var);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60267);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public r0(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f380870a = null;
        this.f380872c = null;
        if (context != null) {
            this.f380872c = context;
            this.f380870a = bVar;
            this.f380871b = new a();
            return;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.f380872c;
        if (context != null) {
            String packageName = context.getPackageName();
            t0.c(f380869f + "apackage\uff1a" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    q0 q0Var = this.f380873d;
                    if (q0Var != null) {
                        String a16 = q0Var.a(packageName);
                        t0.c(f380869f + " getAAID Package: " + packageName);
                        return a16;
                    }
                    return null;
                } catch (Exception unused) {
                    t0.b(f380869f + " geta error, RemoteException!");
                    return null;
                }
            }
            t0.b(f380869f + " input package is null!");
            return null;
        }
        t0.b(f380869f + " Context is null.");
        throw new IllegalArgumentException("Context is null, must be new SxCore first");
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f380872c != null) {
            try {
                q0 q0Var = this.f380873d;
                if (q0Var != null) {
                    String a16 = q0Var.a();
                    t0.b(f380868e + " geto call");
                    return a16;
                }
                return null;
            } catch (Exception e16) {
                t0.b(f380869f + " geto error, RemoteException!");
                e16.printStackTrace();
                return null;
            }
        }
        t0.b(f380869f + " Context is null.");
        throw new IllegalArgumentException("Context is null, must be new SxCore first");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f380872c.bindService(intent, this.f380871b, 1)) {
            t0.b(f380869f + " bindService Successful!");
            return;
        }
        this.f380870a.a(this);
        t0.b(f380869f + " bindService Failed!");
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            if (this.f380873d == null) {
                t0.b(f380869f + " Device not support opendeviceid");
                return false;
            }
            t0.b(f380869f + " Device support opendeviceid");
            return true;
        } catch (Exception unused) {
            t0.b(f380869f + " isSupport error, RemoteException!");
            return false;
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            this.f380872c.unbindService(this.f380871b);
            t0.b(f380869f + " unBind Service successful");
        } catch (IllegalArgumentException unused) {
            t0.b(f380869f + " unBind Service exception");
        }
        this.f380873d = null;
    }
}
