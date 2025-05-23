package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsSdkVersionEntity implements IJsEntityFormatter {
    private static final String TAG = "jsbridge.JsSdkVersionEntity";
    private int mSdkVersion;

    JsSdkVersionEntity() {
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter
    public JSONObject format() {
        try {
            return new JSONObject().put("sdkVersion", this.mSdkVersion);
        } catch (JSONException e16) {
            Log.e(TAG, "format(), format json error: " + e16);
            return null;
        }
    }

    public JsSdkVersionEntity(int i3) {
        this.mSdkVersion = i3;
    }
}
