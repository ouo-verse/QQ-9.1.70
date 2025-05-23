package com.tencent.mobileqq.mini.out.nativePlugins.foundation;

import org.json.JSONObject;

/* loaded from: classes33.dex */
public interface NativePlugin {
    void onDestroy();

    void onInvoke(JSONObject jSONObject, JSContext jSContext);
}
