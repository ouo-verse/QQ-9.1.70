package com.tencent.luggage.wxa.iq;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.luggage.wxa.jq.h;
import com.tencent.luggage.wxa.zp.j;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final b f130752a;

    /* renamed from: b, reason: collision with root package name */
    public final c f130753b;

    /* renamed from: c, reason: collision with root package name */
    public final f f130754c = new f();

    public e(com.tencent.luggage.wxa.zp.a aVar) {
        this.f130752a = new b(aVar.f146779b, aVar.f146778a);
        this.f130753b = new c(aVar.f146780c);
    }

    public com.tencent.luggage.wxa.jq.c a(h hVar, boolean z16) {
        return a(hVar, z16, a(hVar));
    }

    public com.tencent.luggage.wxa.jq.c b(h hVar, boolean z16) {
        return a(hVar, z16, this.f130752a);
    }

    public com.tencent.luggage.wxa.jq.c c(h hVar, boolean z16) {
        return a(hVar, z16, this.f130753b);
    }

    public com.tencent.luggage.wxa.jq.c d(h hVar, boolean z16) {
        hVar.a(this.f130754c);
        if (z16) {
            this.f130754c.d(hVar);
            return new j(hVar);
        }
        return new j(this.f130754c.a(hVar));
    }

    public final com.tencent.luggage.wxa.jq.c a(h hVar, boolean z16, d dVar) {
        hVar.a(dVar);
        if (hVar instanceof com.tencent.luggage.wxa.kq.e) {
            com.tencent.luggage.wxa.kq.e eVar = (com.tencent.luggage.wxa.kq.e) hVar;
            eVar.n().b().a(z16 ? WebViewConstants.WV.ENABLE_WEBAIO_SWITCH : hVar.getDelay(TimeUnit.MILLISECONDS), eVar);
        } else {
            hVar.f().a(hVar);
        }
        return hVar;
    }

    public final d a(h hVar) {
        com.tencent.luggage.wxa.bq.c cVar = com.tencent.luggage.wxa.cq.b.f123843a;
        if (cVar != null) {
            if (cVar.a(hVar.getKey())) {
                return this.f130752a;
            }
            if (this.f130753b.b()) {
                return this.f130752a;
            }
            return this.f130753b;
        }
        if (this.f130753b.b()) {
            return this.f130752a;
        }
        return this.f130753b;
    }
}
