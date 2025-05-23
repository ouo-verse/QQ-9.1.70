package com.tencent.youtu.sdkkitframework;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class BuildConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String BUILD_TYPE = "debug";
    public static final boolean DEBUG;
    public static final String LIBRARY_PACKAGE_NAME = "com.tencent.youtu.sdkkitframework";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15318);
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
