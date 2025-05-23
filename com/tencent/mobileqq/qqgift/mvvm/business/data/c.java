package com.tencent.mobileqq.qqgift.mvvm.business.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f264964a;

    /* renamed from: b, reason: collision with root package name */
    public String f264965b;

    /* renamed from: c, reason: collision with root package name */
    public String f264966c;

    /* renamed from: d, reason: collision with root package name */
    public int f264967d;

    /* renamed from: e, reason: collision with root package name */
    public int f264968e;

    /* renamed from: f, reason: collision with root package name */
    public int f264969f;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
