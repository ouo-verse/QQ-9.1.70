package com.tencent.mobileqq.profilecard.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileSummaryHobbiesEntry {
    static IPatchRedirector $redirector_;
    public ArrayList<ProfileSummaryHobbiesItem> sProfileSummaryHobbiesItem;
    public int serviceType;
    public String strName;
    public String strServiceType;
    public String strServiceUrl;

    public ProfileSummaryHobbiesEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
