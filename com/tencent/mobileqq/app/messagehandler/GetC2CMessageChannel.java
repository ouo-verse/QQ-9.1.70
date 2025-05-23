package com.tencent.mobileqq.app.messagehandler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetC2CMessageChannel {
    static IPatchRedirector $redirector_ = null;
    private static final byte C2C_MSG_CHANNEL_TYPE_ACCOST = 2;
    public static final byte C2C_MSG_CHANNEL_TYPE_ALL = 3;
    public static final byte C2C_MSG_CHANNEL_TYPE_BUDDY = 1;

    public GetC2CMessageChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
