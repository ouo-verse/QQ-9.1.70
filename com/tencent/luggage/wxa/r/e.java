package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.n0.j;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.r.d;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends d {

    /* renamed from: b, reason: collision with root package name */
    public final l f139043b;

    /* renamed from: c, reason: collision with root package name */
    public final l f139044c;

    /* renamed from: d, reason: collision with root package name */
    public int f139045d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f139046e;

    /* renamed from: f, reason: collision with root package name */
    public int f139047f;

    public e(com.tencent.luggage.wxa.q.l lVar) {
        super(lVar);
        this.f139043b = new l(j.f135067a);
        this.f139044c = new l(4);
    }

    @Override // com.tencent.luggage.wxa.r.d
    public boolean a(l lVar) {
        int q16 = lVar.q();
        int i3 = (q16 >> 4) & 15;
        int i16 = q16 & 15;
        if (i16 == 7) {
            this.f139047f = i3;
            if (i3 != 5) {
                return true;
            }
            return false;
        }
        throw new d.a("Video format not supported: " + i16);
    }

    @Override // com.tencent.luggage.wxa.r.d
    public void b(l lVar, long j3) {
        int i3;
        int q16 = lVar.q();
        long t16 = j3 + (lVar.t() * 1000);
        if (q16 == 0 && !this.f139046e) {
            l lVar2 = new l(new byte[lVar.a()]);
            lVar.a(lVar2.f135088a, 0, lVar.a());
            com.tencent.luggage.wxa.o0.a b16 = com.tencent.luggage.wxa.o0.a.b(lVar2);
            this.f139045d = b16.f135960b;
            this.f139042a.a(com.tencent.luggage.wxa.m.j.a((String) null, "video/avc", (String) null, -1, -1, b16.f135961c, b16.f135962d, -1.0f, b16.f135959a, -1, b16.f135963e, (com.tencent.luggage.wxa.p.a) null));
            this.f139046e = true;
            return;
        }
        if (q16 == 1 && this.f139046e) {
            byte[] bArr = this.f139044c.f135088a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i16 = 4 - this.f139045d;
            int i17 = 0;
            while (lVar.a() > 0) {
                lVar.a(this.f139044c.f135088a, i16, this.f139045d);
                this.f139044c.e(0);
                int u16 = this.f139044c.u();
                this.f139043b.e(0);
                this.f139042a.a(this.f139043b, 4);
                this.f139042a.a(lVar, u16);
                i17 = i17 + 4 + u16;
            }
            com.tencent.luggage.wxa.q.l lVar3 = this.f139042a;
            if (this.f139047f == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            lVar3.a(t16, i3, i17, 0, null);
        }
    }
}
