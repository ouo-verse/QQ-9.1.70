package com.tencent.luggage.wxa.ob;

import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C6540a f136262b = new C6540a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List f136263a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ob.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6540a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ob.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6541a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f136264a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6541a(List list) {
                super(1);
                this.f136264a = list;
            }

            public final void a(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                String mimeType = jsonObject.getString("mimeType");
                String materialPath = jsonObject.getString("imagePath");
                String materialName = jsonObject.optString("imageName", "");
                int optInt = jsonObject.optInt("imageSize", 0);
                List list = this.f136264a;
                Intrinsics.checkNotNullExpressionValue(mimeType, "mimeType");
                Intrinsics.checkNotNullExpressionValue(materialPath, "materialPath");
                Intrinsics.checkNotNullExpressionValue(materialName, "materialName");
                list.add(new c(mimeType, materialPath, materialName, optInt));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((JSONObject) obj);
                return Unit.INSTANCE;
            }
        }

        public C6540a() {
        }

        public /* synthetic */ C6540a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            try {
                ArrayList arrayList = new ArrayList();
                com.tencent.luggage.wxa.qn.a.a(new JSONArray(new JSONObject(jsonStr).getString("personalCenterPublishPic")), new C6541a(arrayList));
                return new a(arrayList);
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.AppBrandProfileNativeExtraData", "fromJsonString fail since " + e16);
                return null;
            }
        }
    }

    public a(List personalCreatorExtraDataList) {
        Intrinsics.checkNotNullParameter(personalCreatorExtraDataList, "personalCreatorExtraDataList");
        this.f136263a = personalCreatorExtraDataList;
    }

    public static final a a(String str) {
        return f136262b.a(str);
    }

    public String b() {
        String str;
        try {
            JSONArray jSONArray = new JSONArray();
            for (c cVar : this.f136263a) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mimeType", cVar.d());
                jSONObject.put("imagePath", cVar.a());
                jSONObject.put("imageName", cVar.b());
                jSONObject.put("imageSize", cVar.c());
                jSONArray.mo162put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("personalCenterPublishPic", jSONArray);
            str = jSONObject2.toString();
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.AppBrandProfileNativeExtraData", "toJsonString fail since " + e16);
            str = "{}";
        }
        Intrinsics.checkNotNullExpressionValue(str, "try {\n            val js\u2026     EMPTY_JSON\n        }");
        return str;
    }

    public final List a() {
        return this.f136263a;
    }
}
