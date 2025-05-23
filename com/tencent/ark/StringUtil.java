package com.tencent.ark;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StringUtil {
    public static String format(String str, Object... objArr) {
        return String.format(Constants.DEFAULT_LOCALE, str, objArr);
    }

    public static String getNotNullString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
