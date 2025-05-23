package com.tencent.qmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmsp.oaid2.n;

/* compiled from: P */
/* loaded from: classes22.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f344267a;

    /* renamed from: b, reason: collision with root package name */
    public Context f344268b;

    /* renamed from: c, reason: collision with root package name */
    public n f344269c;

    /* renamed from: d, reason: collision with root package name */
    public o f344270d;

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f344271e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            t0.c("HSDID did service binded");
            q.this.f344269c = n.a.a(iBinder);
            q.this.a(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                q.this.a(false);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    public q(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f344267a = false;
        this.f344271e = new a();
        this.f344268b = context;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            if (!this.f344267a || this.f344271e == null || this.f344268b == null) {
                return;
            }
            t0.c("HSDID start to unbind did service");
            this.f344267a = false;
            this.f344268b.unbindService(this.f344271e);
        } catch (Exception e16) {
            t0.a("HSDID error:" + e16.getMessage());
        }
    }

    public void a(o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) oVar);
            return;
        }
        try {
            this.f344270d = oVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            t0.c("HSDID start to bind did service");
            boolean bindService = this.f344268b.bindService(intent2, this.f344271e, 1);
            this.f344267a = bindService;
            if (bindService) {
                return;
            }
            this.f344270d.b();
        } catch (Exception unused) {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z16) {
        if (z16) {
            try {
                this.f344270d.a(this.f344269c);
                return;
            } catch (Exception e16) {
                t0.a("HSDID notify did bind status error :" + e16.getMessage());
                return;
            }
        }
        this.f344270d.b();
    }
}
