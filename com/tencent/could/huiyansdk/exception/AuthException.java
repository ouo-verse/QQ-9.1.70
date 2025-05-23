package com.tencent.could.huiyansdk.exception;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AuthException extends Exception {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f100039a;

    /* renamed from: b, reason: collision with root package name */
    public String f100040b;

    public AuthException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f100039a = -1;
            this.f100040b = str;
        }
    }

    public AuthException(int i3, String str) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f100039a = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        }
    }
}
