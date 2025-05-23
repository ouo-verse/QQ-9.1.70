package org.light.internal.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.internal.relinker.elf.Elf;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Section32Header extends Elf.SectionHeader {
    public Section32Header(ElfParser elfParser, Elf.Header header, int i3) throws IOException {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (header.bigEndian) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.info = elfParser.readWord(allocate, header.shoff + (i3 * header.shentsize) + 28);
    }
}
