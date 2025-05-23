package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ReqInfo {
    static IPatchRedirector $redirector_;
    public int encryptKeysResultCode;
    public boolean encryptKeysSuccess;
    public String strGetKeySeq;
    public String timeoutReason;

    public ReqInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.encryptKeysSuccess = false;
        this.encryptKeysResultCode = 0;
        this.strGetKeySeq = null;
    }

    public int getEncryptKeyResultCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (this.encryptKeysSuccess) {
            return 0;
        }
        int i3 = this.encryptKeysResultCode;
        if (i3 == 1002) {
            return 11023;
        }
        if (i3 == 11022) {
            return 11022;
        }
        return 11009;
    }
}
