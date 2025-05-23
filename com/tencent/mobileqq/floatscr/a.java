package com.tencent.mobileqq.floatscr;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f209988a;

    /* renamed from: b, reason: collision with root package name */
    public String f209989b;

    /* renamed from: c, reason: collision with root package name */
    public int f209990c;

    /* renamed from: d, reason: collision with root package name */
    public long f209991d;

    /* renamed from: e, reason: collision with root package name */
    public long f209992e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f209990c = 0;
        this.f209991d = 1000L;
        this.f209992e = 1000L;
    }
}
