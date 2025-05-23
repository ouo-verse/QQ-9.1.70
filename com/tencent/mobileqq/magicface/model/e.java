package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f243455a;

    /* renamed from: b, reason: collision with root package name */
    public int f243456b;

    /* renamed from: c, reason: collision with root package name */
    public String f243457c;

    /* renamed from: d, reason: collision with root package name */
    public String f243458d;

    /* renamed from: e, reason: collision with root package name */
    public int f243459e;

    /* renamed from: f, reason: collision with root package name */
    public String f243460f;

    /* renamed from: g, reason: collision with root package name */
    public int f243461g;

    /* renamed from: h, reason: collision with root package name */
    public int f243462h;

    /* renamed from: i, reason: collision with root package name */
    public int f243463i;

    /* renamed from: j, reason: collision with root package name */
    public int f243464j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f243465k;

    /* renamed from: l, reason: collision with root package name */
    public int f243466l;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243455a = -1;
        this.f243456b = -1;
        this.f243459e = 1;
        this.f243462h = 1;
        this.f243465k = false;
        this.f243466l = 0;
    }
}
