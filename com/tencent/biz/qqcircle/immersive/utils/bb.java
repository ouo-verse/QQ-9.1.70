package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.graphics.drawable.ColorDrawable;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bb {
    public static boolean a(Activity activity) {
        try {
            activity.getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
            activity.getWindow().getDecorView().setBackground(new ColorDrawable(-16777216));
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static boolean b(Activity activity) {
        try {
            activity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            activity.getWindow().getDecorView().setBackground(null);
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, invoke);
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }
}
