package com.tencent.mobileqq.qqlive.report.tianjige;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static f f271465d;

    /* renamed from: a, reason: collision with root package name */
    private String f271466a;

    /* renamed from: b, reason: collision with root package name */
    private String f271467b;

    /* renamed from: c, reason: collision with root package name */
    private String f271468c;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271466a = "";
        this.f271467b = "";
        this.f271468c = "";
        f();
        e();
        g();
    }

    public static f b() {
        if (f271465d == null) {
            synchronized (f.class) {
                if (f271465d == null) {
                    f271465d = new f();
                }
            }
        }
        return f271465d;
    }

    private void e() {
        this.f271467b = Build.BRAND;
    }

    private void f() {
        this.f271466a = DeviceInfoMonitor.getModel();
    }

    private void g() {
        this.f271468c = Build.VERSION.RELEASE;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f271467b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271466a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f271468c;
    }
}
