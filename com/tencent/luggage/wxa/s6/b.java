package com.tencent.luggage.wxa.s6;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.v3.m;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f140072a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f140073b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f140074a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(m.f143124a.b());
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f140074a);
        f140073b = lazy;
    }

    public final int a() {
        return ((Number) f140073b.getValue()).intValue();
    }

    public final void a(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, "SDK");
            jSONObject.put("appId", s.d.f138074a.b());
            jSONObject.put("version", 603979777);
            jSONObject.put("localWeChatVersion", f140072a.a());
            Unit unit = Unit.INSTANCE;
            config.put("host", jSONObject);
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.m9.b.a("Luggage.WXA.CommonWxConfig", "attachCommonConfig assign __wxConfig.host e=" + e16);
        }
    }
}
