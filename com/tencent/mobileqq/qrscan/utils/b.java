package com.tencent.mobileqq.qrscan.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static long a(byte[] bArr) {
        long j3 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            j3 += (bArr[(r0 - i3) - 1] & 255) << (i3 * 8);
        }
        return j3;
    }

    public static short b(byte[] bArr) {
        return (short) (((bArr[0] & 255) << 8) + (bArr[1] & 255));
    }

    public static void c(Context context) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.gestureboost.GestureBoostManager");
            Field declaredField = cls.getDeclaredField("sGestureBoostManager");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mContext");
            declaredField2.setAccessible(true);
            if (declaredField2.get(obj) == context) {
                declaredField2.set(obj, null);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("ScannerUtils", 2, th5.getMessage());
            }
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("app_name=qim");
    }

    public static byte[] e(long j3) {
        return new byte[]{(byte) (j3 >>> 56), (byte) (j3 >>> 48), (byte) (j3 >>> 40), (byte) (j3 >>> 32), (byte) (j3 >>> 24), (byte) (j3 >>> 16), (byte) (j3 >>> 8), (byte) j3};
    }

    public static boolean f(int i3) {
        if ((i3 & 2) == 2) {
            return true;
        }
        return false;
    }

    public static boolean g(int i3) {
        if ((i3 & 1) == 1) {
            return true;
        }
        return false;
    }
}
