package com.tencent.mobileqq.jsonconverter;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
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
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static <T> JSONArray a(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (T t16 : list) {
                if (t16 != null) {
                    if (h(t16)) {
                        jSONArray.mo162put(t16);
                    } else if (t16 instanceof List) {
                        jSONArray.mo162put(a((List) t16));
                    } else {
                        jSONArray.mo162put(b(t16));
                    }
                }
            }
        }
        return jSONArray;
    }

    public static <T> JSONObject b(T t16) {
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
                    if (!g(value)) {
                        try {
                            Object obj = field.get(t16);
                            if (obj != null) {
                                if (h(obj)) {
                                    jSONObject.put(value, obj);
                                } else if (obj instanceof List) {
                                    jSONObject.put(value, a((List) obj));
                                } else {
                                    jSONObject.put(value, b(obj));
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

    public static <T> List<T> c(String str, Type type) {
        if (!g(str) && type != null) {
            try {
                return d(new JSONArray(str), type);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static <T> List<T> d(JSONArray jSONArray, Type type) {
        if (jSONArray != null && type != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt != null) {
                    if (opt instanceof JSONObject) {
                        arrayList.add(f((JSONObject) opt, (Class) type));
                    } else if (opt instanceof JSONArray) {
                        arrayList.add(d((JSONArray) opt, ((ParameterizedType) type).getActualTypeArguments()[0]));
                    } else {
                        arrayList.add(opt);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public static <T> T e(String str, Class<T> cls) {
        if (!g(str) && cls != null) {
            try {
                return (T) f(new JSONObject(str), cls);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T f(JSONObject jSONObject, Class<T> cls) {
        T t16;
        Field[] declaredFields;
        Object obj;
        if (jSONObject != null && cls != null) {
            try {
                t16 = cls.newInstance();
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                t16 = null;
                if (t16 != null) {
                    return null;
                }
                while (r4 < r2) {
                }
                return t16;
            } catch (InstantiationException e17) {
                e17.printStackTrace();
                t16 = null;
                if (t16 != null) {
                }
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
                            if (!g(name) && jSONObject.has(name)) {
                                try {
                                    String simpleName = field.getType().getSimpleName();
                                    field.setAccessible(true);
                                    if (PoiListCacheRecord.WEIGHT_TYPE.equals(simpleName)) {
                                        field.set(t16, Integer.valueOf(jSONObject.optInt(name)));
                                    } else if (HippyControllerProps.BOOLEAN.equals(simpleName)) {
                                        field.set(t16, Boolean.valueOf(jSONObject.optBoolean(name)));
                                    } else if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(simpleName)) {
                                        field.set(t16, Long.valueOf(jSONObject.optLong(name)));
                                    } else if ("double".equals(simpleName)) {
                                        field.set(t16, Double.valueOf(jSONObject.optDouble(name)));
                                    } else if ("float".equals(simpleName)) {
                                        field.set(t16, Float.valueOf((float) jSONObject.optDouble(name)));
                                    } else if (Entry.DATA_TYPE_STRING.equals(simpleName)) {
                                        field.set(t16, jSONObject.optString(name));
                                    } else if (Entry.DATA_TYPE_OBJ.equals(simpleName)) {
                                        field.set(t16, new Object());
                                    } else {
                                        Object opt = jSONObject.opt(name);
                                        if (opt instanceof JSONObject) {
                                            obj = f((JSONObject) opt, field.getType());
                                        } else if (opt instanceof JSONArray) {
                                            obj = d((JSONArray) opt, ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
                                        } else {
                                            i("convertFromJSONObject unknown field " + name);
                                            obj = null;
                                        }
                                        field.set(t16, obj);
                                    }
                                } catch (IllegalAccessException e18) {
                                    e18.printStackTrace();
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

    private static boolean g(String str) {
        if (str != null && str.length() > 0) {
            return false;
        }
        return true;
    }

    private static boolean h(Object obj) {
        if (!(obj instanceof Integer) && !(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Long) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Short)) {
            return false;
        }
        return true;
    }

    private static void i(String str) {
        QLog.d("JSONConverter", 2, str);
    }
}
