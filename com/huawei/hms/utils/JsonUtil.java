package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JsonUtil {
    protected static final int VAL_BYTE = 2;
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_MAP = 3;
    protected static final int VAL_NULL = -1;
    protected static final String VAL_TYPE = "_val_type_";

    private static String a(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean isAccessible = field.isAccessible();
                    a(field, true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    a(field, isAccessible);
                    a(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    private static Object b(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object a16 = a(field.getName(), jSONObject);
        if (a16 != null) {
            try {
                if (field.getType().getName().startsWith("com.huawei") && (field.getType().newInstance() instanceof IMessageEntity)) {
                    return jsonToEntity((String) a16, (IMessageEntity) field.getType().newInstance());
                }
                if (!(a16 instanceof JSONObject) || !((JSONObject) a16).has(VAL_TYPE)) {
                    return a16;
                }
                int i3 = ((JSONObject) a16).getInt(VAL_TYPE);
                if (i3 != 1 && i3 != 0) {
                    if (i3 == 2) {
                        return a((JSONObject) a16);
                    }
                    if (i3 == 3) {
                        return b(field.getGenericType(), (JSONObject) a16);
                    }
                    HMSLog.e("JsonUtil", "cannot support type : " + i3);
                }
                return a(field.getGenericType(), (JSONObject) a16);
            } catch (InstantiationException unused) {
                HMSLog.e("JsonUtil", "InstantiationException  ");
            }
        }
        return null;
    }

    public static String createJsonString(IMessageEntity iMessageEntity) {
        if (iMessageEntity == null) {
            HMSLog.e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        try {
            return a(iMessageEntity);
        } catch (IllegalAccessException e16) {
            HMSLog.e("JsonUtil", "catch IllegalAccessException " + e16.getMessage());
            return "";
        } catch (JSONException e17) {
            HMSLog.e("JsonUtil", "catch JSONException " + e17.getMessage());
            return "";
        }
    }

    public static Object getInfoFromJsonobject(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(str2)) {
                    return null;
                }
                Object obj = jSONObject.get(str2);
                if (obj instanceof String) {
                    return obj;
                }
            } catch (JSONException unused) {
                HMSLog.e("JsonUtil", "getInfoFromJsonobject:parser json error :" + str2);
            }
        }
        return null;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.getInt(str);
        }
        return -1;
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public static IMessageEntity jsonToEntity(String str, IMessageEntity iMessageEntity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            a(iMessageEntity, field, jSONObject);
                        } catch (IllegalAccessException unused) {
                            HMSLog.e("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            HMSLog.e("JsonUtil", "catch JSONException when parse jsonString" + e16.getMessage());
        }
        return iMessageEntity;
    }

    private static void a(final Field field, final boolean z16) {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.utils.JsonUtil.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                field.setAccessible(z16);
                return null;
            }
        });
    }

    private static Map b(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < jSONArray.length(); i3 += 2) {
            if (cls.newInstance() instanceof IMessageEntity) {
                hashMap.put(jSONArray.get(i3), jsonToEntity(jSONArray.getString(i3 + 1), (IMessageEntity) cls.newInstance()));
            } else {
                hashMap.put(jSONArray.get(i3), jSONArray.get(i3 + 1));
            }
        }
        return hashMap;
    }

    private static boolean a(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        if (obj instanceof String) {
            jSONObject.put(str, (String) obj);
            return true;
        }
        if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Short) {
            jSONObject.put(str, (Short) obj);
            return true;
        }
        if (obj instanceof Long) {
            jSONObject.put(str, (Long) obj);
            return true;
        }
        if (obj instanceof Float) {
            jSONObject.put(str, (Float) obj);
            return true;
        }
        if (obj instanceof Double) {
            jSONObject.put(str, (Double) obj);
            return true;
        }
        if (obj instanceof Boolean) {
            jSONObject.put(str, (Boolean) obj);
            return true;
        }
        if (obj instanceof JSONObject) {
            jSONObject.put(str, (JSONObject) obj);
            return true;
        }
        if (obj instanceof byte[]) {
            a(str, (byte[]) obj, jSONObject);
            return true;
        }
        if (obj instanceof List) {
            a(str, (List<?>) obj, jSONObject);
            return true;
        }
        if (obj instanceof Map) {
            a(str, (Map) obj, jSONObject);
            return true;
        }
        if (obj instanceof IMessageEntity) {
            try {
                jSONObject.put(str, a((IMessageEntity) obj));
                return true;
            } catch (IllegalAccessException e16) {
                HMSLog.e("JsonUtil", "IllegalAccessException , " + e16);
            }
        }
        return false;
    }

    private static void a(String str, Map map, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof IMessageEntity) {
                jSONArray.mo162put(a((IMessageEntity) key));
            } else {
                jSONArray.mo162put(key);
            }
            if (value instanceof IMessageEntity) {
                jSONArray.mo162put(a((IMessageEntity) value));
            } else {
                jSONArray.mo162put(value);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 3);
        jSONObject2.put("_map_", jSONArray.toString());
        jSONObject.put(str, jSONObject2);
    }

    private static void a(String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 2);
        try {
            jSONObject2.put("_byte_", Base64.encode(bArr));
        } catch (IllegalArgumentException e16) {
            HMSLog.e("JsonUtil", "writeByte failed : " + e16.getMessage());
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void a(String str, List<?> list, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VAL_TYPE, 1);
        jSONObject2.put("_list_size_", list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            a("_list_item_" + i3, list.get(i3), jSONObject2);
            if (list.get(i3) instanceof IMessageEntity) {
                jSONObject2.put(VAL_TYPE, 0);
            }
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void a(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object b16 = b(iMessageEntity, field, jSONObject);
        if (b16 != null) {
            boolean isAccessible = field.isAccessible();
            a(field, true);
            field.set(iMessageEntity, b16);
            a(field, isAccessible);
        }
    }

    private static Object a(String str, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
            return jSONObject.getJSONObject("header").get(str);
        }
        if (jSONObject.has("body") && jSONObject.getJSONObject("body").has(str)) {
            return jSONObject.getJSONObject("body").get(str);
        }
        return null;
    }

    private static List<Object> a(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i3 = jSONObject.getInt("_list_size_");
        int i16 = jSONObject.getInt(VAL_TYPE);
        ArrayList arrayList = new ArrayList(i3);
        for (int i17 = 0; i17 < i3; i17++) {
            Object obj = jSONObject.get("_list_item_" + i17);
            if (i16 == 0) {
                arrayList.add(jsonToEntity((String) obj, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else if (i16 == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static byte[] a(JSONObject jSONObject) throws JSONException {
        try {
            return Base64.decode(jSONObject.getString("_byte_"));
        } catch (IllegalArgumentException e16) {
            HMSLog.e("JsonUtil", "readByte failed : " + e16.getMessage());
            return null;
        }
    }
}
