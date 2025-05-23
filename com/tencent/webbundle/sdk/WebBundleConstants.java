package com.tencent.webbundle.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebBundleConstants {
    static IPatchRedirector $redirector_ = null;
    public static final long AUTO_PRELOAD_DELAY = 500;
    public static final String EVENT_ARGUMENT_OF_PRELOAD_TYPE = "preloadAllPage";
    public static final String EVENT_NAME_OF_WEB_BUNDLE = "vashybrid_bundle_message";
    public static final String EVENT_TYPE_OF_PRELOAD_VIEW = "preloadView";
    public static final String EVENT_TYPE_OF_PUSH_VIEW = "pushView";
    public static final int MAX_CONTINUOUS_FAIL_COUNT = 2;
    public static final String OPEN_WITH_WEBBUNDLE = "openWithWebBundle";
    public static final long PRELOAD_TIME_OUT_LIMIT = 15000;
    public static final int PRELOAD_WEBBUNDLE_COUNT = 2;
    public static final String WEBBUNDLE_BUNDLE_DATA = "bundle_data";
    public static final String WEBBUNDLE_PRELOAD_URL = "preload_url";
    public static final String WEBBUNDLE_REAL_URL = "real_url";

    public WebBundleConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
