package com.tencent.mobileqq.qqsec.api;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replaceAll("<mark>", "").replaceAll("</mark>", "");
        } catch (Throwable th5) {
            QLog.e("FrozenKickUtils", 1, "filterTagFromKickMsg error:", th5);
            return str;
        }
    }
}
