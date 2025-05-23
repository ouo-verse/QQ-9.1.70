package com.tencent.commonsdk.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
class ConfigStruct {
    static IPatchRedirector $redirector_;
    long mCrcvalue;
    String mSopath;

    public ConfigStruct(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str);
        } else {
            this.mCrcvalue = j3;
            this.mSopath = str;
        }
    }
}
