package com.tencent.mobileqq.temp.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f292636a;

    /* renamed from: b, reason: collision with root package name */
    public int f292637b;

    /* renamed from: c, reason: collision with root package name */
    public String f292638c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f292636a = false;
        this.f292637b = 0;
        this.f292638c = null;
    }
}
