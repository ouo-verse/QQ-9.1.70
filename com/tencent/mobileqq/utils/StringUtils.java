package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class StringUtils {
    private static final String TAG = "StringUtils";

    public static boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static long toLong(String str) {
        if (!isNumeric(str)) {
            QLog.e(TAG, 1, "Convert to long error: numStr=" + str);
            return 0L;
        }
        return Long.parseLong(str);
    }
}
