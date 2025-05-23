package com.tencent.mobileqq.qqalbum;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Object f262095a;

    /* renamed from: b, reason: collision with root package name */
    public String f262096b;

    /* renamed from: c, reason: collision with root package name */
    public int f262097c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f262097c = 80;
        }
    }
}
