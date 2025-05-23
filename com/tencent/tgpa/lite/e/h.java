package com.tencent.tgpa.lite.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.lite.e.i;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f375934a;

    /* renamed from: b, reason: collision with root package name */
    private j f375935b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f375936c;

    /* renamed from: d, reason: collision with root package name */
    private i f375937d;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f375938e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            try {
                h.this.f375937d = i.a.a(iBinder);
                if (h.this.f375936c && h.this.f375937d != null) {
                    if (h.this.f375937d.b()) {
                        com.tencent.tgpa.lite.g.h.a("MSA Lenovo supported oaid:" + h.this.f375937d.a(), new Object[0]);
                        if (h.this.f375935b != null) {
                            h.this.f375935b.a(h.this.f375937d.a());
                        }
                    } else {
                        com.tencent.tgpa.lite.g.h.d("MSA Lenovo not supported", new Object[0]);
                    }
                } else {
                    com.tencent.tgpa.lite.g.h.b("MSA Lenovo Service get oaid failed.", new Object[0]);
                }
            } catch (Throwable th5) {
                com.tencent.tgpa.lite.g.h.b("MSA Lenovo oaid get exception.", new Object[0]);
                th5.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                Log.d("TGPA_MID", "Lenovo MSA onServiceDisconnected ");
            }
        }
    }

    public h(Context context, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jVar);
            return;
        }
        this.f375938e = new a();
        this.f375934a = context;
        this.f375935b = jVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            boolean bindService = this.f375934a.bindService(intent, this.f375938e, 1);
            this.f375936c = bindService;
            if (bindService) {
                com.tencent.tgpa.lite.g.h.c("bind Lenovo service success!", new Object[0]);
            } else {
                com.tencent.tgpa.lite.g.h.b("bind Lenovo service failed!", new Object[0]);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            com.tencent.tgpa.lite.g.h.b("bind Lenovo service exception. ", new Object[0]);
        }
    }
}
