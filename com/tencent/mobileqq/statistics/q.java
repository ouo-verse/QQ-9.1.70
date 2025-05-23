package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected AppRuntime f290074a;

    /* renamed from: b, reason: collision with root package name */
    protected String f290075b;

    /* renamed from: c, reason: collision with root package name */
    protected String f290076c;

    /* renamed from: d, reason: collision with root package name */
    protected String f290077d;

    /* renamed from: e, reason: collision with root package name */
    protected String f290078e;

    /* renamed from: f, reason: collision with root package name */
    protected String f290079f;

    /* renamed from: g, reason: collision with root package name */
    protected int f290080g;

    /* renamed from: h, reason: collision with root package name */
    protected int f290081h;

    /* renamed from: i, reason: collision with root package name */
    protected int f290082i;

    /* renamed from: j, reason: collision with root package name */
    protected List<String> f290083j;

    public q(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f290075b = "";
        this.f290076c = "";
        this.f290077d = "";
        this.f290078e = "";
        this.f290079f = "";
        this.f290081h = 1;
        this.f290074a = appRuntime;
    }

    public q a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (q) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.f290076c = str;
        return this;
    }

    public q b(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (q) iPatchRedirector.redirect((short) 10, (Object) this, (Object) strArr);
        }
        if (this.f290083j == null) {
            this.f290083j = new ArrayList(4);
        }
        if (strArr != null) {
            Collections.addAll(this.f290083j, strArr);
        }
        return this;
    }

    public q c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (q) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        this.f290082i = i3;
        return this;
    }

    public q d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (q) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.f290078e = str;
        return this;
    }

    public q e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (q) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        this.f290080g = i3;
        return this;
    }

    public q f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (q) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.f290077d = str;
        return this;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        List<String> list = this.f290083j;
        if (list != null && list.size() != 0) {
            while (this.f290083j.size() < 4) {
                this.f290083j.add("");
            }
            ReportController.n(this.f290074a, this.f290075b, this.f290076c, this.f290079f, this.f290077d, this.f290078e, this.f290082i, this.f290081h, this.f290080g, this.f290083j.get(0), this.f290083j.get(1), this.f290083j.get(2), this.f290083j.get(3));
            return;
        }
        ReportController.n(this.f290074a, this.f290075b, this.f290076c, this.f290079f, this.f290077d, this.f290078e, this.f290082i, this.f290081h, this.f290080g, "", "", "", "");
    }

    public q h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (q) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.f290079f = str;
        return this;
    }

    public q i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (q) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.f290075b = str;
        return this;
    }
}
