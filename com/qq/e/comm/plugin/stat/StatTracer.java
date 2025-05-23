package com.qq.e.comm.plugin.stat;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StatTracer {
    public static void instantReport(String str) {
        if (com.qq.e.comm.plugin.j.c.a(str, "linkEventInstantReport", 1, 1)) {
            j.a();
        }
    }

    @Deprecated
    public static void trackEvent(int i3, int i16, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("pid", str);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        j.a(i3, i16, jSONObject2, jSONObject);
    }

    public static void trackEvent(int i3, JSONObject jSONObject, JSONObject jSONObject2) {
        j.a(i3, 0, jSONObject, jSONObject2);
    }

    public static void trackEvent(int i3, int i16, b bVar, c cVar) {
        j.a(i3, i16, bVar == null ? null : bVar.a(), cVar != null ? cVar.a() : null);
    }

    public static void trackEvent(int i3, int i16, b bVar) {
        trackEvent(i3, i16, bVar, (c) null);
    }
}
