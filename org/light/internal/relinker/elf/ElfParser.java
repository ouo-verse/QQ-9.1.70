package org.light.internal.relinker.elf;

import com.tencent.ttpic.openapi.initializer.so.MinElf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import org.light.internal.relinker.elf.Elf;

/* loaded from: classes29.dex */
public class ElfParser implements Closeable, Elf {
    private final int MAGIC = MinElf.ELF_MAGIC;
    private final FileChannel channel;

    public ElfParser(File file) throws FileNotFoundException {
        if (file != null && file.exists()) {
            this.channel = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    private long offsetFromVma(Elf.Header header, long j3, long j16) throws IOException {
        for (long j17 = 0; j17 < j3; j17++) {
            Elf.ProgramHeader programHeader = header.getProgramHeader(j17);
            if (programHeader.type == 1) {
                long j18 = programHeader.vaddr;
                if (j18 <= j16 && j16 <= programHeader.memsz + j18) {
                    return (j16 - j18) + programHeader.offset;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public Elf.Header parseHeader() throws IOException {
        boolean z16;
        this.channel.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (readWord(allocate, 0L) == 1179403647) {
            short readByte = readByte(allocate, 4L);
            if (readByte(allocate, 5L) == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (readByte == 1) {
                return new Elf32Header(z16, this);
            }
            if (readByte == 2) {
                return new Elf64Header(z16, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> parseNeededDependencies() throws IOException {
        ByteOrder byteOrder;
        long j3;
        Elf.DynamicStructure dynamicStructure;
        this.channel.position(0L);
        ArrayList arrayList = new ArrayList();
        Elf.Header parseHeader = parseHeader();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (parseHeader.bigEndian) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = parseHeader.phnum;
        int i3 = 0;
        if (j16 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j16 = parseHeader.getSectionHeader(0).info;
        }
        long j17 = 0;
        while (true) {
            if (j17 < j16) {
                Elf.ProgramHeader programHeader = parseHeader.getProgramHeader(j17);
                if (programHeader.type == 2) {
                    j3 = programHeader.offset;
                    break;
                }
                j17++;
            } else {
                j3 = 0;
                break;
            }
        }
        if (j3 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j18 = 0;
        do {
            dynamicStructure = parseHeader.getDynamicStructure(j3, i3);
            long j19 = dynamicStructure.tag;
            if (j19 == 1) {
                arrayList2.add(Long.valueOf(dynamicStructure.val));
            } else if (j19 == 5) {
                j18 = dynamicStructure.val;
            }
            i3++;
        } while (dynamicStructure.tag != 0);
        if (j18 != 0) {
            long offsetFromVma = offsetFromVma(parseHeader, j16, j18);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(readString(allocate, ((Long) it.next()).longValue() + offsetFromVma));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    protected void read(ByteBuffer byteBuffer, long j3, int i3) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i3);
        long j16 = 0;
        while (j16 < i3) {
            int read = this.channel.read(byteBuffer, j3 + j16);
            if (read != -1) {
                j16 += read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }

    protected short readByte(ByteBuffer byteBuffer, long j3) throws IOException {
        read(byteBuffer, j3, 1);
        return (short) (byteBuffer.get() & 255);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int readHalf(ByteBuffer byteBuffer, long j3) throws IOException {
        read(byteBuffer, j3, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long readLong(ByteBuffer byteBuffer, long j3) throws IOException {
        read(byteBuffer, j3, 8);
        return byteBuffer.getLong();
    }

    protected String readString(ByteBuffer byteBuffer, long j3) throws IOException {
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            long j16 = 1 + j3;
            short readByte = readByte(byteBuffer, j3);
            if (readByte != 0) {
                sb5.append((char) readByte);
                j3 = j16;
            } else {
                return sb5.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long readWord(ByteBuffer byteBuffer, long j3) throws IOException {
        read(byteBuffer, j3, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
