package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class b extends c {
    public b(i iVar, d dVar, long j3, int i3) {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (dVar.f423571a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = j3 + (i3 * 16);
        this.f423569a = iVar.c(allocate, j16);
        this.f423570b = iVar.c(allocate, j16 + 8);
    }
}
