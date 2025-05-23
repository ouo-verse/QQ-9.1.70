package com.tencent.luggage.wxa.ae;

import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.hn.m9;
import com.tencent.luggage.wxa.ml.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.f1;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k extends com.tencent.luggage.wxa.xd.a implements com.tencent.luggage.wxa.xd.b {
    @Override // com.tencent.luggage.wxa.xd.b
    public void a(f1 f1Var) {
        com.tencent.luggage.wxa.xd.d f16 = f1Var.f();
        JSONObject e16 = f1Var.e();
        f1Var.g();
        f1Var.d();
        boolean optBoolean = e16.optBoolean("requestInQueue", true);
        if ("adOperateWXData".equalsIgnoreCase(getName())) {
            a(f1Var, (g) null);
            return;
        }
        try {
            e16.put("wxdataQueueTimestamp", w0.c());
        } catch (JSONException unused) {
        }
        if (!optBoolean) {
            b.a(f16).a(this, f1Var);
        } else {
            e.a(f16).a(this, f1Var);
        }
    }

    public abstract void a(f1 f1Var, g gVar);

    public final void b(f1 f1Var, g gVar) {
        a(f1Var, gVar);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public final void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        throw new UnsupportedOperationException();
    }

    public final void b(f1 f1Var) {
        w.d("MicroMsg.AppBrand.BaseAuthJsApi", "AuthTimeout callback id:%d", Integer.valueOf(f1Var.d()));
        com.tencent.luggage.wxa.xd.d f16 = f1Var.f();
        int d16 = f1Var.d();
        com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121310f;
        a(f16, d16, cVar.f121278b, cVar);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public final void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p pVar) {
        throw new UnsupportedOperationException();
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str, JSONObject jSONObject) {
        dVar.a(i3, makeReturnJson(str, jSONObject));
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str, com.tencent.luggage.wxa.af.c cVar) {
        if (w0.c(str)) {
            dVar.a(i3, makeReturnJson(cVar));
        } else {
            dVar.a(i3, makeReturnJson(str, cVar));
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str, com.tencent.luggage.wxa.af.c cVar, JSONObject jSONObject) {
        if (w0.c(str)) {
            dVar.a(i3, makeReturnJson(cVar, jSONObject));
        } else {
            dVar.a(i3, makeReturnJson(str, cVar, jSONObject));
        }
    }

    public static LinkedList a(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m9 m9Var = (m9) it.next();
            c.f fVar = new c.f();
            fVar.f134645a = m9Var.f128168d;
            fVar.f134647c = m9Var.f128169e;
            fVar.f134646b = m9Var.f128170f;
            linkedList2.add(fVar);
        }
        return linkedList2;
    }

    public boolean a(JSONArray jSONArray, com.tencent.luggage.wxa.ic.g gVar) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                } catch (JSONException unused) {
                    w.b("MicroMsg.AppBrand.BaseAuthJsApi", "illegal arguments");
                }
                if (gVar.c(jSONArray.get(i3).toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
