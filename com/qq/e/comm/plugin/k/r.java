package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class r {
    public static Pair<Integer, JSONArray> a(String str) {
        Pair<Integer, JSONArray> a16;
        JSONArray jSONArray = new JSONArray();
        String c16 = com.qq.e.comm.plugin.j.e.a().c(str, "ex_exp_info");
        int i3 = -1;
        if (!TextUtils.isEmpty(c16) && (a16 = a(c16, -1, jSONArray)) != null) {
            i3 = ((Integer) a16.first).intValue();
            jSONArray = (JSONArray) a16.second;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("wuji expinfo = ");
        sb5.append(jSONArray);
        GDTLogger.d(sb5.toString() != null ? jSONArray.toString() : "");
        return new Pair<>(Integer.valueOf(i3), jSONArray);
    }

    public static Pair<Integer, JSONArray> b(String str) {
        String str2;
        Pair<Integer, JSONArray> a16;
        Pair<Integer, JSONArray> a17;
        JSONArray jSONArray = new JSONArray();
        String b16 = com.qq.e.comm.plugin.j.e.a().b((String) null, "ex_exp_info");
        int i3 = -1;
        if (!TextUtils.isEmpty(b16) && (a17 = a(b16, -1, jSONArray)) != null) {
            i3 = ((Integer) a17.first).intValue();
            jSONArray = (JSONArray) a17.second;
        }
        String b17 = com.qq.e.comm.plugin.j.e.a().b(str, "ex_exp_info");
        if (!TextUtils.isEmpty(b17) && !b17.equals(b16) && (a16 = a(b17, i3, jSONArray)) != null) {
            i3 = ((Integer) a16.first).intValue();
            jSONArray = (JSONArray) a16.second;
        }
        if (("wuji expinfo = " + jSONArray) != null) {
            str2 = jSONArray.toString();
        } else {
            str2 = "";
        }
        GDTLogger.d(str2);
        return new Pair<>(Integer.valueOf(i3), jSONArray);
    }

    public static Pair<Integer, JSONArray> a(String str, int i3, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject a16 = y.a(str);
        int c16 = y.c(a16, "type");
        JSONArray f16 = y.f(a16, "exp_id");
        if (!w.b(f16)) {
            if (w.b(jSONArray)) {
                jSONArray = f16;
            } else {
                for (int i16 = 0; i16 < f16.length(); i16++) {
                    w.a(jSONArray, w.c(f16, i16));
                }
            }
        }
        return new Pair<>(Integer.valueOf(c16), jSONArray);
    }
}
