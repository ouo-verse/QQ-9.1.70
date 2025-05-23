package com.tencent.luggage.wxa.xd;

import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class h1 {
    public static void a(com.tencent.luggage.wxa.ei.p pVar, String str, String str2, int i3) {
        a(pVar, str, str2, i3, 0);
    }

    public static void a(com.tencent.luggage.wxa.ei.p pVar, String str, String str2, int i3, int i16) {
        com.tencent.luggage.wxa.ei.o oVar;
        if ((pVar instanceof com.tencent.luggage.wxa.ei.j) && (oVar = (com.tencent.luggage.wxa.ei.o) ((com.tencent.luggage.wxa.ei.j) pVar).a(com.tencent.luggage.wxa.ei.o.class)) != null) {
            if (com.tencent.luggage.wxa.tn.w0.c(str2)) {
                str2 = "{}";
            }
            JSONObject jSONObject = new JSONObject();
            if (i16 != 0) {
                try {
                    jSONObject.put("__subscribe_webviewId", i16);
                } catch (JSONException unused) {
                }
            }
            oVar.a(str, str2, i3, a(jSONObject));
            return;
        }
        pVar.evaluateJavascript(a(com.tencent.luggage.wxa.uk.w.a(str), str2, i3, i16), null);
    }

    public static String a(String str, String str2, int i3) {
        return a(str, str2, i3, 0);
    }

    public static String a(String str, String str2, int i3, int i16) {
        String str3;
        if (com.tencent.luggage.wxa.tn.w0.c(str2)) {
            str2 = "{}";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (i16 != 0) {
                try {
                    jSONObject.put("__subscribe_webviewId", i16);
                } catch (JSONException unused) {
                }
            }
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            if (i3 == 0) {
                str3 = "undefined";
            } else {
                str3 = i3 + "";
            }
            objArr[2] = str3;
            objArr[3] = a(jSONObject);
            return String.format(locale, "WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)", objArr);
        } catch (OutOfMemoryError e16) {
            String format = String.format(Locale.ENGLISH, "oom:%s, event:%s, data.size:%d", e16.getMessage(), str, Integer.valueOf(com.tencent.luggage.wxa.tn.w0.d(str2).length()));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsScriptEvaluator", "message:%s", format);
            throw new OutOfMemoryError(format);
        }
    }

    public static String a() {
        return a(null);
    }

    public static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsScriptEvaluator", "makeExtStatJson e = %s", e16);
                return "{}";
            }
        }
        return jSONObject.put("nativeTime", System.currentTimeMillis()).toString();
    }
}
