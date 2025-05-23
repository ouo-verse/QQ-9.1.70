package cooperation.qzone;

import android.util.Pair;
import cooperation.qzone.util.QZLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ShareElfFile implements Closeable {
    public static final int ERROR_CODE_BAD_ELF_CLASS = -2;
    public static final int ERROR_CODE_BAD_ELF_ENCODING = -3;
    public static final int ERROR_CODE_BAD_ELF_VERSION = -5;
    public static final int ERROR_CODE_BAD_MAGIC = -1;
    public static final int ERROR_CODE_FAIL_READ_PHDR = -7;
    public static final int ERROR_CODE_FAIL_READ_REST_EHDR = -4;
    public static final int ERROR_CODE_FAIL_READ_SHDR = -8;
    public static final int ERROR_CODE_FILE_NOT_EXISTS = -9;
    public static final int ERROR_CODE_UNEXPECTED_ELF_CALSS = -6;
    public static final int ERROR_CODE_UNKOWN = -1000;
    public static final int FILE_TYPE_ELF = 1;
    public static final int FILE_TYPE_ODEX = 0;
    public static final int FILE_TYPE_OTHERS = -1;
    private static final String TAG = "ShareElfFile";
    public ElfHeader elfHeader;
    private final FileInputStream fis;
    public ProgramHeader[] programHeaders;
    public SectionHeader[] sectionHeaders;
    private final Map<String, SectionHeader> sectionNameToHeaderMap = new HashMap();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ElfHeader {
        public static final int EI_CLASS = 4;
        public static final int EI_DATA = 5;
        private static final int EI_NINDENT = 16;
        public static final int EI_VERSION = 6;
        public static final int ELFCLASS32 = 1;
        public static final int ELFCLASS64 = 2;
        public static final int ELFDATA2LSB = 1;
        public static final int ELFDATA2MSB = 2;
        public static final int ET_CORE = 4;
        public static final int ET_DYN = 3;
        public static final int ET_EXEC = 2;
        public static final int ET_HIPROC = 65535;
        public static final int ET_LOPROC = 65280;
        public static final int ET_NONE = 0;
        public static final int ET_REL = 1;
        public static final int EV_CURRENT = 1;
        public final short eEhSize;
        public final long eEntry;
        public final int eFlags;
        public final byte[] eIndent;
        public final short eMachine;
        public final short ePhEntSize;
        public final short ePhNum;
        public final long ePhOff;
        public final short eShEntSize;
        public final short eShNum;
        public final long eShOff;
        public final short eShStrNdx;
        public final short eType;
        public final int eVersion;

        ElfHeader(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.eIndent = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                ShareElfFile.assertInRange(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                ShareElfFile.assertInRange(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                ShareElfFile.readUntilLimit(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.eType = allocate.getShort();
                this.eMachine = allocate.getShort();
                int i3 = allocate.getInt();
                this.eVersion = i3;
                ShareElfFile.assertInRange(i3, 1, 1, "bad elf version: " + i3);
                byte b16 = bArr[4];
                if (b16 == 1) {
                    this.eEntry = allocate.getInt();
                    this.ePhOff = allocate.getInt();
                    this.eShOff = allocate.getInt();
                } else if (b16 == 2) {
                    this.eEntry = allocate.getLong();
                    this.ePhOff = allocate.getLong();
                    this.eShOff = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.eFlags = allocate.getInt();
                this.eEhSize = allocate.getShort();
                this.ePhEntSize = allocate.getShort();
                this.ePhNum = allocate.getShort();
                this.eShEntSize = allocate.getShort();
                this.eShNum = allocate.getShort();
                this.eShStrNdx = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ProgramHeader {
        public static final int PF_R = 4;
        public static final int PF_W = 2;
        public static final int PF_X = 1;
        public static final int PT_DYNAMIC = 2;
        public static final int PT_HIPROC = Integer.MAX_VALUE;
        public static final int PT_INTERP = 3;
        public static final int PT_LOAD = 1;
        public static final int PT_LOPROC = 1879048192;
        public static final int PT_NOTE = 4;
        public static final int PT_NULL = 0;
        public static final int PT_PHDR = 6;
        public static final int PT_SHLIB = 5;
        public final long pAlign;
        public final long pFileSize;
        public final int pFlags;
        public final long pMemSize;
        public final long pOffset;
        public final long pPddr;
        public final int pType;
        public final long pVddr;

        ProgramHeader(ByteBuffer byteBuffer, int i3) throws IOException {
            if (i3 == 1) {
                this.pType = byteBuffer.getInt();
                this.pOffset = byteBuffer.getInt();
                this.pVddr = byteBuffer.getInt();
                this.pPddr = byteBuffer.getInt();
                this.pFileSize = byteBuffer.getInt();
                this.pMemSize = byteBuffer.getInt();
                this.pFlags = byteBuffer.getInt();
                this.pAlign = byteBuffer.getInt();
                return;
            }
            if (i3 == 2) {
                this.pType = byteBuffer.getInt();
                this.pFlags = byteBuffer.getInt();
                this.pOffset = byteBuffer.getLong();
                this.pVddr = byteBuffer.getLong();
                this.pPddr = byteBuffer.getLong();
                this.pFileSize = byteBuffer.getLong();
                this.pMemSize = byteBuffer.getLong();
                this.pAlign = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: " + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class SectionHeader {
        public static final int SHF_ALLOC = 2;
        public static final int SHF_EXECINSTR = 4;
        public static final int SHF_MASKPROC = -268435456;
        public static final int SHF_WRITE = 1;
        public static final int SHN_ABS = 65521;
        public static final int SHN_COMMON = 65522;
        public static final int SHN_HIPROC = 65311;
        public static final int SHN_HIRESERVE = 65535;
        public static final int SHN_LOPROC = 65280;
        public static final int SHN_LORESERVE = 65280;
        public static final int SHN_UNDEF = 0;
        public static final int SHT_DYNAMIC = 6;
        public static final int SHT_DYNSYM = 11;
        public static final int SHT_HASH = 5;
        public static final int SHT_HIPROC = Integer.MAX_VALUE;
        public static final int SHT_HIUSER = -1;
        public static final int SHT_LOPROC = 1879048192;
        public static final int SHT_LOUSER = Integer.MIN_VALUE;
        public static final int SHT_NOBITS = 8;
        public static final int SHT_NOTE = 7;
        public static final int SHT_NULL = 0;
        public static final int SHT_PROGBITS = 1;
        public static final int SHT_REL = 9;
        public static final int SHT_RELA = 4;
        public static final int SHT_SHLIB = 10;
        public static final int SHT_STRTAB = 3;
        public static final int SHT_SYMTAB = 2;
        public final long shAddr;
        public final long shAddrAlign;
        public final long shEntSize;
        public final long shFlags;
        public final int shInfo;
        public final int shLink;
        public final int shName;
        public String shNameStr;
        public final long shOffset;
        public final long shSize;
        public final int shType;

        SectionHeader(ByteBuffer byteBuffer, int i3) throws IOException {
            if (i3 == 1) {
                this.shName = byteBuffer.getInt();
                this.shType = byteBuffer.getInt();
                this.shFlags = byteBuffer.getInt();
                this.shAddr = byteBuffer.getInt();
                this.shOffset = byteBuffer.getInt();
                this.shSize = byteBuffer.getInt();
                this.shLink = byteBuffer.getInt();
                this.shInfo = byteBuffer.getInt();
                this.shAddrAlign = byteBuffer.getInt();
                this.shEntSize = byteBuffer.getInt();
            } else if (i3 == 2) {
                this.shName = byteBuffer.getInt();
                this.shType = byteBuffer.getInt();
                this.shFlags = byteBuffer.getLong();
                this.shAddr = byteBuffer.getLong();
                this.shOffset = byteBuffer.getLong();
                this.shSize = byteBuffer.getLong();
                this.shLink = byteBuffer.getInt();
                this.shInfo = byteBuffer.getInt();
                this.shAddrAlign = byteBuffer.getLong();
                this.shEntSize = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: " + i3);
            }
            this.shNameStr = null;
        }
    }

    public ShareElfFile(File file) throws IOException {
        ByteOrder byteOrder;
        SectionHeader[] sectionHeaderArr;
        this.elfHeader = null;
        this.programHeaders = null;
        this.sectionHeaders = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.fis = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.elfHeader = new ElfHeader(channel);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.elfHeader.ePhEntSize);
        if (this.elfHeader.eIndent[5] == 1) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        allocate.order(byteOrder);
        channel.position(this.elfHeader.ePhOff);
        this.programHeaders = new ProgramHeader[this.elfHeader.ePhNum];
        for (int i3 = 0; i3 < this.programHeaders.length; i3++) {
            readUntilLimit(channel, allocate, "failed to read phdr.");
            this.programHeaders[i3] = new ProgramHeader(allocate, this.elfHeader.eIndent[4]);
        }
        channel.position(this.elfHeader.eShOff);
        allocate.limit(this.elfHeader.eShEntSize);
        this.sectionHeaders = new SectionHeader[this.elfHeader.eShNum];
        int i16 = 0;
        while (true) {
            sectionHeaderArr = this.sectionHeaders;
            if (i16 >= sectionHeaderArr.length) {
                break;
            }
            readUntilLimit(channel, allocate, "failed to read shdr.");
            this.sectionHeaders[i16] = new SectionHeader(allocate, this.elfHeader.eIndent[4]);
            i16++;
        }
        short s16 = this.elfHeader.eShStrNdx;
        if (s16 > 0) {
            ByteBuffer section = getSection(sectionHeaderArr[s16]);
            for (SectionHeader sectionHeader : this.sectionHeaders) {
                section.position(sectionHeader.shName);
                String readCString = readCString(section);
                sectionHeader.shNameStr = readCString;
                this.sectionNameToHeaderMap.put(readCString, sectionHeader);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertInRange(int i3, int i16, int i17, String str) throws IOException {
        if (i3 >= i16 && i3 <= i17) {
        } else {
            throw new IOException(str);
        }
    }

    public static Pair<Integer, Throwable> checkOat(File file) {
        int i3 = 0;
        try {
            try {
                new ShareElfFile(file).close();
            } catch (IOException e16) {
                QZLog.e(TAG, "", e16);
            }
            return new Pair<>(0, null);
        } catch (IOException e17) {
            String message = e17.getMessage();
            if (message != null) {
                if (message.startsWith("bad elf magic")) {
                    i3 = -1;
                } else if (message.startsWith("bad elf class")) {
                    i3 = -2;
                } else if (message.startsWith("bad elf data encoding")) {
                    i3 = -3;
                } else if (message.startsWith("failed to read rest part of ehdr")) {
                    i3 = -4;
                } else if (message.startsWith("bad elf version")) {
                    i3 = -5;
                } else if (message.startsWith("Unexpected elf class")) {
                    i3 = -6;
                } else if (message.startsWith("failed to read phdr")) {
                    i3 = -7;
                } else if (message.startsWith("failed to read shdr")) {
                    i3 = -8;
                } else {
                    i3 = -1000;
                }
            }
            return new Pair<>(Integer.valueOf(i3), e17);
        }
    }

    public static int getFileTypeByMagic(File file) throws IOException {
        byte[] bArr;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            bArr = new byte[4];
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            fileInputStream.read(bArr);
            byte b16 = bArr[0];
            if (b16 == 100 && bArr[1] == 101 && bArr[2] == 121 && bArr[3] == 10) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                return 0;
            }
            if (b16 == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76) {
                if (bArr[3] == 70) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused2) {
                    }
                    return 1;
                }
            }
            try {
                fileInputStream.close();
                return -1;
            } catch (Throwable unused3) {
                return -1;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    public static String readCString(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public static void readUntilLimit(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fis.close();
        this.sectionNameToHeaderMap.clear();
        this.programHeaders = null;
        this.sectionHeaders = null;
    }

    public FileChannel getChannel() {
        return this.fis.getChannel();
    }

    public ByteOrder getDataOrder() {
        if (this.elfHeader.eIndent[5] == 1) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        return ByteOrder.BIG_ENDIAN;
    }

    public ByteBuffer getSection(SectionHeader sectionHeader) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate((int) sectionHeader.shSize);
        this.fis.getChannel().position(sectionHeader.shOffset);
        readUntilLimit(this.fis.getChannel(), allocate, "failed to read section: " + sectionHeader.shNameStr);
        return allocate;
    }

    public SectionHeader getSectionHeaderByName(String str) {
        return this.sectionNameToHeaderMap.get(str);
    }

    public ByteBuffer getSegment(ProgramHeader programHeader) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate((int) programHeader.pFileSize);
        this.fis.getChannel().position(programHeader.pOffset);
        readUntilLimit(this.fis.getChannel(), allocate, "failed to read segment (type: " + programHeader.pType + ").");
        return allocate;
    }

    public boolean is32BitElf() {
        if (this.elfHeader.eIndent[4] == 1) {
            return true;
        }
        return false;
    }
}
