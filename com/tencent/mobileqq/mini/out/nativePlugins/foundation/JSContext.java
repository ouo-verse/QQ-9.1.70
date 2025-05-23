package com.tencent.mobileqq.mini.out.nativePlugins.foundation;

import android.app.Activity;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface JSContext {
    void callJs(String str, JSONObject jSONObject);

    void evaluateCallback(boolean z16, JSONObject jSONObject, String str);

    Activity getActivity();
}
