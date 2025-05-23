package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.widget.chat.data.a f273862a;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273862a = new com.tencent.mobileqq.qqlive.widget.chat.data.a();
        }
    }

    public com.tencent.mobileqq.qqlive.widget.chat.data.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.widget.chat.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f273862a;
    }
}
