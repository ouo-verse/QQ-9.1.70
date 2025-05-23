package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.utils.URLSafeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    public static String a(String str) {
        if (str != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(URLSafeUtil.TAG, 4, "decode src:" + str);
            }
            if (c(str)) {
                String str2 = new String(com.tencent.mobileqq.util.i.a(str.substring(4), 11));
                if (QLog.isDevelopLevel()) {
                    QLog.i(URLSafeUtil.TAG, 4, "decode result:" + str2);
                }
                return str2;
            }
            return str;
        }
        throw new NullPointerException("decode src should not be null");
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = URLSafeUtil.BAZE64 + com.tencent.mobileqq.util.i.f(str.getBytes(), 11);
        if (QLog.isDevelopLevel()) {
            QLog.i(URLSafeUtil.TAG, 4, "encode:" + str + " to:" + str2);
        }
        return str2;
    }

    public static boolean c(String str) {
        if (str != null) {
            return str.startsWith(URLSafeUtil.BAZE64);
        }
        throw new NullPointerException("isBase64 src should not be null");
    }
}
