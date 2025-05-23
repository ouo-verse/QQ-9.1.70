package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import trpc.yes.common.MessageOuterClass$AnchorChargeMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public MessageOuterClass$AnchorChargeMsg f273849d;

    /* renamed from: e, reason: collision with root package name */
    private i f273850e;

    public a(MessageOuterClass$AnchorChargeMsg messageOuterClass$AnchorChargeMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageOuterClass$AnchorChargeMsg);
        } else {
            this.f273850e = new i();
            this.f273849d = messageOuterClass$AnchorChargeMsg;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f273850e;
    }
}
