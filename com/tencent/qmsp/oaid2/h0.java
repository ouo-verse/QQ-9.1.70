package com.tencent.qmsp.oaid2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h0 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f344225a;

    /* renamed from: b, reason: collision with root package name */
    public long f344226b;

    /* renamed from: c, reason: collision with root package name */
    public String f344227c;

    public h0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.f344227c = str;
        this.f344225a = i3;
        this.f344226b = System.currentTimeMillis() + 86400000;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ValueData{value='" + this.f344227c + "', code=" + this.f344225a + ", expired=" + this.f344226b + '}';
    }
}
