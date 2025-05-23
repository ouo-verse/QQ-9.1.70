package com.tencent.mobileqq.leba.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f240474a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f240475b;

    /* renamed from: c, reason: collision with root package name */
    public int f240476c;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240474a = 0;
        this.f240475b = false;
        this.f240476c = 0;
    }
}
