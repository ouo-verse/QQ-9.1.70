package com.tencent.qqperf.monitor.crash.tools;

import android.app.Activity;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public class p {
    public static void a(Activity activity, String str) {
        String obj;
        Object b16 = b(activity);
        if (b16 == null) {
            obj = "null";
        } else {
            obj = b16.toString();
        }
        QLog.e("WindowInfoHelper", 1, "checkPhoneWindowContext checkTag:" + str + " | activity:" + activity.toString() + " | phoneWindowContext: " + obj);
    }

    private static Object b(Activity activity) {
        if (activity == null) {
            QLog.w("WindowInfoHelper", 1, "getPhoneWindowContext jump activity is null");
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            QLog.w("WindowInfoHelper", 1, "getPhoneWindowContext jump activity.getWindow() is null. activity = " + activity.toString());
            return null;
        }
        try {
            Field declaredField = Window.class.getDeclaredField("mContext");
            declaredField.setAccessible(true);
            return declaredField.get(window);
        } catch (Throwable th5) {
            try {
                QLog.e("WindowInfoHelper", 1, "getPhoneWindowContext has exception!", th5);
            } catch (Throwable unused) {
            }
            return null;
        }
    }
}
