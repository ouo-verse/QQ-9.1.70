package com.tencent.luggage.wxa.ij;

import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final C6318a f130602e = new C6318a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f130603a;

    /* renamed from: b, reason: collision with root package name */
    public final String f130604b;

    /* renamed from: c, reason: collision with root package name */
    public final String f130605c;

    /* renamed from: d, reason: collision with root package name */
    public final int f130606d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ij.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6318a {
        public C6318a() {
        }

        public /* synthetic */ C6318a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(jsonStr);
                String mimeType = jSONObject.getString("mimeType");
                String materialPath = jSONObject.getString("materialPath");
                String materialName = jSONObject.optString("materialName", "");
                int optInt = jSONObject.optInt("materialSize", 0);
                Intrinsics.checkNotNullExpressionValue(mimeType, "mimeType");
                Intrinsics.checkNotNullExpressionValue(materialPath, "materialPath");
                Intrinsics.checkNotNullExpressionValue(materialName, "materialName");
                return new a(mimeType, materialPath, materialName, optInt);
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", "fromJsonString fail since " + e16);
                return null;
            }
        }
    }

    public a(String mimeType, String materialPath, String materialName, int i3) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(materialPath, "materialPath");
        Intrinsics.checkNotNullParameter(materialName, "materialName");
        this.f130603a = mimeType;
        this.f130604b = materialPath;
        this.f130605c = materialName;
        this.f130606d = i3;
    }

    public static final a a(String str) {
        return f130602e.a(str);
    }

    public final String b() {
        return this.f130603a;
    }

    public String c() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mimeType", this.f130603a);
            jSONObject.put("materialPath", this.f130604b);
            jSONObject.put("materialName", this.f130605c);
            jSONObject.put("materialSize", this.f130606d);
            str = jSONObject.toString();
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", "toJsonString fail since " + e16);
            str = "{}";
        }
        Intrinsics.checkNotNullExpressionValue(str, "try {\n            val js\u2026     EMPTY_JSON\n        }");
        return str;
    }

    public final String a() {
        return this.f130604b;
    }
}
