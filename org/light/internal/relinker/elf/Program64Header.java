package org.light.internal.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.internal.relinker.elf.Elf;

/* loaded from: classes29.dex */
public class Program64Header extends Elf.ProgramHeader {
    public Program64Header(ElfParser elfParser, Elf.Header header, long j3) throws IOException {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (header.bigEndian) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = header.phoff + (j3 * header.phentsize);
        this.type = elfParser.readWord(allocate, j16);
        this.offset = elfParser.readLong(allocate, 8 + j16);
        this.vaddr = elfParser.readLong(allocate, 16 + j16);
        this.memsz = elfParser.readLong(allocate, j16 + 40);
    }
}
