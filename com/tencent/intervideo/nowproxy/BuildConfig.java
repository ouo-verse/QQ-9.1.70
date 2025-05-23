package com.tencent.intervideo.nowproxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class BuildConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String APPLICATION_ID = "com.tencent.intervideo.nowproxy";
    public static final String BUILD_TYPE = "debug";
    public static final boolean DEBUG;
    public static final String FLAVOR = "";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEBUG = true;
        }
    }

    public BuildConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
