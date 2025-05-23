package com.tencent.mobileqq.profile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f260135a;

    /* renamed from: b, reason: collision with root package name */
    public Object f260136b;

    public b(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, obj);
        } else {
            this.f260135a = i3;
            this.f260136b = obj;
        }
    }
}
