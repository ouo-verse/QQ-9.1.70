package com.tencent.qmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmsp.oaid2.v;

/* compiled from: P */
/* loaded from: classes22.dex */
public class x {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f344308e = "LXOP";

    /* renamed from: a, reason: collision with root package name */
    private Context f344309a;

    /* renamed from: b, reason: collision with root package name */
    public v f344310b;

    /* renamed from: c, reason: collision with root package name */
    private ServiceConnection f344311c;

    /* renamed from: d, reason: collision with root package name */
    public b f344312d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) x.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            synchronized (this) {
                x.this.f344310b = v.a.a(iBinder);
                x xVar = x.this;
                b bVar = xVar.f344312d;
                if (bVar != null) {
                    bVar.a(xVar);
                }
                x.this.b("Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            x xVar = x.this;
            xVar.f344310b = null;
            xVar.b("Service onServiceDisconnected");
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a(x xVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public x(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        this.f344309a = null;
        this.f344312d = null;
        if (context != null) {
            this.f344309a = context;
            this.f344312d = bVar;
            this.f344311c = new a();
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f344309a.bindService(intent, this.f344311c, 1)) {
                b("bindService Successful!");
                return;
            }
            b bVar2 = this.f344312d;
            if (bVar2 != null) {
                bVar2.a(this);
            }
            b("bindService Failed!!!");
            return;
        }
        throw new NullPointerException("Context can not be null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        t0.c(f344308e + " " + str);
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Context context = this.f344309a;
        if (context != null) {
            String packageName = context.getPackageName();
            b("liufeng, getAAID package\uff1a" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    v vVar = this.f344310b;
                    if (vVar != null) {
                        return vVar.c(packageName);
                    }
                    return null;
                } catch (Exception unused) {
                    a("getAAID error, RemoteException!");
                    return null;
                }
            }
            b("input package is null!");
            return null;
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            this.f344309a.unbindService(this.f344311c);
            b("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            a("unBind Service exception");
        }
        this.f344310b = null;
    }

    private void a(String str) {
        t0.a(f344308e + " " + str);
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            if (this.f344310b == null) {
                return false;
            }
            b("Device support opendeviceid");
            return this.f344310b.c();
        } catch (Exception unused) {
            a("isSupport error, RemoteException!");
            return false;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f344309a != null) {
            try {
                v vVar = this.f344310b;
                if (vVar != null) {
                    return vVar.b();
                }
                return null;
            } catch (Exception e16) {
                a("getOAID error, RemoteException!");
                e16.printStackTrace();
                return null;
            }
        }
        a("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }
}
