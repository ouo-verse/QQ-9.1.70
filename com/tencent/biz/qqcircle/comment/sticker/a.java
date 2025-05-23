package com.tencent.biz.qqcircle.comment.sticker;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f83932a;

    /* renamed from: b, reason: collision with root package name */
    public final String f83933b;

    /* renamed from: c, reason: collision with root package name */
    public final String f83934c;

    a(String str, String str2, String str3) {
        this.f83932a = str;
        this.f83933b = str2;
        this.f83934c = str3;
    }

    public static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("thumbUrl");
        String optString3 = jSONObject.optString("md5");
        if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new a(optString, optString2, optString3);
    }

    public String a() {
        if (TextUtils.isEmpty(this.f83933b)) {
            return this.f83932a;
        }
        return this.f83933b;
    }
}
