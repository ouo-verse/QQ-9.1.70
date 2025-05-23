package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f286177a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f286178b;

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
