package com.tencent.luggage.wxa.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends d {

    /* renamed from: j, reason: collision with root package name */
    public final i f123158j;

    public g(boolean z16, i iVar) {
        ByteOrder byteOrder;
        this.f123144a = z16;
        this.f123158j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f123145b = iVar.b(allocate, 16L);
        this.f123146c = iVar.e(allocate, 28L);
        this.f123147d = iVar.e(allocate, 32L);
        this.f123148e = iVar.b(allocate, 42L);
        this.f123149f = iVar.b(allocate, 44L);
        this.f123150g = iVar.b(allocate, 46L);
        this.f123151h = iVar.b(allocate, 48L);
        this.f123152i = iVar.b(allocate, 50L);
    }

    @Override // com.tencent.luggage.wxa.c.d
    public f a(int i3) {
        return new l(this.f123158j, this, i3);
    }

    @Override // com.tencent.luggage.wxa.c.d
    public e a(long j3) {
        return new j(this.f123158j, this, j3);
    }

    @Override // com.tencent.luggage.wxa.c.d
    public c a(long j3, int i3) {
        return new a(this.f123158j, this, j3, i3);
    }
}
