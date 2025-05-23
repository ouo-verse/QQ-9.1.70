package com.tencent.luggage.wxa.z5;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ei.z;
import com.tencent.luggage.wxa.fd.o;
import com.tencent.luggage.wxa.kj.g0;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.o0;
import com.tencent.luggage.wxa.kj.q0;
import com.tencent.luggage.wxa.kj.u1;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.kj.y0;
import com.tencent.luggage.wxa.lk.j;
import com.tencent.luggage.wxa.p5.e;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.w;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends y0 {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends b {
        public a(c cVar) {
            super(cVar);
        }

        @Override // com.tencent.luggage.wxa.z5.b
        public void e(String str) {
            w.d("Luggage.MPPageViewRendererStandaloneXWebImpl", "onScriptCodeCacheProvided(%s)", str);
        }
    }

    public c(@NonNull e eVar) {
        super(eVar);
    }

    @Override // com.tencent.luggage.wxa.kj.y0, com.tencent.luggage.wxa.kj.a
    public final q0 O() {
        if (b0().supportFeature(2002) && b0().supportFeature(2004)) {
            return new a(this);
        }
        return super.O();
    }

    public final int Z() {
        return w().S().V;
    }

    @Override // com.tencent.luggage.wxa.kj.y0, com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.kj.x
    public boolean a(String str, k1 k1Var) {
        j.a(u(), "internal:prepare", "MPPageViewRendererStandaloneXWebImpl:loadURL");
        boolean a16 = super.a(str, k1Var);
        e eVar = (e) t();
        Objects.requireNonNull(eVar);
        com.tencent.luggage.wxa.z5.a.a(eVar);
        j.c(u());
        return a16;
    }

    public final q a0() {
        return (q) a(q.class);
    }

    public u1 b0() {
        if (H() instanceof u1) {
            return (u1) H();
        }
        if (H() instanceof g0) {
            o0 C = ((g0) H()).C();
            if (C instanceof u1) {
                return (u1) C;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.y0
    public o0 d(Context context) {
        u1 u1Var = new u1(context);
        o.b(u1Var.getOriginUserAgent());
        return u1Var;
    }

    @Override // com.tencent.luggage.wxa.kj.y0, com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void m() {
        Objects.requireNonNull((e) t());
        if (z.a((v) t())) {
            z.a(((e) t()).getJsRuntime(), ((e) t()).y0().getComponentId(), ((e) t()).getComponentId(), u());
        }
        super.m();
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.mj.d
    public Map q() {
        return new com.tencent.luggage.wxa.p5.c().b();
    }
}
