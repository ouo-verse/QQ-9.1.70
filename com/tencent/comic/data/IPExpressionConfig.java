package com.tencent.comic.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class IPExpressionConfig implements Serializable {
    static IPatchRedirector $redirector_;
    public HashMap<String, String> mExpressionMap;
    public String mPrefixUrl;

    public IPExpressionConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mExpressionMap = new HashMap<>();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "IPExpressionConfig{mPrefixUrl='" + this.mPrefixUrl + "', mExpressionMap=" + this.mExpressionMap + '}';
    }
}
