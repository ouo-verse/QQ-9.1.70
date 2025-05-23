package com.tencent.mobileqq.phonecontact.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f258471a;

    /* renamed from: b, reason: collision with root package name */
    public String f258472b;

    /* renamed from: c, reason: collision with root package name */
    public String f258473c;

    /* renamed from: d, reason: collision with root package name */
    public int f258474d;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258471a = "";
        }
    }
}
