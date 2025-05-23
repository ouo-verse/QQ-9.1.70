package com.tencent.gcloud.gcloud;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class BuildConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String APPLICATION_ID = "com.tencent.gcloud.gcloud";
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "";
    public static final String GCLOUD_VERSION_DETAIL = "2.8.00.gcloud-dev-v2.9.0.7fea5cda";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "2.8.00.200922";

    public BuildConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
