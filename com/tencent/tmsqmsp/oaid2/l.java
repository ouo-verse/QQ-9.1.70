package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmsqmsp.oaid2.i;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes26.dex */
final class l implements ServiceConnection {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public CountDownLatch f380823d;

    /* renamed from: e, reason: collision with root package name */
    a f380824e;

    /* renamed from: f, reason: collision with root package name */
    private k f380825f;

    /* renamed from: h, reason: collision with root package name */
    private c f380826h;

    /* renamed from: i, reason: collision with root package name */
    private b f380827i;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f380828a;

        /* renamed from: b, reason: collision with root package name */
        boolean f380829b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b extends i.a {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.tmsqmsp.oaid2.i
        public void a(int i3, long j3, boolean z16, float f16, double d16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Float.valueOf(f16), Double.valueOf(d16), str);
        }

        @Override // com.tencent.tmsqmsp.oaid2.i
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
                return;
            }
            if (bundle == null) {
                t0.a("honor get oaid,bundle is null");
            } else {
                String string = bundle.getString("oa_id_flag");
                l.this.f380824e.f380828a = string;
                t0.b("honor got oaid is ".concat(String.valueOf(string)));
            }
            l.this.f380823d.countDown();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c extends i.a {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.tmsqmsp.oaid2.i
        public void a(int i3, long j3, boolean z16, float f16, double d16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Float.valueOf(f16), Double.valueOf(d16), str);
        }

        @Override // com.tencent.tmsqmsp.oaid2.i
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
                return;
            }
            if (bundle == null) {
                t0.a("honor get oaid_limit_state,bundle is null");
            } else {
                boolean z16 = bundle.getBoolean("oa_id_limit_state");
                l.this.f380824e.f380829b = z16;
                t0.b("honor got oaid_limit_state is ".concat(String.valueOf(z16)));
            }
            l.this.f380823d.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380823d = new CountDownLatch(2);
        this.f380826h = new c();
        this.f380827i = new b();
    }

    public static boolean b(Context context) {
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.hihonor.id", 0);
            new Intent("com.hihonor.id.HnOaIdService").setPackage("com.hihonor.id");
            return !InstalledAppListMonitor.queryIntentServices(r4, r2, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        try {
            context.unbindService(this);
        } catch (Exception e16) {
            t0.a("honor unbind service exceprion:" + e16.toString());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName, (Object) iBinder);
            return;
        }
        this.f380824e = new a();
        if (iBinder != null) {
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                if (!(queryLocalInterface instanceof k)) {
                    this.f380825f = new j(iBinder);
                } else {
                    this.f380825f = (k) queryLocalInterface;
                }
            } catch (Throwable unused) {
                this.f380823d.countDown();
                this.f380823d.countDown();
                return;
            }
        }
        k kVar = this.f380825f;
        if (kVar == null) {
            return;
        }
        kVar.b(this.f380827i);
        this.f380825f.a(this.f380826h);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) componentName);
        } else {
            this.f380823d.countDown();
            this.f380823d.countDown();
        }
    }
}
