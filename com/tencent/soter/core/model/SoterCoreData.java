package com.tencent.soter.core.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterCoreData {
    static IPatchRedirector $redirector_;
    private static volatile SoterCoreData instance;
    private String mAskName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16602);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            instance = null;
        }
    }

    public SoterCoreData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAskName = ConstantsSoter.COMMON_SOTER_APP_SECURE_KEY_NAME;
        }
    }

    public static SoterCoreData getInstance() {
        SoterCoreData soterCoreData;
        if (instance == null) {
            synchronized (SoterCoreData.class) {
                if (instance == null) {
                    instance = new SoterCoreData();
                }
                soterCoreData = instance;
            }
            return soterCoreData;
        }
        return instance;
    }

    public String getAskName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mAskName;
    }

    public void setAskName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mAskName = str;
        }
    }
}
