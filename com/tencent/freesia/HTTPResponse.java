package com.tencent.freesia;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes6.dex */
public final class HTTPResponse {
    static IPatchRedirector $redirector_;
    public final HashMap<String, String> mHeader;
    public final int mHttpCode;

    public HTTPResponse(int i3, @NonNull HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) hashMap);
        } else {
            this.mHttpCode = i3;
            this.mHeader = hashMap;
        }
    }

    @NonNull
    public HashMap<String, String> getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mHeader;
    }

    public int getHttpCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mHttpCode;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "HTTPResponse{mHttpCode=" + this.mHttpCode + ",mHeader=" + this.mHeader + "}";
    }
}
