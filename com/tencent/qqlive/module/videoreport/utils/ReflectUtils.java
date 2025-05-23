package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.module.videoreport.Log;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Object getField(Class<?> cls, String str, Object obj) {
        try {
            return getFieldWithException(cls, str, obj);
        } catch (Exception e16) {
            Log.e(TAG, "getField " + e16);
            return null;
        }
    }

    public static Object getFieldWithException(Class<?> cls, String str, Object obj) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object getField(Class<?> cls, String str) {
        try {
            return getFieldWithException(cls, str, null);
        } catch (Exception e16) {
            Log.e(TAG, "getField " + e16);
            return null;
        }
    }

    public static <T> T getField(String str, Object obj) {
        try {
            Field field = obj.getClass().getField(str);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }
}
