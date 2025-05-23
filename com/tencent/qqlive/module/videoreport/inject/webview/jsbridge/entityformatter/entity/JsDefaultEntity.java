package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsDefaultEntity implements IJsEntityFormatter {
    private static final String TAG = "JsDefaultEntity";
    private JSONObject mResult = new JSONObject();

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter
    public JSONObject format() {
        return this.mResult;
    }

    public void setData(String str, String str2) {
        try {
            this.mResult.put(str, str2);
        } catch (Exception e16) {
            Log.e(TAG, "set data error " + e16);
        }
    }
}
