package com.tencent.mobileqq.Doraemon;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a {
    void onComplete();

    void onFailure(int i3, String str);

    void onPermission(int i3);

    void onSuccess(JSONObject jSONObject);

    void onTrigger(JSONObject jSONObject);
}
