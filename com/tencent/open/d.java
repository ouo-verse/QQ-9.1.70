package com.tencent.open;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f341141a;

    /* renamed from: b, reason: collision with root package name */
    public final String f341142b;

    /* renamed from: c, reason: collision with root package name */
    public final String f341143c;

    /* renamed from: d, reason: collision with root package name */
    public final String f341144d;

    /* renamed from: e, reason: collision with root package name */
    public final String f341145e;

    d(String str, String str2, String str3, String str4, String str5) {
        this.f341141a = str;
        this.f341142b = str2;
        this.f341143c = str3;
        this.f341144d = str4;
        this.f341145e = str5;
    }

    @Nullable
    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("browser");
        String optString2 = jSONObject.optString("pkg_name");
        String optString3 = jSONObject.optString(QZoneDTLoginReporter.SCHEMA);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return null;
        }
        return new d(optString, optString2, optString3, jSONObject.optString("pt_browser", ""), jSONObject.optString("sign", ""));
    }
}
