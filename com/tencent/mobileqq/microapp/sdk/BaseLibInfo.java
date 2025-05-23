package com.tencent.mobileqq.microapp.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BaseLibInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public String baseLibKey;
    public String baseLibUrl;
    public String baseLibVersion;

    public BaseLibInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.baseLibUrl = str;
        this.baseLibKey = str2;
        this.baseLibVersion = str3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BaseLibInfo{baseLibUrl='" + this.baseLibUrl + "', baseLibKey='" + this.baseLibKey + "', baseLibVersion='" + this.baseLibVersion + "'}";
    }
}
