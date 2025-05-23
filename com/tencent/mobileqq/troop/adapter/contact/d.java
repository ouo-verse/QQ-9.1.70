package com.tencent.mobileqq.troop.adapter.contact;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f293808a;

    /* renamed from: b, reason: collision with root package name */
    public Object f293809b;

    public d(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, obj);
        } else {
            this.f293808a = i3;
            this.f293809b = obj;
        }
    }
}
