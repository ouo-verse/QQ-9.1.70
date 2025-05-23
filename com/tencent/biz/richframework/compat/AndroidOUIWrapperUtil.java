package com.tencent.biz.richframework.compat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AndroidOUIWrapperUtil {
    @SuppressLint({"DiscouragedPrivateApi"})
    public static void fixOrientation(Activity activity) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ActivityInfo activityInfo = (ActivityInfo) declaredField.get(activity);
            if (activityInfo == null) {
                return;
            }
            activityInfo.screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @SuppressLint({"PrivateApi"})
    public static boolean isTranslucentOrFloating(Activity activity) {
        boolean z16;
        boolean z17 = false;
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        try {
            int[] iArr = (int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
            if (iArr == null) {
                return false;
            }
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(iArr);
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, obtainStyledAttributes);
            if (invoke instanceof Boolean) {
                z16 = ((Boolean) invoke).booleanValue();
            } else {
                z16 = false;
            }
            try {
                method.setAccessible(false);
                return z16;
            } catch (Exception e16) {
                z17 = z16;
                e = e16;
                e.printStackTrace();
                return z17;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
