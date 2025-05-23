package com.tencent.tgpa.lite.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.lite.e.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f375914a;

    /* renamed from: b, reason: collision with root package name */
    private j f375915b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f375916c;

    /* renamed from: d, reason: collision with root package name */
    private b f375917d;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f375918e;

    /* compiled from: P */
    /* renamed from: com.tencent.tgpa.lite.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class ServiceConnectionC9906a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        ServiceConnectionC9906a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                a.this.f375917d = b.a.a(iBinder);
                if (a.this.f375916c && a.this.f375917d != null) {
                    if (a.this.f375917d.a()) {
                        com.tencent.tgpa.lite.g.h.a("MSA ASUS supported, oaid:" + a.this.f375917d.b(), new Object[0]);
                        if (a.this.f375915b != null) {
                            a.this.f375915b.a(a.this.f375917d.b());
                        }
                    } else {
                        com.tencent.tgpa.lite.g.h.d("MSA ASUS not supported", new Object[0]);
                    }
                } else {
                    com.tencent.tgpa.lite.g.h.b("MSA ASUS Service get oaid failed.", new Object[0]);
                }
            } catch (Throwable th5) {
                com.tencent.tgpa.lite.g.h.b("MSA ASUS oaid get exception.", new Object[0]);
                th5.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            } else {
                Log.d("TGPA_MID", "ASUS MSA onServiceDisconnected ");
            }
        }
    }

    public a(Context context, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jVar);
            return;
        }
        this.f375918e = new ServiceConnectionC9906a();
        this.f375914a = context;
        this.f375915b = jVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            boolean bindService = this.f375914a.bindService(intent2, this.f375918e, 1);
            this.f375916c = bindService;
            if (bindService) {
                com.tencent.tgpa.lite.g.h.c("bind ASUS service success!", new Object[0]);
            } else {
                com.tencent.tgpa.lite.g.h.b("bind ASUS service failed!", new Object[0]);
            }
        } catch (Exception e16) {
            com.tencent.tgpa.lite.g.h.b("bind huawei service exception. ", new Object[0]);
            e16.printStackTrace();
        }
    }
}
