package com.tencent.luggage.wxa.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends c {
    public a(i iVar, d dVar, long j3, int i3) {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (dVar.f123144a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = j3 + (i3 * 8);
        this.f123142a = iVar.e(allocate, j16);
        this.f123143b = iVar.e(allocate, j16 + 4);
    }
}
