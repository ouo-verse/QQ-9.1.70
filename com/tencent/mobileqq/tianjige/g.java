package com.tencent.mobileqq.tianjige;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile g f292950d;

    /* renamed from: a, reason: collision with root package name */
    private String f292951a;

    /* renamed from: b, reason: collision with root package name */
    private String f292952b;

    /* renamed from: c, reason: collision with root package name */
    private String f292953c;

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f292951a = "";
        this.f292952b = "";
        this.f292953c = "";
        f();
        e();
        g();
    }

    public static g b() {
        if (f292950d == null) {
            synchronized (g.class) {
                if (f292950d == null) {
                    f292950d = new g();
                }
            }
        }
        return f292950d;
    }

    private void e() {
        this.f292952b = Build.BRAND;
    }

    private void f() {
        this.f292951a = DeviceInfoMonitor.getModel();
    }

    private void g() {
        this.f292953c = Build.VERSION.RELEASE;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f292952b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f292951a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f292953c;
    }
}
