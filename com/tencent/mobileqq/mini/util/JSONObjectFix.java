package com.tencent.mobileqq.mini.util;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class JSONObjectFix extends JSONObject {
    public JSONObjectFix(String str) throws JSONException {
        super(str);
    }

    @Override // org.json.JSONObject, com.tencent.luggage.wxa.xa.c
    public String optString(String str, String str2) {
        return isNull(str) ? str2 : super.optString(str, str2);
    }

    public JSONObjectFix() {
    }
}
