package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bullace {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382615a;

    /* renamed from: b, reason: collision with root package name */
    public final String f382616b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382617c;

    public Bullace(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2);
            return;
        }
        this.f382615a = i3;
        this.f382616b = str;
        this.f382617c = str2;
    }
}
