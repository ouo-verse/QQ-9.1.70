package org.light.internal.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.internal.relinker.elf.Elf;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Elf64Header extends Elf.Header {
    private final ElfParser parser;

    public Elf64Header(boolean z16, ElfParser elfParser) throws IOException {
        ByteOrder byteOrder;
        this.bigEndian = z16;
        this.parser = elfParser;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.type = elfParser.readHalf(allocate, 16L);
        this.phoff = elfParser.readLong(allocate, 32L);
        this.shoff = elfParser.readLong(allocate, 40L);
        this.phentsize = elfParser.readHalf(allocate, 54L);
        this.phnum = elfParser.readHalf(allocate, 56L);
        this.shentsize = elfParser.readHalf(allocate, 58L);
        this.shnum = elfParser.readHalf(allocate, 60L);
        this.shstrndx = elfParser.readHalf(allocate, 62L);
    }

    @Override // org.light.internal.relinker.elf.Elf.Header
    public Elf.DynamicStructure getDynamicStructure(long j3, int i3) throws IOException {
        return new Dynamic64Structure(this.parser, this, j3, i3);
    }

    @Override // org.light.internal.relinker.elf.Elf.Header
    public Elf.ProgramHeader getProgramHeader(long j3) throws IOException {
        return new Program64Header(this.parser, this, j3);
    }

    @Override // org.light.internal.relinker.elf.Elf.Header
    public Elf.SectionHeader getSectionHeader(int i3) throws IOException {
        return new Section64Header(this.parser, this, i3);
    }
}
