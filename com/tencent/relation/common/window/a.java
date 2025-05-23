package com.tencent.relation.common.window;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f364879a;

    /* renamed from: b, reason: collision with root package name */
    public int f364880b;

    /* renamed from: c, reason: collision with root package name */
    public float f364881c;

    /* renamed from: d, reason: collision with root package name */
    public float f364882d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f364879a = 0;
        this.f364880b = 0;
        this.f364881c = 0.0f;
        this.f364882d = 0.0f;
    }
}
