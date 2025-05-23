package com.tencent.mobileqq.profilecard.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class ProfileSummaryHobbiesItem {
    static IPatchRedirector $redirector_ = null;
    public static final int SERVICE_TYPE_TROOP = 5;
    public long groupCode;
    public ArrayList<ProfileGroupLabel> labels;
    public int service;
    public int serviceType;
    public String strCoverUrl;
    public String strDesc;
    public String strJmpUrl;
    public String strSubInfo;
    public String strTitle;
    public String strTitleIconUrl;

    public ProfileSummaryHobbiesItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
