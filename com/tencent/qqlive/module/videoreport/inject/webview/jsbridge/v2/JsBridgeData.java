package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v2;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsBridgeData {
    public final String mCallbackId;
    public JSONObject mData;
    public final String mHandleName;

    public JsBridgeData(String str, String str2, JSONObject jSONObject) {
        this.mHandleName = str;
        this.mCallbackId = str2;
        this.mData = jSONObject;
    }
}
