package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public QLBroadCastFreeLove f273857d;

    /* renamed from: e, reason: collision with root package name */
    private i f273858e;

    public g(QLBroadCastFreeLove qLBroadCastFreeLove) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qLBroadCastFreeLove);
        } else {
            this.f273858e = new i();
            this.f273857d = qLBroadCastFreeLove;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f273858e;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "LikeMsg{broadCastFreeLove=" + this.f273857d + '}';
    }
}
