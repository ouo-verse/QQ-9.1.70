package com.tencent.qimei.ac;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f342932a;

    /* renamed from: b, reason: collision with root package name */
    public final String f342933b;

    /* renamed from: c, reason: collision with root package name */
    public final String f342934c;

    /* renamed from: d, reason: collision with root package name */
    public final String f342935d;

    public b(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4);
            return;
        }
        this.f342932a = str;
        this.f342933b = str2;
        this.f342934c = str3;
        this.f342935d = str4;
    }
}
