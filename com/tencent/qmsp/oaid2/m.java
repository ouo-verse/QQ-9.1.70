package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class m implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f344243a;

    /* renamed from: b, reason: collision with root package name */
    private IVendorCallback f344244b;

    /* renamed from: c, reason: collision with root package name */
    private String f344245c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f344246d;

    /* renamed from: e, reason: collision with root package name */
    private l f344247e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                m.this.c();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f344245c = "";
        this.f344246d = false;
        this.f344247e = new l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 17)
    public void c() {
        boolean z16;
        if (this.f344247e.b(this.f344243a)) {
            if (!g() && !f()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                t0.b("honor get oaid success");
            } else {
                t0.b("honor get oaid failed");
            }
        } else {
            t0.a("honor {com.hihonor.id.HnOaIdService} not exist");
        }
        b();
    }

    private boolean f() {
        boolean z16;
        try {
            this.f344247e.a(this.f344243a);
            this.f344247e.f344232a.await(2L, TimeUnit.SECONDS);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            this.f344247e.c(this.f344243a);
            throw th5;
        }
        if (this.f344247e.a().c()) {
            this.f344245c = this.f344247e.a().a();
            z16 = true;
            this.f344246d = !this.f344247e.a().b();
            this.f344247e.c(this.f344243a);
            return z16;
        }
        z16 = false;
        this.f344247e.c(this.f344243a);
        return z16;
    }

    @RequiresApi(api = 17)
    private boolean g() {
        try {
            String string = Settings.Global.getString(this.f344243a.getContentResolver(), "oaid_limit_state");
            String string2 = Settings.Global.getString(this.f344243a.getContentResolver(), "oaid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                this.f344246d = !Boolean.parseBoolean(string);
                this.f344245c = string2;
                return true;
            }
        } catch (Throwable th5) {
            t0.a("honor get cache oaid error " + th5.toString());
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f344246d;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            new BaseThread(new a(), "query-oaid").start();
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        IVendorCallback iVendorCallback = this.f344244b;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(this.f344246d, "", this.f344245c);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iVendorCallback);
        } else {
            this.f344243a = context;
            this.f344244b = iVendorCallback;
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f344245c : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
