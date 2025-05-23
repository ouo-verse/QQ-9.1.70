package com.tencent.mobileqq.subaccount.logic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f291134a;

    /* renamed from: b, reason: collision with root package name */
    public int f291135b;

    /* renamed from: c, reason: collision with root package name */
    public String f291136c;

    /* renamed from: d, reason: collision with root package name */
    public int f291137d;

    /* renamed from: e, reason: collision with root package name */
    public int f291138e;

    /* renamed from: f, reason: collision with root package name */
    public int f291139f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f291135b = 0;
        this.f291136c = "";
        this.f291139f = 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "result:" + this.f291137d + " mainAccount:" + this.f291134a + " errorType:" + this.f291135b + " errorMsg:" + this.f291136c + " interval:" + this.f291138e + " allLastMsgTime:" + this.f291139f;
    }
}
