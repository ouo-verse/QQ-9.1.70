package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class URLSafeUtil {
    public static final String BAZE64 = "*S1*";
    public static final String TAG = "NearbyURLSafeUtil";

    public static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = BAZE64 + com.tencent.mobileqq.util.i.f(str.getBytes(), 11);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "encode:" + str + " to:" + str2);
        }
        return str2;
    }

    public static String decode(String str) {
        if (str != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "decode src:" + str);
            }
            if (!isBaze64(str)) {
                return str;
            }
            String str2 = new String(com.tencent.mobileqq.util.i.a(str.substring(4), 11));
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "decode result:" + str2);
            }
            return str2;
        }
        throw new NullPointerException("decode src should not be null");
    }

    public static boolean isBaze64(String str) {
        if (str != null) {
            return str.startsWith(BAZE64);
        }
        throw new NullPointerException("isBase64 src should not be null");
    }
}
