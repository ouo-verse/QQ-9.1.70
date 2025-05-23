package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Canesatici {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382619a;

    /* renamed from: b, reason: collision with root package name */
    public final String f382620b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382621c;

    /* renamed from: d, reason: collision with root package name */
    public String f382622d;

    public Canesatici(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2);
            return;
        }
        this.f382619a = i3;
        this.f382620b = str;
        this.f382621c = str2;
    }

    public Canesatici(int i3) {
        this(i3, null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }
}
