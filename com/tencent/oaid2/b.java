package com.tencent.oaid2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.b.a;
import com.tencent.qimei.c.c;
import com.tencent.qimei.i.e;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements com.tencent.qimei.a.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.qimei.a.b f339475a;

    /* renamed from: b, reason: collision with root package name */
    private a f339476b;

    /* renamed from: c, reason: collision with root package name */
    private Context f339477c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f339478d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f339475a = null;
        this.f339476b = null;
        this.f339477c = null;
        this.f339478d = false;
    }

    private String c() {
        com.tencent.qimei.b.a aVar = a.C9312a.f343202a;
        if (aVar.a() == null) {
            return "";
        }
        if (aVar.b()) {
            if (aVar.a() == null) {
                return "";
            }
            aVar.f343200a.edit().clear().apply();
            return "";
        }
        String string = aVar.f343200a.getString("qm_ch_od", "");
        if (string == null) {
            return "";
        }
        return string;
    }

    private void d(boolean z16, String str) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.qimei.b.a aVar = a.C9312a.f343202a;
            if (aVar.a() != null) {
                aVar.f343200a.edit().putString("qm_ch_od", str).apply();
            }
            String valueOf = String.valueOf(z16);
            if (aVar.a() != null) {
                aVar.f343200a.edit().putString("qm_od_is_sup", valueOf).apply();
            }
        }
    }

    public void a(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2);
            return;
        }
        com.tencent.qimei.ad.b.b("vm onResult " + z16);
        try {
            a aVar = this.f339476b;
            if (aVar != null) {
                aVar.onResult(z16, str, str2);
                this.f339478d = true;
            }
        } catch (Throwable th5) {
            com.tencent.qimei.ad.b.a(th5.toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(Context context, a aVar) {
        VendorChecker vendorChecker;
        boolean z16;
        com.tencent.qimei.a.b aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar)).intValue();
        }
        this.f339476b = aVar;
        a.C9312a.f343202a.f343201b = context;
        String c16 = c();
        boolean z17 = true;
        if (!TextUtils.isEmpty(c16)) {
            callbackOaid(true, "", c16, true);
        }
        VendorChecker[] values = VendorChecker.values();
        int i3 = 0;
        while (true) {
            if (i3 < 12) {
                vendorChecker = values[i3];
                if (vendorChecker.a()) {
                    break;
                }
                i3++;
            } else {
                vendorChecker = VendorChecker.UNSUPPORTED;
                break;
            }
        }
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f339477c = applicationContext;
            if (applicationContext == null) {
                this.f339477c = context;
            }
        }
        switch (vendorChecker.ordinal()) {
            case 0:
                try {
                    InstalledAppListMonitor.getPackageInfo(this.f339477c.getPackageManager(), "com.coolpad.deviceidsupport", 0);
                    z16 = true;
                } catch (Throwable unused) {
                    z16 = false;
                }
                if (z16) {
                    this.f339475a = new c();
                    break;
                }
                break;
            case 1:
                aVar2 = new com.tencent.qimei.n.a();
                this.f339475a = aVar2;
                break;
            case 2:
                aVar2 = new com.tencent.qimei.m.b();
                this.f339475a = aVar2;
                break;
            case 3:
                aVar2 = new com.tencent.qimei.f.c();
                this.f339475a = aVar2;
                break;
            case 4:
                aVar2 = new com.tencent.qimei.k.b();
                this.f339475a = aVar2;
                break;
            case 5:
                aVar2 = new com.tencent.qimei.g.b();
                this.f339475a = aVar2;
                break;
            case 6:
                aVar2 = new com.tencent.qimei.e.c();
                this.f339475a = aVar2;
                break;
            case 7:
                aVar2 = new com.tencent.qimei.l.c();
                this.f339475a = aVar2;
                break;
            case 8:
                aVar2 = new e();
                this.f339475a = aVar2;
                break;
            case 9:
                aVar2 = new com.tencent.qimei.j.a();
                this.f339475a = aVar2;
                break;
            case 10:
                aVar2 = new com.tencent.qimei.h.e();
                this.f339475a = aVar2;
                break;
            case 11:
                this.f339475a = new com.tencent.qimei.d.e();
                InstalledAppListMonitor.getPackageInfo(this.f339477c.getPackageManager(), "com.coolpad.deviceidsupport", 0);
                z16 = true;
                if (z16) {
                }
                break;
        }
        if (this.f339475a == null) {
            if (TextUtils.isEmpty(com.tencent.qimei.a.c.a("ro.build.version.emui")) && TextUtils.isEmpty(com.tencent.qimei.a.c.a("hw_sc.build.platform.version"))) {
                z17 = false;
            }
            if (z17) {
                this.f339475a = new com.tencent.qimei.f.c();
            }
        }
        if (this.f339475a == null) {
            callbackOaid(false, "", "", false);
            return -12;
        }
        com.tencent.qimei.ad.b.a("init");
        try {
            this.f339475a.a(this.f339477c, this);
            if (!this.f339475a.e()) {
                try {
                    this.f339475a.h();
                } catch (Throwable unused2) {
                    callbackOaid(false, "", "", false);
                    return -13;
                }
            } else {
                com.tencent.qimei.ad.b.a("sync");
                try {
                    this.f339475a.g();
                } catch (Throwable unused3) {
                    callbackOaid(false, "", "", false);
                }
            }
            return 0;
        } catch (Throwable unused4) {
            callbackOaid(false, "", "", false);
            return -13;
        }
    }

    @Override // com.tencent.qimei.a.a
    public synchronized void callbackOaid(boolean z16, String str, String str2, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (!this.f339478d) {
            a(z16, str, str2);
        }
        if (!z17) {
            d(z16, str2);
            try {
                com.tencent.qimei.a.b bVar = this.f339475a;
                if (bVar != null) {
                    bVar.k();
                }
            } catch (Throwable th5) {
                com.tencent.qimei.ad.b.a(th5.toString());
            }
        }
    }
}
