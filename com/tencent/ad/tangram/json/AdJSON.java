package com.tencent.ad.tangram.json;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public class AdJSON {
    @Nullable
    private static JSONArray fromArrayObject(@NonNull Object obj, @NonNull Set<Object> set) throws Exception {
        if (AdJSONHelper.wrapClass(obj.getClass()).isArray()) {
            if (set.contains(obj)) {
                return null;
            }
            set.add(obj);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < Array.getLength(obj); i3++) {
                Object fromObject = fromObject(Array.get(obj, i3), set);
                if (fromObject != null && !JSONObject.NULL.equals(fromObject)) {
                    jSONArray.put(i3, fromObject);
                } else {
                    jSONArray.put(i3, JSONObject.NULL);
                }
            }
            set.remove(obj);
            return jSONArray;
        }
        throw new Exception("not an array");
    }

    @Nullable
    private static JSONObject fromClassObject(@NonNull Object obj, @NonNull Set<Object> set) throws Exception {
        if (set.contains(obj)) {
            return null;
        }
        set.add(obj);
        Class wrapClass = AdJSONHelper.wrapClass(obj.getClass());
        JSONObject jSONObject = new JSONObject();
        for (Field field : AdJSONHelper.getFields(wrapClass)) {
            if (!TextUtils.equals(field.getName(), "this$0") && !TextUtils.equals(field.getName(), "$change") && !TextUtils.equals(field.getName(), "serialVersionUID")) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                field.setAccessible(isAccessible);
                Object fromObject = fromObject(obj2, set);
                if (fromObject != null || JSONObject.NULL.equals(fromObject)) {
                    jSONObject.put(field.getName(), fromObject);
                }
            }
        }
        set.remove(obj);
        return jSONObject;
    }

    private static Object fromNumberObject(@NonNull Object obj) throws Exception {
        Class wrapClass = AdJSONHelper.wrapClass(obj.getClass());
        if (AdJSONHelper.isNumberClass(wrapClass)) {
            if (wrapClass == Short.class) {
                return Integer.valueOf(((Short) Short.class.cast(obj)).shortValue());
            }
            if (wrapClass == Integer.class) {
                return Integer.class.cast(obj);
            }
            if (wrapClass == Long.class) {
                return obj.toString();
            }
            if (wrapClass == Float.class) {
                return Double.valueOf(((Float) Float.class.cast(obj)).floatValue());
            }
            if (wrapClass == Double.class) {
                return Double.class.cast(obj);
            }
            throw new Exception("not supported");
        }
        throw new Exception("not a number");
    }

    @Nullable
    public static Object fromObject(Object obj) throws Exception {
        return fromObject(obj, new HashSet());
    }

    private static Object fromPrimitiveObject(@NonNull Object obj) throws Exception {
        Class wrapClass = AdJSONHelper.wrapClass(obj.getClass());
        if (AdJSONHelper.isPrimitiveClass(wrapClass)) {
            if (wrapClass == Boolean.class) {
                return Boolean.class.cast(obj);
            }
            if (wrapClass == Character.class) {
                return String.valueOf(Character.class.cast(obj));
            }
            if (wrapClass != Byte.class) {
                if (AdJSONHelper.isNumberClass(wrapClass)) {
                    return fromNumberObject(obj);
                }
                throw new Exception("not supported");
            }
            throw new Exception("not supported");
        }
        throw new Exception("not primitive");
    }

    private static Object toArrayObject(@NonNull JSONArray jSONArray, @NonNull Class cls) throws Exception {
        Object obj;
        if (cls.isArray()) {
            Object newInstance = Array.newInstance(cls.getComponentType(), jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object obj2 = jSONArray.get(i3);
                if (obj2 != null && !JSONObject.NULL.equals(obj2)) {
                    obj = toObject(obj2, cls.getComponentType());
                } else {
                    obj = null;
                }
                Array.set(newInstance, i3, obj);
            }
            return newInstance;
        }
        throw new Exception("not an array");
    }

    private static Boolean toBooleanObject(@NonNull Object obj, Class cls) throws Exception {
        if (AdJSONHelper.wrapClass(cls) == Boolean.class) {
            if (AdJSONHelper.wrapClass(obj.getClass()) == Boolean.class) {
                return (Boolean) Boolean.class.cast(obj);
            }
            throw new Exception("format error");
        }
        throw new Exception("not boolean");
    }

    @Nullable
    private static Character toCharacterbject(@NonNull Object obj, Class cls) throws Exception {
        if (AdJSONHelper.wrapClass(cls) == Character.class) {
            if (AdJSONHelper.wrapClass(obj.getClass()) == Character.class) {
                return (Character) Character.class.cast(obj);
            }
            if (obj instanceof String) {
                String str = (String) String.class.cast(obj);
                if (str.length() == 0) {
                    return null;
                }
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new Exception("format error");
            }
            throw new Exception("format error");
        }
        throw new Exception("not a character");
    }

    private static Object toClassObject(@NonNull JSONObject jSONObject, @NonNull Class cls) throws Exception {
        Object obj;
        if (!AdJSONHelper.isPrimitiveClass(cls) && cls != String.class) {
            Object newInstance = cls.newInstance();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Field field = AdJSONHelper.getField(cls, str);
                if (field != null) {
                    Object obj2 = jSONObject.get(str);
                    if (obj2 != null && !JSONObject.NULL.equals(obj2)) {
                        obj = toObject(obj2, field.getType());
                    } else {
                        obj = null;
                    }
                    boolean isAccessible = field.isAccessible();
                    field.setAccessible(true);
                    field.set(newInstance, obj);
                    field.setAccessible(isAccessible);
                }
            }
            return newInstance;
        }
        throw new Exception("not a class");
    }

    private static Object toNumberObject(@NonNull Object obj, Class cls) throws Exception {
        Class wrapClass = AdJSONHelper.wrapClass(cls);
        if (AdJSONHelper.isNumberClass(wrapClass)) {
            Class wrapClass2 = AdJSONHelper.wrapClass(obj.getClass());
            Class[] clsArr = {Short.class, Integer.class, Long.class};
            Class[] clsArr2 = {Float.class, Double.class};
            if (AdJSONHelper.isClass(wrapClass, clsArr) && (AdJSONHelper.isClass(wrapClass2, clsArr) || wrapClass2 == String.class)) {
                return wrapClass.getDeclaredMethod("valueOf", String.class).invoke(wrapClass, obj.toString());
            }
            if (wrapClass == Float.class) {
                if (wrapClass2 == Float.class) {
                    return obj;
                }
                if (wrapClass2 == Double.class) {
                    double doubleValue = ((Double) Double.class.cast(obj)).doubleValue();
                    if (doubleValue >= -3.4028234663852886E38d && doubleValue <= 3.4028234663852886E38d) {
                        return wrapClass.getDeclaredMethod("valueOf", String.class).invoke(wrapClass, obj.toString());
                    }
                    throw new Exception("out of range");
                }
                if (AdJSONHelper.isClass(wrapClass2, clsArr)) {
                    return toNumberObject(Double.valueOf(obj.toString()), wrapClass);
                }
                if (wrapClass2 == String.class) {
                    float floatValue = Float.valueOf(obj.toString()).floatValue();
                    if (floatValue >= -3.4028235E38f && floatValue <= Float.MAX_VALUE) {
                        return Float.valueOf(floatValue);
                    }
                    throw new Exception("out of range");
                }
                throw new Exception("format error");
            }
            if (wrapClass == Double.class && (AdJSONHelper.isClass(wrapClass2, clsArr) || AdJSONHelper.isClass(wrapClass2, clsArr2) || wrapClass2 == String.class)) {
                return wrapClass.getDeclaredMethod("valueOf", String.class).invoke(wrapClass, obj.toString());
            }
            throw new Exception("format error");
        }
        throw new Exception("not a number");
    }

    @Nullable
    public static Object toObject(@Nullable Object obj, @Nullable Class cls) throws Exception {
        if (cls != null) {
            if (obj == null) {
                return null;
            }
            if (AdJSONHelper.isPrimitiveClass(cls)) {
                return toPrimitiveObject(obj, cls);
            }
            if (cls == String.class) {
                return toStringObject(obj, cls);
            }
            if (cls.isArray()) {
                return toArrayObject((JSONArray) JSONArray.class.cast(obj), cls);
            }
            if (obj.getClass() == JSONObject.class) {
                return toClassObject((JSONObject) JSONObject.class.cast(obj), cls);
            }
            throw new Exception("format error");
        }
        throw new Exception("cls can not be null");
    }

    @Nullable
    private static Object toPrimitiveObject(@NonNull Object obj, Class cls) throws Exception {
        Class wrapClass = AdJSONHelper.wrapClass(cls);
        if (AdJSONHelper.isPrimitiveClass(wrapClass)) {
            if (wrapClass == Boolean.class) {
                return toBooleanObject(obj, wrapClass);
            }
            if (wrapClass == Character.class) {
                return toCharacterbject(obj, wrapClass);
            }
            if (wrapClass != Byte.class) {
                if (AdJSONHelper.isNumberClass(wrapClass)) {
                    return toNumberObject(obj, wrapClass);
                }
                throw new Exception("not supported");
            }
            throw new Exception("byte is not supported");
        }
        throw new Exception("not primitive");
    }

    private static String toStringObject(Object obj, Class cls) throws Exception {
        if (cls == String.class) {
            if (obj instanceof String) {
                return (String) String.class.cast(obj);
            }
            throw new Exception("format error");
        }
        throw new Exception("not a string");
    }

    @Nullable
    private static Object fromObject(@Nullable Object obj, @Nullable Set<Object> set) throws Exception {
        if (obj == null) {
            return null;
        }
        if (set != null) {
            Class wrapClass = AdJSONHelper.wrapClass(obj.getClass());
            if (AdJSONHelper.isPrimitiveClass(wrapClass)) {
                return fromPrimitiveObject(obj);
            }
            if (wrapClass == String.class) {
                return String.valueOf(obj);
            }
            if (wrapClass.isArray()) {
                return fromArrayObject(obj, set);
            }
            return fromClassObject(obj, set);
        }
        throw new Exception("objects can not be null");
    }
}
