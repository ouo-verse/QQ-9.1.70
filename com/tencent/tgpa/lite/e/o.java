package com.tencent.tgpa.lite.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tgpa.lite.e.p;

/* compiled from: P */
/* loaded from: classes26.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f375954a;

    /* renamed from: b, reason: collision with root package name */
    private j f375955b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f375956c;

    /* renamed from: d, reason: collision with root package name */
    private p f375957d;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f375958e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            Log.d("TGPA_MID", "Sumsung Service onServiceConnected");
            try {
                o.this.f375957d = p.a.a(iBinder);
                if (o.this.f375956c && o.this.f375957d != null) {
                    com.tencent.tgpa.lite.g.h.a("MSA Sumsung supported, oaid:" + o.this.f375957d.a(), new Object[0]);
                    if (o.this.f375955b != null) {
                        o.this.f375955b.a(o.this.f375957d.a());
                    }
                } else {
                    com.tencent.tgpa.lite.g.h.d("MSA Sumsung not supported", new Object[0]);
                }
            } catch (Throwable th5) {
                com.tencent.tgpa.lite.g.h.b("MSA Sumsung oaid get exception.", new Object[0]);
                th5.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                o.this.f375957d = null;
                com.tencent.tgpa.lite.g.h.d("Sumsung Service onServiceDisconnected", new Object[0]);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    public o(Context context, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jVar);
            return;
        }
        this.f375956c = false;
        this.f375957d = null;
        this.f375958e = new a();
        this.f375954a = context;
        this.f375955b = jVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            InstalledAppListMonitor.getPackageInfo(this.f375954a.getPackageManager(), "com.samsung.android.deviceidservice", 0);
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            boolean bindService = this.f375954a.bindService(intent, this.f375958e, 1);
            this.f375956c = bindService;
            if (bindService) {
                com.tencent.tgpa.lite.g.h.c("bind Sumsung service success.", new Object[0]);
            } else {
                com.tencent.tgpa.lite.g.h.d("bind Sumsung service failed.", new Object[0]);
            }
        } catch (Exception e16) {
            com.tencent.tgpa.lite.g.h.b("bind Sumsung service exception. ", new Object[0]);
            e16.printStackTrace();
        }
    }
}
