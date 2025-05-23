package com.tencent.mobileqq.matchfriend.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f244051a;

    /* renamed from: b, reason: collision with root package name */
    public String f244052b;

    /* renamed from: c, reason: collision with root package name */
    public String f244053c;

    /* renamed from: d, reason: collision with root package name */
    public String f244054d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f244051a = "";
        this.f244052b = "";
        this.f244053c = "";
        this.f244054d = "";
    }
}
