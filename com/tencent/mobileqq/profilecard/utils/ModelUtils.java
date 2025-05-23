package com.tencent.mobileqq.profilecard.utils;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ModelUtils {
    private static final String TAG = "ModelUtils";

    public static Object mapToObject(Map<String, Object> map, Class<?> cls) {
        Object obj = null;
        if (map == null) {
            return null;
        }
        try {
            obj = cls.newInstance();
            for (Field field : obj.getClass().getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
                    field.setAccessible(true);
                    if (map.containsKey(field.getName())) {
                        field.set(obj, map.get(field.getName()));
                    } else {
                        QLog.e("ModelUtils", 1, String.format("mapToObject, %s.%s is null", cls.getSimpleName(), field.getName()));
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return obj;
    }

    public static Map objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                hashMap.put(field.getName(), field.get(obj));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }
}
