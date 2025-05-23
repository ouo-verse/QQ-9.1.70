package com.tencent.mobileqq.timiqqid.callback;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface GeekSdkListener {
    void onBeforeCallStartScan();

    void onInitComplete(String str);

    void onInitFailed(int i3, JSONObject jSONObject);

    void onReceivedEvent(int i3, JSONObject jSONObject);
}
