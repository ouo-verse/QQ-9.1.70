package com.tencent.luggage.wxa.qg;

import android.webkit.URLUtil;
import com.tencent.luggage.wxa.pg.c;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements com.tencent.luggage.wxa.rg.a {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.pg.a f138720a;

    /* renamed from: b, reason: collision with root package name */
    public k f138721b;

    /* renamed from: c, reason: collision with root package name */
    public j f138722c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.pg.b f138723d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.rg.l f138724e;

    /* renamed from: f, reason: collision with root package name */
    public b f138725f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.pg.c.a
        public void a(long j3, long j16) {
            com.tencent.luggage.wxa.tg.h.a(3, "DataSourceBuilder", String.format("onCachedBytesRead, cacheSizeBytes:%s, cachedBytesRead:%s", Long.valueOf(j3), Long.valueOf(j16)));
        }

        @Override // com.tencent.luggage.wxa.pg.c.a
        public void a(String str, long j3, long j16, long j17) {
            com.tencent.luggage.wxa.tg.h.a(3, "DataSourceBuilder", String.format("onHttpUpstreamServerCost, videoUuid:%s, httpDnsCost:%s, httpConnectCost:%s, httpFirstRecvCost:%s", str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17)));
            if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                com.tencent.luggage.wxa.og.a.a().m().a(str, j3, j16, j17);
            }
        }

        @Override // com.tencent.luggage.wxa.pg.c.a
        public void a(String str, int i3, long j3, long j16, long j17) {
            com.tencent.luggage.wxa.tg.h.a(3, "DataSourceBuilder", String.format("downloadSizeAndDuration, uuid:%s, totalUpstreamBytesRead:%s, totalUpstreamReadCost:%s, totalLength:%s, totalCachedBytesRead:%s", str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17)));
            if (com.tencent.luggage.wxa.og.a.a().m() != null) {
                com.tencent.luggage.wxa.og.a.a().m().a(str, i3, j3, j16, j17);
            }
        }
    }

    public i(com.tencent.luggage.wxa.pg.a aVar, com.tencent.luggage.wxa.rg.c cVar, com.tencent.luggage.wxa.rg.l lVar) {
        if (this.f138725f == null) {
            this.f138725f = new h(null, null);
        }
        this.f138722c = new n("com.tencent.mm.video", new com.tencent.luggage.wxa.tg.g(), this.f138725f, cVar, lVar.e(), lVar);
        this.f138721b = new k();
        this.f138720a = aVar;
        if (aVar != null) {
            this.f138723d = new com.tencent.luggage.wxa.pg.b(aVar, com.tencent.luggage.wxa.og.a.a().f());
        }
        this.f138724e = lVar;
    }

    @Override // com.tencent.luggage.wxa.rg.a
    public e a(String str, String str2) {
        com.tencent.luggage.wxa.pg.b bVar;
        this.f138722c.a(str2);
        com.tencent.luggage.wxa.pg.b bVar2 = this.f138723d;
        if (bVar2 != null) {
            bVar2.a(str2);
        }
        this.f138721b.a(str2);
        boolean z16 = !URLUtil.isNetworkUrl(str);
        boolean c16 = com.tencent.luggage.wxa.tg.h.c(str);
        boolean e16 = com.tencent.luggage.wxa.tg.h.e(str);
        if (c16) {
            com.tencent.luggage.wxa.qg.a aVar = new com.tencent.luggage.wxa.qg.a(com.tencent.luggage.wxa.og.a.a().b());
            aVar.a(str2);
            com.tencent.luggage.wxa.tg.h.a(4, str2 + "DataSourceBuilder", "play asset file, dataSource:" + aVar);
            return aVar;
        }
        if (e16) {
            o oVar = new o(com.tencent.luggage.wxa.og.a.a().b());
            oVar.a(str2);
            com.tencent.luggage.wxa.tg.h.a(4, str2 + "DataSourceBuilder", "play raw file, dataSource:" + oVar);
            return oVar;
        }
        if (z16) {
            k kVar = this.f138721b;
            com.tencent.luggage.wxa.tg.h.a(4, str2 + "DataSourceBuilder", "play local file, dataSource:" + kVar);
            return kVar;
        }
        if (this.f138720a != null && com.tencent.luggage.wxa.og.a.a().o()) {
            a aVar2 = new a();
            com.tencent.luggage.wxa.pg.a aVar3 = this.f138720a;
            j jVar = this.f138722c;
            k kVar2 = this.f138721b;
            if (this.f138724e.s()) {
                bVar = this.f138723d;
            } else {
                bVar = null;
            }
            com.tencent.luggage.wxa.pg.c cVar = new com.tencent.luggage.wxa.pg.c(aVar3, jVar, kVar2, bVar, false, true, aVar2);
            cVar.a(str2);
            com.tencent.luggage.wxa.tg.h.a(4, str2 + "DataSourceBuilder", "cache enabled, dataSource:" + cVar);
            return cVar;
        }
        j jVar2 = this.f138722c;
        com.tencent.luggage.wxa.tg.h.a(5, str2 + "DataSourceBuilder", "cache disabled, dataSource:" + jVar2);
        return jVar2;
    }
}
