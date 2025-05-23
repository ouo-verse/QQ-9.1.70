package com.tencent.soter.core.model;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ConstantsSoter {
    public static final IPatchRedirector $redirector_ = null;
    public static final String COMMON_SOTER_APP_SECURE_KEY_NAME;
    public static final int ERR_ANDROID_AIDL_EXCEPTION = 101;
    public static final int ERR_ANDROID_AIDL_RESULT = 102;
    public static final int ERR_ANDROID_BEFORE_TREBLE = 103;
    public static final int ERR_ANDROID_BIND_SERVICE_OUTTIME = 105;
    public static final int ERR_ANDROID_HAREWARE_NOT_SUPPORT = 104;
    public static final int ERR_BIOMETRIC_FAIL_MAX = 10308;
    public static final int ERR_BIOMETRIC_FAIL_MAX_PERMANENT = 10309;
    public static final int ERR_BIOMETRIC_WAIT_TIMEOUT = 10309;
    public static final int ERR_FINGERPRINT_FAIL_MAX = 10308;
    public static final int ERR_NEGATIVE_BUTTON = 10310;
    public static final int ERR_SOTER_AUTH_ERROR = 401;
    public static final int ERR_SOTER_INNER = 200;
    public static final int ERR_SOTER_OK = 0;
    public static final int ERR_SOTER_SRV_CONFIG = 300;
    public static final int ERR_SOTER_UNKNOWN = 100;
    public static final int FACEID_AUTH = 2;
    public static final long FACEID_AUTH_CHECK_TIME = 3000;
    public static final int FINGERPRINT_AUTH = 1;
    public static final String SOTER_BIOMETRIC_ERR_FAIL_MAX_MSG = "Too many failed times";
    public static final String SOTER_COMMON_KEYNAME_PREFIX = "Wechat";
    public static final String SOTER_FACEID_ERR_FAIL_MAX_MSG = "Too many failed times";
    public static final String SOTER_FINGERPRINT_ERR_FAIL_MAX_MSG = "Too many failed times";
    public static final String SOTER_PROVIDER_NAME = "SoterKeyStore";

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(16572), (Class<?>) ConstantsSoter.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        COMMON_SOTER_APP_SECURE_KEY_NAME = SOTER_COMMON_KEYNAME_PREFIX + Process.myUid();
    }
}
