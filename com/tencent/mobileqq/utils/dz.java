package com.tencent.mobileqq.utils;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dz {
    public static void a(Bundle bundle, ClassLoader classLoader) {
        Parcelable parcelable = bundle.getParcelable("android:support:fragments");
        if (parcelable != null) {
            try {
                Class<?> cls = Class.forName("androidx.fragment.app.QFragmentManagerState");
                Class<?> cls2 = Class.forName("androidx.fragment.app.QFragmentState");
                if (cls.isInstance(parcelable)) {
                    b(parcelable, cls2, cls.getDeclaredField("mActive"), classLoader);
                }
            } catch (Exception unused) {
                QLog.d("SavedInstanceStateUtils", 2, "Patch error");
            }
        }
    }

    private static void b(Parcelable parcelable, Class cls, Field field, ClassLoader classLoader) throws IllegalAccessException, NoSuchFieldException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        if (field.getType().isArray()) {
            Object obj = field.get(parcelable);
            int length = Array.getLength(obj);
            for (int i3 = 0; i3 < length; i3++) {
                Object obj2 = Array.get(obj, i3);
                if (obj2 != null && cls.isInstance(obj2)) {
                    Field declaredField = cls.getDeclaredField("mArguments");
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj3 = declaredField.get(obj2);
                    if (obj3 != null && (obj3 instanceof Bundle)) {
                        ((Bundle) obj3).setClassLoader(classLoader);
                    }
                }
            }
        }
    }
}
