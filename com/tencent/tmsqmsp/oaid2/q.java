package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmsqmsp.oaid2.n;

/* compiled from: P */
/* loaded from: classes26.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f380859a;

    /* renamed from: b, reason: collision with root package name */
    public Context f380860b;

    /* renamed from: c, reason: collision with root package name */
    public n f380861c;

    /* renamed from: d, reason: collision with root package name */
    public o f380862d;

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f380863e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    final class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) q.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            t0.c("HSDID did service binded");
            q.this.f380861c = n.a.a(iBinder);
            q.this.a(true);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
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
        this.f380859a = false;
        this.f380863e = new a();
        this.f380860b = context;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            if (!this.f380859a || this.f380863e == null || this.f380860b == null) {
                return;
            }
            t0.c("HSDID start to unbind did service");
            this.f380859a = false;
            this.f380860b.unbindService(this.f380863e);
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
            this.f380862d = oVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            t0.c("HSDID start to bind did service");
            boolean bindService = this.f380860b.bindService(intent2, this.f380863e, 1);
            this.f380859a = bindService;
            if (bindService) {
                return;
            }
            this.f380862d.b();
        } catch (Exception unused) {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z16) {
        if (z16) {
            try {
                this.f380862d.a(this.f380861c);
                return;
            } catch (Exception e16) {
                t0.a("HSDID notify did bind status error :" + e16.getMessage());
                return;
            }
        }
        this.f380862d.b();
    }
}
