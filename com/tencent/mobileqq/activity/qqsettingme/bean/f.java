package com.tencent.mobileqq.activity.qqsettingme.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f184887a;

    /* renamed from: b, reason: collision with root package name */
    public String f184888b;

    /* renamed from: c, reason: collision with root package name */
    public String f184889c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f184890d;

    /* renamed from: e, reason: collision with root package name */
    public String f184891e;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
