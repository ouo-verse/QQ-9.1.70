package com.tencent.mobileqq.qqbattery;

import android.app.Application;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class e implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public Application f262250d;

    /* renamed from: e, reason: collision with root package name */
    public int f262251e;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f262251e = 0;
        }
    }

    public Application b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Application) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f262250d;
    }

    public void c(Application application) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) application);
        } else {
            if (this.f262250d == null) {
                this.f262251e = 1;
                this.f262250d = application;
                return;
            }
            throw new c.f("plugin duplicate init, application is not null");
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.f262251e == 8) {
            return true;
        }
        return false;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f262251e == 2) {
            return true;
        }
        return false;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (d()) {
            com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_Plugin", "plugin start, but plugin has been already destroyed", new Object[0]);
        }
        if (e()) {
            com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_Plugin", "plugin start, but plugin has been already started", new Object[0]);
        }
        this.f262251e = 2;
    }
}
