package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter;

import com.tencent.qqlive.module.videoreport.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsCallbackBuilder {
    private static final String TAG = "jsbridge.JsCallbackBuilder";
    private IJsEntityFormatter dataFormatter;
    private String ret = "0";

    /* renamed from: msg, reason: collision with root package name */
    private String f345270msg = "success";

    public String format() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", this.ret).put("msg", this.f345270msg);
            IJsEntityFormatter iJsEntityFormatter = this.dataFormatter;
            if (iJsEntityFormatter != null) {
                jSONObject.put("data", iJsEntityFormatter.format());
            }
        } catch (JSONException e16) {
            Log.e(TAG, "format(), format error:" + e16);
        }
        return jSONObject.toString();
    }

    public JsCallbackBuilder setData(IJsEntityFormatter iJsEntityFormatter) {
        this.dataFormatter = iJsEntityFormatter;
        return this;
    }

    public JsCallbackBuilder setMsg(String str) {
        this.f345270msg = str;
        return this;
    }

    public JsCallbackBuilder setRet(String str) {
        this.ret = str;
        return this;
    }
}
