package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.QAdSpaJsApi;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pw2.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, d> f303844a;

    /* renamed from: b, reason: collision with root package name */
    private b f303845b;

    public c(b bVar, a aVar) {
        this.f303845b = bVar;
        this.f303844a = aVar.d();
    }

    private String b(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!c(z16, jSONObject.optString("from"))) {
                    return f(str, 100, "not from TencentVideo JsBridge");
                }
                return g(str, jSONObject);
            } catch (Exception e16) {
                n.c("QADJsCallJava", e16);
                return d(str, e16);
            }
        }
        return f(str, 500, "call data empty");
    }

    private boolean c(boolean z16, String str) {
        if (z16) {
            return "qqlive".equals(str);
        }
        return true;
    }

    private String d(String str, Exception exc) {
        if (exc.getCause() != null) {
            return f(str, 500, "method execute error:" + exc.getCause().getMessage());
        }
        return f(str, 500, "method execute error:" + exc.getMessage());
    }

    private d e(String str) {
        d dVar = this.f303844a.get(str);
        if (dVar == null) {
            return this.f303844a.get(str.replace("_O", "_S"));
        }
        return dVar;
    }

    private String f(String str, int i3, Object obj) {
        String valueOf;
        if (obj == null) {
            valueOf = "null";
        } else if (obj instanceof String) {
            valueOf = "\"" + ((Object) ((String) obj).replace("\"", "\\\"")) + "\"";
        } else if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof JSONObject)) {
            n.b("QADJsCallJava", "UnSupported return format");
            valueOf = "undefined";
        } else {
            valueOf = String.valueOf(obj);
        }
        String format = String.format("{\"code\": %d, \"result\": %s}", Integer.valueOf(i3), valueOf);
        n.a("QADJsCallJava", " call json: " + str + " result:" + format);
        return format;
    }

    private String g(String str, JSONObject jSONObject) throws JSONException, IllegalAccessException, InvocationTargetException {
        String string = jSONObject.getString("method");
        JSONArray jSONArray = jSONObject.getJSONArray("types");
        JSONArray jSONArray2 = jSONObject.getJSONArray("args");
        StringBuffer stringBuffer = new StringBuffer(string);
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        int k3 = k(jSONArray, jSONArray2, stringBuffer, length, objArr, 0);
        String stringBuffer2 = stringBuffer.toString();
        d e16 = e(stringBuffer2);
        if (e16 == null) {
            return f(str, 500, "not found method(" + stringBuffer2 + ") with valid parameters");
        }
        Method method = e16.f303847b;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a aVar = e16.f303846a;
        o(aVar, objArr);
        h(jSONArray2, objArr, k3, method);
        return f(str, 200, method.invoke(aVar, objArr));
    }

    private void h(JSONArray jSONArray, Object[] objArr, int i3, Method method) throws JSONException {
        if (i3 > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (i3 > 0) {
                int i16 = i3 / 10;
                int i17 = (i3 - (i16 * 10)) - 1;
                Class<?> cls = parameterTypes[i17];
                if (cls == Integer.TYPE) {
                    objArr[i17] = Integer.valueOf(jSONArray.getInt(i17));
                } else if (cls == Long.TYPE) {
                    objArr[i17] = Long.valueOf(Long.parseLong(jSONArray.getString(i17)));
                } else {
                    objArr[i17] = Double.valueOf(jSONArray.getDouble(i17));
                }
                i3 = i16;
            }
        }
    }

    private void i(JSONArray jSONArray, StringBuffer stringBuffer, Object[] objArr, int i3) throws JSONException {
        if (jSONArray.isNull(i3)) {
            objArr[i3] = null;
            return;
        }
        String string = jSONArray.getString(i3);
        if (string.length() > 3) {
            String[] split = string.substring(2, string.length() - 2).split("\",\"");
            long[] jArr = new long[split.length];
            for (int i16 = 0; i16 < split.length; i16++) {
                try {
                    jArr[i16] = Long.parseLong(split[i16]);
                } catch (Exception unused) {
                    stringBuffer.append("_[LS");
                    objArr[i3] = split;
                    return;
                }
            }
            stringBuffer.append("_[LN");
            objArr[i3] = jArr;
            return;
        }
        stringBuffer.append("_[LS");
        objArr[i3] = null;
    }

    private void j(JSONArray jSONArray, StringBuffer stringBuffer, Object[] objArr, int i3) throws JSONException {
        stringBuffer.append("_B");
        objArr[i3] = Boolean.valueOf(jSONArray.getBoolean(i3));
    }

    private int k(JSONArray jSONArray, JSONArray jSONArray2, StringBuffer stringBuffer, int i3, Object[] objArr, int i16) throws JSONException {
        for (int i17 = 0; i17 < i3; i17++) {
            String optString = jSONArray.optString(i17);
            if (HippyControllerProps.STRING.equals(optString)) {
                n(jSONArray2, stringBuffer, objArr, i17);
            } else if ("number".equals(optString)) {
                i16 = l(stringBuffer, i16, i17);
            } else if (HippyControllerProps.BOOLEAN.equals(optString)) {
                j(jSONArray2, stringBuffer, objArr, i17);
            } else if ("object".equals(optString)) {
                m(jSONArray2, stringBuffer, objArr, i17);
            } else if (HippyControllerProps.ARRAY.equals(optString)) {
                i(jSONArray2, stringBuffer, objArr, i17);
            } else if ("function".equals(optString)) {
                stringBuffer.append("_F");
                objArr[i17] = new jv2.c(this.f303845b, jSONArray2.getInt(i17));
            } else {
                stringBuffer.append("_P");
            }
        }
        return i16;
    }

    private int l(StringBuffer stringBuffer, int i3, int i16) {
        stringBuffer.append("_N");
        return (i3 * 10) + i16 + 1;
    }

    private void m(JSONArray jSONArray, StringBuffer stringBuffer, Object[] objArr, int i3) throws JSONException {
        JSONObject jSONObject;
        stringBuffer.append("_O");
        if (jSONArray.isNull(i3)) {
            jSONObject = null;
        } else {
            jSONObject = jSONArray.getJSONObject(i3);
        }
        objArr[i3] = jSONObject;
    }

    private void n(JSONArray jSONArray, StringBuffer stringBuffer, Object[] objArr, int i3) throws JSONException {
        String string;
        stringBuffer.append("_S");
        if (jSONArray.isNull(i3)) {
            string = null;
        } else {
            string = jSONArray.getString(i3);
        }
        objArr[i3] = string;
    }

    private void o(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a aVar, Object[] objArr) {
        if (!(aVar instanceof QAdSpaJsApi)) {
            return;
        }
        for (Object obj : objArr) {
            if (obj instanceof jv2.c) {
                ((jv2.c) obj).c("TenvideoJSBridge");
            }
        }
    }

    public String a(String str) {
        return b(str, true);
    }
}
