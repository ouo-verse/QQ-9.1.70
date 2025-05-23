package com.tencent.qimei.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.d.a;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements ServiceConnection {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public CountDownLatch f343224a;

    /* renamed from: b, reason: collision with root package name */
    public a f343225b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.qimei.d.c f343226c;

    /* renamed from: d, reason: collision with root package name */
    public c f343227d;

    /* renamed from: e, reason: collision with root package name */
    public b f343228e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f343229a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f343230b;

        public a(d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends a.AbstractBinderC9315a {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.qimei.d.a
        public void a(int i3, long j3, boolean z16, float f16, double d16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Float.valueOf(f16), Double.valueOf(d16), str);
        }

        @Override // com.tencent.qimei.d.a
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
                return;
            }
            if (bundle == null) {
                com.tencent.qimei.ad.b.a("honor get oaid,bundle is null");
            } else {
                String string = bundle.getString("oa_id_flag");
                d.this.f343225b.f343229a = string;
                com.tencent.qimei.ad.b.b("honor got oaid is " + string);
            }
            d.this.f343224a.countDown();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c extends a.AbstractBinderC9315a {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.qimei.d.a
        public void a(int i3, long j3, boolean z16, float f16, double d16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16), Float.valueOf(f16), Double.valueOf(d16), str);
        }

        @Override // com.tencent.qimei.d.a
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
                return;
            }
            if (bundle == null) {
                com.tencent.qimei.ad.b.a("honor get oaid_limit_state,bundle is null");
            } else {
                boolean z16 = bundle.getBoolean("oa_id_limit_state");
                d.this.f343225b.f343230b = z16;
                com.tencent.qimei.ad.b.b("honor got oaid_limit_state is " + z16);
            }
            d.this.f343224a.countDown();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343224a = new CountDownLatch(2);
        this.f343227d = new c();
        this.f343228e = new b();
    }

    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        try {
            context.unbindService(this);
        } catch (Exception e16) {
            com.tencent.qimei.ad.b.a("honor unbind service exceprion:" + e16.toString());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.tencent.qimei.d.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName, (Object) iBinder);
            return;
        }
        this.f343225b = new a(this);
        if (iBinder != null) {
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                if (!(queryLocalInterface instanceof com.tencent.qimei.d.c)) {
                    cVar = new com.tencent.qimei.d.b(iBinder);
                } else {
                    cVar = (com.tencent.qimei.d.c) queryLocalInterface;
                }
                this.f343226c = cVar;
            } catch (Throwable unused) {
                this.f343224a.countDown();
                this.f343224a.countDown();
                return;
            }
        }
        com.tencent.qimei.d.c cVar2 = this.f343226c;
        if (cVar2 == null) {
            return;
        }
        cVar2.a(this.f343228e);
        this.f343226c.b(this.f343227d);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) componentName);
        } else {
            this.f343224a.countDown();
            this.f343224a.countDown();
        }
    }
}
