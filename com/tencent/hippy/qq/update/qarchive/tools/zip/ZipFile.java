package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ZipFile {
    static final int BYTE_SHIFT = 8;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final long CFH_SIG = ZipLong.getValue(ZipOutputStream.CFH_SIG);
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MAX_EOCD_SIZE = 65557;
    private static final int MIN_EOCD_SIZE = 22;
    static final int NIBLET_MASK = 15;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int ZIP64_EOCDL_LENGTH = 20;
    private static final int ZIP64_EOCDL_LOCATOR_OFFSET = 8;
    private static final int ZIP64_EOCD_CFD_LOCATOR_OFFSET = 48;
    private final byte[] CFH_BUF;
    private final byte[] DWORD_BUF;
    private final Comparator<ZipEntry> OFFSET_COMPARATOR;
    private final byte[] SHORT_BUF;
    private final byte[] WORD_BUF;
    private final RandomAccessFile archive;
    private final String archiveName;
    private boolean closed;
    private final String encoding;
    private final Map<ZipEntry, OffsetEntry> entries;
    private final Map<String, ZipEntry> nameMap;
    private final boolean useUnicodeExtraFields;
    private final ZipEncoding zipEncoding;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class NameAndComment {
        private final byte[] comment;
        private final byte[] name;

        NameAndComment(byte[] bArr, byte[] bArr2) {
            this.name = bArr;
            this.comment = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class OffsetEntry {
        private long headerOffset = -1;
        private long dataOffset = -1;

        OffsetEntry() {
        }
    }

    public ZipFile(File file) throws IOException {
        this(file, (String) null);
    }

    public static void closeQuietly(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private Map<ZipEntry, NameAndComment> populateFromCentralDirectory() throws IOException {
        HashMap hashMap = new HashMap();
        positionAtCentralDirectory();
        this.archive.readFully(this.WORD_BUF);
        long value = ZipLong.getValue(this.WORD_BUF);
        if (value != CFH_SIG && startsWithLocalFileHeader()) {
            throw new IOException("central directory is empty, can't expand corrupt archive.");
        }
        while (value == CFH_SIG) {
            readCentralDirectoryEntry(hashMap);
            this.archive.readFully(this.WORD_BUF);
            value = ZipLong.getValue(this.WORD_BUF);
        }
        return hashMap;
    }

    private void positionAtCentralDirectory() throws IOException {
        boolean z16;
        positionAtEndOfCentralDirectoryRecord();
        boolean z17 = false;
        if (this.archive.getFilePointer() > 20) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RandomAccessFile randomAccessFile = this.archive;
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 20);
            this.archive.readFully(this.WORD_BUF);
            z17 = Arrays.equals(ZipOutputStream.ZIP64_EOCD_LOC_SIG, this.WORD_BUF);
        }
        if (!z17) {
            if (z16) {
                skipBytes(16);
            }
            positionAtCentralDirectory32();
            return;
        }
        positionAtCentralDirectory64();
    }

    private void positionAtCentralDirectory32() throws IOException {
        skipBytes(16);
        this.archive.readFully(this.WORD_BUF);
        this.archive.seek(ZipLong.getValue(this.WORD_BUF));
    }

    private void positionAtCentralDirectory64() throws IOException {
        skipBytes(4);
        this.archive.readFully(this.DWORD_BUF);
        this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
        this.archive.readFully(this.WORD_BUF);
        if (Arrays.equals(this.WORD_BUF, ZipOutputStream.ZIP64_EOCD_SIG)) {
            skipBytes(44);
            this.archive.readFully(this.DWORD_BUF);
            this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
            return;
        }
        throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
    }

    private void positionAtEndOfCentralDirectoryRecord() throws IOException {
        if (tryToLocateSignature(22L, 65557L, ZipOutputStream.EOCD_SIG)) {
        } else {
            throw new ZipException("archive is not a ZIP archive");
        }
    }

    private void readCentralDirectoryEntry(Map<ZipEntry, NameAndComment> map) throws IOException {
        ZipEncoding zipEncoding;
        this.archive.readFully(this.CFH_BUF);
        ZipEntry zipEntry = new ZipEntry();
        zipEntry.setPlatform((ZipShort.getValue(this.CFH_BUF, 0) >> 8) & 15);
        GeneralPurposeBit parse = GeneralPurposeBit.parse(this.CFH_BUF, 4);
        boolean usesUTF8ForNames = parse.usesUTF8ForNames();
        if (usesUTF8ForNames) {
            zipEncoding = ZipEncodingHelper.UTF8_ZIP_ENCODING;
        } else {
            zipEncoding = this.zipEncoding;
        }
        zipEntry.setGeneralPurposeBit(parse);
        zipEntry.setMethod(ZipShort.getValue(this.CFH_BUF, 6));
        zipEntry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.CFH_BUF, 8)));
        zipEntry.setCrc(ZipLong.getValue(this.CFH_BUF, 12));
        zipEntry.setCompressedSize(ZipLong.getValue(this.CFH_BUF, 16));
        zipEntry.setSize(ZipLong.getValue(this.CFH_BUF, 20));
        int value = ZipShort.getValue(this.CFH_BUF, 24);
        int value2 = ZipShort.getValue(this.CFH_BUF, 26);
        int value3 = ZipShort.getValue(this.CFH_BUF, 28);
        int value4 = ZipShort.getValue(this.CFH_BUF, 30);
        zipEntry.setInternalAttributes(ZipShort.getValue(this.CFH_BUF, 32));
        zipEntry.setExternalAttributes(ZipLong.getValue(this.CFH_BUF, 34));
        byte[] bArr = new byte[value];
        this.archive.readFully(bArr);
        zipEntry.setName(zipEncoding.decode(bArr), bArr);
        OffsetEntry offsetEntry = new OffsetEntry();
        offsetEntry.headerOffset = ZipLong.getValue(this.CFH_BUF, 38);
        this.entries.put(zipEntry, offsetEntry);
        this.nameMap.put(zipEntry.getName(), zipEntry);
        byte[] bArr2 = new byte[value2];
        this.archive.readFully(bArr2);
        zipEntry.setCentralDirectoryExtra(bArr2);
        setSizesAndOffsetFromZip64Extra(zipEntry, offsetEntry, value4);
        byte[] bArr3 = new byte[value3];
        this.archive.readFully(bArr3);
        zipEntry.setComment(zipEncoding.decode(bArr3));
        if (!usesUTF8ForNames && this.useUnicodeExtraFields) {
            map.put(zipEntry, new NameAndComment(bArr, bArr3));
        }
    }

    private void resolveLocalFileHeaderData(Map<ZipEntry, NameAndComment> map) throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.entries);
        this.entries.clear();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            ZipEntry zipEntry = (ZipEntry) entry.getKey();
            OffsetEntry offsetEntry = (OffsetEntry) entry.getValue();
            long j3 = offsetEntry.headerOffset;
            RandomAccessFile randomAccessFile = this.archive;
            long j16 = j3 + LFH_OFFSET_FOR_FILENAME_LENGTH;
            randomAccessFile.seek(j16);
            this.archive.readFully(this.SHORT_BUF);
            int value = ZipShort.getValue(this.SHORT_BUF);
            this.archive.readFully(this.SHORT_BUF);
            int value2 = ZipShort.getValue(this.SHORT_BUF);
            int i3 = value;
            while (i3 > 0) {
                int skipBytes = this.archive.skipBytes(i3);
                if (skipBytes > 0) {
                    i3 -= skipBytes;
                } else {
                    throw new IOException("failed to skip file name in local file header");
                }
            }
            byte[] bArr = new byte[value2];
            this.archive.readFully(bArr);
            zipEntry.setExtra(bArr);
            offsetEntry.dataOffset = j16 + 2 + 2 + value + value2;
            if (map.containsKey(zipEntry)) {
                String name = zipEntry.getName();
                NameAndComment nameAndComment = map.get(zipEntry);
                ZipUtil.setNameAndCommentFromExtraFields(zipEntry, nameAndComment.name, nameAndComment.comment);
                if (!name.equals(zipEntry.getName())) {
                    this.nameMap.remove(name);
                    this.nameMap.put(zipEntry.getName(), zipEntry);
                }
            }
            this.entries.put(zipEntry, offsetEntry);
        }
    }

    private void setSizesAndOffsetFromZip64Extra(ZipEntry zipEntry, OffsetEntry offsetEntry, int i3) throws IOException {
        boolean z16;
        boolean z17;
        boolean z18;
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) zipEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (zip64ExtendedInformationExtraField != null) {
            boolean z19 = true;
            if (zipEntry.getSize() == 4294967295L) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (zipEntry.getCompressedSize() == 4294967295L) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (offsetEntry.headerOffset == 4294967295L) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (i3 != 65535) {
                z19 = false;
            }
            zip64ExtendedInformationExtraField.reparseCentralDirectoryData(z16, z17, z18, z19);
            if (z16) {
                zipEntry.setSize(zip64ExtendedInformationExtraField.getSize().getLongValue());
            } else if (z17) {
                zip64ExtendedInformationExtraField.setSize(new ZipEightByteInteger(zipEntry.getSize()));
            }
            if (z17) {
                zipEntry.setCompressedSize(zip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
            } else if (z16) {
                zip64ExtendedInformationExtraField.setCompressedSize(new ZipEightByteInteger(zipEntry.getCompressedSize()));
            }
            if (z18) {
                offsetEntry.headerOffset = zip64ExtendedInformationExtraField.getRelativeHeaderOffset().getLongValue();
            }
        }
    }

    private void skipBytes(int i3) throws IOException {
        int i16 = 0;
        while (i16 < i3) {
            int skipBytes = this.archive.skipBytes(i3 - i16);
            if (skipBytes > 0) {
                i16 += skipBytes;
            } else {
                throw new EOFException();
            }
        }
    }

    private boolean startsWithLocalFileHeader() throws IOException {
        this.archive.seek(0L);
        this.archive.readFully(this.WORD_BUF);
        return Arrays.equals(this.WORD_BUF, ZipOutputStream.LFH_SIG);
    }

    private boolean tryToLocateSignature(long j3, long j16, byte[] bArr) throws IOException {
        long length = this.archive.length() - j3;
        long max = Math.max(0L, this.archive.length() - j16);
        boolean z16 = false;
        if (length >= 0) {
            while (true) {
                if (length < max) {
                    break;
                }
                this.archive.seek(length);
                int read = this.archive.read();
                if (read == -1) {
                    break;
                }
                if (read == bArr[0] && this.archive.read() == bArr[1] && this.archive.read() == bArr[2] && this.archive.read() == bArr[3]) {
                    z16 = true;
                    break;
                }
                length--;
            }
        }
        if (z16) {
            this.archive.seek(length);
        }
        return z16;
    }

    public boolean canReadEntryData(ZipEntry zipEntry) {
        return ZipUtil.canHandleEntryData(zipEntry);
    }

    public void close() throws IOException {
        this.closed = true;
        this.archive.close();
    }

    protected void finalize() throws Throwable {
        try {
            if (!this.closed) {
                System.err.println("Cleaning up unclosed ZipFile for archive " + this.archiveName);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Enumeration<ZipEntry> getEntries() {
        return Collections.enumeration(this.entries.keySet());
    }

    public Enumeration<ZipEntry> getEntriesInPhysicalOrder() {
        ZipEntry[] zipEntryArr = (ZipEntry[]) this.entries.keySet().toArray(new ZipEntry[0]);
        Arrays.sort(zipEntryArr, this.OFFSET_COMPARATOR);
        return Collections.enumeration(Arrays.asList(zipEntryArr));
    }

    public ZipEntry getEntry(String str) {
        return this.nameMap.get(str);
    }

    public InputStream getInputStream(ZipEntry zipEntry) throws IOException, ZipException {
        OffsetEntry offsetEntry = this.entries.get(zipEntry);
        if (offsetEntry == null) {
            return null;
        }
        ZipUtil.checkRequestedFeatures(zipEntry);
        BoundedInputStream boundedInputStream = new BoundedInputStream(offsetEntry.dataOffset, zipEntry.getCompressedSize());
        int method = zipEntry.getMethod();
        if (method != 0) {
            if (method == 8) {
                boundedInputStream.addDummy();
                final Inflater inflater = new Inflater(true);
                return new InflaterInputStream(boundedInputStream, inflater) { // from class: com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile.1
                    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        super.close();
                        inflater.end();
                    }
                };
            }
            throw new ZipException("Found unsupported compression method " + zipEntry.getMethod());
        }
        return boundedInputStream;
    }

    public ZipFile(String str) throws IOException {
        this(new File(str), (String) null);
    }

    public ZipFile(String str, String str2) throws IOException {
        this(new File(str), str2, true);
    }

    public ZipFile(File file, String str) throws IOException {
        this(file, str, true);
    }

    public ZipFile(File file, String str, boolean z16) throws IOException {
        this.entries = new LinkedHashMap(509);
        this.nameMap = new HashMap(509);
        this.DWORD_BUF = new byte[8];
        this.WORD_BUF = new byte[4];
        this.CFH_BUF = new byte[42];
        this.SHORT_BUF = new byte[2];
        this.OFFSET_COMPARATOR = new Comparator<ZipEntry>() { // from class: com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile.2
            @Override // java.util.Comparator
            public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                if (zipEntry == zipEntry2) {
                    return 0;
                }
                OffsetEntry offsetEntry = (OffsetEntry) ZipFile.this.entries.get(zipEntry);
                OffsetEntry offsetEntry2 = (OffsetEntry) ZipFile.this.entries.get(zipEntry2);
                if (offsetEntry == null) {
                    return 1;
                }
                if (offsetEntry2 == null) {
                    return -1;
                }
                long j3 = offsetEntry.headerOffset - offsetEntry2.headerOffset;
                if (j3 == 0) {
                    return 0;
                }
                return j3 < 0 ? -1 : 1;
            }
        };
        this.archiveName = file.getAbsolutePath();
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.useUnicodeExtraFields = z16;
        this.archive = new RandomAccessFile(file, "r");
        try {
            resolveLocalFileHeaderData(populateFromCentralDirectory());
        } catch (Throwable th5) {
            try {
                this.closed = true;
                this.archive.close();
            } catch (IOException unused) {
            }
            throw th5;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class BoundedInputStream extends InputStream {
        private boolean addDummyByte = false;
        private long loc;
        private long remaining;

        BoundedInputStream(long j3, long j16) {
            this.remaining = j16;
            this.loc = j3;
        }

        void addDummy() {
            this.addDummyByte = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read;
            long j3 = this.remaining;
            this.remaining = j3 - 1;
            if (j3 > 0) {
                synchronized (ZipFile.this.archive) {
                    RandomAccessFile randomAccessFile = ZipFile.this.archive;
                    long j16 = this.loc;
                    this.loc = 1 + j16;
                    randomAccessFile.seek(j16);
                    read = ZipFile.this.archive.read();
                }
                return read;
            }
            if (!this.addDummyByte) {
                return -1;
            }
            this.addDummyByte = false;
            return 0;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            int read;
            long j3 = this.remaining;
            if (j3 <= 0) {
                if (!this.addDummyByte) {
                    return -1;
                }
                this.addDummyByte = false;
                bArr[i3] = 0;
                return 1;
            }
            if (i16 <= 0) {
                return 0;
            }
            if (i16 > j3) {
                i16 = (int) j3;
            }
            synchronized (ZipFile.this.archive) {
                ZipFile.this.archive.seek(this.loc);
                read = ZipFile.this.archive.read(bArr, i3, i16);
            }
            if (read > 0) {
                long j16 = read;
                this.loc += j16;
                this.remaining -= j16;
            }
            return read;
        }
    }
}
