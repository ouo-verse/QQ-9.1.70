package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class v extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public int f196248g;

    /* renamed from: h, reason: collision with root package name */
    public int f196249h;

    /* renamed from: i, reason: collision with root package name */
    public long f196250i;

    /* renamed from: j, reason: collision with root package name */
    public long f196251j;

    /* renamed from: k, reason: collision with root package name */
    public long f196252k;

    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f196216a = 10001;
            this.f196217b = 4;
        }
    }
}
