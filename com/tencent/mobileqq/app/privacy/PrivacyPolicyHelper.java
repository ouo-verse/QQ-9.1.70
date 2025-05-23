package com.tencent.mobileqq.app.privacy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class PrivacyPolicyHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String FILE_COMMON = "common_mmkv_configurations";
    public static final String PRIVACYPOLICY_KEY = "privacypolicy_state";
    public static final String PRIVACYPOLICY_STATE_ALLOW = "1";
    public static final String PRIVACYPOLICY_STATE_NOT_ALLOW = "0";
    private static final String TAG = "PrivacyPolicyHelper";
    private static boolean sUserAllowed;

    public PrivacyPolicyHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static String getPrivacyPolicyStatus(Context context) {
        MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
        String decodeString = from.decodeString(PRIVACYPOLICY_KEY, "");
        if (TextUtils.isEmpty(decodeString)) {
            String d16 = cl.d(context, PRIVACYPOLICY_KEY);
            if (TextUtils.isEmpty(d16)) {
                d16 = "0";
            } else {
                from.encodeString(PRIVACYPOLICY_KEY, d16);
                QLog.d("PrivacyPolicyHelper", 1, "migration privacy state: " + d16);
            }
            return d16;
        }
        return decodeString;
    }

    static boolean isUserAllow(Context context) {
        if (!sUserAllowed && "1".equals(getPrivacyPolicyStatus(context))) {
            sUserAllowed = true;
        }
        return sUserAllowed;
    }

    static void setPrivacyPolicyStatus(Context context, String str) {
        QMMKV.from(context, "common_mmkv_configurations").encodeString(PRIVACYPOLICY_KEY, str);
        cl.j(context, PRIVACYPOLICY_KEY, str);
        QLog.d("PrivacyPolicyHelper", 1, "setPrivacyPolicyStatus, state=" + str);
    }

    public static boolean isUserAllow() {
        return isUserAllow(BaseApplication.getContext());
    }
}
