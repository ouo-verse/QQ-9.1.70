package com.tencent.open.appcommon;

import com.tencent.mobileqq.jsbridge.a;
import com.tencent.open.base.f;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends Common {
    public static String I(WebView webView, HashMap<String, a.b> hashMap, String str) {
        Class<?> cls;
        Method method;
        String invoke;
        Method[] methodArr;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("r", "-1");
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray(URLDecoder.decode(str, "UTF-8"));
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("ns");
                    String optString2 = optJSONObject.optString("method");
                    String optString3 = optJSONObject.optString("guid");
                    String optString4 = optJSONObject.optString("args");
                    f.a("Common", "nameSpace:" + optString + ",methodName=" + optString2 + ",paramsStr=" + optString4);
                    ArrayList arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray3 = new JSONArray(optString4);
                        for (int i16 = 0; i16 < jSONArray3.length(); i16++) {
                            arrayList.add(jSONArray3.getString(i16));
                        }
                        cls = com.tencent.open.appcommon.js.c.f340696b.get(optString);
                        if (com.tencent.open.appcommon.js.c.f340695a.contains(optString2)) {
                            arrayList.add(optString3);
                        }
                    } catch (Exception e16) {
                        f.c("Common", "callBatch args error : " + e16.toString());
                    }
                    if (cls != null) {
                        Method[] methods = cls.getMethods();
                        int length = methods.length;
                        int i17 = 0;
                        while (true) {
                            if (i17 < length) {
                                method = methods[i17];
                                if (method.getName().equals(optString2)) {
                                    methodArr = methods;
                                    if (method.getParameterTypes().length == arrayList.size()) {
                                        break;
                                    }
                                } else {
                                    methodArr = methods;
                                }
                                i17++;
                                methods = methodArr;
                            } else {
                                method = null;
                                break;
                            }
                        }
                        Method method2 = method;
                        if (method2 != null) {
                            a.b bVar = hashMap.get(optString);
                            try {
                                f.a("Common", "callBatch <call> class : " + bVar.getClass().getName() + " , method : " + optString2 + "\n , args : " + arrayList.toString());
                                if (arrayList.size() == 0) {
                                    invoke = method2.invoke(bVar, new Object[0]);
                                } else {
                                    invoke = method2.invoke(bVar, arrayList.toArray());
                                }
                                Class<?> returnType = method2.getReturnType();
                                if (returnType != Void.TYPE && returnType != Void.class && invoke != null) {
                                    String str2 = "";
                                    if (invoke instanceof String) {
                                        invoke.replace("\\", "\\\\").replace("'", "\\'");
                                        str2 = invoke;
                                    } else {
                                        if (!(invoke instanceof Number) && !(invoke instanceof Long) && !(invoke instanceof Integer) && !(invoke instanceof Double) && !(invoke instanceof Float)) {
                                            if (invoke instanceof Boolean) {
                                                str2 = invoke.toString();
                                            }
                                        }
                                        str2 = invoke.toString();
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    JSONArray jSONArray4 = new JSONArray();
                                    jSONObject2.put("guid", optString3);
                                    jSONObject2.put("r", 0);
                                    jSONObject2.put("data", str2);
                                    jSONArray4.mo162put("interface." + optString2);
                                    jSONArray4.mo162put(jSONObject2);
                                    jSONArray.mo162put(jSONArray4);
                                }
                            } catch (Exception e17) {
                                f.d("Common", "callBatch error", e17);
                            }
                        }
                    }
                }
            }
            jSONObject.put("r", 0);
            jSONObject.put("data", jSONArray);
            f.a("Common", "Response<callBatch> syncCallBatch result : " + jSONObject);
        } catch (UnsupportedEncodingException e18) {
            f.j("Common", "callBatch decode params format err", e18);
        } catch (JSONException e19) {
            f.j("Common", "callBatch request params format err", e19);
        }
        return jSONObject.toString();
    }
}
