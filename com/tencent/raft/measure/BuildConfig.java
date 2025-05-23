package com.tencent.raft.measure;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class BuildConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.tencent.raft.measure";
    public static final String RAFT_VERSION = "0.5.2.16";

    public BuildConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
