package com.tencent.common.config.pad;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static DeviceType a(Context context) {
        if (c(context)) {
            return DeviceType.TABLET;
        }
        return DeviceType.PHONE;
    }

    public static boolean b() {
        return "EEBBK".equalsIgnoreCase(Build.BRAND);
    }

    private static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageManager().hasSystemFeature("com.eebbk.features.pad");
    }
}
