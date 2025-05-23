package com.tencent.luggage.wxa.l6;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.ef.k {
    public static final int CTRL_INDEX = 57;

    @NotNull
    public static final String NAME = "geoLocation";

    /* renamed from: b, reason: collision with root package name */
    public static final a f133063b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public String makeReturnJson(String reason, Map map) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        com.tencent.luggage.wxa.h6.f.a(map);
        JSONObject jSONObject = new JSONObject(map);
        if (jSONObject.has("buildingId")) {
            jSONObject.put("indoor_building_id", jSONObject.remove("buildingId"));
        }
        if (jSONObject.has("floorName")) {
            jSONObject.put("indoor_building_floor", jSONObject.remove("floorName"));
        }
        if (jSONObject.has("indoorLocationType")) {
            jSONObject.put("indoor_building_type", jSONObject.remove("indoorLocationType"));
        }
        jSONObject.put("err_msg", "geo_location:" + reason);
        String makeReturnJson = super.makeReturnJson(reason, jSONObject);
        Intrinsics.checkNotNullExpressionValue(makeReturnJson, "super.makeReturnJson(reason, json)");
        return makeReturnJson;
    }
}
