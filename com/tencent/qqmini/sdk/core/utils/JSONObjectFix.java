package com.tencent.qqmini.sdk.core.utils;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JSONObjectFix extends JSONObject {
    public JSONObjectFix(String str) throws JSONException {
        super(str);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public String optString(String str, String str2) {
        if (isNull(str)) {
            return str2;
        }
        return super.optString(str, str2);
    }

    public JSONObjectFix() {
    }
}
