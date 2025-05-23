package com.tencent.mobileqq.qqlive.room.prepare;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f272085a;

    /* renamed from: b, reason: collision with root package name */
    public String f272086b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f272087c;

    public x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f272085a = "";
        this.f272086b = "";
        this.f272087c = false;
    }
}
