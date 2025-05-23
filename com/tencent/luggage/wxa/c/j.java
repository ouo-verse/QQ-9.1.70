package com.tencent.luggage.wxa.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends e {
    public j(i iVar, d dVar, long j3) {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (dVar.f123144a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = dVar.f123146c + (j3 * dVar.f123148e);
        this.f123153a = iVar.e(allocate, j16);
        this.f123154b = iVar.e(allocate, 4 + j16);
        this.f123155c = iVar.e(allocate, 8 + j16);
        this.f123156d = iVar.e(allocate, j16 + 20);
    }
}
