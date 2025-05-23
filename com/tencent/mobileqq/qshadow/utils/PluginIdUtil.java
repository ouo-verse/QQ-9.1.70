package com.tencent.mobileqq.qshadow.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class PluginIdUtil {
    static IPatchRedirector $redirector_;

    PluginIdUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String convertQPluginId2QShadowId(String str) {
        int indexOf = str.indexOf(".apk");
        if (indexOf < 0) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String convertQShadowId2QPluginId(String str) {
        return getGroupId(str) + ".apk";
    }

    public static String getGroupId(String str) {
        int indexOf = str.indexOf("-");
        if (indexOf < 0) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static boolean isQPluginId(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(".apk")) {
            return true;
        }
        return false;
    }
}
