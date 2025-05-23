package com.tencent.mobileqq.util;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class JSONUtils {

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes20.dex */
    public @interface FieldName {
        String value() default "";
    }

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes20.dex */
    public @interface GenericType {
        Class value() default Object.class;
    }

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes20.dex */
    public @interface NotKey {
    }

    public static JSONObject a(Object obj) {
        JSONObject jSONObject = new JSONObject();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int length = declaredFields.length;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                if (Modifier.isPublic(declaredFields[i3].getModifiers())) {
                    declaredFields[i3].setAccessible(true);
                    Object obj2 = declaredFields[i3].get(obj);
                    if (obj2 instanceof PBField) {
                        obj2 = obj2.getClass().getDeclaredMethod("get", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    if (obj2 instanceof List) {
                        JSONArray jSONArray = new JSONArray();
                        for (Object obj3 : (List) obj2) {
                            if (e(obj3)) {
                                jSONArray.mo162put(obj3);
                            } else if (obj3 != null) {
                                jSONArray.mo162put(a(obj3));
                            }
                        }
                        jSONObject.put(declaredFields[i3].getName(), jSONArray);
                    } else if (e(obj2)) {
                        jSONObject.put(declaredFields[i3].getName(), obj2);
                    } else if (obj2 != null) {
                        jSONObject.put(declaredFields[i3].getName(), a(obj2));
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("JSONUtils", 2, "convert error:" + e16);
                }
            }
        }
        return jSONObject;
    }

    public static Object b(JSONObject jSONObject, Class<?> cls) {
        Object obj;
        if (jSONObject == null || cls == null) {
            return null;
        }
        try {
            obj = cls.newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
                String simpleName = field.getType().getSimpleName();
                try {
                    if (jSONObject.has(name)) {
                        field.setAccessible(true);
                        if (simpleName.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                            field.set(obj, Integer.valueOf(jSONObject.getInt(name)));
                        } else if (simpleName.equals(HippyControllerProps.BOOLEAN)) {
                            field.set(obj, Boolean.valueOf(jSONObject.getBoolean(name)));
                        } else if (simpleName.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                            field.set(obj, Long.valueOf(jSONObject.getLong(name)));
                        } else if (simpleName.equals("double")) {
                            field.set(obj, Double.valueOf(jSONObject.getDouble(name)));
                        } else if (simpleName.equals(Entry.DATA_TYPE_STRING)) {
                            field.set(obj, jSONObject.getString(name));
                        } else if (simpleName.equals("String[]")) {
                            JSONArray jSONArray = jSONObject.getJSONArray(name);
                            if (jSONArray.length() > 0) {
                                String[] strArr = new String[jSONArray.length()];
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    strArr[i3] = jSONArray.getString(i3);
                                }
                                field.set(obj, strArr);
                            }
                        }
                    }
                } catch (IllegalAccessException e16) {
                    if (QLog.isDevelopLevel()) {
                        e16.printStackTrace();
                    }
                    return null;
                } catch (JSONException e17) {
                    if (QLog.isDevelopLevel()) {
                        e17.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return obj;
    }

    public static <T> T c(JSONObject jSONObject, Class<T> cls) {
        List list;
        if (jSONObject != null && cls != null) {
            try {
                T newInstance = cls.newInstance();
                for (Field field : cls.getFields()) {
                    String name = field.getName();
                    if (!field.isAnnotationPresent(NotKey.class) && !Modifier.isStatic(field.getModifiers())) {
                        if (field.isAnnotationPresent(FieldName.class)) {
                            name = ((FieldName) field.getAnnotation(FieldName.class)).value();
                        }
                        if (jSONObject.has(name)) {
                            Class<?> type = field.getType();
                            if (d(type)) {
                                field.set(newInstance, jSONObject.get(name));
                            } else if (List.class.isAssignableFrom(type)) {
                                JSONArray jSONArray = jSONObject.getJSONArray(name);
                                if (!field.isAnnotationPresent(GenericType.class)) {
                                    return null;
                                }
                                Class value = ((GenericType) field.getAnnotation(GenericType.class)).value();
                                if (List.class.equals(type)) {
                                    list = new ArrayList();
                                } else {
                                    list = (List) type.newInstance();
                                }
                                field.set(newInstance, list);
                                if (d(value)) {
                                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                        list.add(jSONArray.get(i3));
                                    }
                                } else {
                                    for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                        list.add(c(jSONArray.getJSONObject(i16), value));
                                    }
                                }
                            } else {
                                field.set(jSONObject.getJSONObject(name), type);
                            }
                        }
                    }
                }
                return newInstance;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("JSONUtils", 2, "convert json error\n" + e16);
                }
            }
        }
        return null;
    }

    static boolean d(Class cls) {
        if (!cls.isPrimitive() && !cls.equals(Integer.class) && !cls.equals(Long.class) && !cls.equals(String.class) && !cls.equals(Boolean.class) && !cls.equals(Double.class)) {
            return false;
        }
        return true;
    }

    static boolean e(Object obj) {
        if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            return false;
        }
        return true;
    }
}
