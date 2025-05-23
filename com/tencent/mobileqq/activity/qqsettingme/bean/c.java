package com.tencent.mobileqq.activity.qqsettingme.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f184878a;

    /* renamed from: b, reason: collision with root package name */
    public String f184879b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f184880c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
