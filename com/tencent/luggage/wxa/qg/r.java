package com.tencent.luggage.wxa.qg;

import com.tencent.luggage.wxa.pg.b;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r implements e {

    /* renamed from: a, reason: collision with root package name */
    public final e f138790a;

    /* renamed from: b, reason: collision with root package name */
    public final d f138791b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f138792c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f138793d;

    /* renamed from: e, reason: collision with root package name */
    public String f138794e = "";

    public r(e eVar, d dVar) {
        this.f138790a = (e) com.tencent.luggage.wxa.tg.a.a(eVar);
        this.f138791b = (d) com.tencent.luggage.wxa.tg.a.a(dVar);
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long a(g gVar) {
        long j3;
        long j16;
        long j17;
        boolean z16;
        g gVar2 = gVar;
        long a16 = this.f138790a.a(gVar2);
        com.tencent.luggage.wxa.rg.b bVar = com.tencent.luggage.wxa.rg.b.f139662c;
        e eVar = this.f138790a;
        if (eVar instanceof l) {
            long c16 = eVar.c();
            List list = (List) ((l) this.f138790a).a().get("Content-Type");
            if (list != null && !list.isEmpty()) {
                bVar = com.tencent.luggage.wxa.rg.b.d((String) list.get(0));
            }
            j3 = c16;
        } else {
            j3 = -1;
        }
        if (gVar2.f138706d != -1 || a16 == -1) {
            j16 = j3;
            j17 = a16;
            z16 = false;
        } else {
            j16 = j3;
            j17 = a16;
            z16 = false;
            gVar2 = new g(gVar2.f138703a, gVar2.f138704b, gVar2.f138705c, a16, gVar2.f138707e, gVar2.f138708f, gVar2.f138709g, gVar2.f138710h);
        }
        this.f138792c = z16;
        long j18 = j16;
        if (j18 != -1) {
            try {
                this.f138791b.a(gVar2, j18, bVar);
                this.f138793d = true;
            } catch (b.a e16) {
                this.f138792c = true;
                com.tencent.luggage.wxa.tg.h.a(5, d(), "error open dataSink " + e16.toString(), e16);
            }
        } else {
            this.f138792c = true;
        }
        return j17;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long available() {
        return this.f138790a.available();
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long c() {
        return this.f138790a.c();
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void close() {
        try {
            this.f138790a.close();
            try {
                if (this.f138793d) {
                    this.f138791b.close();
                }
            } catch (b.a e16) {
                com.tencent.luggage.wxa.tg.h.a(5, d(), "error close dataSink " + e16.toString(), e16);
            }
        } catch (Throwable th5) {
            try {
                if (this.f138793d) {
                    this.f138791b.close();
                }
            } catch (b.a e17) {
                com.tencent.luggage.wxa.tg.h.a(5, d(), "error close dataSink " + e17.toString(), e17);
            }
            throw th5;
        }
    }

    public String d() {
        return this.f138794e + "TeeDataSource";
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public com.tencent.luggage.wxa.rg.b getFileType() {
        return this.f138790a.getFileType();
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public int read(byte[] bArr, int i3, int i16) {
        int read = this.f138790a.read(bArr, i3, i16);
        if (read > 0) {
            if (this.f138792c) {
                return read;
            }
            try {
                if (this.f138793d) {
                    this.f138791b.write(bArr, i3, read);
                }
            } catch (b.a e16) {
                this.f138792c = true;
                com.tencent.luggage.wxa.tg.h.a(5, d(), "error write dataSink " + e16.toString(), e16);
            }
        }
        return read;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void a(String str) {
        this.f138794e = str;
    }
}
