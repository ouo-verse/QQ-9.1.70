package com.tencent.biz.qui.quicommon;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Method f95158a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f95159b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f95160c;

    static {
        try {
            f95158a = Class.class.getDeclaredMethod("forName", String.class);
            f95159b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f95160c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable unused) {
            ud0.d.b(ReflectionUtil.TAG, ud0.d.f438811e, "init throw t");
        }
    }

    private static boolean a() {
        if (f95158a != null && f95159b != null && f95160c != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Object b(@NonNull Object obj, @NonNull String str, @NonNull String str2, Object obj2) {
        if (a()) {
            try {
                Field field = (Field) f95160c.invoke((Class) f95158a.invoke(null, str), str2);
                field.setAccessible(true);
                return field.get(obj);
            } catch (Throwable th5) {
                Log.e(ReflectionUtil.TAG, "getFiled throw t", th5);
                return obj2;
            }
        }
        return obj2;
    }

    @Nullable
    public static Field c(@NonNull String str, @NonNull String str2) {
        Field field;
        Field field2 = null;
        if (!a()) {
            return null;
        }
        try {
            field = (Field) f95160c.invoke((Class) f95158a.invoke(null, str), str2);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            field.setAccessible(true);
            return field;
        } catch (Throwable th6) {
            th = th6;
            field2 = field;
            Log.e(ReflectionUtil.TAG, "getFiled throw t", th);
            return field2;
        }
    }
}
