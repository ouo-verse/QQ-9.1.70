package com.tencent.ad.tangram.json;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdJSONHelper {

    @NonNull
    private static Map<Class, Class> PRIMITIVE_CLASSES = new HashMap<Class, Class>() { // from class: com.tencent.ad.tangram.json.AdJSONHelper.1
        {
            put(Boolean.TYPE, Boolean.class);
            put(Character.TYPE, Character.class);
            put(Byte.TYPE, Byte.class);
            put(Short.TYPE, Short.class);
            put(Integer.TYPE, Integer.class);
            put(Long.TYPE, Long.class);
            put(Float.TYPE, Float.class);
            put(Double.TYPE, Double.class);
            put(Void.TYPE, Void.class);
        }
    };

    AdJSONHelper() {
    }

    @Nullable
    public static Field getField(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Field field : getFields(cls)) {
            if (TextUtils.equals(field.getName(), str)) {
                return field;
            }
        }
        return null;
    }

    @NonNull
    public static Set<Field> getFields(Class cls) {
        HashSet<Field> hashSet = new HashSet();
        while (cls != null && cls != Object.class && cls.getName().indexOf("android") != 0 && cls.getName().indexOf(ResourceAttributes.TelemetrySdkLanguageValues.JAVA) != 0) {
            try {
                hashSet.addAll(Arrays.asList(cls.getDeclaredFields()));
            } catch (Throwable unused) {
            }
            cls = cls.getSuperclass();
        }
        HashSet hashSet2 = new HashSet();
        for (Field field : hashSet) {
            if (!Modifier.isFinal(field.getModifiers())) {
                hashSet2.add(field);
            }
        }
        return hashSet2;
    }

    public static boolean isClass(Type type, @NonNull Class[] clsArr) {
        if (!(type instanceof Class)) {
            return false;
        }
        Class cls = (Class) Class.class.cast(type);
        for (Class cls2 : clsArr) {
            if (TextUtils.equals(cls2.getName(), cls.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberClass(Class cls) {
        Class wrapClass = wrapClass(cls);
        if (wrapClass != Short.class && wrapClass != Integer.class && wrapClass != Long.class && wrapClass != Float.class && wrapClass != Double.class) {
            return false;
        }
        return true;
    }

    public static boolean isPrimitiveClass(Class cls) {
        for (Class cls2 : PRIMITIVE_CLASSES.keySet()) {
            if (cls == cls2 || cls == PRIMITIVE_CLASSES.get(cls2)) {
                return true;
            }
        }
        return false;
    }

    public static Class wrapClass(Class cls) {
        Class cls2 = PRIMITIVE_CLASSES.get(cls);
        if (cls2 != null) {
            return cls2;
        }
        return cls;
    }
}
