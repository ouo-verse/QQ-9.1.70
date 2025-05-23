package com.tencent.mobileqq.leba.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f240471a;

    /* renamed from: b, reason: collision with root package name */
    public int f240472b;

    /* renamed from: c, reason: collision with root package name */
    public int f240473c;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "GroupInfo\uff1a" + this.f240471a + "|" + this.f240472b + "|" + this.f240473c;
    }
}
