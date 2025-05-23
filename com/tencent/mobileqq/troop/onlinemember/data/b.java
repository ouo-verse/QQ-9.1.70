package com.tencent.mobileqq.troop.onlinemember.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f298043a;

    /* renamed from: b, reason: collision with root package name */
    public String f298044b;

    /* renamed from: c, reason: collision with root package name */
    public String f298045c;

    /* renamed from: d, reason: collision with root package name */
    public int f298046d;

    /* renamed from: e, reason: collision with root package name */
    public String f298047e;

    /* renamed from: f, reason: collision with root package name */
    public int f298048f;

    /* renamed from: g, reason: collision with root package name */
    public String f298049g;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f298043a = 1;
        }
    }
}
