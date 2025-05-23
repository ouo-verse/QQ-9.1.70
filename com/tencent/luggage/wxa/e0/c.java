package com.tencent.luggage.wxa.e0;

import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.j;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends a {

    /* renamed from: i, reason: collision with root package name */
    public byte[] f124466i;

    /* renamed from: j, reason: collision with root package name */
    public int f124467j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f124468k;

    public c(g gVar, j jVar, int i3, com.tencent.luggage.wxa.m.j jVar2, int i16, Object obj, byte[] bArr) {
        super(gVar, jVar, i3, jVar2, i16, obj, -9223372036854775807L, -9223372036854775807L);
        this.f124466i = bArr;
    }

    public abstract void a(byte[] bArr, int i3);

    @Override // com.tencent.luggage.wxa.l0.r.c
    public final boolean a() {
        return this.f124468k;
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public final void b() {
        try {
            this.f124465h.a(this.f124458a);
            int i3 = 0;
            this.f124467j = 0;
            while (i3 != -1 && !this.f124468k) {
                f();
                i3 = this.f124465h.read(this.f124466i, this.f124467j, 16384);
                if (i3 != -1) {
                    this.f124467j += i3;
                }
            }
            if (!this.f124468k) {
                a(this.f124466i, this.f124467j);
            }
        } finally {
            v.a(this.f124465h);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.c
    public final void c() {
        this.f124468k = true;
    }

    @Override // com.tencent.luggage.wxa.e0.a
    public long d() {
        return this.f124467j;
    }

    public byte[] e() {
        return this.f124466i;
    }

    public final void f() {
        byte[] bArr = this.f124466i;
        if (bArr == null) {
            this.f124466i = new byte[16384];
        } else if (bArr.length < this.f124467j + 16384) {
            this.f124466i = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }
}
