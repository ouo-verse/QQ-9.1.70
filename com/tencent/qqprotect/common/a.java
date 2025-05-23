package com.tencent.qqprotect.common;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a() {
        String packageName = MobileQQ.sMobileQQ.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return "com.tencent.mobileqq";
        }
        return packageName;
    }
}
