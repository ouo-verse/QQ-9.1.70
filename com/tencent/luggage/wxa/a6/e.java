package com.tencent.luggage.wxa.a6;

import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.z;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.r4.c {
    public final g L;

    public e(com.tencent.luggage.wxa.r4.d dVar) {
        super(dVar);
        this.L = new b();
    }

    @Override // com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public void U() {
        super.U();
        Objects.requireNonNull((com.tencent.luggage.wxa.r4.d) t());
        if (z.a((l) t())) {
            z.b(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), ((com.tencent.luggage.wxa.r4.d) t()).getComponentId(), x());
            z.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), ((com.tencent.luggage.wxa.r4.d) t()).getComponentId(), ((com.tencent.luggage.wxa.r4.d) t()).getComponentId(), x());
        }
        this.L.a(this);
    }

    @Override // com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public boolean a(String str, JSONObject jSONObject) {
        f.a();
        if (super.a(str, jSONObject)) {
            return true;
        }
        return this.L.a(str, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public void b(com.tencent.luggage.wxa.ic.g gVar) {
        super.b(gVar);
        this.L.a(gVar);
    }

    @Override // com.tencent.luggage.wxa.r4.c
    public String d0() {
        return super.d0() + com.tencent.luggage.wxa.tk.c.b("wxa_library/NativeGlobal-WAService.js");
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public Map q() {
        return new com.tencent.luggage.wxa.p5.c().a();
    }

    public final byte[] t0() {
        if (com.tencent.luggage.wxa.t9.l.i()) {
            return com.tencent.luggage.wxa.tk.c.a("wxa_library/v8_snapshot64.bin");
        }
        return com.tencent.luggage.wxa.tk.c.a("wxa_library/v8_snapshot.bin");
    }

    @Override // com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public void u() {
        super.u();
        this.L.a();
    }

    @Override // com.tencent.luggage.wxa.r4.c, com.tencent.luggage.wxa.r4.f
    public j v() {
        d.a aVar = new d.a(com.tencent.luggage.wxa.q5.c.f137855a.a(), t0());
        aVar.f122191g = true;
        aVar.f122190f = "1";
        aVar.f122199o = new WeakReference((com.tencent.luggage.wxa.xd.e) t());
        return new com.tencent.luggage.wxa.ei.d(aVar);
    }

    @Override // com.tencent.luggage.wxa.r4.f, com.tencent.luggage.wxa.m4.a
    public Object a(Class cls) {
        Object a16 = super.a(cls);
        if (a16 != null) {
            return a16;
        }
        Object a17 = this.L.a(cls);
        if (a17 != null) {
            return cls.cast(a17);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        try {
            jSONObject.put("JSEngineName", com.tencent.luggage.wxa.u4.b.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime()));
            jSONObject.put("supressOffscreenPatch", true);
        } catch (JSONException e16) {
            w.a("Luggage.Standalone.MPServiceLogic", e16, "attachCommonConfig error", new Object[0]);
        }
    }
}
