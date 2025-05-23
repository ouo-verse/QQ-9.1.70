package com.tencent.qmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmsp.oaid2.i;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes22.dex */
class l implements ServiceConnection {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public CountDownLatch f344232a;

    /* renamed from: b, reason: collision with root package name */
    private a f344233b;

    /* renamed from: c, reason: collision with root package name */
    private k f344234c;

    /* renamed from: d, reason: collision with root package name */
    private c f344235d;

    /* renamed from: e, reason: collision with root package name */
    private b f344236e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f344237a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f344238b;

        a(l lVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lVar);
            }
        }

        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.f344238b;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (!TextUtils.isEmpty(this.f344237a) && !this.f344238b) {
                return true;
            }
            return false;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f344237a : (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f344237a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z16) {
            this.f344238b = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends i.a {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.qmsp.oaid2.i
        public void a(int i3, long j3, boolean z16, float f16, double d16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Float.valueOf(f16), Double.valueOf(d16), str);
        }

        @Override // com.tencent.qmsp.oaid2.i
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
                l.this.f344233b.a(string);
                t0.b("honor got oaid is " + string);
            }
            l.this.f344232a.countDown();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c extends i.a {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.qmsp.oaid2.i
        public void a(int i3, long j3, boolean z16, float f16, double d16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Float.valueOf(f16), Double.valueOf(d16), str);
        }

        @Override // com.tencent.qmsp.oaid2.i
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
                l.this.f344233b.a(z16);
                t0.b("honor got oaid_limit_state is " + z16);
            }
            l.this.f344232a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f344232a = new CountDownLatch(2);
        this.f344235d = new c();
        this.f344236e = new b();
    }

    public boolean b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.hihonor.id", 0);
            new Intent("com.hihonor.id.HnOaIdService").setPackage("com.hihonor.id");
            return !InstalledAppListMonitor.queryIntentServices(r5, r2, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    public void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        try {
            context.unbindService(this);
        } catch (Exception e16) {
            t0.a("honor unbind service exceprion:" + e16.toString());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) componentName, (Object) iBinder);
            return;
        }
        this.f344233b = new a(this);
        if (iBinder != null) {
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                if (!(queryLocalInterface instanceof k)) {
                    this.f344234c = new j(iBinder);
                } else {
                    this.f344234c = (k) queryLocalInterface;
                }
            } catch (Throwable unused) {
                this.f344232a.countDown();
                this.f344232a.countDown();
                return;
            }
        }
        k kVar = this.f344234c;
        if (kVar == null) {
            return;
        }
        kVar.b(this.f344236e);
        this.f344234c.a(this.f344235d);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) componentName);
        } else {
            this.f344232a.countDown();
            this.f344232a.countDown();
        }
    }

    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f344233b : (a) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        context.bindService(intent, this, 1);
    }
}
