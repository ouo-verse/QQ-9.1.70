package com.tencent.qqmini.sdk.utils;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
/* loaded from: classes23.dex */
public class JSONUtils {
    static final String TAG = "JSONUtils";

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface FieldName {
        String value() default "";
    }

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface GenericType {
        Class value() default Object.class;
    }

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface NotKey {
    }

    public static JSONObject convert2JSON(Object obj) {
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
                            if (isBaseType(obj3)) {
                                jSONArray.mo162put(obj3);
                            } else if (obj3 != null) {
                                jSONArray.mo162put(convert2JSON(obj3));
                            }
                        }
                        jSONObject.put(declaredFields[i3].getName(), jSONArray);
                    } else if (isBaseType(obj2)) {
                        jSONObject.put(declaredFields[i3].getName(), obj2);
                    } else if (obj2 != null) {
                        jSONObject.put(declaredFields[i3].getName(), convert2JSON(obj2));
                    }
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "convert error:" + e16);
            }
        }
        return jSONObject;
    }

    public static Object convertFrom(JSONObject jSONObject, Class<?> cls) {
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
            if ((!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) && !jsonToField(jSONObject, obj, field, name)) {
                return null;
            }
        }
        return obj;
    }

    public static <T> T convertFromJsonObject(JSONObject jSONObject, Class<T> cls) {
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
                            if (isBaseType((Class) type)) {
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
                                if (isBaseType(value)) {
                                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                        list.add(jSONArray.get(i3));
                                    }
                                } else {
                                    for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                        list.add(convertFromJsonObject(jSONArray.getJSONObject(i16), value));
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
                QMLog.e(TAG, "convert json error\n" + e16);
            }
        }
        return null;
    }

    public static JSONObject convertTo(Object obj) {
        if (obj == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            try {
                for (Field field : declaredFields) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
                        String name = field.getName();
                        String simpleName = field.getType().getSimpleName();
                        if (simpleName.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                            jSONObject.put(name, field.getInt(obj));
                        } else if (simpleName.equals(HippyControllerProps.BOOLEAN)) {
                            jSONObject.put(name, field.getBoolean(obj));
                        } else if (simpleName.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                            jSONObject.put(name, field.getLong(obj));
                        } else if (simpleName.equals("double")) {
                            jSONObject.put(name, field.getDouble(obj));
                        } else if (simpleName.equals(Entry.DATA_TYPE_STRING)) {
                            jSONObject.put(name, (String) field.get(obj));
                        }
                    }
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return jSONObject;
    }

    static boolean isBaseType(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double);
    }

    private static boolean jsonToField(JSONObject jSONObject, Object obj, Field field, String str) {
        String simpleName = field.getType().getSimpleName();
        try {
            if (jSONObject.has(str)) {
                field.setAccessible(true);
                if (simpleName.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                    field.set(obj, Integer.valueOf(jSONObject.getInt(str)));
                } else if (simpleName.equals(HippyControllerProps.BOOLEAN)) {
                    field.set(obj, Boolean.valueOf(jSONObject.getBoolean(str)));
                } else if (simpleName.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                    field.set(obj, Long.valueOf(jSONObject.getLong(str)));
                } else if (simpleName.equals("double")) {
                    field.set(obj, Double.valueOf(jSONObject.getDouble(str)));
                } else if (simpleName.equals(Entry.DATA_TYPE_STRING)) {
                    field.set(obj, jSONObject.getString(str));
                } else if (simpleName.equals("String[]")) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    if (jSONArray.length() > 0) {
                        String[] strArr = new String[jSONArray.length()];
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            strArr[i3] = jSONArray.getString(i3);
                        }
                        field.set(obj, strArr);
                    }
                }
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    static boolean isBaseType(Class cls) {
        return cls.isPrimitive() || cls.equals(Integer.class) || cls.equals(Long.class) || cls.equals(String.class) || cls.equals(Boolean.class) || cls.equals(Double.class);
    }
}
