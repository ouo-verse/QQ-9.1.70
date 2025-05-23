package com.tencent.mobileqq.leba.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static int a(int i3) {
        if (i3 != 4033) {
            if (i3 == 4034) {
                return 1;
            }
            QLog.e("PluginConfigUtils", 1, "getPluginConfigMode return unspecified");
            return 0;
        }
        return 2;
    }

    public static int b(int i3) {
        if (i3 != 4034 && i3 != 4033) {
            QLog.i("PluginConfigUtils", 1, "getPluginConfigStyle return unspecified");
            return 0;
        }
        if (!com.tencent.mobileqq.leba.feed.d.a()) {
            return 1;
        }
        return 2;
    }

    public static boolean c(int i3, int i16) {
        if ((i3 == 1 || i3 == 2) && (i16 == 1 || i16 == 2)) {
            return true;
        }
        return false;
    }
}
