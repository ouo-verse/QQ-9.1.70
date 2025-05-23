package com.tencent.hippy.qq.update.qarchive.tools.zip;

import com.tencent.commonsdk.soload.MyZipConstants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ZipOutputStream extends FilterOutputStream {
    private static final int BUFFER_SIZE = 32768;
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = null;
    public static final int DEFLATED = 8;
    private static final int DEFLATER_BLOCK_SIZE = 8192;

    @Deprecated
    public static final int EFS_FLAG = 2048;
    public static final int STORED = 0;
    protected byte[] buf;
    private long cdLength;
    private long cdOffset;
    private String comment;
    private final CRC32 crc;
    private UnicodeExtraFieldPolicy createUnicodeExtraFields;
    protected final Deflater def;
    private String encoding;
    private final List<ZipEntry> entries;
    private CurrentEntry entry;
    private boolean fallbackToUTF8;
    private boolean finished;
    private boolean hasCompressionLevelChanged;
    private boolean hasUsedZip64;
    private int level;
    private int method;
    private final Map<ZipEntry, Long> offsets;
    private final RandomAccessFile raf;
    private boolean useUTF8Flag;
    private long written;
    private Zip64Mode zip64Mode;
    private ZipEncoding zipEncoding;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] ZERO = {0, 0};
    private static final byte[] LZERO = {0, 0, 0, 0};
    protected static final byte[] LFH_SIG = ZipLong.LFH_SIG.getBytes();
    protected static final byte[] DD_SIG = ZipLong.DD_SIG.getBytes();
    protected static final byte[] CFH_SIG = ZipLong.CFH_SIG.getBytes();
    protected static final byte[] EOCD_SIG = ZipLong.getBytes(MyZipConstants.ENDSIG);
    static final byte[] ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
    static final byte[] ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);
    private static final byte[] ONE = ZipLong.getBytes(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class CurrentEntry {
        private final ZipEntry entry;
        private boolean hasWritten;
        private long localDataStart = 0;
        private long dataStart = 0;
        private long bytesRead = 0;
        private boolean causedUseOfZip64 = false;

        CurrentEntry(ZipEntry zipEntry) {
            this.entry = zipEntry;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = new UnicodeExtraFieldPolicy("always");
        public static final UnicodeExtraFieldPolicy NEVER = new UnicodeExtraFieldPolicy("never");
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        private final String name;

        UnicodeExtraFieldPolicy(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public ZipOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.crc = new CRC32();
        this.written = 0L;
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.offsets = new HashMap();
        this.encoding = null;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.def = new Deflater(this.level, true);
        this.buf = new byte[32768];
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.raf = null;
    }

    private void addUnicodeExtraFields(ZipEntry zipEntry, boolean z16, ByteBuffer byteBuffer) throws IOException {
        UnicodeExtraFieldPolicy unicodeExtraFieldPolicy = this.createUnicodeExtraFields;
        UnicodeExtraFieldPolicy unicodeExtraFieldPolicy2 = UnicodeExtraFieldPolicy.ALWAYS;
        if (unicodeExtraFieldPolicy == unicodeExtraFieldPolicy2 || !z16) {
            zipEntry.addExtraField(new UnicodePathExtraField(zipEntry.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment = zipEntry.getComment();
        if (comment != null && !"".equals(comment)) {
            boolean canEncode = this.zipEncoding.canEncode(comment);
            if (this.createUnicodeExtraFields == unicodeExtraFieldPolicy2 || !canEncode) {
                ByteBuffer encode = getEntryEncoding(zipEntry).encode(comment);
                zipEntry.addExtraField(new UnicodeCommentExtraField(comment, encode.array(), encode.arrayOffset(), encode.limit() - encode.position()));
            }
        }
    }

    protected static long adjustToLong(int i3) {
        return ZipUtil.adjustToLong(i3);
    }

    private void deflateUntilInputIsNeeded() throws IOException {
        while (!this.def.needsInput()) {
            deflate();
        }
    }

    private void flushDeflater() throws IOException {
        if (this.entry.entry.getMethod() == 8) {
            this.def.finish();
            while (!this.def.finished()) {
                deflate();
            }
        }
    }

    private Zip64Mode getEffectiveZip64Mode(ZipEntry zipEntry) {
        if (this.zip64Mode == Zip64Mode.AsNeeded && this.raf == null && zipEntry.getMethod() == 8 && zipEntry.getSize() == -1) {
            return Zip64Mode.Never;
        }
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipEntry zipEntry) {
        if (!this.zipEncoding.canEncode(zipEntry.getName()) && this.fallbackToUTF8) {
            return ZipEncodingHelper.UTF8_ZIP_ENCODING;
        }
        return this.zipEncoding;
    }

    private ByteBuffer getName(ZipEntry zipEntry) throws IOException {
        return getEntryEncoding(zipEntry).encode(zipEntry.getName());
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipEntry zipEntry) {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            currentEntry.causedUseOfZip64 = !this.hasUsedZip64;
        }
        this.hasUsedZip64 = true;
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) zipEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (zip64ExtendedInformationExtraField == null) {
            zip64ExtendedInformationExtraField = new Zip64ExtendedInformationExtraField();
        }
        zipEntry.addAsFirstExtraField(zip64ExtendedInformationExtraField);
        return zip64ExtendedInformationExtraField;
    }

    private boolean handleSizesAndCrc(long j3, long j16, Zip64Mode zip64Mode) throws ZipException {
        boolean z16;
        if (this.entry.entry.getMethod() == 8) {
            this.entry.entry.setSize(this.entry.bytesRead);
            this.entry.entry.setCompressedSize(j3);
            this.entry.entry.setCrc(j16);
            this.def.reset();
        } else if (this.raf == null) {
            if (this.entry.entry.getCrc() == j16) {
                if (this.entry.entry.getSize() != j3) {
                    throw new ZipException("bad size for entry " + this.entry.entry.getName() + MsgSummary.STR_COLON + this.entry.entry.getSize() + " instead of " + j3);
                }
            } else {
                throw new ZipException("bad CRC checksum for entry " + this.entry.entry.getName() + MsgSummary.STR_COLON + Long.toHexString(this.entry.entry.getCrc()) + " instead of " + Long.toHexString(j16));
            }
        } else {
            this.entry.entry.setSize(j3);
            this.entry.entry.setCompressedSize(j3);
            this.entry.entry.setCrc(j16);
        }
        if (zip64Mode != Zip64Mode.Always && this.entry.entry.getSize() < 4294967295L && this.entry.entry.getCompressedSize() < 4294967295L) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
        return z16;
    }

    private void handleZip64Extra(ZipEntry zipEntry, long j3, boolean z16) {
        if (z16) {
            Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(zipEntry);
            if (zipEntry.getCompressedSize() < 4294967295L && zipEntry.getSize() < 4294967295L) {
                zip64Extra.setCompressedSize(null);
                zip64Extra.setSize(null);
            } else {
                zip64Extra.setCompressedSize(new ZipEightByteInteger(zipEntry.getCompressedSize()));
                zip64Extra.setSize(new ZipEightByteInteger(zipEntry.getSize()));
            }
            if (j3 >= 4294967295L) {
                zip64Extra.setRelativeHeaderOffset(new ZipEightByteInteger(j3));
            }
            zipEntry.setExtra();
        }
    }

    private boolean hasZip64Extra(ZipEntry zipEntry) {
        if (zipEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) != null) {
            return true;
        }
        return false;
    }

    private void rewriteSizesAndCrc(boolean z16) throws IOException {
        long filePointer = this.raf.getFilePointer();
        this.raf.seek(this.entry.localDataStart);
        writeOut(ZipLong.getBytes(this.entry.entry.getCrc()));
        if (hasZip64Extra(this.entry.entry) && z16) {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            writeOut(zipLong.getBytes());
            writeOut(zipLong.getBytes());
        } else {
            writeOut(ZipLong.getBytes(this.entry.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.entry.getSize()));
        }
        if (hasZip64Extra(this.entry.entry)) {
            this.raf.seek(this.entry.localDataStart + 12 + 4 + getName(this.entry.entry).limit() + 4);
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getSize()));
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getCompressedSize()));
            if (!z16) {
                this.raf.seek(this.entry.localDataStart - 10);
                writeOut(ZipShort.getBytes(10));
                this.entry.entry.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
                this.entry.entry.setExtra();
                if (this.entry.causedUseOfZip64) {
                    this.hasUsedZip64 = false;
                }
            }
        }
        this.raf.seek(filePointer);
    }

    private void setDefaults(ZipEntry zipEntry) {
        if (zipEntry.getMethod() == -1) {
            zipEntry.setMethod(this.method);
        }
        if (zipEntry.getTime() == -1) {
            zipEntry.setTime(System.currentTimeMillis());
        }
    }

    private boolean shouldAddZip64Extra(ZipEntry zipEntry, Zip64Mode zip64Mode) {
        if (zip64Mode != Zip64Mode.Always && zipEntry.getSize() < 4294967295L && zipEntry.getCompressedSize() < 4294967295L && (zipEntry.getSize() != -1 || this.raf == null || zip64Mode == Zip64Mode.Never)) {
            return false;
        }
        return true;
    }

    protected static ZipLong toDosTime(Date date) {
        return ZipUtil.toDosTime(date);
    }

    private void validateSizeInformation(Zip64Mode zip64Mode) throws ZipException {
        if (this.entry.entry.getMethod() == 0 && this.raf == null) {
            if (this.entry.entry.getSize() != -1) {
                if (this.entry.entry.getCrc() != -1) {
                    this.entry.entry.setCompressedSize(this.entry.entry.getSize());
                } else {
                    throw new ZipException("crc checksum is required for STORED method when not writing to a file");
                }
            } else {
                throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
            }
        }
        if ((this.entry.entry.getSize() < 4294967295L && this.entry.entry.getCompressedSize() < 4294967295L) || zip64Mode != Zip64Mode.Never) {
        } else {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
    }

    private void writeDeflated(byte[] bArr, int i3, int i16) throws IOException {
        if (i16 > 0 && !this.def.finished()) {
            this.entry.bytesRead += i16;
            if (i16 <= 8192) {
                this.def.setInput(bArr, i3, i16);
                deflateUntilInputIsNeeded();
                return;
            }
            int i17 = i16 / 8192;
            for (int i18 = 0; i18 < i17; i18++) {
                this.def.setInput(bArr, (i18 * 8192) + i3, 8192);
                deflateUntilInputIsNeeded();
            }
            int i19 = i17 * 8192;
            if (i19 < i16) {
                this.def.setInput(bArr, i3 + i19, i16 - i19);
                deflateUntilInputIsNeeded();
            }
        }
    }

    private void writeVersionNeededToExtractAndGeneralPurposeBits(int i3, boolean z16, boolean z17) throws IOException {
        boolean z18;
        int i16;
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        if (!this.useUTF8Flag && !z16) {
            z18 = false;
        } else {
            z18 = true;
        }
        generalPurposeBit.useUTF8ForNames(z18);
        if (i3 == 8 && this.raf == null) {
            generalPurposeBit.useDataDescriptor(true);
            i16 = 20;
        } else {
            i16 = 10;
        }
        if (z17) {
            i16 = 45;
        }
        writeOut(ZipShort.getBytes(i16));
        writeOut(generalPurposeBit.encode());
    }

    public boolean canWriteEntryData(ZipEntry zipEntry) {
        return ZipUtil.canHandleEntryData(zipEntry);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.finished) {
            finish();
        }
        destroy();
    }

    public void closeEntry() throws IOException {
        if (!this.finished) {
            CurrentEntry currentEntry = this.entry;
            if (currentEntry != null) {
                if (!currentEntry.hasWritten) {
                    write(EMPTY, 0, 0);
                }
                flushDeflater();
                Zip64Mode effectiveZip64Mode = getEffectiveZip64Mode(this.entry.entry);
                long j3 = this.written - this.entry.dataStart;
                long value = this.crc.getValue();
                this.crc.reset();
                boolean handleSizesAndCrc = handleSizesAndCrc(j3, value, effectiveZip64Mode);
                if (this.raf != null) {
                    rewriteSizesAndCrc(handleSizesAndCrc);
                }
                writeDataDescriptor(this.entry.entry);
                this.entry = null;
                return;
            }
            throw new IOException("No current entry to close");
        }
        throw new IOException("Stream has already been finished");
    }

    protected final void deflate() throws IOException {
        Deflater deflater = this.def;
        byte[] bArr = this.buf;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            writeOut(this.buf, 0, deflate);
            this.written += deflate;
        }
    }

    void destroy() throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        OutputStream outputStream = ((FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            if (this.entry != null) {
                closeEntry();
            }
            this.cdOffset = this.written;
            Iterator<ZipEntry> it = this.entries.iterator();
            while (it.hasNext()) {
                writeCentralFileHeader(it.next());
            }
            this.cdLength = this.written - this.cdOffset;
            writeZip64CentralDirectory();
            writeCentralDirectoryEnd();
            this.offsets.clear();
            this.entries.clear();
            this.def.end();
            this.finished = true;
            return;
        }
        throw new IOException("This archive has already been finished");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = ((FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    protected byte[] getBytes(String str) throws ZipException {
        try {
            ByteBuffer encode = ZipEncodingHelper.getZipEncoding(this.encoding).encode(str);
            int limit = encode.limit();
            byte[] bArr = new byte[limit];
            System.arraycopy(encode.array(), encode.arrayOffset(), bArr, 0, limit);
            return bArr;
        } catch (IOException e16) {
            throw new ZipException("Failed to encode name: " + e16.getMessage());
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public boolean isSeekable() {
        if (this.raf != null) {
            return true;
        }
        return false;
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        if (!this.finished) {
            if (this.entry != null) {
                closeEntry();
            }
            CurrentEntry currentEntry = new CurrentEntry(zipEntry);
            this.entry = currentEntry;
            this.entries.add(currentEntry.entry);
            setDefaults(this.entry.entry);
            Zip64Mode effectiveZip64Mode = getEffectiveZip64Mode(this.entry.entry);
            validateSizeInformation(effectiveZip64Mode);
            if (shouldAddZip64Extra(this.entry.entry, effectiveZip64Mode)) {
                Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(this.entry.entry);
                ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
                if (this.entry.entry.getMethod() == 0 && this.entry.entry.getSize() != -1) {
                    zipEightByteInteger = new ZipEightByteInteger(this.entry.entry.getSize());
                }
                zip64Extra.setSize(zipEightByteInteger);
                zip64Extra.setCompressedSize(zipEightByteInteger);
                this.entry.entry.setExtra();
            }
            if (this.entry.entry.getMethod() == 8 && this.hasCompressionLevelChanged) {
                this.def.setLevel(this.level);
                this.hasCompressionLevelChanged = false;
            }
            writeLocalFileHeader(this.entry.entry);
            return;
        }
        throw new IOException("Stream has already been finished");
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy unicodeExtraFieldPolicy) {
        this.createUnicodeExtraFields = unicodeExtraFieldPolicy;
    }

    public void setEncoding(String str) {
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        if (this.useUTF8Flag && !ZipEncodingHelper.isUTF8(str)) {
            this.useUTF8Flag = false;
        }
    }

    public void setFallbackToUTF8(boolean z16) {
        this.fallbackToUTF8 = z16;
    }

    public void setLevel(int i3) {
        boolean z16;
        if (i3 >= -1 && i3 <= 9) {
            if (this.level != i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.hasCompressionLevelChanged = z16;
            this.level = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid compression level: " + i3);
    }

    public void setMethod(int i3) {
        this.method = i3;
    }

    public void setUseLanguageEncodingFlag(boolean z16) {
        boolean z17;
        if (z16 && ZipEncodingHelper.isUTF8(this.encoding)) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.useUTF8Flag = z17;
    }

    public void setUseZip64(Zip64Mode zip64Mode) {
        this.zip64Mode = zip64Mode;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        ZipUtil.checkRequestedFeatures(this.entry.entry);
        this.entry.hasWritten = true;
        if (this.entry.entry.getMethod() == 8) {
            writeDeflated(bArr, i3, i16);
        } else {
            writeOut(bArr, i3, i16);
            this.written += i16;
        }
        this.crc.update(bArr, i3, i16);
    }

    protected void writeCentralDirectoryEnd() throws IOException {
        writeOut(EOCD_SIG);
        byte[] bArr = ZERO;
        writeOut(bArr);
        writeOut(bArr);
        int size = this.entries.size();
        if (size > 65535 && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("archive contains more than 65535 entries.");
        }
        if (this.cdOffset > 4294967295L && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
        }
        byte[] bytes = ZipShort.getBytes(Math.min(size, 65535));
        writeOut(bytes);
        writeOut(bytes);
        writeOut(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
        writeOut(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
        ByteBuffer encode = this.zipEncoding.encode(this.comment);
        writeOut(ZipShort.getBytes(encode.limit()));
        writeOut(encode.array(), encode.arrayOffset(), encode.limit() - encode.position());
    }

    protected void writeCentralFileHeader(ZipEntry zipEntry) throws IOException {
        boolean z16;
        int i3;
        writeOut(CFH_SIG);
        this.written += 4;
        long longValue = this.offsets.get(zipEntry).longValue();
        boolean z17 = false;
        if (!hasZip64Extra(zipEntry) && zipEntry.getCompressedSize() < 4294967295L && zipEntry.getSize() < 4294967295L && longValue < 4294967295L) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
        }
        handleZip64Extra(zipEntry, longValue, z16);
        int platform = zipEntry.getPlatform() << 8;
        if (!this.hasUsedZip64) {
            i3 = 20;
        } else {
            i3 = 45;
        }
        writeOut(ZipShort.getBytes(platform | i3));
        this.written += 2;
        int method = zipEntry.getMethod();
        if (!this.zipEncoding.canEncode(zipEntry.getName()) && this.fallbackToUTF8) {
            z17 = true;
        }
        writeVersionNeededToExtractAndGeneralPurposeBits(method, z17, z16);
        this.written += 4;
        writeOut(ZipShort.getBytes(method));
        this.written += 2;
        writeOut(ZipUtil.toDosTime(zipEntry.getTime()));
        this.written += 4;
        writeOut(ZipLong.getBytes(zipEntry.getCrc()));
        if (zipEntry.getCompressedSize() < 4294967295L && zipEntry.getSize() < 4294967295L) {
            writeOut(ZipLong.getBytes(zipEntry.getCompressedSize()));
            writeOut(ZipLong.getBytes(zipEntry.getSize()));
        } else {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            writeOut(zipLong.getBytes());
            writeOut(zipLong.getBytes());
        }
        this.written += 12;
        ByteBuffer name = getName(zipEntry);
        writeOut(ZipShort.getBytes(name.limit()));
        this.written += 2;
        byte[] centralDirectoryExtra = zipEntry.getCentralDirectoryExtra();
        writeOut(ZipShort.getBytes(centralDirectoryExtra.length));
        this.written += 2;
        String comment = zipEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        ByteBuffer encode = getEntryEncoding(zipEntry).encode(comment);
        writeOut(ZipShort.getBytes(encode.limit()));
        this.written += 2;
        writeOut(ZERO);
        this.written += 2;
        writeOut(ZipShort.getBytes(zipEntry.getInternalAttributes()));
        this.written += 2;
        writeOut(ZipLong.getBytes(zipEntry.getExternalAttributes()));
        this.written += 4;
        writeOut(ZipLong.getBytes(Math.min(longValue, 4294967295L)));
        this.written += 4;
        writeOut(name.array(), name.arrayOffset(), name.limit() - name.position());
        this.written += name.limit();
        writeOut(centralDirectoryExtra);
        this.written += centralDirectoryExtra.length;
        writeOut(encode.array(), encode.arrayOffset(), encode.limit() - encode.position());
        this.written += encode.limit();
    }

    protected void writeDataDescriptor(ZipEntry zipEntry) throws IOException {
        int i3;
        if (zipEntry.getMethod() == 8 && this.raf == null) {
            writeOut(DD_SIG);
            writeOut(ZipLong.getBytes(zipEntry.getCrc()));
            if (!hasZip64Extra(zipEntry)) {
                writeOut(ZipLong.getBytes(zipEntry.getCompressedSize()));
                writeOut(ZipLong.getBytes(zipEntry.getSize()));
                i3 = 4;
            } else {
                writeOut(ZipEightByteInteger.getBytes(zipEntry.getCompressedSize()));
                writeOut(ZipEightByteInteger.getBytes(zipEntry.getSize()));
                i3 = 8;
            }
            this.written += (i3 * 2) + 8;
        }
    }

    protected void writeLocalFileHeader(ZipEntry zipEntry) throws IOException {
        boolean z16;
        boolean canEncode = this.zipEncoding.canEncode(zipEntry.getName());
        ByteBuffer name = getName(zipEntry);
        if (this.createUnicodeExtraFields != UnicodeExtraFieldPolicy.NEVER) {
            addUnicodeExtraFields(zipEntry, canEncode, name);
        }
        this.offsets.put(zipEntry, Long.valueOf(this.written));
        writeOut(LFH_SIG);
        this.written += 4;
        int method = zipEntry.getMethod();
        if (!canEncode && this.fallbackToUTF8) {
            z16 = true;
        } else {
            z16 = false;
        }
        writeVersionNeededToExtractAndGeneralPurposeBits(method, z16, hasZip64Extra(zipEntry));
        this.written += 4;
        writeOut(ZipShort.getBytes(method));
        this.written += 2;
        writeOut(ZipUtil.toDosTime(zipEntry.getTime()));
        long j3 = this.written + 4;
        this.written = j3;
        this.entry.localDataStart = j3;
        if (method != 8 && this.raf == null) {
            writeOut(ZipLong.getBytes(zipEntry.getCrc()));
            byte[] bytes = ZipLong.ZIP64_MAGIC.getBytes();
            if (!hasZip64Extra(zipEntry)) {
                bytes = ZipLong.getBytes(zipEntry.getSize());
            }
            writeOut(bytes);
            writeOut(bytes);
        } else {
            byte[] bArr = LZERO;
            writeOut(bArr);
            if (hasZip64Extra(this.entry.entry)) {
                ZipLong zipLong = ZipLong.ZIP64_MAGIC;
                writeOut(zipLong.getBytes());
                writeOut(zipLong.getBytes());
            } else {
                writeOut(bArr);
                writeOut(bArr);
            }
        }
        this.written += 12;
        writeOut(ZipShort.getBytes(name.limit()));
        this.written += 2;
        byte[] localFileDataExtra = zipEntry.getLocalFileDataExtra();
        writeOut(ZipShort.getBytes(localFileDataExtra.length));
        this.written += 2;
        writeOut(name.array(), name.arrayOffset(), name.limit() - name.position());
        this.written += name.limit();
        writeOut(localFileDataExtra);
        long length = this.written + localFileDataExtra.length;
        this.written = length;
        this.entry.dataStart = length;
    }

    protected final void writeOut(byte[] bArr) throws IOException {
        writeOut(bArr, 0, bArr.length);
    }

    protected void writeZip64CentralDirectory() throws IOException {
        if (this.zip64Mode == Zip64Mode.Never) {
            return;
        }
        if (!this.hasUsedZip64 && (this.cdOffset >= 4294967295L || this.cdLength >= 4294967295L || this.entries.size() >= 65535)) {
            this.hasUsedZip64 = true;
        }
        if (!this.hasUsedZip64) {
            return;
        }
        long j3 = this.written;
        writeOut(ZIP64_EOCD_SIG);
        writeOut(ZipEightByteInteger.getBytes(44L));
        writeOut(ZipShort.getBytes(45));
        writeOut(ZipShort.getBytes(45));
        byte[] bArr = LZERO;
        writeOut(bArr);
        writeOut(bArr);
        byte[] bytes = ZipEightByteInteger.getBytes(this.entries.size());
        writeOut(bytes);
        writeOut(bytes);
        writeOut(ZipEightByteInteger.getBytes(this.cdLength));
        writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
        writeOut(ZIP64_EOCD_LOC_SIG);
        writeOut(bArr);
        writeOut(ZipEightByteInteger.getBytes(j3));
        writeOut(ONE);
    }

    protected static byte[] toDosTime(long j3) {
        return ZipUtil.toDosTime(j3);
    }

    protected final void writeOut(byte[] bArr, int i3, int i16) throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.write(bArr, i3, i16);
        } else {
            ((FilterOutputStream) this).out.write(bArr, i3, i16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipOutputStream(File file) throws IOException {
        super(null);
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.crc = new CRC32();
        this.written = 0L;
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.offsets = new HashMap();
        this.encoding = null;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.def = new Deflater(this.level, true);
        this.buf = new byte[32768];
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.setLength(0L);
            } catch (IOException unused) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                } else {
                    randomAccessFile2 = randomAccessFile;
                }
                ((FilterOutputStream) this).out = new FileOutputStream(file);
                randomAccessFile = randomAccessFile2;
                this.raf = randomAccessFile;
            }
        } catch (IOException unused3) {
            randomAccessFile = null;
        }
        this.raf = randomAccessFile;
    }
}
