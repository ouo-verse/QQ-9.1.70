package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private String f39136a;

    /* renamed from: b, reason: collision with root package name */
    private long f39137b;

    public static List<s> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt instanceof JSONObject) {
                    s a16 = a((JSONObject) opt);
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                } else {
                    GDTLogger.e("Slot.parseList error !");
                }
            }
        }
        return arrayList;
    }

    public static s a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return null;
        }
        s sVar = new s();
        sVar.a(jSONObject.optString("url"));
        sVar.a(jSONObject.optLong("reporttime"));
        return sVar;
    }

    public String a() {
        return this.f39136a;
    }

    public void a(String str) {
        this.f39136a = str;
    }

    public void a(long j3) {
        this.f39137b = j3;
    }
}
