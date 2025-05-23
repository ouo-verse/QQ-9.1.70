package com.tencent.mobileqq.profilecard.bussiness.medalwall;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileMedalWallEntryInfo {
    static IPatchRedirector $redirector_;
    public boolean hasRedPoint;
    public int redPointCount;
    public boolean showMetalWall;

    public ProfileMedalWallEntryInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
