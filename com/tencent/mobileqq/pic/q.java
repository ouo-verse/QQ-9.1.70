package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f258790a;

    /* renamed from: b, reason: collision with root package name */
    public m.a f258791b;

    /* renamed from: c, reason: collision with root package name */
    public p f258792c;

    /* renamed from: d, reason: collision with root package name */
    public Object f258793d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f258794e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f258795f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f258796g;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258790a = -2;
        }
    }
}
