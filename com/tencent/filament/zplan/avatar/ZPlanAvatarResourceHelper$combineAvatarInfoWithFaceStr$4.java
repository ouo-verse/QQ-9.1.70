package com.tencent.filament.zplan.avatar;

import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"addFaceMakeups", "", "faceMakeup", "Lorg/json/JSONArray;", "dressUpSlots", "makeupSlots", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$4 extends Lambda implements Function3<JSONArray, JSONArray, JSONArray, Unit> {
    public static final ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$4 INSTANCE = new ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$4();

    ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$4() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        invoke2(jSONArray, jSONArray2, jSONArray3);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable JSONArray jSONArray, @Nullable JSONArray jSONArray2, @Nullable JSONArray jSONArray3) {
        boolean t06;
        if (jSONArray == null || jSONArray2 == null || jSONArray3 == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            long optLong = jSONArray.optJSONObject(i3).optLong("ShapeID");
            long optLong2 = jSONArray.optJSONObject(i3).optLong("SlotID");
            t06 = ZPlanAvatarResourceHelper.f105660o.t0(optLong2);
            JSONArray jSONArray4 = t06 ? jSONArray3 : jSONArray2;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, optLong2);
            jSONObject.put("item_id", optLong);
            Unit unit = Unit.INSTANCE;
            jSONArray4.mo162put(jSONObject);
        }
    }
}
