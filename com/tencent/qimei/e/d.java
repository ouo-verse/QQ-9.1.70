package com.tencent.qimei.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.e.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f343251a;

    /* renamed from: b, reason: collision with root package name */
    public Context f343252b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.qimei.e.a f343253c;

    /* renamed from: d, reason: collision with root package name */
    public b f343254d;

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f343255e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.qimei.e.a c9317a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            com.tencent.qimei.ad.b.c("HSDID did service binded");
            d dVar = d.this;
            int i3 = a.AbstractBinderC9316a.f343241a;
            if (iBinder == null) {
                c9317a = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                if (queryLocalInterface != null && (queryLocalInterface instanceof com.tencent.qimei.e.a)) {
                    c9317a = (com.tencent.qimei.e.a) queryLocalInterface;
                } else {
                    c9317a = new a.AbstractBinderC9316a.C9317a(iBinder);
                }
            }
            dVar.f343253c = c9317a;
            d.this.a(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                d.this.a(false);
            }
        }
    }

    public d(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f343251a = false;
        this.f343255e = new a();
        this.f343252b = context;
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            try {
                ((c) this.f343254d).a(this.f343253c);
                return;
            } catch (Exception e16) {
                com.tencent.qimei.ad.b.a("HSDID notify did bind status error :" + e16.getMessage());
                return;
            }
        }
        com.tencent.qimei.a.a aVar = ((c) this.f343254d).f343243a;
        if (aVar != null) {
            aVar.callbackOaid(false, null, null, false);
        }
    }
}
