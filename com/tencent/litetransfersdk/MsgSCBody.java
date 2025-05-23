package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgSCBody {
    static IPatchRedirector $redirector_;
    public boolean bTimeOut;
    public MsgSCBody0x211 msgBody0x211;
    public MsgSCBody0x345 msgBody0x345;
    public MsgSCBody0x346 msgBody0x346;
    public int uMsgType;

    public MsgSCBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
