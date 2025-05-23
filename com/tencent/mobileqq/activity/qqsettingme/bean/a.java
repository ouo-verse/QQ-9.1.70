package com.tencent.mobileqq.activity.qqsettingme.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f184869a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f184870b;

    /* renamed from: c, reason: collision with root package name */
    public String f184871c;

    /* renamed from: d, reason: collision with root package name */
    public String f184872d;

    /* renamed from: e, reason: collision with root package name */
    public String f184873e;

    /* renamed from: f, reason: collision with root package name */
    public int f184874f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f184869a = 1;
            this.f184870b = true;
        }
    }
}
