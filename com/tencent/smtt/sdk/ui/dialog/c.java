package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.FontSettingManager;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static float f369539a = -1.0f;

    /* renamed from: b, reason: collision with root package name */
    private static int f369540b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f369541c = -1;

    public static int a(Context context, float f16) {
        return b(context, (f16 * 160.0f) / 320.0f);
    }

    private static void b(Context context) {
        if (f369539a < 0.0f) {
            try {
                String str = FontSettingManager.TAG;
                Field declaredField = FontSettingManager.class.getDeclaredField("customMetrics");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj instanceof DisplayMetrics) {
                    DisplayMetrics displayMetrics = (DisplayMetrics) obj;
                    f369539a = displayMetrics.density;
                    f369540b = displayMetrics.heightPixels;
                }
            } catch (Exception unused) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                f369539a = displayMetrics2.density;
                f369540b = displayMetrics2.heightPixels;
            }
        }
    }

    public static int a(Context context) {
        if (f369540b == -1) {
            b(context);
        }
        return f369540b;
    }

    private static int b(Context context, float f16) {
        if (f369539a == -1.0f) {
            b(context);
        }
        return (int) ((f16 * f369539a) + 0.5f);
    }
}
