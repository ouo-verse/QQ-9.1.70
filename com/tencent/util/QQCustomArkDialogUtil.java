package com.tencent.util;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQCustomArkDialogUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String APP_MIN_VERSION = "appMinVersion";
    public static final String APP_NAME = "appName";
    public static final String APP_VIEW = "appView";
    public static final String BIZ_SRC = "bizsrc";
    public static final String META_DATA = "metaData";
    public static final String SCALE = "scale";
    public static final String TROOP_UIN = "troop_uin";

    public QQCustomArkDialogUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bundle zipArgs(String str, String str2, String str3, String str4, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("appName", str);
        bundle.putString(APP_MIN_VERSION, str3);
        bundle.putString(APP_VIEW, str2);
        bundle.putString(META_DATA, str4);
        return bundle;
    }

    public static Bundle zipArgs(String str, String str2, String str3, String str4, float f16, String str5, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("appName", str);
        bundle.putString(APP_MIN_VERSION, str3);
        bundle.putString(APP_VIEW, str2);
        bundle.putString(META_DATA, str4);
        bundle.putFloat("scale", f16);
        bundle.putString("troop_uin", str5);
        return bundle;
    }
}
