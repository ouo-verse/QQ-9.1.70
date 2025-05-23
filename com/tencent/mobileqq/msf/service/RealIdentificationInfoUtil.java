package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RealIdentificationInfoUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RealIdentificationInfoUtil";

    public RealIdentificationInfoUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getIdentification(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getModel() {
        return Build.MODEL;
    }
}
