package com.tencent.luggage.wxa.i3;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final a f129339b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f129340c = {"host_scene"};

    /* renamed from: a, reason: collision with root package name */
    public final Map f129341a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a(String str) {
            boolean z16;
            boolean z17 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (z16) {
                return null;
            }
            try {
                return new n(com.tencent.luggage.wxa.e5.f.b(new JSONObject(str)), z17, 2, defaultConstructorMarker);
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f129342a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return null;
        }
    }

    public n(Map map, boolean z16) {
        Map withDefaultMutable;
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (z16 ? ArraysKt___ArraysKt.contains(f129340c, entry.getKey()) : true) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new HashMap(linkedHashMap), b.f129342a);
        this.f129341a = withDefaultMutable;
    }

    public final int a() {
        Object obj = this.f129341a.get("host_scene");
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e16) {
                com.tencent.luggage.wxa.tn.w.b("WxaHostNativeExtraData", "parse host_scene(" + obj + ") get exception:" + e16);
                return 0;
            }
        }
        if (!(obj instanceof Number)) {
            return 0;
        }
        return ((Number) obj).intValue();
    }

    public final String b() {
        Object obj = this.f129341a.get(StartupReportKey.SCENE_NOTE);
        if (obj == null || !(obj instanceof String)) {
            return "";
        }
        return (String) obj;
    }

    public final String c() {
        com.tencent.luggage.wxa.h6.f.a(this.f129341a);
        String jSONObject = new JSONObject(this.f129341a).toString(0);
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(map).toString(0)");
        return jSONObject;
    }

    public final Map d() {
        return this.f129341a;
    }

    public /* synthetic */ n(Map map, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i3 & 2) != 0 ? false : z16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(String json, boolean z16) {
        this(com.tencent.luggage.wxa.e5.f.b(new JSONObject(json)), z16);
        Intrinsics.checkNotNullParameter(json, "json");
    }

    public /* synthetic */ n(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16);
    }
}
