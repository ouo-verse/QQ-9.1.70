package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class k extends e {
    public k(i iVar, d dVar, long j3) {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (dVar.f423571a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = dVar.f423573c + (j3 * dVar.f423575e);
        this.f423580a = iVar.e(allocate, j16);
        this.f423581b = iVar.c(allocate, 8 + j16);
        this.f423582c = iVar.c(allocate, 16 + j16);
        this.f423583d = iVar.c(allocate, j16 + 40);
    }
}
