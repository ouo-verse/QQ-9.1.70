package com.tencent.mobileqq.profilecard.multyple;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class FriendProfileCardMultiple implements IProfileCardMultiple {
    static IPatchRedirector $redirector_;
    private IProfileCardMultiConfig profileCardMultiConfig;
    private IProfileCardVersion profileCardVersion;

    public FriendProfileCardMultiple(IProfileCardVersion iProfileCardVersion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iProfileCardVersion);
        } else {
            init(iProfileCardVersion);
        }
    }

    private void init(IProfileCardVersion iProfileCardVersion) {
        this.profileCardVersion = iProfileCardVersion;
        this.profileCardMultiConfig = iProfileCardVersion.getVersionConfig();
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiple
    public IProfileCardMultiConfig getMultiConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IProfileCardMultiConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.profileCardMultiConfig;
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiple
    public IProfileCardVersion getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IProfileCardVersion) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.profileCardVersion;
    }
}
