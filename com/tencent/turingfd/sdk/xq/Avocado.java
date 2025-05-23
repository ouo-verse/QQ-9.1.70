package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Avocado {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382584a;

    /* renamed from: b, reason: collision with root package name */
    public int f382585b;

    public Avocado(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.f382584a = str;
            this.f382585b = i3;
        }
    }

    public static Avocado a(int i3) {
        return new Avocado("", i3);
    }
}
