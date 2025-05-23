package com.tencent.midas.comm.log.internal;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.APLogInfo;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes9.dex */
public class APCallbackLogger {
    private static Object logCallbackObj;
    private static Method onLoggingMethod;

    public static boolean init(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            Class<?> cls = Class.forName(str);
            logCallbackObj = cls.newInstance();
            onLoggingMethod = cls.getDeclaredMethod("onLogging", Integer.TYPE, String.class, String.class);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void log(int i3, String str, String str2) {
        String substring;
        Method method;
        int i16 = 0;
        while (i16 < str2.length()) {
            try {
                int i17 = i16 + 3600;
                if (str2.length() <= i17) {
                    substring = str2.substring(i16);
                } else {
                    substring = str2.substring(i16, i17);
                }
                Object obj = logCallbackObj;
                if (obj != null && (method = onLoggingMethod) != null) {
                    try {
                        method.invoke(obj, Integer.valueOf(i3), str, substring);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                i16 = i17;
            } catch (Throwable th5) {
                Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "print log error: <%s>%s", th5.getClass().getName(), th5.getMessage()));
                return;
            }
        }
    }

    public static void release() {
        logCallbackObj = null;
        onLoggingMethod = null;
    }
}
