package com.tencent.luggage.wxa.l6;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f133053a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f133054b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f133055c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f133056d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f133057e;

    static {
        String str;
        String str2;
        String str3;
        String str4 = "{}";
        try {
            str = new JSONObject().put("err_msg", "system:function_not_exist").toString();
        } catch (JSONException unused) {
            str = "{}";
        }
        Intrinsics.checkNotNullExpressionValue(str, "try {\n        JSONObject\u2026ion) {\n        \"{}\"\n    }");
        f133054b = str;
        try {
            str2 = new JSONObject().put("err_msg", "system:invalid_data").toString();
        } catch (JSONException unused2) {
            str2 = "{}";
        }
        Intrinsics.checkNotNullExpressionValue(str2, "try {\n        JSONObject\u2026ion) {\n        \"{}\"\n    }");
        f133055c = str2;
        try {
            str3 = new JSONObject().put("err_msg", "system:invalid_api").toString();
        } catch (JSONException unused3) {
            str3 = "{}";
        }
        Intrinsics.checkNotNullExpressionValue(str3, "try {\n        JSONObject\u2026ion) {\n        \"{}\"\n    }");
        f133056d = str3;
        try {
            str4 = new JSONObject().put("err_msg", "system:access_denied").toString();
        } catch (JSONException unused4) {
        }
        Intrinsics.checkNotNullExpressionValue(str4, "try {\n        JSONObject\u2026ion) {\n        \"{}\"\n    }");
        f133057e = str4;
    }

    public final String a() {
        return f133057e;
    }

    public final String b() {
        return f133054b;
    }

    public final String c() {
        return f133056d;
    }

    public final String d() {
        return f133055c;
    }
}
