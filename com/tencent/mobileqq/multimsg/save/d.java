package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f251678a;

    /* renamed from: b, reason: collision with root package name */
    public int f251679b;

    /* renamed from: c, reason: collision with root package name */
    public int f251680c;

    /* renamed from: d, reason: collision with root package name */
    public String f251681d;

    /* renamed from: e, reason: collision with root package name */
    public int f251682e;

    /* renamed from: f, reason: collision with root package name */
    public int f251683f;

    /* renamed from: g, reason: collision with root package name */
    public c f251684g;

    /* renamed from: h, reason: collision with root package name */
    public p f251685h;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251678a = false;
            this.f251683f = 0;
        }
    }
}
