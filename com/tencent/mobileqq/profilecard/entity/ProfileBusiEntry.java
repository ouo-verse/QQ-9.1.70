package com.tencent.mobileqq.profilecard.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileBusiEntry {
    static IPatchRedirector $redirector_ = null;
    public static final int JOINED_TROOP_BUSI_ENTRY_TYPE = 1024;
    public int nBusiEntryType;
    public String strContent;
    public String strJumpUrl;
    public String strLogoUrl;
    public String strTitle;

    public ProfileBusiEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        String str = this.strTitle;
        if (str != null && str.trim().length() > 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "[" + this.nBusiEntryType + "," + this.strLogoUrl + "," + this.strTitle + "," + this.strContent + "," + this.strJumpUrl + "]";
    }
}
