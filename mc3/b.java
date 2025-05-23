package mc3;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import xu4.c;
import xu4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"Lxu4/f;", "Lorg/json/JSONObject;", "c", "Lxu4/a;", "a", "Lxu4/c;", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final JSONObject a(xu4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", aVar.f448705a);
            jSONObject.put("title", aVar.f448706b);
            jSONObject.put("msg", aVar.f448707c);
            jSONObject.put("url", aVar.f448708d);
            jSONObject.put("modal", aVar.f448709e);
            jSONObject.put("data", aVar.f448710f);
            jSONObject.put("logout_time", aVar.f448711g);
            jSONObject.put("rulename", aVar.f448712h);
        } catch (Exception e16) {
            QLog.w("Instruction", 4, "json failed", e16);
        }
        return jSONObject;
    }

    public static final JSONObject b(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", cVar.f448719a);
            jSONObject.put("msg", cVar.f448720b);
            jSONObject.put("traceId", cVar.f448721c);
            jSONObject.put("duration", cVar.f448723e);
            JSONArray jSONArray = new JSONArray();
            xu4.a[] instructions = cVar.f448722d;
            Intrinsics.checkNotNullExpressionValue(instructions, "instructions");
            for (xu4.a i3 : instructions) {
                Intrinsics.checkNotNullExpressionValue(i3, "i");
                jSONArray.mo162put(a(i3));
            }
            jSONObject.put("instructions", jSONArray);
        } catch (Exception e16) {
            QLog.w("JudgeTimingRsp", 4, "json failed", e16);
        }
        return jSONObject;
    }

    public static final JSONObject c(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", fVar.f448728a);
            jSONObject.put("ruleName", fVar.f448729b);
            jSONObject.put("instrTraceid", fVar.f448730c);
            jSONObject.put("execTime", fVar.f448731d);
        } catch (Exception e16) {
            QLog.w("ReportInfo", 4, "json failed", e16);
        }
        return jSONObject;
    }
}
