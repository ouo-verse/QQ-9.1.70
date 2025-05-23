package h03;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import f03.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lh03/c;", "", "Lorg/json/JSONObject;", "animJsonObject", "Lf03/d;", "shootAnimationConfig", "", "a", "Lf03/b;", "bubbleConfig", "", "jsonString", "bubbleId", "b", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {
    private final void a(JSONObject animJsonObject, d shootAnimationConfig) {
        d.a aVar = new d.a();
        String optString = animJsonObject.optString("type");
        Intrinsics.checkNotNullExpressionValue(optString, "animJsonObject.optString(\"type\")");
        aVar.p(optString);
        aVar.i(animJsonObject.optInt("duration"));
        aVar.f(animJsonObject.optInt("delay"));
        aVar.j(animJsonObject.optInt("op"));
        aVar.l(animJsonObject.optInt("sx"));
        aVar.m(animJsonObject.optInt("sy"));
        aVar.k(animJsonObject.optInt("rz"));
        aVar.g(animJsonObject.optInt("dirX"));
        aVar.h(animJsonObject.optInt("dirY"));
        aVar.n(animJsonObject.optInt("tx"));
        aVar.o(animJsonObject.optInt(AdParam.TY));
        shootAnimationConfig.a().add(aVar);
        if (Intrinsics.areEqual(aVar.getType(), "physical")) {
            shootAnimationConfig.w(aVar.getDelay());
        }
        if (Intrinsics.areEqual(aVar.getType(), CanvasView.ACTION_ROTATE)) {
            shootAnimationConfig.x(aVar.getRz());
        }
        if (Intrinsics.areEqual(aVar.getType(), "opacity")) {
            if (aVar.getOp() == 0) {
                shootAnimationConfig.s(aVar.getDelay());
                shootAnimationConfig.t(aVar.getDuration());
            } else if (aVar.getOp() == 1) {
                shootAnimationConfig.z(aVar.getDelay());
                shootAnimationConfig.A(aVar.getDuration());
            }
        }
    }

    public final void b(@NotNull f03.b bubbleConfig, @NotNull String jsonString, @NotNull String bubbleId) {
        JSONArray jSONArray;
        List split$default;
        List split$default2;
        List split$default3;
        List split$default4;
        List split$default5;
        List split$default6;
        Intrinsics.checkNotNullParameter(bubbleConfig, "bubbleConfig");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        d dVar = new d();
        dVar.p(bubbleId);
        JSONObject jSONObject = new JSONObject(jsonString);
        if (jSONObject.has("eles")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("eles");
            int length = jSONArray2.length();
            JSONArray jSONArray3 = null;
            JSONObject jSONObject2 = null;
            JSONObject jSONObject3 = null;
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject4 = jSONArray2.getJSONObject(i3);
                if (jSONObject4.optInt("id") == 1) {
                    jSONObject2 = jSONObject4;
                }
                if (jSONObject4.optInt("id") == 5) {
                    jSONObject3 = jSONObject4;
                }
            }
            if (jSONObject2 != null && jSONObject2.has(ReportConstant.COSTREPORT_TRANS)) {
                JSONArray jSONArray4 = jSONObject2.getJSONArray(ReportConstant.COSTREPORT_TRANS);
                int length2 = jSONArray4.length();
                JSONArray jSONArray5 = null;
                for (int i16 = 0; i16 < length2; i16++) {
                    JSONObject jSONObject5 = jSONArray4.getJSONObject(i16);
                    if (jSONObject5.has("linkViews")) {
                        jSONArray3 = jSONObject5.getJSONArray("linkViews");
                    }
                    if (jSONObject5.has("anim")) {
                        jSONArray5 = jSONObject5.getJSONArray("anim");
                    }
                }
                jSONArray = jSONArray3;
                jSONArray3 = jSONArray5;
            } else {
                jSONArray = null;
            }
            if (jSONArray3 != null) {
                int length3 = jSONArray3.length();
                for (int i17 = 0; i17 < length3; i17++) {
                    JSONObject animJsonObject = jSONArray3.getJSONObject(i17);
                    if (Intrinsics.areEqual(animJsonObject.optString("status"), "physical")) {
                        Intrinsics.checkNotNullExpressionValue(animJsonObject, "animJsonObject");
                        a(animJsonObject, dVar);
                    }
                }
            }
            if (jSONArray != null) {
                int length4 = jSONArray.length();
                int i18 = 0;
                while (true) {
                    if (i18 >= length4) {
                        break;
                    }
                    JSONObject jSONObject6 = jSONArray.getJSONObject(i18);
                    if (Intrinsics.areEqual(jSONObject6.optString("status", ""), "physical")) {
                        dVar.v(jSONObject6.optInt("parCount"));
                        if (jSONObject6.has("parRules")) {
                            JSONObject optJSONObject = jSONObject6.optJSONObject("parRules");
                            String bgString = optJSONObject.optString("st.bg");
                            Intrinsics.checkNotNullExpressionValue(bgString, "bgString");
                            split$default = StringsKt__StringsKt.split$default((CharSequence) bgString, new String[]{":"}, false, 0, 6, (Object) null);
                            if (split$default.size() == 2) {
                                dVar.y((String) split$default.get(0));
                                split$default6 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{","}, false, 0, 6, (Object) null);
                                dVar.l().addAll(split$default6);
                            }
                            String dirXJsonString = optJSONObject.optString("anim.dirX");
                            Intrinsics.checkNotNullExpressionValue(dirXJsonString, "dirXJsonString");
                            split$default2 = StringsKt__StringsKt.split$default((CharSequence) dirXJsonString, new String[]{":"}, false, 0, 6, (Object) null);
                            if (split$default2.size() == 2) {
                                split$default5 = StringsKt__StringsKt.split$default((CharSequence) split$default2.get(1), new String[]{","}, false, 0, 6, (Object) null);
                                dVar.b().addAll(split$default5);
                            }
                            String dirYJsonString = optJSONObject.optString("anim.dirY");
                            Intrinsics.checkNotNullExpressionValue(dirYJsonString, "dirYJsonString");
                            split$default3 = StringsKt__StringsKt.split$default((CharSequence) dirYJsonString, new String[]{":"}, false, 0, 6, (Object) null);
                            if (split$default3.size() == 2) {
                                split$default4 = StringsKt__StringsKt.split$default((CharSequence) split$default3.get(1), new String[]{","}, false, 0, 6, (Object) null);
                                dVar.c().addAll(split$default4);
                            }
                        }
                    } else {
                        i18++;
                    }
                }
            }
            if (jSONObject3 != null) {
                if (jSONObject3.has("st")) {
                    JSONObject optJSONObject2 = jSONObject3.optJSONObject("st");
                    dVar.B(optJSONObject2.optInt("w"));
                    dVar.r(optJSONObject2.optInt(h.F));
                    dVar.u(optJSONObject2.optInt("op"));
                }
                if (jSONObject3.has("tp")) {
                    dVar.q(jSONObject3.optJSONObject("tp").optInt("duration"));
                }
                if (jSONObject3.has("anim")) {
                    JSONArray optJSONArray = jSONObject3.optJSONArray("anim");
                    int length5 = optJSONArray.length();
                    for (int i19 = 0; i19 < length5; i19++) {
                        JSONObject animJsonObject2 = optJSONArray.getJSONObject(i19);
                        Intrinsics.checkNotNullExpressionValue(animJsonObject2, "animJsonObject");
                        a(animJsonObject2, dVar);
                    }
                }
            }
            bubbleConfig.z(dVar);
        }
    }
}
