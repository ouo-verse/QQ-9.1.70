package com.tencent.misc.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f151681a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f151682b;

    public a(int i3, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bool);
        } else {
            this.f151681a = i3;
            this.f151682b = bool;
        }
    }
}
