package com.tencent.qimei.w;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f343413a;

    /* renamed from: b, reason: collision with root package name */
    public String f343414b;

    /* renamed from: c, reason: collision with root package name */
    public String f343415c;

    /* renamed from: d, reason: collision with root package name */
    public String f343416d;

    /* renamed from: e, reason: collision with root package name */
    public int f343417e;

    /* renamed from: f, reason: collision with root package name */
    public String f343418f;

    public c(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str);
        } else {
            this.f343413a = z16;
            this.f343414b = str;
        }
    }

    public c(boolean z16, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2);
            return;
        }
        this.f343413a = z16;
        this.f343416d = str;
        this.f343417e = i3;
        this.f343418f = str2;
    }
}
