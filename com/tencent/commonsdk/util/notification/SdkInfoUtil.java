package com.tencent.commonsdk.util.notification;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SdkInfoUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int Q_VERSION_CODE = 29;

    public SdkInfoUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isAndroidQ() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    public static boolean isOreo() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean isTargetSDKOreo() {
        if (BaseApplication.getContext().getApplicationContext().getApplicationInfo().targetSdkVersion >= 26) {
            return true;
        }
        return false;
    }
}
