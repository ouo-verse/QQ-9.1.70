package com.tencent.tgpa.vendorpd;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BuildConfig {
    static IPatchRedirector $redirector_ = null;
    public static final boolean ADD_EXSDROOT = true;
    public static final String APPLICATION_ID = "com.tencent.tgpa.vendorpd";
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "common";
    public static final int VERSION_CODE = 17;
    public static final String VERSION_NAME = "1.1.7";

    public BuildConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
