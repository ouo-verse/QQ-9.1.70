package com.tencent.sonic.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicConstants {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_CODE_BUILD_HTML_ERROR = -1008;
    public static final int ERROR_CODE_CONNECT_IOE = -901;
    public static final int ERROR_CODE_CONNECT_NPE = -903;
    public static final int ERROR_CODE_CONNECT_TOE = -902;
    public static final int ERROR_CODE_DATA_VERIFY_FAIL = -1001;
    public static final int ERROR_CODE_MAKE_DIR_ERROR = -1003;
    public static final int ERROR_CODE_MERGE_DIFF_DATA_FAIL = -1006;
    public static final int ERROR_CODE_SERVER_DATA_EXCEPTION = -1007;
    public static final int ERROR_CODE_SPLIT_HTML_FAIL = -1005;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_UNKNOWN = -1;
    public static final int ERROR_CODE_WRITE_FILE_FAIL = -1004;
    public static final int SESSION_MODE_DEFAULT = 0;
    public static final int SESSION_MODE_QUICK = 1;
    public static final String SONIC_PARAMETER_NAME_PREFIX = "sonic_";
    public static final String SONIC_REMAIN_PARAMETER_NAMES = "sonic_remain_params";
    public static final String SONIC_REMAIN_PARAMETER_SPLIT_CHAR = ";";
    public static final String SONIC_SDK_LOG_PREFIX = "SonicSdk_";
    public static final String SONIC_VERSION_NUM = "3.0.2";

    public SonicConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
