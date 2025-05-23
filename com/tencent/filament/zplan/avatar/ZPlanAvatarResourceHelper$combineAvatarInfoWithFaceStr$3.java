package com.tencent.filament.zplan.avatar;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"addFaceColors", "", "faceColors", "Lorg/json/JSONArray;", "colorInfoSlots", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$3 extends Lambda implements Function2<JSONArray, JSONArray, Unit> {
    public static final ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$3 INSTANCE = new ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$3();

    ZPlanAvatarResourceHelper$combineAvatarInfoWithFaceStr$3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(JSONArray jSONArray, JSONArray jSONArray2) {
        invoke2(jSONArray, jSONArray2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable JSONArray jSONArray, @Nullable JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray2 == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, jSONArray.optJSONObject(i3).getLong("SlotID"));
            jSONObject.put("color_type", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("custom_color", com.tencent.filament.zplan.util.b.f106240a.b(jSONArray.optJSONObject(i3).optLong(BdhLogUtil.LogTag.Tag_Req), jSONArray.optJSONObject(i3).optLong("G"), jSONArray.optJSONObject(i3).optLong("B"), 255L));
            Unit unit = Unit.INSTANCE;
            jSONObject.put("single_color", jSONObject2);
            jSONArray2.mo162put(jSONObject);
        }
    }
}
