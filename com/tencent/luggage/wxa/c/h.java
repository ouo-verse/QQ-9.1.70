package com.tencent.luggage.wxa.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f123159j;

    public h(boolean z16, i iVar) {
        ByteOrder byteOrder;
        this.f123144a = z16;
        this.f123159j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f123145b = iVar.b(allocate, 16L);
        this.f123146c = iVar.c(allocate, 32L);
        this.f123147d = iVar.c(allocate, 40L);
        this.f123148e = iVar.b(allocate, 54L);
        this.f123149f = iVar.b(allocate, 56L);
        this.f123150g = iVar.b(allocate, 58L);
        this.f123151h = iVar.b(allocate, 60L);
        this.f123152i = iVar.b(allocate, 62L);
    }

    @Override // com.tencent.luggage.wxa.c.d
    public f a(int i3) {
        return new m(this.f123159j, this, i3);
    }

    @Override // com.tencent.luggage.wxa.c.d
    public e a(long j3) {
        return new k(this.f123159j, this, j3);
    }

    @Override // com.tencent.luggage.wxa.c.d
    public c a(long j3, int i3) {
        return new b(this.f123159j, this, j3, i3);
    }
}
