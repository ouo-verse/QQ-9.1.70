package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgCSBody {
    static IPatchRedirector $redirector_;
    public MsgCSBody0x211 msgBody0x211;
    public MsgCSBody0x345 msgBody0x345;
    public MsgCSBody0x346 msgBody0x346;
    public int uMsgTime;
    public int uMsgType;

    public MsgCSBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
