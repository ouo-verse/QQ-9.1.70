package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class MobileUtil {
    private static final String MOBILE_BEGIN_CHAR = "1";
    private static final int MOBILE_LENGTH = 11;

    public static String splitCountryMobile(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 11) {
            return "";
        }
        int length = str.length();
        String substring = str.substring(length - 11, length);
        return !substring.startsWith("1") ? "" : substring;
    }
}
