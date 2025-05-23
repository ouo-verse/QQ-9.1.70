package com.tencent.qimei.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.d.d;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements com.tencent.qimei.a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f343233a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.a.a f343234b;

    /* renamed from: c, reason: collision with root package name */
    public String f343235c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f343236d;

    /* renamed from: e, reason: collision with root package name */
    public d f343237e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f343238f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f343239g;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            e eVar = e.this;
            d dVar = eVar.f343237e;
            Context context = eVar.f343233a;
            dVar.getClass();
            PackageManager packageManager = context.getPackageManager();
            boolean z17 = true;
            try {
                InstalledAppListMonitor.getPackageInfo(packageManager, "com.hihonor.id", 0);
                Intent intent = new Intent("com.hihonor.id.HnOaIdService");
                intent.setPackage("com.hihonor.id");
                z16 = !InstalledAppListMonitor.queryIntentServices(packageManager, intent, 0).isEmpty();
            } catch (Exception unused) {
                z16 = false;
            }
            if (z16) {
                if (!eVar.b() && !eVar.a()) {
                    z17 = false;
                }
                if (z17) {
                    str = "honor get oaid success";
                } else {
                    str = "honor get oaid failed";
                }
                com.tencent.qimei.ad.b.b(str);
            } else {
                com.tencent.qimei.ad.b.a("honor {com.hihonor.id.HnOaIdService} not exist");
            }
            com.tencent.qimei.a.a aVar = eVar.f343234b;
            if (aVar != null) {
                aVar.callbackOaid(eVar.f343236d, "", eVar.f343235c, false);
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343235c = "";
        this.f343236d = false;
        this.f343237e = new d();
        this.f343238f = false;
        this.f343239g = new a();
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343233a = context;
            this.f343234b = aVar;
        }
    }

    @RequiresApi(api = 17)
    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        try {
            String string = Settings.Global.getString(this.f343233a.getContentResolver(), "oaid_limit_state");
            String string2 = Settings.Global.getString(this.f343233a.getContentResolver(), "oaid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                this.f343236d = !Boolean.parseBoolean(string);
                this.f343235c = string2;
                return true;
            }
        } catch (Throwable th5) {
            com.tencent.qimei.ad.b.a("honor get cache oaid error " + th5.toString());
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            com.tencent.qimei.b.d.f343207e.a(this.f343239g);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        if (r7.f343238f != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        r7.f343237e.a(r7.f343233a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r7.f343238f == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        boolean z16 = false;
        try {
            d dVar = this.f343237e;
            Context context = this.f343233a;
            dVar.getClass();
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            this.f343238f = context.bindService(intent, dVar, 1);
            this.f343237e.f343224a.await(2L, TimeUnit.SECONDS);
            d.a aVar = this.f343237e.f343225b;
            if ((TextUtils.isEmpty(aVar.f343229a) || aVar.f343230b) ? false : true) {
                this.f343235c = this.f343237e.f343225b.f343229a;
                this.f343236d = !r1.f343230b;
                z16 = true;
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (this.f343238f) {
                this.f343237e.a(this.f343233a);
            }
            throw th5;
        }
    }
}
