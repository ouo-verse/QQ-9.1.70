package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js;

import android.webkit.JavascriptInterface;
import org.json.JSONObject;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdJavaScriptInterface {
    private static final String TAG = "QAdJavaScriptInterface";
    private c mJsCallJava;

    public QAdJavaScriptInterface(c cVar) {
        this.mJsCallJava = cVar;
    }

    @JavascriptInterface
    public String invoke(String str) {
        n.a(TAG, "JavaScriptInterface invoke:" + str);
        try {
            JSONObject jSONObject = new JSONObject(this.mJsCallJava.a(str));
            if (jSONObject.optInt("code") != 100) {
                return jSONObject.toString();
            }
            return "";
        } catch (Exception e16) {
            n.d(TAG, e16, "JavaScriptInterface invoke error !!:" + str);
            return "";
        }
    }
}
