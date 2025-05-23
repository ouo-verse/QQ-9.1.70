package com.tencent.relation.common.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static int a(float f16) {
        return (int) TypedValue.applyDimension(1, f16, Resources.getSystem().getDisplayMetrics());
    }

    public static long b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            QLog.e(str, 1, "parseLong text = ", str2);
            return 0L;
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception unused) {
            QLog.e(str, 1, "parseLong text = ", str2);
            return 0L;
        }
    }
}
