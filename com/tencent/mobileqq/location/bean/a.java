package com.tencent.mobileqq.location.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125$MsgBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private submsgtype0x125$MsgBody f241217a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public submsgtype0x125$MsgBody a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (submsgtype0x125$MsgBody) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f241217a;
    }

    public void b(submsgtype0x125$MsgBody submsgtype0x125_msgbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) submsgtype0x125_msgbody);
        } else {
            this.f241217a = submsgtype0x125_msgbody;
        }
    }
}
