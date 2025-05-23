package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f286173a;

    /* renamed from: b, reason: collision with root package name */
    public long f286174b;

    /* renamed from: c, reason: collision with root package name */
    public long f286175c;

    /* renamed from: d, reason: collision with root package name */
    public int f286176d;

    public ab() {
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
        return "----dump tempSession info----friendType:" + this.f286173a + " groupCode:" + this.f286174b + " groupUin:" + this.f286175c;
    }
}
