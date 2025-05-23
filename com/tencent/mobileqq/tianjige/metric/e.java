package com.tencent.mobileqq.tianjige.metric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.metrics.DoubleHistogram;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private DoubleHistogram f292982a;

    /* renamed from: b, reason: collision with root package name */
    private String f292983b;

    /* renamed from: c, reason: collision with root package name */
    private String f292984c;

    /* renamed from: d, reason: collision with root package name */
    private String f292985d;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new d(this.f292982a, this.f292983b, this.f292984c, this.f292985d);
    }

    public e b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (e) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.f292984c = str;
        return this;
    }

    public e c(DoubleHistogram doubleHistogram) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) doubleHistogram);
        }
        this.f292982a = doubleHistogram;
        return this;
    }

    public e d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.f292983b = str;
        return this;
    }

    public e e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.f292985d = str;
        return this;
    }
}
