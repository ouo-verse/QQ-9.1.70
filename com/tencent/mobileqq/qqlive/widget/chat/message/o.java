package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class o implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private i f273875d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.widget.chat.data.c f273876e;

    public com.tencent.mobileqq.qqlive.widget.chat.data.c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.widget.chat.data.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f273876e;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f273875d;
    }
}
