package com.tencent.mobileqq.qqpermission.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AuthorizationMessage extends ResponsesInfo {
    static IPatchRedirector $redirector_;
    public String supplement;

    public AuthorizationMessage(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.content = str;
        this.supplement = str2;
        this.isChecked = this.isDefaultCheck;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AuthorizationMessage{supplement='" + this.supplement + "', content='" + this.content + "', isDefaultCheck=" + this.isDefaultCheck + ", isChecked=" + this.isChecked + "} " + super.toString();
    }
}
