package com.tencent.qimei.i;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f343312a;

    /* renamed from: b, reason: collision with root package name */
    public long f343313b;

    /* renamed from: c, reason: collision with root package name */
    public String f343314c;

    public d(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.f343314c = null;
        this.f343312a = i3;
        this.f343313b = System.currentTimeMillis() + 86400000;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ValueData{value='" + this.f343314c + "', code=" + this.f343312a + ", expired=" + this.f343313b + '}';
    }
}
