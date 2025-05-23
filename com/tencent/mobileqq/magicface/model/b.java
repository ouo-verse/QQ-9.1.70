package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f243430a;

    /* renamed from: b, reason: collision with root package name */
    public int f243431b;

    /* renamed from: c, reason: collision with root package name */
    public String f243432c;

    /* renamed from: d, reason: collision with root package name */
    public String f243433d;

    /* renamed from: e, reason: collision with root package name */
    public String f243434e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
