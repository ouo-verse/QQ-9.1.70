package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FeatureSwitch {
    static IPatchRedirector $redirector_;
    public String mOwner;
    public boolean mSwitchEnable;
    public String mSwitchInfo;
    public String mSwitchName;

    public FeatureSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FeatureSwitch{mSwitchEnable=" + this.mSwitchEnable + ", mSwitchName='" + this.mSwitchName + "', mSwitchInfo='" + this.mSwitchInfo + "', mOwner='" + this.mOwner + "'}";
    }
}
