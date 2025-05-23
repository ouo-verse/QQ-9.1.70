package com.tencent.luggage.wxa.x4;

import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.r4.d;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xi.a;
import com.tencent.luggage.wxa.xi.f;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends a.d {

        /* renamed from: d, reason: collision with root package name */
        public final e f144592d;

        @Override // com.tencent.luggage.wxa.xi.a.d, com.tencent.luggage.wxa.xi.a
        public void a(String str, a.c cVar) {
            ((d) this.f144592d.h0()).b(ModulePkgInfo.MAIN_MODULE_NAME);
            super.a(str, cVar);
        }

        public b(e eVar) {
            this.f144592d = eVar;
        }
    }

    public static com.tencent.luggage.wxa.xi.a a(e eVar) {
        boolean z16;
        if (eVar.j0() != null && (!w0.a((List) eVar.j0().f125966l.f151864d) || eVar.S().l())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new f(eVar);
        }
        return new b(eVar);
    }
}
