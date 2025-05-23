package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class a extends c {
    public a(i iVar, d dVar, long j3, int i3) {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (dVar.f423571a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = j3 + (i3 * 8);
        this.f423569a = iVar.e(allocate, j16);
        this.f423570b = iVar.e(allocate, j16 + 4);
    }
}
