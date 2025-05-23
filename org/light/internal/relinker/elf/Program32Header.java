package org.light.internal.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.internal.relinker.elf.Elf;

/* loaded from: classes29.dex */
public class Program32Header extends Elf.ProgramHeader {
    public Program32Header(ElfParser elfParser, Elf.Header header, long j3) throws IOException {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (header.bigEndian) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = header.phoff + (j3 * header.phentsize);
        this.type = elfParser.readWord(allocate, j16);
        this.offset = elfParser.readWord(allocate, 4 + j16);
        this.vaddr = elfParser.readWord(allocate, 8 + j16);
        this.memsz = elfParser.readWord(allocate, j16 + 20);
    }
}
