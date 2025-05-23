package com.tencent.luggage.wxa.xd;

import android.text.TextUtils;
import android.webkit.ValueCallback;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class i1 {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements ValueCallback {
        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsScriptEvaluatorWC", "hy: value ret: %s", str);
        }
    }

    public static void a(com.tencent.luggage.wxa.ei.j jVar, String str, String str2, int i3) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        Object[] objArr = new Object[6];
        objArr[0] = "WeixinJSBridge";
        objArr[1] = "WeixinJSBridge";
        objArr[2] = str;
        objArr[3] = str2;
        if (i3 == 0) {
            str3 = "undefined";
        } else {
            str3 = i3 + "";
        }
        objArr[4] = str3;
        objArr[5] = h1.a();
        jVar.evaluateJavascript(String.format("typeof %s !== 'undefined' && %s.subscribeHandler(\"%s\", %s, %s, %s)", objArr), null);
    }

    public static void b(com.tencent.luggage.wxa.ei.j jVar, String str, String str2, int i3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsScriptEvaluatorWC", "hy: dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(i3));
        jVar.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('%s', %s)", str, str2), new a());
    }
}
