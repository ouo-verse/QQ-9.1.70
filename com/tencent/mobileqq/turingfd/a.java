package com.tencent.mobileqq.turingfd;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.tinyid.impl.TinyIDHandler;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static a f303432g;

    /* renamed from: a, reason: collision with root package name */
    private String f303433a;

    /* renamed from: b, reason: collision with root package name */
    private String f303434b;

    /* renamed from: c, reason: collision with root package name */
    private String f303435c;

    /* renamed from: d, reason: collision with root package name */
    private String f303436d;

    /* renamed from: e, reason: collision with root package name */
    private String f303437e;

    /* renamed from: f, reason: collision with root package name */
    private String f303438f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.turingfd.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C8851a implements o.c {
        static IPatchRedirector $redirector_;

        C8851a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.statistics.o.c
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.f303437e = str2;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements TinyIDHandler.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.tinyid.impl.TinyIDHandler.a
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else if (a.this.p(str)) {
                a.this.f303438f = str;
            }
        }
    }

    public a(Context context, AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, appInterface, Boolean.valueOf(z16));
            return;
        }
        this.f303433a = "";
        this.f303434b = "";
        this.f303435c = "";
        this.f303436d = "";
        this.f303437e = "";
        this.f303438f = "Default_TinyId";
        k(context);
        m();
        j(context);
        l(context);
        n();
        if (z16 && appInterface != null) {
            o(appInterface);
        }
    }

    public static a g(Context context, AppInterface appInterface, boolean z16) {
        if (f303432g == null) {
            synchronized (a.class) {
                if (f303432g == null) {
                    f303432g = new a(context, appInterface, z16);
                }
            }
        }
        return f303432g;
    }

    private void j(Context context) {
        String e16 = ah.e();
        if (e16 != null) {
            this.f303433a = e16.toLowerCase();
        }
    }

    private void k(Context context) {
        String z16;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 && i3 < 26 && (z16 = ah.z()) != null) {
            this.f303434b = z16.toLowerCase();
        }
    }

    private void l(Context context) {
        String A = ah.A();
        if (A != null) {
            this.f303435c = A.toLowerCase();
        }
    }

    private void m() {
        this.f303436d = DeviceInfoMonitor.getModel();
    }

    private void n() {
        o.d(new C8851a());
        this.f303437e = o.c();
    }

    private void o(AppInterface appInterface) {
        TinyIDHandler tinyIDHandler = (TinyIDHandler) appInterface.getBusinessHandler(TinyIDHandler.f293222m);
        String currentAccountUin = appInterface.getCurrentAccountUin();
        tinyIDHandler.E2(currentAccountUin, new b());
        String F2 = tinyIDHandler.F2(currentAccountUin);
        if (p(F2)) {
            this.f303438f = F2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(@Nullable String str) {
        if (str != null && str.length() >= 4) {
            return true;
        }
        return false;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f303433a;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f303434b;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f303435c;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f303437e;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f303438f;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "QQTuringPrivateInfo{imei='" + this.f303434b + "', androidID='" + this.f303433a + "', imsi='" + this.f303435c + "', model='" + this.f303436d + "', sQimei='" + this.f303437e + "', sTinyID='" + this.f303438f + "'}";
    }
}
