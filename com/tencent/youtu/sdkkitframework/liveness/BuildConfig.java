package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class BuildConfig {
    static IPatchRedirector $redirector_ = null;

    @Deprecated
    public static final String APPLICATION_ID = "com.tencent.youtu.sdkkitframework.liveness";
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "tinycv";
    public static final String LIBRARY_PACKAGE_NAME = "com.tencent.youtu.sdkkitframework.liveness";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.1.20.5.1";

    public BuildConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
