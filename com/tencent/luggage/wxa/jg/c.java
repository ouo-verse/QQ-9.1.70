package com.tencent.luggage.wxa.jg;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f131069a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Map a(String type, com.tencent.luggage.wxa.xd.d component) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        return null;
    }

    public final Map a(com.tencent.luggage.wxa.xd.d component, JSONObject jSONObject) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(component, "component");
        String optString = jSONObject != null ? jSONObject.optString("type") : null;
        if (optString == null || optString.length() == 0) {
            return null;
        }
        Map a16 = a(optString, component);
        if (a16 != null) {
            return a16;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }
}
