package com.tencent.intervideo.nowproxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class InitData {
    static IPatchRedirector $redirector_;
    public String mAppID;
    public int mClientType;
    public String mGuid;
    public boolean mIsCpu64bit;
    public String mQBID;
    public String mQUA;
    public boolean mSetILoggerFactoryInside;
    public String mSourceUid;
    public String mSourceVersion;

    public InitData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSetILoggerFactoryInside = true;
            this.mIsCpu64bit = false;
        }
    }
}
