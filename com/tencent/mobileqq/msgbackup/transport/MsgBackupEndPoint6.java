package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class MsgBackupEndPoint6 {
    static IPatchRedirector $redirector_;

    public MsgBackupEndPoint6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
