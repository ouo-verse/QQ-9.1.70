package com.tencent.mobileqq.profilecard.base.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileConfigBean {
    static IPatchRedirector $redirector_ = null;
    public static final String PROFILE_VERSION_CONFIG_KEY = "profile_card_version";
    private static final String TAG = "ProfileConfigBean";
    public static final int VERSION_DEFAULT = 0;
    public static final int VERSION_ELEGANT = 1;
    public int mVersion;

    public ProfileConfigBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mVersion = 1;
        }
    }
}
