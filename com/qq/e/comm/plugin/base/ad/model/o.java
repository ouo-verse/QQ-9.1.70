package com.qq.e.comm.plugin.base.ad.model;

import com.qq.e.comm.plugin.k.y;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private String f39077a;

    public String a() {
        return this.f39077a;
    }

    public void a(String str) {
        this.f39077a = str;
    }

    public static o a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return null;
        }
        o oVar = new o();
        oVar.a(jSONObject.optString("image_url"));
        return oVar;
    }
}
