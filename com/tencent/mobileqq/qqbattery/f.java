package com.tencent.mobileqq.qqbattery;

import android.app.Application;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.utils.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static volatile f f262252c;

    /* renamed from: a, reason: collision with root package name */
    public final Application f262253a;

    /* renamed from: b, reason: collision with root package name */
    public final g f262254b;

    public f(Application application, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) application, (Object) gVar);
            return;
        }
        this.f262253a = application;
        this.f262254b = gVar;
        gVar.c(application);
    }

    public static f c(Application application, g gVar) {
        if (application != null) {
            if (gVar != null) {
                synchronized (f.class) {
                    if (f262252c == null) {
                        f262252c = new f(application, gVar);
                    } else {
                        com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_QQBattery", "QQBattery instance is already set. this invoking will be ignored", new Object[0]);
                    }
                }
                return f262252c;
            }
            throw new RuntimeException("QQBattery init, Application should not be null");
        }
        throw new c.f("QQBattery init, Application should not be null");
    }

    public static boolean d() {
        if (f262252c != null) {
            return true;
        }
        return false;
    }

    public static void e(a.InterfaceC8297a interfaceC8297a) {
        com.tencent.mobileqq.qqbattery.utils.a.e(interfaceC8297a);
    }

    public static f g() {
        if (f262252c != null) {
            return f262252c;
        }
        throw new RuntimeException("you must init QQBattery sdk first");
    }

    public d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f262254b;
    }

    public Application b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Application) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f262253a;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            this.f262254b.f();
        } catch (Throwable th5) {
            com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_QQBattery", th5, "startPlugin error", new Object[0]);
        }
    }
}
