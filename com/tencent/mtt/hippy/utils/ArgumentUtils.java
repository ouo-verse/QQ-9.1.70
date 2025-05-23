package com.tencent.mtt.hippy.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyTurboObj;
import com.tencent.mtt.hippy.annotation.HippyTurboProp;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ArgumentUtils {
    private static final String TAG = "ArgumentUtils";
    private static HashMap<Class, String> sMethodSigMap = new HashMap<>();

    private static String buildSignature(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder("(");
        for (Class<?> cls : parameterTypes) {
            try {
                sb5.append(getSupportSignature(cls));
            } catch (Exception unused) {
                sb5 = new StringBuilder();
            }
        }
        sb5.append(")");
        sb5.append(getSupportSignature(method.getReturnType()));
        String sb6 = sb5.toString();
        LogUtils.d("buildSignature", "method " + method.getName() + " sig " + sb6);
        return sb6;
    }

    private static boolean canPropExpose(HippyTurboProp hippyTurboProp, HippyMethod hippyMethod) {
        if ((hippyTurboProp != null && hippyTurboProp.expose()) || (hippyMethod != null && hippyMethod.isSync())) {
            return true;
        }
        return false;
    }

    public static HippyArray fromArray(Object obj) {
        HippyArray hippyArray = new HippyArray();
        int i3 = 0;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            int length = strArr.length;
            while (i3 < length) {
                hippyArray.pushString(strArr[i3]);
                i3++;
            }
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            int length2 = parcelableArr.length;
            while (i3 < length2) {
                Parcelable parcelable = parcelableArr[i3];
                if (parcelable instanceof Bundle) {
                    hippyArray.pushMap(fromBundle((Bundle) parcelable));
                }
                i3++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i3 < length3) {
                hippyArray.pushInt(iArr[i3]);
                i3++;
            }
        } else if (obj instanceof float[]) {
            int length4 = ((float[]) obj).length;
            while (i3 < length4) {
                hippyArray.pushDouble(r5[i3]);
                i3++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length5 = dArr.length;
            while (i3 < length5) {
                hippyArray.pushDouble(dArr[i3]);
                i3++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length6 = zArr.length;
            while (i3 < length6) {
                hippyArray.pushBoolean(zArr[i3]);
                i3++;
            }
        } else {
            throw new IllegalArgumentException("Unknown array type " + obj.getClass());
        }
        return hippyArray;
    }

    public static HippyMap fromBundle(Bundle bundle) {
        HippyMap hippyMap = new HippyMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                hippyMap.pushNull(str);
            } else if (obj.getClass().isArray()) {
                hippyMap.pushArray(str, fromArray(obj));
            } else if (obj instanceof String) {
                hippyMap.pushString(str, (String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    hippyMap.pushInt(str, ((Integer) obj).intValue());
                } else {
                    hippyMap.pushDouble(str, ((Number) obj).doubleValue());
                }
            } else if (obj instanceof Boolean) {
                hippyMap.pushBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Bundle) {
                hippyMap.pushMap(str, fromBundle((Bundle) obj));
            } else {
                throw new IllegalArgumentException("Could not convert " + obj.getClass());
            }
        }
        return hippyMap;
    }

    public static HippyArray fromJavaArgs(Object[] objArr) {
        HippyArray hippyArray = new HippyArray();
        if (objArr != null && objArr.length > 0) {
            try {
                for (Object obj : objArr) {
                    if (obj == null) {
                        hippyArray.pushNull();
                    } else {
                        parseObjectGotoArray(hippyArray, obj);
                    }
                }
            } catch (Throwable th5) {
                LogUtils.d(TAG, "fromJavaArgs: " + th5.getMessage());
            }
        }
        return hippyArray;
    }

    public static String getMethodsSignature(Object obj) {
        LogUtils.d(TAG, "enter getMethodsSignature");
        String str = null;
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (sMethodSigMap.containsKey(cls)) {
            String str2 = sMethodSigMap.get(cls);
            LogUtils.d(TAG, "exit getMethodsSignature from cache= " + str2);
            return str2;
        }
        Method[] methods = cls.getMethods();
        if (methods != null && methods.length != 0) {
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < methods.length; i3++) {
                if (canPropExpose((HippyTurboProp) methods[i3].getAnnotation(HippyTurboProp.class), (HippyMethod) methods[i3].getAnnotation(HippyMethod.class))) {
                    hashMap.put(methods[i3].getName(), buildSignature(methods[i3]));
                }
            }
            if (hashMap.size() != 0) {
                str = hashMap.toString();
            }
            sMethodSigMap.put(cls, str);
            LogUtils.d(TAG, "exit getMethodsSignature=" + str);
        }
        return str;
    }

    public static String getSupportSignature(Class cls) {
        if (cls == Boolean.TYPE) {
            return "Z";
        }
        if (cls == Double.TYPE) {
            return "D";
        }
        if (cls == Integer.TYPE) {
            return "I";
        }
        if (cls == Float.TYPE) {
            return UserInfo.SEX_FEMALE;
        }
        if (cls == Long.TYPE) {
            return "J";
        }
        if (cls == Void.TYPE) {
            return "V";
        }
        if (isSupportedObject(cls)) {
            return "L" + cls.getCanonicalName().replace(".", "/") + ";";
        }
        LogUtils.e(TAG, "getSupportSignature null :" + cls.getCanonicalName());
        return "Lcom/invalid;";
    }

    private static boolean isSupportedObject(Class cls) {
        if (cls != Boolean.class && cls != Integer.class && cls != Double.class && cls != Float.class && cls != Long.class && cls != String.class && cls != HippyArray.class && cls != HippyMap.class && cls != Promise.class && cls.getAnnotation(HippyTurboObj.class) == null) {
            return false;
        }
        return true;
    }

    public static String objectToJson(Object obj) {
        if (obj == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        objectToJson(sb5, obj);
        return sb5.toString();
    }

    public static String objectToJsonOpt(Object obj, StringBuilder sb5) {
        if (obj == null) {
            return "";
        }
        objectToJson(sb5, obj);
        return sb5.toString();
    }

    public static Object parseArgument(Type type, HippyArray hippyArray, int i3) {
        if (type == String.class) {
            return hippyArray.getString(i3);
        }
        if (type == Integer.TYPE || type == Integer.class) {
            return Integer.valueOf(hippyArray.getInt(i3));
        }
        if (type == Long.TYPE || type == Long.class) {
            return Long.valueOf(hippyArray.getLong(i3));
        }
        if (type == Double.TYPE || type == Double.class) {
            return Double.valueOf(hippyArray.getDouble(i3));
        }
        if (type == Boolean.TYPE || type == Boolean.class) {
            return Boolean.valueOf(hippyArray.getBoolean(i3));
        }
        if (type == Float.TYPE || type == Float.class) {
            return Float.valueOf((float) hippyArray.getDouble(i3));
        }
        if (type == HippyArray.class) {
            return hippyArray.getArray(i3);
        }
        if (type == HippyMap.class) {
            return hippyArray.getMap(i3);
        }
        throw new IllegalArgumentException("parseArgument exception");
    }

    private static void parseObjectGotoArray(HippyArray hippyArray, Object obj) throws JSONException {
        if (obj != null && obj != JSONObject.NULL) {
            Class<?> cls = obj.getClass();
            if (obj instanceof String) {
                hippyArray.pushString((String) obj);
                return;
            }
            if (cls != Integer.TYPE && cls != Integer.class) {
                if (cls != Double.TYPE && cls != Double.class) {
                    if (cls != Long.TYPE && cls != Long.class) {
                        if (cls != Boolean.TYPE && cls != Boolean.class) {
                            if (cls == HippyArray.class) {
                                hippyArray.pushArray((HippyArray) obj);
                                return;
                            }
                            if (cls == HippyMap.class) {
                                hippyArray.pushMap((HippyMap) obj);
                                return;
                            }
                            if (cls == JSONArray.class) {
                                HippyArray hippyArray2 = new HippyArray();
                                JSONArray jSONArray = (JSONArray) obj;
                                int length = jSONArray.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    parseObjectGotoArray(hippyArray2, jSONArray.get(i3));
                                }
                                hippyArray.pushArray(hippyArray2);
                                return;
                            }
                            if (cls == JSONObject.class) {
                                HippyMap hippyMap = new HippyMap();
                                JSONObject jSONObject = (JSONObject) obj;
                                Iterator keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String str = (String) keys.next();
                                    parseObjectGotoMap(hippyMap, str, jSONObject.get(str));
                                }
                                hippyArray.pushMap(hippyMap);
                                return;
                            }
                            return;
                        }
                        hippyArray.pushBoolean(((Boolean) obj).booleanValue());
                        return;
                    }
                    hippyArray.pushLong(((Long) obj).longValue());
                    return;
                }
                hippyArray.pushDouble(((Double) obj).doubleValue());
                return;
            }
            hippyArray.pushInt(((Integer) obj).intValue());
            return;
        }
        hippyArray.pushNull();
    }

    private static void parseObjectGotoMap(HippyMap hippyMap, String str, Object obj) throws JSONException {
        if (obj != null && obj != JSONObject.NULL) {
            Class<?> cls = obj.getClass();
            if (obj instanceof String) {
                hippyMap.pushString(str, (String) obj);
                return;
            }
            if (cls != Integer.TYPE && cls != Integer.class) {
                if (cls != Double.TYPE && cls != Double.class) {
                    if (cls != Long.TYPE && cls != Long.class) {
                        if (cls != Boolean.TYPE && cls != Boolean.class) {
                            if (cls == JSONArray.class) {
                                HippyArray hippyArray = new HippyArray();
                                hippyMap.pushArray(str, hippyArray);
                                JSONArray jSONArray = (JSONArray) obj;
                                int length = jSONArray.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    parseObjectGotoArray(hippyArray, jSONArray.get(i3));
                                }
                                return;
                            }
                            if (cls == JSONObject.class) {
                                HippyMap hippyMap2 = new HippyMap();
                                hippyMap.pushMap(str, hippyMap2);
                                JSONObject jSONObject = (JSONObject) obj;
                                Iterator keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String str2 = (String) keys.next();
                                    parseObjectGotoMap(hippyMap2, str2, jSONObject.get(str2));
                                }
                                return;
                            }
                            return;
                        }
                        hippyMap.pushBoolean(str, ((Boolean) obj).booleanValue());
                        return;
                    }
                    hippyMap.pushLong(str, ((Long) obj).longValue());
                    return;
                }
                hippyMap.pushDouble(str, ((Double) obj).doubleValue());
                return;
            }
            hippyMap.pushInt(str, ((Integer) obj).intValue());
            return;
        }
        hippyMap.pushNull(str);
    }

    public static HippyArray parseToArray(String str) {
        HippyArray hippyArray = new HippyArray();
        if (TextUtils.isEmpty(str)) {
            return hippyArray;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                parseObjectGotoArray(hippyArray, jSONArray.get(i3));
            }
        } catch (Throwable unused) {
        }
        return hippyArray;
    }

    public static HippyMap parseToMap(String str) {
        HippyMap hippyMap = new HippyMap();
        if (TextUtils.isEmpty(str)) {
            return hippyMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                parseObjectGotoMap(hippyMap, str2, jSONObject.get(str2));
            }
        } catch (Throwable unused) {
        }
        return hippyMap;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0026. Please report as an issue. */
    private static void stringFormat(String str, StringBuilder sb5) {
        String str2;
        sb5.append("\"");
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt != '\f') {
                if (charAt != '\r') {
                    if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                str2 = "\\b";
                                break;
                            case '\t':
                                str2 = "\\t";
                                break;
                            case '\n':
                                str2 = RedTouch.NEWLINE_CHAR;
                                break;
                            default:
                                if (charAt <= 31) {
                                    str2 = String.format("\\u%04x", Integer.valueOf(charAt));
                                    break;
                                }
                                break;
                        }
                    } else {
                        sb5.append('\\');
                    }
                    sb5.append(charAt);
                } else {
                    str2 = "\\r";
                }
            } else {
                str2 = "\\f";
            }
            sb5.append(str2);
        }
        sb5.append("\"");
    }

    public static Bundle toBundle(HippyMap hippyMap) {
        String str;
        Bundle bundle = new Bundle(9);
        if (hippyMap != null) {
            for (String str2 : hippyMap.keySet()) {
                Object obj = hippyMap.get(str2);
                if (obj == null) {
                    str = null;
                } else if (obj instanceof String) {
                    str = (String) obj;
                } else if (!obj.getClass().isAssignableFrom(Integer.TYPE) && !(obj instanceof Integer)) {
                    if (!obj.getClass().isAssignableFrom(Long.TYPE) && !(obj instanceof Long)) {
                        if (!obj.getClass().isAssignableFrom(Double.TYPE) && !(obj instanceof Double)) {
                            if (!obj.getClass().isAssignableFrom(Boolean.TYPE) && !(obj instanceof Boolean)) {
                                if (obj instanceof HippyMap) {
                                    bundle.putBundle(str2, toBundle((HippyMap) obj));
                                } else {
                                    if (obj instanceof HippyArray) {
                                        throw new UnsupportedOperationException("Arrays aren't supported yet.");
                                    }
                                    throw new IllegalArgumentException("Could not convert object with key: " + str2 + ".");
                                }
                            } else {
                                bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                            }
                        } else {
                            bundle.putDouble(str2, ((Double) obj).doubleValue());
                        }
                    } else {
                        bundle.putLong(str2, ((Long) obj).longValue());
                    }
                } else {
                    bundle.putInt(str2, ((Integer) obj).intValue());
                }
                bundle.putString(str2, str);
            }
        }
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ff, code lost:
    
        if (java.lang.Float.isNaN(((java.lang.Float) r6).floatValue()) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0101, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
    
        if (java.lang.Double.isNaN(((java.lang.Double) r6).doubleValue()) != false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void objectToJson(StringBuilder sb5, Object obj) {
        String str;
        if (obj == null) {
            sb5.append("\"\"");
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str2)) {
                sb5.append("\"\"");
                return;
            } else {
                stringFormat(str2, sb5);
                return;
            }
        }
        if (!obj.getClass().isAssignableFrom(Integer.TYPE) && !(obj instanceof Integer) && !obj.getClass().isAssignableFrom(Long.TYPE) && !(obj instanceof Long)) {
            int i3 = 0;
            if (!obj.getClass().isAssignableFrom(Double.TYPE) && !(obj instanceof Double)) {
                if (!obj.getClass().isAssignableFrom(Boolean.TYPE) && !(obj instanceof Boolean)) {
                    if (!obj.getClass().isAssignableFrom(Float.TYPE) && !(obj instanceof Float)) {
                        if (obj instanceof HippyArray) {
                            sb5.append("[");
                            HippyArray hippyArray = (HippyArray) obj;
                            int size = hippyArray.size();
                            while (i3 < size) {
                                objectToJson(sb5, hippyArray.getObject(i3));
                                if (i3 != size - 1) {
                                    sb5.append(",");
                                }
                                i3++;
                            }
                            str = "]";
                        } else {
                            if (!(obj instanceof HippyMap)) {
                                return;
                            }
                            sb5.append("{");
                            HippyMap hippyMap = (HippyMap) obj;
                            for (String str3 : hippyMap.keySet()) {
                                sb5.append("\"");
                                sb5.append(str3);
                                sb5.append("\"");
                                sb5.append(":");
                                objectToJson(sb5, hippyMap.get(str3));
                                sb5.append(",");
                                i3 = 1;
                            }
                            if (i3 != 0) {
                                sb5.deleteCharAt(sb5.length() - 1);
                            }
                            str = "}";
                        }
                        sb5.append(str);
                        return;
                    }
                }
            }
        }
        sb5.append(obj);
    }

    public static Object parseArgument(Type type, HippyMap hippyMap, String str) {
        if (type == String.class) {
            return hippyMap.getString(str);
        }
        if (type == Integer.TYPE || type == Integer.class) {
            return Integer.valueOf(hippyMap.getInt(str));
        }
        if (type == Long.TYPE || type == Long.class) {
            return Long.valueOf(hippyMap.getLong(str));
        }
        if (type == Double.TYPE || type == Double.class) {
            return Double.valueOf(hippyMap.getDouble(str));
        }
        if (type == Float.TYPE || type == Float.class) {
            return Float.valueOf((float) hippyMap.getDouble(str));
        }
        if (type == Boolean.TYPE || type == Boolean.class) {
            return Boolean.valueOf(hippyMap.getBoolean(str));
        }
        if (type == HippyArray.class) {
            return hippyMap.getArray(str);
        }
        if (type == HippyMap.class) {
            return hippyMap.getMap(str);
        }
        throw new IllegalArgumentException("parseArgument exception");
    }

    public static Object parseArgument(Type type, Object obj) {
        if (type == String.class) {
            return String.valueOf(obj);
        }
        if (type == Integer.TYPE || type == Integer.class) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (type == Long.TYPE || type == Long.class) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (type == Double.TYPE || type == Double.class) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (type == Float.TYPE || type == Float.class) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (type == Boolean.TYPE || type == Boolean.class || type == HippyArray.class || type == HippyMap.class) {
            return obj;
        }
        throw new IllegalArgumentException("parseArgument exception");
    }
}
