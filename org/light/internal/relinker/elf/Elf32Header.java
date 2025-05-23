package org.light.internal.relinker.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.internal.relinker.elf.Elf;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Elf32Header extends Elf.Header {
    private final ElfParser parser;

    public Elf32Header(boolean z16, ElfParser elfParser) throws IOException {
        ByteOrder byteOrder;
        this.bigEndian = z16;
        this.parser = elfParser;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.type = elfParser.readHalf(allocate, 16L);
        this.phoff = elfParser.readWord(allocate, 28L);
        this.shoff = elfParser.readWord(allocate, 32L);
        this.phentsize = elfParser.readHalf(allocate, 42L);
        this.phnum = elfParser.readHalf(allocate, 44L);
        this.shentsize = elfParser.readHalf(allocate, 46L);
        this.shnum = elfParser.readHalf(allocate, 48L);
        this.shstrndx = elfParser.readHalf(allocate, 50L);
    }

    @Override // org.light.internal.relinker.elf.Elf.Header
    public Elf.DynamicStructure getDynamicStructure(long j3, int i3) throws IOException {
        return new Dynamic32Structure(this.parser, this, j3, i3);
    }

    @Override // org.light.internal.relinker.elf.Elf.Header
    public Elf.ProgramHeader getProgramHeader(long j3) throws IOException {
        return new Program32Header(this.parser, this, j3);
    }

    @Override // org.light.internal.relinker.elf.Elf.Header
    public Elf.SectionHeader getSectionHeader(int i3) throws IOException {
        return new Section32Header(this.parser, this, i3);
    }
}
