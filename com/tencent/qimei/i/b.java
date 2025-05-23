package com.tencent.qimei.i;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f343301a;

    /* renamed from: b, reason: collision with root package name */
    public long f343302b;

    /* renamed from: c, reason: collision with root package name */
    public String f343303c;

    /* renamed from: d, reason: collision with root package name */
    public String f343304d;

    public b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f343303c = str;
        }
    }
}
