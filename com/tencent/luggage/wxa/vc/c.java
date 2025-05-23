package com.tencent.luggage.wxa.vc;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.wc.a0;
import com.tencent.luggage.wxa.wc.b0;
import com.tencent.luggage.wxa.wc.c0;
import com.tencent.luggage.wxa.wc.d0;
import com.tencent.luggage.wxa.wc.e0;
import com.tencent.luggage.wxa.wc.f0;
import com.tencent.luggage.wxa.wc.g;
import com.tencent.luggage.wxa.wc.g0;
import com.tencent.luggage.wxa.wc.h;
import com.tencent.luggage.wxa.wc.h0;
import com.tencent.luggage.wxa.wc.i;
import com.tencent.luggage.wxa.wc.i0;
import com.tencent.luggage.wxa.wc.j;
import com.tencent.luggage.wxa.wc.j0;
import com.tencent.luggage.wxa.wc.k;
import com.tencent.luggage.wxa.wc.k0;
import com.tencent.luggage.wxa.wc.l;
import com.tencent.luggage.wxa.wc.m;
import com.tencent.luggage.wxa.wc.n;
import com.tencent.luggage.wxa.wc.o;
import com.tencent.luggage.wxa.wc.p;
import com.tencent.luggage.wxa.wc.q;
import com.tencent.luggage.wxa.wc.r;
import com.tencent.luggage.wxa.wc.s;
import com.tencent.luggage.wxa.wc.t;
import com.tencent.luggage.wxa.wc.u;
import com.tencent.luggage.wxa.wc.v;
import com.tencent.luggage.wxa.wc.w;
import com.tencent.luggage.wxa.wc.x;
import com.tencent.luggage.wxa.wc.y;
import com.tencent.luggage.wxa.wc.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Map f143339a = new HashMap();

    public c() {
        a(new e0());
        a(new q());
        a(new f0());
        a(new v());
        a(new k());
        a(new com.tencent.luggage.wxa.wc.a());
        a(new h());
        a(new com.tencent.luggage.wxa.wc.e());
        a(new l());
        a(new i());
        a(new com.tencent.luggage.wxa.wc.f());
        a(new d0());
        a(new j());
        a(new g());
        a(new com.tencent.luggage.wxa.wc.c());
        a(new com.tencent.luggage.wxa.wc.b());
        a(new g0());
        a(new h0());
        a(new x());
        a(new a0());
        a(new b0());
        a(new c0());
        a(new s());
        a(new y());
        a(new t());
        a(new u());
        a(new r());
        a(new z());
        a(new i0());
        a(new w());
        a(new p());
        a(new n());
        a(new k0());
        a(new o());
        a(new m());
        a(new j0());
    }

    public boolean a(d dVar, Canvas canvas, JSONObject jSONObject) {
        String optString = jSONObject.optString("method");
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        com.tencent.luggage.wxa.wc.d dVar2 = (com.tencent.luggage.wxa.wc.d) this.f143339a.get(optString);
        if (dVar2 == null) {
            return false;
        }
        return dVar2.a(dVar, canvas, optJSONArray);
    }

    public boolean a(d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.a aVar) {
        com.tencent.luggage.wxa.wc.d dVar2 = (com.tencent.luggage.wxa.wc.d) this.f143339a.get(aVar.f144662a);
        if (dVar2 == null) {
            return false;
        }
        return dVar2.a(dVar, canvas, aVar);
    }

    public final void a(com.tencent.luggage.wxa.wc.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f143339a.put(dVar.getMethod(), dVar);
    }
}
