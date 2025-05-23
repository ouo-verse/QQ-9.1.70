package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class m extends f {
    public m(i iVar, d dVar, int i3) {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (dVar.f423571a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f423584a = iVar.e(allocate, dVar.f423574d + (i3 * dVar.f423577g) + 44);
    }
}
