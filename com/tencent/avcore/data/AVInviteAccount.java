package com.tencent.avcore.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVInviteAccount {
    static IPatchRedirector $redirector_;
    public String account;
    public int accountType;
    public int inviteType;
    TelInfo msgTelInfo;
    public int result;

    public AVInviteAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.msgTelInfo = new TelInfo();
        }
    }
}
