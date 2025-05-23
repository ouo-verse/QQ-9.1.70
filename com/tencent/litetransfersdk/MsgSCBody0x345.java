package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgSCBody0x345 {
    static IPatchRedirector $redirector_;
    public SubCmd0x6RspBody subCmd0x6RspBody;
    public int uMsgSubType;
    public int uint32_return_code;

    public MsgSCBody0x345() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
