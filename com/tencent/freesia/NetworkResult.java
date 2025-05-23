package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class NetworkResult {
    static IPatchRedirector $redirector_;
    public final boolean mHttpSuccess;
    public final boolean mQpsLimit;
    public final int mResultCode;
    public final boolean mSuccess;

    public NetworkResult(boolean z16, int i3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.mSuccess = z16;
        this.mResultCode = i3;
        this.mHttpSuccess = z17;
        this.mQpsLimit = z18;
    }

    public boolean getHttpSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mHttpSuccess;
    }

    public boolean getQpsLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mQpsLimit;
    }

    public int getResultCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mResultCode;
    }

    public boolean getSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mSuccess;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "NetworkResult{mSuccess=" + this.mSuccess + ",mResultCode=" + this.mResultCode + ",mHttpSuccess=" + this.mHttpSuccess + ",mQpsLimit=" + this.mQpsLimit + "}";
    }
}
