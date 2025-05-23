package com.tencent.luggage.wxa.ij;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f130607c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List f130608a;

    /* renamed from: b, reason: collision with root package name */
    public final String f130609b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(String jsonStr) {
            String str = "materialOrigin";
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(jsonStr);
                JSONArray jSONArray = jSONObject.getJSONArray("multiSelectMaterials");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    String type = jSONObject2.getString("type");
                    String name = jSONObject2.optString("name", "");
                    String path = jSONObject2.optString("path", "");
                    JSONArray jSONArray2 = jSONArray;
                    int optInt = jSONObject2.optInt("size", 0);
                    String content = jSONObject2.optString("content", "");
                    String talker = jSONObject2.optString("talker", "");
                    long optLong = jSONObject2.optLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, 0L);
                    long optLong2 = jSONObject2.optLong("messageId", 0L);
                    Intrinsics.checkNotNullExpressionValue(type, "type");
                    Intrinsics.checkNotNullExpressionValue(name, "name");
                    Intrinsics.checkNotNullExpressionValue(path, "path");
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    Intrinsics.checkNotNullExpressionValue(talker, "talker");
                    arrayList.add(new c(type, name, path, optInt, content, talker, optLong, optLong2, null, 256, null));
                    i3++;
                    jSONArray = jSONArray2;
                    length = length;
                    str = str;
                    jSONObject = jSONObject;
                }
                String str2 = str;
                String optString = jSONObject.optString(str2, "");
                Intrinsics.checkNotNullExpressionValue(optString, str2);
                return new b(arrayList, optString);
            } catch (Exception e16) {
                w.f("AppBrandOpenMaterialNativeExtraDataForOpenMsg", "fromJsonString fail since " + e16);
                return null;
            }
        }
    }

    public b(List multiSelectMaterials, String materialOrigin) {
        Intrinsics.checkNotNullParameter(multiSelectMaterials, "multiSelectMaterials");
        Intrinsics.checkNotNullParameter(materialOrigin, "materialOrigin");
        this.f130608a = multiSelectMaterials;
        this.f130609b = materialOrigin;
    }

    public final List a() {
        return this.f130608a;
    }

    public final String b() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (c cVar : this.f130608a) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", cVar.e());
                jSONObject2.put("name", cVar.b());
                jSONObject2.put("path", cVar.c());
                jSONObject2.put("size", cVar.d());
                jSONObject2.put("content", cVar.a());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("materials", jSONArray);
            jSONObject.put("materialOrigin", this.f130609b);
            str = jSONObject.toString();
            w.a("AppBrandOpenMaterialNativeExtraDataForOpenMsg", "toJsonStringWithoutMsg " + str);
        } catch (Exception e16) {
            w.f("AppBrandOpenMaterialNativeExtraDataForOpenMsg", "toJsonString fail since " + e16);
            str = "{}";
        }
        Intrinsics.checkNotNullExpressionValue(str, "try {\n            val ma\u2026     EMPTY_JSON\n        }");
        return str;
    }
}
