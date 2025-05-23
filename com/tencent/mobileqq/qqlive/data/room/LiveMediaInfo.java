package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveMediaInfo {
    static IPatchRedirector $redirector_;
    public int authEncryptionType;
    public byte[] sig;
    public long timeOut;

    public LiveMediaInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LiveMediaInfo is [sig= " + Utils.e(this.sig) + ";timeOut=" + this.timeOut + ";authEncryptionType=" + this.authEncryptionType + "]";
    }
}
