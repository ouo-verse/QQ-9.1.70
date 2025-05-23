package com.tencent.mobileqq.profilecard.multyple;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes16.dex */
public class ProfileCardVersion implements IProfileCardVersion {
    static IPatchRedirector $redirector_;
    public static final ProfileCardVersion V_ELEGANT;
    public static final ProfileCardVersion V_OLD;
    private int versionNum;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36469);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            V_OLD = new ProfileCardVersion(0) { // from class: com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion.1
                static IPatchRedirector $redirector_;
                private IProfileCardMultiConfig profileCardMultiConfig;

                {
                    super(r4);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, r4);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion, com.tencent.mobileqq.profilecard.multyple.IProfileCardVersion
                public IProfileCardMultiConfig getVersionConfig() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (IProfileCardMultiConfig) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    if (this.profileCardMultiConfig == null) {
                        this.profileCardMultiConfig = new ProfileCardOldConfig();
                    }
                    return this.profileCardMultiConfig;
                }
            };
            V_ELEGANT = new ProfileCardVersion(202109) { // from class: com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion.2
                static IPatchRedirector $redirector_;
                private IProfileCardMultiConfig profileCardMultiConfig;

                {
                    super(r4);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, r4);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion, com.tencent.mobileqq.profilecard.multyple.IProfileCardVersion
                public IProfileCardMultiConfig getVersionConfig() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (IProfileCardMultiConfig) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    if (this.profileCardMultiConfig == null) {
                        this.profileCardMultiConfig = new ProfileCardElegantConfig();
                    }
                    return this.profileCardMultiConfig;
                }
            };
        }
    }

    public ProfileCardVersion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.versionNum = i3;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardVersion
    public IProfileCardMultiConfig getVersionConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IProfileCardMultiConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ProfileCardOldConfig();
    }

    @Override // com.tencent.mobileqq.profilecard.multyple.IProfileCardVersion
    public int getVersionNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.versionNum;
    }
}
