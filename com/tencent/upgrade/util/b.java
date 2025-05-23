package com.tencent.upgrade.util;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        if (Build.SUPPORTED_64_BIT_ABIS.length > 0) {
            return true;
        }
        return false;
    }
}
