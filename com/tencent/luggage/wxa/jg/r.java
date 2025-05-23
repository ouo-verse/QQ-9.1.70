package com.tencent.luggage.wxa.jg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r extends com.tencent.luggage.wxa.xd.v {
    private static final int CTRL_INDEX = 1063;

    @NotNull
    private static final String NAME = "openSystemSetting";

    /* renamed from: a, reason: collision with root package name */
    public static final b f131116a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f131117b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f131118a = new a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jg.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6338a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public static final C6338a f131119a = new C6338a();

            public C6338a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
                boolean z16 = true;
                if (w0.a(context, intent, true)) {
                    try {
                        com.tencent.luggage.wxa.fa.b.a(context, intent);
                        context.startActivity(intent);
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.JsApiOpenSystemSetting", e16, "", new Object[0]);
                    }
                    return Boolean.valueOf(z16);
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public static final b f131120a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intent intent = new Intent("android.settings.BLUETOOTH_SETTINGS");
                boolean z16 = true;
                if (w0.a(context, intent, true)) {
                    try {
                        com.tencent.luggage.wxa.fa.b.a(context, intent);
                        context.startActivity(intent);
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.JsApiOpenSystemSetting", e16, "", new Object[0]);
                    }
                    return Boolean.valueOf(z16);
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        }

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            Map mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("appAuthorize", C6338a.f131119a), TuplesKt.to("systemBluetooth", b.f131120a));
            return mapOf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map a() {
            return (Map) r.f131117b.getValue();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f131118a);
        f131117b = lazy;
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, env is null");
            String makeReturnJson = makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson, "makeReturnJson(AppBrandE\u2026s.General.INTERNAL_ERROR)");
            return makeReturnJson;
        }
        Context context = dVar.getContext();
        if (context == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, context is null");
            String makeReturnJson2 = makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson2, "makeReturnJson(AppBrandE\u2026s.General.INTERNAL_ERROR)");
            return makeReturnJson2;
        }
        if (jSONObject != null && jSONObject.has("type")) {
            String optString = jSONObject.optString("type");
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, openType: " + optString);
            Function1 function1 = (Function1) f131116a.a().get(optString);
            if (function1 == null) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, openAction is null");
                String makeReturnJson3 = makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
                Intrinsics.checkNotNullExpressionValue(makeReturnJson3, "makeReturnJson(AppBrandE\u2026ral.INVALID_REQUEST_DATA)");
                return makeReturnJson3;
            }
            if (!((Boolean) function1.invoke(context)).booleanValue()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, open fail");
                String makeReturnJson4 = makeReturnJson(com.tencent.luggage.wxa.af.a.f121214e);
                Intrinsics.checkNotNullExpressionValue(makeReturnJson4, "makeReturnJson(AppBrandE\u2026.SETTINGS_PAGE_NOT_FOUND)");
                return makeReturnJson4;
            }
            String makeReturnJson5 = makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson5, "makeReturnJson(AppBrandErrors.General.OK)");
            return makeReturnJson5;
        }
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, data is illegal, data: " + jSONObject);
        String makeReturnJson6 = makeReturnJson(com.tencent.luggage.wxa.af.e.f121315k);
        Intrinsics.checkNotNullExpressionValue(makeReturnJson6, "makeReturnJson(AppBrandE\u2026ral.INVALID_REQUEST_DATA)");
        return makeReturnJson6;
    }
}
