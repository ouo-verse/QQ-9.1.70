package com.tencent.luggage.wxa.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends e {
    public k(i iVar, d dVar, long j3) {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (dVar.f123144a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = dVar.f123146c + (j3 * dVar.f123148e);
        this.f123153a = iVar.e(allocate, j16);
        this.f123154b = iVar.c(allocate, 8 + j16);
        this.f123155c = iVar.c(allocate, 16 + j16);
        this.f123156d = iVar.c(allocate, j16 + 40);
    }
}
