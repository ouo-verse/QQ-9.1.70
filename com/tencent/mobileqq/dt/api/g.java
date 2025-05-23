package com.tencent.mobileqq.dt.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f203666a;

    /* renamed from: b, reason: collision with root package name */
    public final String f203667b;

    /* renamed from: c, reason: collision with root package name */
    public final String f203668c;

    public g(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2);
            return;
        }
        this.f203666a = i3;
        this.f203667b = str;
        this.f203668c = str2;
    }
}
