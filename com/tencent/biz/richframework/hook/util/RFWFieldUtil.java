package com.tencent.biz.richframework.hook.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWFieldUtil {
    public static Field getField(Class cls, String str) {
        while (cls != Object.class) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static void setField(Class cls, Object obj, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        if (Modifier.isFinal(declaredField.getModifiers()) && !declaredField.getType().isPrimitive()) {
            Field declaredField2 = Field.class.getDeclaredField("accessFlags");
            declaredField2.setAccessible(true);
            declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
        }
        if (!declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        declaredField.set(obj, obj2);
    }

    public static Object getField(Class cls, Object obj, String str) throws Exception {
        Field field = getField(cls, str);
        if (field != null) {
            return field.get(obj);
        }
        return null;
    }
}
