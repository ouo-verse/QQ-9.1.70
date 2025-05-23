package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RFCInfoNotify {
    static IPatchRedirector $redirector_;
    public boolean bool_file_assist;
    public int uServerIp;
    public long uSessionId;
    public int uSvrPort;
    public long uSvrTaskId;
    public byte[] vTokenKey;

    public RFCInfoNotify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
