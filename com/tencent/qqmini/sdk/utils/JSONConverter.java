package com.tencent.qqmini.sdk.utils;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JSONConverter {
    public static <T> JSONArray convert2JSONArray(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (T t16 : list) {
                if (t16 != null) {
                    if (isPrimitiveType(t16)) {
                        jSONArray.mo162put(t16);
                    } else if (t16 instanceof List) {
                        jSONArray.mo162put(convert2JSONArray((List) t16));
                    } else {
                        jSONArray.mo162put(convert2JSONObject(t16));
                    }
                }
            }
        }
        return jSONArray;
    }

    public static <T> JSONObject convert2JSONObject(T t16) {
        Alias alias;
        JSONObject jSONObject = new JSONObject();
        if (t16 == null) {
            return jSONObject;
        }
        Field[] declaredFields = t16.getClass().getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            for (Field field : declaredFields) {
                if (field != null && (alias = (Alias) field.getAnnotation(Alias.class)) != null) {
                    String value = alias.value();
                    if (!isEmpty(value)) {
                        try {
                            Object obj = field.get(t16);
                            if (obj != null) {
                                if (isPrimitiveType(obj)) {
                                    jSONObject.put(value, obj);
                                } else if (obj instanceof List) {
                                    jSONObject.put(value, convert2JSONArray((List) obj));
                                } else {
                                    jSONObject.put(value, convert2JSONObject(obj));
                                }
                            }
                        } catch (IllegalAccessException e16) {
                            e16.printStackTrace();
                        } catch (JSONException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public static <T> List<T> convertFromJSONArray(String str, Type type) {
        if (!isEmpty(str) && type != null) {
            try {
                return convertFromJSONArray(new JSONArray(str), type);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T convertFromJSONObject(String str, Class<T> cls) {
        if (!isEmpty(str) && cls != null) {
            try {
                return (T) convertFromJSONObject(new JSONObject(str), cls);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    private static boolean isEmpty(String str) {
        if (str != null && str.length() > 0) {
            return false;
        }
        return true;
    }

    private static boolean isPrimitiveType(Object obj) {
        if (!(obj instanceof Integer) && !(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Long) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Short)) {
            return false;
        }
        return true;
    }

    private static void printLog(String str) {
        QMLog.d("JSONConverter", str);
    }

    private static <T> void setField(JSONObject jSONObject, T t16, Field field, String str, String str2) throws IllegalAccessException {
        Object obj;
        if (PoiListCacheRecord.WEIGHT_TYPE.equals(str2)) {
            field.set(t16, Integer.valueOf(jSONObject.optInt(str)));
            return;
        }
        if (HippyControllerProps.BOOLEAN.equals(str2)) {
            field.set(t16, Boolean.valueOf(jSONObject.optBoolean(str)));
            return;
        }
        if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(str2)) {
            field.set(t16, Long.valueOf(jSONObject.optLong(str)));
            return;
        }
        if ("double".equals(str2)) {
            field.set(t16, Double.valueOf(jSONObject.optDouble(str)));
            return;
        }
        if ("float".equals(str2)) {
            field.set(t16, Float.valueOf((float) jSONObject.optDouble(str)));
            return;
        }
        if (Entry.DATA_TYPE_STRING.equals(str2)) {
            field.set(t16, jSONObject.optString(str));
            return;
        }
        if (Entry.DATA_TYPE_OBJ.equals(str2)) {
            field.set(t16, new Object());
            return;
        }
        Object opt = jSONObject.opt(str);
        if (opt instanceof JSONObject) {
            obj = convertFromJSONObject((JSONObject) opt, field.getType());
        } else if (opt instanceof JSONArray) {
            obj = convertFromJSONArray((JSONArray) opt, ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
        } else {
            printLog("convertFromJSONObject unknown field " + str);
            obj = null;
        }
        field.set(t16, obj);
    }

    public static <T> List<T> convertFromJSONArray(JSONArray jSONArray, Type type) {
        if (jSONArray == null || type == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object opt = jSONArray.opt(i3);
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    arrayList.add(convertFromJSONObject((JSONObject) opt, (Class) type));
                } else if (opt instanceof JSONArray) {
                    arrayList.add(convertFromJSONArray((JSONArray) opt, ((ParameterizedType) type).getActualTypeArguments()[0]));
                } else {
                    arrayList.add(opt);
                }
            }
        }
        return arrayList;
    }

    public static <T> T convertFromJSONObject(JSONObject jSONObject, Class<T> cls) {
        T t16;
        Field[] declaredFields;
        if (jSONObject != null && cls != null) {
            try {
                t16 = cls.newInstance();
            } catch (Exception e16) {
                e16.printStackTrace();
                t16 = null;
            }
            if (t16 != null && (declaredFields = cls.getDeclaredFields()) != null && declaredFields.length != 0) {
                for (Field field : declaredFields) {
                    if (field != null) {
                        int modifiers = field.getModifiers();
                        if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
                            String name = field.getName();
                            Alias alias = (Alias) field.getAnnotation(Alias.class);
                            if (alias != null) {
                                name = alias.value();
                            }
                            if (!isEmpty(name) && jSONObject.has(name)) {
                                try {
                                    String simpleName = field.getType().getSimpleName();
                                    field.setAccessible(true);
                                    setField(jSONObject, t16, field, name, simpleName);
                                } catch (IllegalAccessException e17) {
                                    e17.printStackTrace();
                                    return null;
                                }
                            }
                        }
                    }
                }
                return t16;
            }
        }
        return null;
    }
}
