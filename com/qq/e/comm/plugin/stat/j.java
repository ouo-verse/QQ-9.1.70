package com.qq.e.comm.plugin.stat;

import android.util.Pair;
import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.x;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.TGSplashExpIdUtil;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class j {
    public static void a(int i3, int i16, JSONObject jSONObject, JSONObject jSONObject2) {
        if (f.a(i3)) {
            try {
                jSONObject2 = a(y.e(jSONObject, "pid"), jSONObject2);
            } catch (Throwable th5) {
                GDTLogger.e("StatEventReportUtils [add]:", th5);
            }
            try {
                if (GDTLogger.isEnableConsoleLog()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("StatTrackerReport  eventId =");
                    sb5.append(i3);
                    sb5.append("=eventValue ==");
                    sb5.append(i16);
                    sb5.append("=biz ==");
                    String str = "";
                    sb5.append(jSONObject == null ? "" : jSONObject.toString());
                    sb5.append("=ext ==");
                    if (jSONObject2 != null) {
                        str = jSONObject2.toString();
                    }
                    sb5.append(str);
                    GDTLogger.d(sb5.toString());
                }
            } catch (Throwable th6) {
                GDTLogger.e("StatEventReportUtils:", th6);
            }
            long currentTimeMillis = System.currentTimeMillis();
            x xVar = new x();
            xVar.a("seq", l.a()).a("ts", currentTimeMillis).a("ei", i3).a(LinkReportConstant$EventKey.VALUE, i16).a("biz", jSONObject).a("ext", jSONObject2);
            p.a().a(e.a(currentTimeMillis, d.a(xVar.a(), "ext"), i3));
        }
    }

    private static JSONObject b(String str, JSONObject jSONObject) {
        Pair<Integer, JSONArray> a16 = com.qq.e.comm.plugin.j.e.a().a(str);
        if (a16 == null) {
            return jSONObject;
        }
        if (!w.b((JSONArray) a16.second)) {
            w.a((JSONArray) a16.second, y.f(jSONObject, "exp_id"));
            if (!w.b((JSONArray) a16.second)) {
                if (y.a(jSONObject)) {
                    jSONObject = y.a(jSONObject.toString());
                } else {
                    jSONObject = y.a();
                }
                y.a(jSONObject, "exp_id", a16.second);
                y.a(jSONObject, "exp_type", a16.first);
            }
        }
        return jSONObject;
    }

    public static void a() {
        p.a().b();
    }

    private static JSONObject a(String str, JSONObject jSONObject) {
        JSONArray a16 = w.a(TGSplashExpIdUtil.getExpIdSet());
        if (!w.b(a16)) {
            JSONObject a17 = y.a(jSONObject) ? y.a(jSONObject.toString()) : y.a();
            w.a(a16, y.f(jSONObject, "exp_id"));
            y.a(a17, "exp_id", a16);
            jSONObject = a17;
        }
        return b(str, jSONObject);
    }
}
