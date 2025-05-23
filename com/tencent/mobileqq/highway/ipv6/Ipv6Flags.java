package com.tencent.mobileqq.highway.ipv6;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Ipv6Flags {
    static IPatchRedirector $redirector_;
    public int mBdhStrategy;
    public int mConnAttemptDelay;
    public int mRMDownStrategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ipv6Flags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public boolean isIpv6BDHFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        BdhLogUtil.LogEvent("E", "Ipv6Config.isIpv6BDHFirst, mBdhStrategy = " + this.mBdhStrategy);
        if (this.mBdhStrategy == 2) {
            return true;
        }
        if (this.mRMDownStrategy == 3 && MsfServiceSdk.get().getConnectedIPFamily() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ipv6Flags(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.mRMDownStrategy = i3;
        this.mBdhStrategy = i16;
        this.mConnAttemptDelay = i17;
    }
}
