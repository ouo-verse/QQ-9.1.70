package com.tencent.qfsmonet.process.core;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Keep
/* loaded from: classes22.dex */
public class MonetProcessParams {
    static IPatchRedirector $redirector_;
    private String mOpIdentifier;
    private String mParamsKey;
    private String mParamsValue;

    MonetProcessParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Keep
    public String getOpIdentifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mOpIdentifier;
    }

    @Keep
    public String getParamsKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mParamsKey;
    }

    @Keep
    public String getParamsValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mParamsValue;
    }

    @Keep
    public MonetProcessParams(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        this.mOpIdentifier = str;
        this.mParamsKey = str2;
        this.mParamsValue = str3;
    }
}
