package com.tencent.ams.xsad.rewarded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f71725a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f71726b;

    /* renamed from: c, reason: collision with root package name */
    public int f71727c;

    /* renamed from: d, reason: collision with root package name */
    public int f71728d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
