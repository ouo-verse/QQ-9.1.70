package com.tencent.mobileqq.activity.contact.connections;

import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ConnectsExplorationBanner extends MayKnowRecommend {
    static IPatchRedirector $redirector_;
    private boolean isBanner;

    public ConnectsExplorationBanner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isBanner = true;
        }
    }

    public boolean isBanner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isBanner;
    }

    public void setBanner(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isBanner = z16;
        }
    }
}
