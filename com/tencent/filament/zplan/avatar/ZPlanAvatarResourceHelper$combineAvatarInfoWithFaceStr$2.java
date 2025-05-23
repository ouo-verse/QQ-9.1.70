package com.tencent.filament.zplan.avatar;

import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"addFaceControlPoints", "", "faceControlPoints", "Lorg/json/JSONArray;", "slot", "", "faceInfoSlots", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2 extends Lambda implements Function3<JSONArray, Long, JSONArray, Unit> {
    public static final ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2 INSTANCE = new ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2();

    ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(JSONArray jSONArray, Long l3, JSONArray jSONArray2) {
        invoke(jSONArray, l3.longValue(), jSONArray2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable JSONArray jSONArray, long j3, @Nullable JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null) {
            return;
        }
        int length = jSONArray.length();
        JSONArray jSONArray3 = new JSONArray();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("control_index", optJSONObject.optInt("GroupID"));
                jSONObject.put("x_per", (int) (optJSONObject.optDouble("Pos") * 100));
                Unit unit = Unit.INSTANCE;
                jSONArray3.mo162put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("control_points", jSONArray3);
        jSONObject2.put(MiniAppReportManager2.KEY_SLOT_ID, j3);
        Unit unit2 = Unit.INSTANCE;
        jSONArray2.mo162put(jSONObject2);
    }
}
