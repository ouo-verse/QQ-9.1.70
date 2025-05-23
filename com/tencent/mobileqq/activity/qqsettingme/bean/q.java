package com.tencent.mobileqq.activity.qqsettingme.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f184950a;

    /* renamed from: b, reason: collision with root package name */
    public String f184951b;

    /* renamed from: c, reason: collision with root package name */
    public String f184952c;

    /* renamed from: d, reason: collision with root package name */
    public String f184953d;

    /* renamed from: e, reason: collision with root package name */
    public String f184954e;

    /* renamed from: f, reason: collision with root package name */
    public String f184955f;

    /* renamed from: g, reason: collision with root package name */
    public int f184956g;

    /* renamed from: h, reason: collision with root package name */
    public String f184957h;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184950a = 0;
        this.f184951b = "";
        this.f184952c = "";
        this.f184953d = "";
        this.f184954e = "";
        this.f184955f = "";
        this.f184956g = 0;
        this.f184957h = "";
    }
}
