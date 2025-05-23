package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WeJson {
    static IPatchRedirector $redirector_ = null;
    private static final String EMPTY_ARR = "[]";
    private static final String EMPTY_MAP = "{}";

    public WeJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private <T> T fromArr(JSONArray jSONArray, Class<T> cls) {
        Class<?> componentType = cls.getComponentType();
        T t16 = (T) Array.newInstance(componentType, jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Array.set(t16, i3, fromJsonData(getObject(jSONArray, i3), componentType, componentType));
        }
        return t16;
    }

    private <T> T fromJsonArr(JSONArray jSONArray, Class<T> cls, Class<?> cls2) {
        if (cls.equals(List.class)) {
            return (T) fromList(jSONArray, cls, cls2);
        }
        if (cls.isArray()) {
            return (T) fromArr(jSONArray, cls);
        }
        throw new WeJsonException("json \u89e3\u6790\u9519\u8bef:\u4e0d\u652f\u6301\u7684\u7c7b\u578b:" + cls.getName());
    }

    private Object fromJsonData(Object obj, Class<?> cls, Class<?> cls2) {
        if (obj instanceof JSONArray) {
            return fromJsonArr((JSONArray) obj, cls, cls2);
        }
        if (obj instanceof JSONObject) {
            return fromJsonObj((JSONObject) obj, cls, cls2);
        }
        return obj;
    }

    private <T> T fromJsonObj(JSONObject jSONObject, Class<T> cls, Class<?> cls2) {
        if (cls.equals(Map.class)) {
            return (T) fromMap(jSONObject, cls, cls2);
        }
        return (T) fromPojo(jSONObject, cls);
    }

    private List fromList(JSONArray jSONArray, Class<List> cls, Class<?> cls2) {
        List newInstance;
        if (cls2 != null) {
            if (cls.getName().equals("java.util.List")) {
                newInstance = new ArrayList();
            } else {
                try {
                    newInstance = cls.newInstance();
                } catch (Exception e16) {
                    throw new WeJsonException("\u521b\u5efaList\u7c7b\u578b\u5931\u8d25,\u8be5\u5217\u8868\u4e0d\u652f\u6301\u65e0\u53c2\u5b9e\u4f8b\u5316", e16);
                }
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object object = getObject(jSONArray, i3);
                if (object instanceof JSONArray) {
                    newInstance.add(fromJsonArr((JSONArray) object, cls, cls2));
                } else if (object instanceof JSONObject) {
                    newInstance.add(fromJsonObj((JSONObject) object, cls, cls2));
                } else {
                    newInstance.add(object);
                }
            }
            return newInstance;
        }
        throw new WeJsonException("\u65e0\u6cd5\u786e\u5b9a\u5217\u8868\u9879\u7684\u7c7b\u578b");
    }

    private Map fromMap(JSONObject jSONObject, Class<Map> cls, Class<?> cls2) {
        Map newInstance;
        if (cls2 != null) {
            if (cls.getName().equals("java.util.Map")) {
                newInstance = new HashMap();
            } else {
                try {
                    newInstance = cls.newInstance();
                } catch (Exception e16) {
                    throw new WeJsonException("\u521b\u5efaMap\u7c7b\u578b\u5931\u8d25,\u8be5Map\u4e0d\u652f\u6301\u65e0\u53c2\u5b9e\u4f8b\u5316", e16);
                }
            }
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object object = getObject(jSONObject, str);
                if (object != null) {
                    newInstance.put(str, fromJsonData(object, cls, cls2));
                } else {
                    newInstance.put(str, null);
                }
            }
            return newInstance;
        }
        throw new WeJsonException("\u65e0\u6cd5\u786e\u5b9a\u5217\u8868\u9879\u7684\u7c7b\u578b");
    }

    private <T> T fromPojo(JSONObject jSONObject, Class<T> cls) {
        String substring;
        Field[] declaredFields = cls.getDeclaredFields();
        Class<? super T> superclass = cls.getSuperclass();
        Field[] fieldArr = new Field[0];
        if (superclass != null) {
            fieldArr = superclass.getDeclaredFields();
        }
        int length = declaredFields.length + fieldArr.length;
        Field[] fieldArr2 = new Field[length];
        for (int i3 = 0; i3 < declaredFields.length; i3++) {
            fieldArr2[i3] = declaredFields[i3];
        }
        for (int length2 = declaredFields.length; length2 < length; length2++) {
            fieldArr2[length2] = fieldArr[length2 - declaredFields.length];
        }
        if (length == 0) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            for (int i16 = 0; i16 < length; i16++) {
                Field field = fieldArr2[i16];
                String name = field.getName();
                if (!name.contains("$")) {
                    int modifiers = field.getModifiers();
                    Object opt = jSONObject.opt(name);
                    if (opt == null) {
                        continue;
                    } else {
                        Object fromJsonData = fromJsonData(opt, getMemberType(cls, field), getSubType(cls, field, opt));
                        if (JSONObject.NULL.equals(fromJsonData)) {
                            fromJsonData = null;
                        }
                        if ((modifiers & 1) != 0) {
                            try {
                                field.set(newInstance, fromJsonData);
                            } catch (IllegalAccessException e16) {
                                throw new WeJsonException("\u8bbe\u7f6e\u6210\u5458\u53d8\u91cf\u503c\u5931\u8d25.", e16);
                            }
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("set");
                            sb5.append(name.substring(0, 1).toUpperCase());
                            if (name.length() == 1) {
                                substring = "";
                            } else {
                                substring = name.substring(1);
                            }
                            sb5.append(substring);
                            try {
                                try {
                                    cls.getMethod(sb5.toString(), field.getType()).invoke(newInstance, fromJsonData);
                                } catch (Exception e17) {
                                    throw new WeJsonException("\u8c03\u7528set\u65b9\u6cd5\u5931\u8d25.", e17);
                                }
                            } catch (NoSuchMethodException e18) {
                                e18.printStackTrace();
                            }
                        }
                    }
                }
            }
            return newInstance;
        } catch (Exception e19) {
            throw new WeJsonException("\u5fc5\u987b\u4e3a\u8be5\u7c7b\u578b\u63d0\u4f9b\u4e00\u4e2a\u65e0\u53c2\u6784\u9020\u65b9\u6cd5:" + cls.getName(), e19);
        }
    }

    private <T> Class<?> getMemberType(Class<T> cls, Field field) {
        if (field.getGenericType() instanceof TypeVariable) {
            cls.getTypeParameters();
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    return (Class) type;
                }
                throw new WeJsonException("\u4e0d\u652f\u6301\u5d4c\u5957\u6cdb\u578b");
            }
            throw new WeJsonException("\u7f3a\u5c11\u6cdb\u578b\u4fe1\u606f:" + cls);
        }
        return field.getType();
    }

    private Object getObject(JSONArray jSONArray, int i3) {
        try {
            return jSONArray.get(i3);
        } catch (JSONException e16) {
            throw new WeJsonException("JSONArray.get() cause JSONException", e16);
        }
    }

    private <T> Class<?> getSubType(Class<T> cls, Field field, Object obj) {
        if (field.getGenericType() instanceof TypeVariable) {
            cls.getTypeParameters();
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    return (Class) type;
                }
                throw new WeJsonException("\u4e0d\u652f\u6301\u5d4c\u5957\u6cdb\u578b");
            }
            throw new WeJsonException("\u7f3a\u5c11\u6cdb\u578b\u4fe1\u606f:" + cls);
        }
        if (field.getType().equals(List.class)) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (Class) type2;
                }
                throw new WeJsonException("\u4e0d\u652f\u6301\u5d4c\u5957\u6cdb\u578b:" + field.getName());
            }
            throw new WeJsonException("\u7f3a\u5c11\u6cdb\u578b\u7c7b\u578b\u58f0\u660e:" + field.getName());
        }
        if (field.getType().equals(Map.class)) {
            Type genericType2 = field.getGenericType();
            if (genericType2 instanceof ParameterizedType) {
                Type type3 = ((ParameterizedType) genericType2).getActualTypeArguments()[1];
                if (type3 instanceof Class) {
                    return (Class) type3;
                }
                throw new WeJsonException("\u4e0d\u652f\u6301\u5d4c\u5957\u6cdb\u578b:" + field.getName());
            }
            throw new WeJsonException("\u7f3a\u5c11\u6cdb\u578b\u7c7b\u578b\u58f0\u660e:" + field.getName());
        }
        return field.getType();
    }

    private String getValidStr(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\n", RedTouch.NEWLINE_CHAR).replace("\r", "\\r").replace("\f", "\\f").replace("\t", "\\t");
    }

    private <T> boolean isPrimitivePackageType(T t16) {
        if (!(t16 instanceof Integer) && !(t16 instanceof Short) && !(t16 instanceof Long) && !(t16 instanceof Byte) && !(t16 instanceof Boolean) && !(t16 instanceof Float) && !(t16 instanceof Double) && !(t16 instanceof Character)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void process(StringBuilder sb5, T t16) {
        if (t16.getClass().isPrimitive()) {
            sb5.append(t16);
            return;
        }
        if (t16 instanceof String) {
            sb5.append('\"');
            sb5.append(getValidStr((String) t16));
            sb5.append('\"');
        } else {
            if (isPrimitivePackageType(t16)) {
                sb5.append(t16);
                return;
            }
            if (t16.getClass().isArray()) {
                processArr(sb5, (Object[]) t16);
                return;
            }
            if (t16 instanceof Iterable) {
                processIterable(sb5, (Iterable) t16);
            } else if (t16 instanceof Map) {
                processMap(sb5, (Map) t16);
            } else {
                processObj(sb5, t16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processArr(StringBuilder sb5, Object[] objArr) {
        if (objArr.length == 0) {
            sb5.append("[]");
            return;
        }
        sb5.append('[');
        for (int i3 = 0; i3 < objArr.length; i3++) {
            process(sb5, objArr[i3]);
            if (i3 < objArr.length - 1) {
                sb5.append(',');
            }
        }
        sb5.append(']');
    }

    private void processIterable(StringBuilder sb5, Iterable iterable) {
        Iterator it = iterable.iterator();
        sb5.append('[');
        int i3 = 0;
        while (it.hasNext()) {
            i3++;
            process(sb5, it.next());
            sb5.append(',');
        }
        if (i3 > 0) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        sb5.append(']');
    }

    private void processMap(StringBuilder sb5, Map<String, Object> map) {
        if (map.size() == 0) {
            sb5.append("{}");
            return;
        }
        sb5.append('{');
        int size = map.size();
        int i3 = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (key != null && !key.equals("") && value != null && (!(value instanceof String) || !entry.equals(""))) {
                sb5.append('\"');
                sb5.append(key);
                sb5.append('\"');
                sb5.append(':');
                process(sb5, value);
                if (i3 < size - 1) {
                    sb5.append(',');
                }
                i3++;
            }
        }
        sb5.append('}');
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processObj(StringBuilder sb5, T t16) {
        Object invoke;
        Field[] declaredFields = t16.getClass().getDeclaredFields();
        Field[] declaredFields2 = t16.getClass().getSuperclass().getDeclaredFields();
        int length = declaredFields.length + declaredFields2.length;
        Field[] fieldArr = new Field[length];
        int i3 = 0;
        for (int i16 = 0; i16 < declaredFields.length; i16++) {
            fieldArr[i16] = declaredFields[i16];
        }
        for (int length2 = declaredFields.length; length2 < length; length2++) {
            fieldArr[length2] = declaredFields2[length2 - declaredFields.length];
        }
        if (length == 0) {
            sb5.append("{}");
            return;
        }
        HashMap hashMap = new HashMap();
        int i17 = 0;
        while (true) {
            String str = "";
            if (i17 >= length) {
                break;
            }
            try {
                Field field = fieldArr[i17];
                int modifiers = field.getModifiers();
                if ((modifiers & 8) == 0) {
                    String name = field.getName();
                    if (!name.contains("$")) {
                        if ((modifiers & 1) != 0) {
                            Object obj = field.get(t16);
                            if (obj != null) {
                                hashMap.put(name, obj);
                            }
                        } else {
                            Class<?> cls = t16.getClass();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("get");
                            sb6.append(name.substring(0, 1).toUpperCase());
                            if (name.length() != 1) {
                                str = name.substring(1);
                            }
                            sb6.append(str);
                            Method method = cls.getMethod(sb6.toString(), new Class[0]);
                            if (method != null && (invoke = method.invoke(t16, new Object[0])) != null) {
                                hashMap.put(name, invoke);
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            i17++;
        }
        sb5.append('{');
        int size = hashMap.size();
        for (Map.Entry entry : hashMap.entrySet()) {
            i3++;
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            if ((value instanceof String) && value.equals("")) {
                if (str2.equals("image")) {
                    value = "";
                }
            }
            sb5.append('\"');
            sb5.append(str2);
            sb5.append('\"');
            sb5.append(':');
            process(sb5, value);
            if (i3 < size) {
                sb5.append(',');
            }
        }
        sb5.append('}');
    }

    public <T> T fromJson(String str, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) cls);
        }
        if (str == null) {
            return null;
        }
        if (cls != null) {
            String trim = str.trim();
            if (trim.startsWith("[")) {
                try {
                    T t16 = (T) fromJsonArr(new JSONArray(trim), cls, null);
                    if (t16 != null) {
                        return t16;
                    }
                } catch (Exception e16) {
                    throw new WeJsonException("json \u89e3\u6790\u9519\u8bef" + e16.getMessage(), e16);
                }
            } else if (trim.startsWith("{")) {
                try {
                    return (T) fromJsonObj(new JSONObject(trim), cls, null);
                } catch (Exception e17) {
                    throw new WeJsonException("json \u89e3\u6790\u9519\u8bef:" + e17.getMessage(), e17);
                }
            }
            throw new WeJsonException("classOfT \u6307\u5b9a\u9519\u8bef");
        }
        throw new WeJsonException("\u5fc5\u987b\u6307\u5b9aclassOfT");
    }

    public <T> String toJson(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? toJson(t16, 0) : (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
    }

    public <T> String toJson(T t16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16, i3);
        }
        if (t16 == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        process(sb5, t16);
        return sb5.toString();
    }

    private Object getObject(JSONObject jSONObject, String str) {
        try {
            return jSONObject.get(str);
        } catch (JSONException e16) {
            throw new WeJsonException("JSONObject.get() cause JSONException", e16);
        }
    }
}
