package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupNetState {
    static IPatchRedirector $redirector_;
    public boolean tcpConnected;
    public boolean udpDetected;

    public MsgBackupNetState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
