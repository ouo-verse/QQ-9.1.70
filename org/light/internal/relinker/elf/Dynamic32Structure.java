package org.light.internal.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.internal.relinker.elf.Elf;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Dynamic32Structure extends Elf.DynamicStructure {
    public Dynamic32Structure(ElfParser elfParser, Elf.Header header, long j3, int i3) throws IOException {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (header.bigEndian) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = j3 + (i3 * 8);
        this.tag = elfParser.readWord(allocate, j16);
        this.val = elfParser.readWord(allocate, j16 + 4);
    }
}
