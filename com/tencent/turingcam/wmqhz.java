package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class wmqhz {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382423a;

    /* renamed from: b, reason: collision with root package name */
    public int f382424b;

    public wmqhz(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.f382423a = str;
            this.f382424b = i3;
        }
    }

    public static wmqhz a(int i3) {
        return new wmqhz("", i3);
    }
}
