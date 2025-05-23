package com.tencent.luggage.wxa.bf;

import com.tencent.luggage.wxa.bf.e;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.o f122533a;

    static {
        e.a.a();
    }

    public abstract f a(com.tencent.luggage.wxa.xd.d dVar, String str, JSONObject jSONObject);

    public void a(com.tencent.luggage.wxa.xd.o oVar) {
        this.f122533a = oVar;
    }

    public final f a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.ei.p pVar, JSONObject jSONObject) {
        String a16 = a(jSONObject);
        if (com.tencent.luggage.wxa.tn.w0.c(a16)) {
            return new f("fail invalid path", new Object[0]);
        }
        if (!dVar.a(this.f122533a.getName(), pVar)) {
            return new f("fail:interrupted", new Object[0]);
        }
        return a(dVar, a16, jSONObject);
    }

    public String a(JSONObject jSONObject) {
        String optString = jSONObject.optString("filePath", null);
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            optString = jSONObject.optString("dirPath", null);
        }
        return com.tencent.luggage.wxa.tn.w0.c(optString) ? jSONObject.optString("path", null) : optString;
    }
}
