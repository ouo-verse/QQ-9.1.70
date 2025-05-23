package com.tencent.mobileqq.mini.cache;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BlobCache implements Closeable {
    private static final int BH_CHECKSUM = 8;
    private static final int BH_KEY = 0;
    private static final int BH_LENGTH = 16;
    private static final int BH_OFFSET = 12;
    private static final int BLOB_HEADER_SIZE = 20;
    private static final int DATA_HEADER_SIZE = 4;
    private static final int IH_ACTIVE_BYTES = 20;
    private static final int IH_ACTIVE_ENTRIES = 16;
    private static final int IH_ACTIVE_REGION = 12;
    private static final int IH_CHECKSUM = 28;
    private static final int IH_MAGIC = 0;
    private static final int IH_MAX_BYTES = 8;
    private static final int IH_MAX_ENTRIES = 4;
    private static final int IH_VERSION = 24;
    private static final int INDEX_HEADER_SIZE = 32;
    private static final int MAGIC_DATA_FILE = -1121680112;
    private static final int MAGIC_INDEX_FILE = -1289277392;
    private static final String TAG = "BlobCache";
    private int mActiveBytes;
    private RandomAccessFile mActiveDataFile;
    private int mActiveEntries;
    private int mActiveHashStart;
    private int mActiveRegion;
    private Adler32 mAdler32;
    private byte[] mBlobHeader;
    private RandomAccessFile mDataFile0;
    private RandomAccessFile mDataFile1;
    private int mFileOffset;
    private RandomAccessFile mInactiveDataFile;
    private int mInactiveHashStart;
    private MappedByteBuffer mIndexBuffer;
    private FileChannel mIndexChannel;
    private RandomAccessFile mIndexFile;
    private byte[] mIndexHeader;
    private LookupRequest mLookupRequest;
    private int mMaxBytes;
    private int mMaxEntries;
    private int mSlotOffset;
    private int mVersion;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class LookupRequest {
        public byte[] buffer;
        public long key;
        public int length;
    }

    public BlobCache(String str, int i3, int i16, boolean z16) throws IOException {
        this(str, i3, i16, z16, 0);
    }

    private void closeAll() {
        closeSilently(this.mIndexChannel);
        closeSilently(this.mIndexFile);
        closeSilently(this.mDataFile0);
        closeSilently(this.mDataFile1);
    }

    private static void deleteFileSilently(String str) {
        try {
            new File(str).delete();
        } catch (Throwable unused) {
        }
    }

    public static void deleteFiles(String str) {
        deleteFileSilently(str + ".idx");
        deleteFileSilently(str + ".0");
        deleteFileSilently(str + ".1");
    }

    private void flipRegion() throws IOException {
        int i3 = 1 - this.mActiveRegion;
        this.mActiveRegion = i3;
        this.mActiveEntries = 0;
        this.mActiveBytes = 4;
        writeInt(this.mIndexHeader, 12, i3);
        writeInt(this.mIndexHeader, 16, this.mActiveEntries);
        writeInt(this.mIndexHeader, 20, this.mActiveBytes);
        updateIndexHeader();
        setActiveVariables();
        clearHash(this.mActiveHashStart);
        syncIndex();
    }

    private boolean getBlob(RandomAccessFile randomAccessFile, int i3, LookupRequest lookupRequest) throws IOException {
        byte[] bArr = this.mBlobHeader;
        long filePointer = randomAccessFile.getFilePointer();
        try {
            randomAccessFile.seek(i3);
            if (randomAccessFile.read(bArr) != 20) {
                Log.w(TAG, "cannot read blob header");
                return false;
            }
            long readLong = readLong(bArr, 0);
            if (readLong != lookupRequest.key) {
                Log.w(TAG, "blob key does not match: " + readLong);
                return false;
            }
            int readInt = readInt(bArr, 8);
            int readInt2 = readInt(bArr, 12);
            if (readInt2 != i3) {
                Log.w(TAG, "blob offset does not match: " + readInt2);
                return false;
            }
            int readInt3 = readInt(bArr, 16);
            if (readInt3 >= 0 && readInt3 <= (this.mMaxBytes - i3) - 20) {
                byte[] bArr2 = lookupRequest.buffer;
                if (bArr2 == null || bArr2.length < readInt3) {
                    lookupRequest.buffer = new byte[readInt3];
                }
                byte[] bArr3 = lookupRequest.buffer;
                lookupRequest.length = readInt3;
                if (randomAccessFile.read(bArr3, 0, readInt3) != readInt3) {
                    Log.w(TAG, "cannot read blob data");
                    return false;
                }
                if (checkSum(bArr3, 0, readInt3) != readInt) {
                    Log.w(TAG, "blob checksum does not match: " + readInt);
                    return false;
                }
                randomAccessFile.seek(filePointer);
                return true;
            }
            Log.w(TAG, "invalid blob length: " + readInt3);
            return false;
        } catch (Throwable th5) {
            try {
                Log.e(TAG, "getBlob failed.", th5);
                return false;
            } finally {
                randomAccessFile.seek(filePointer);
            }
        }
    }

    private void insertInternal(long j3, byte[] bArr, int i3) throws IOException {
        byte[] bArr2 = this.mBlobHeader;
        int checkSum = checkSum(bArr);
        writeLong(bArr2, 0, j3);
        writeInt(bArr2, 8, checkSum);
        writeInt(bArr2, 12, this.mActiveBytes);
        writeInt(bArr2, 16, i3);
        this.mActiveDataFile.write(bArr2);
        this.mActiveDataFile.write(bArr, 0, i3);
        this.mIndexBuffer.putLong(this.mSlotOffset, j3);
        this.mIndexBuffer.putInt(this.mSlotOffset + 8, this.mActiveBytes);
        int i16 = this.mActiveBytes + i3 + 20;
        this.mActiveBytes = i16;
        writeInt(this.mIndexHeader, 20, i16);
    }

    private boolean loadIndex() {
        try {
            this.mIndexFile.seek(0L);
            this.mDataFile0.seek(0L);
            this.mDataFile1.seek(0L);
            byte[] bArr = this.mIndexHeader;
            if (this.mIndexFile.read(bArr) != 32) {
                Log.w(TAG, "cannot read header");
                return false;
            }
            if (readInt(bArr, 0) != MAGIC_INDEX_FILE) {
                Log.w(TAG, "cannot read header magic");
                return false;
            }
            if (readInt(bArr, 24) != this.mVersion) {
                Log.w(TAG, "version mismatch");
                return false;
            }
            this.mMaxEntries = readInt(bArr, 4);
            this.mMaxBytes = readInt(bArr, 8);
            this.mActiveRegion = readInt(bArr, 12);
            this.mActiveEntries = readInt(bArr, 16);
            this.mActiveBytes = readInt(bArr, 20);
            if (checkSum(bArr, 0, 28) != readInt(bArr, 28)) {
                Log.w(TAG, "header checksum does not match");
                return false;
            }
            int i3 = this.mMaxEntries;
            if (i3 <= 0) {
                Log.w(TAG, "invalid max entries");
                return false;
            }
            int i16 = this.mMaxBytes;
            if (i16 <= 0) {
                Log.w(TAG, "invalid max bytes");
                return false;
            }
            int i17 = this.mActiveRegion;
            if (i17 != 0 && i17 != 1) {
                Log.w(TAG, "invalid active region");
                return false;
            }
            int i18 = this.mActiveEntries;
            if (i18 >= 0 && i18 <= i3) {
                int i19 = this.mActiveBytes;
                if (i19 >= 4 && i19 <= i16) {
                    if (this.mIndexFile.length() != (this.mMaxEntries * 12 * 2) + 32) {
                        Log.w(TAG, "invalid index file length");
                        return false;
                    }
                    byte[] bArr2 = new byte[4];
                    if (this.mDataFile0.read(bArr2) != 4) {
                        Log.w(TAG, "cannot read data file magic");
                        return false;
                    }
                    if (readInt(bArr2, 0) != MAGIC_DATA_FILE) {
                        Log.w(TAG, "invalid data file magic");
                        return false;
                    }
                    if (this.mDataFile1.read(bArr2) != 4) {
                        Log.w(TAG, "cannot read data file magic");
                        return false;
                    }
                    if (readInt(bArr2, 0) != MAGIC_DATA_FILE) {
                        Log.w(TAG, "invalid data file magic");
                        return false;
                    }
                    FileChannel channel = this.mIndexFile.getChannel();
                    this.mIndexChannel = channel;
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, this.mIndexFile.length());
                    this.mIndexBuffer = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    setActiveVariables();
                    return true;
                }
                Log.w(TAG, "invalid active bytes");
                return false;
            }
            Log.w(TAG, "invalid active entries");
            return false;
        } catch (IOException e16) {
            Log.e(TAG, "loadIndex failed.", e16);
            return false;
        }
    }

    private boolean lookupInternal(long j3, int i3) {
        int i16 = this.mMaxEntries;
        int i17 = (int) (j3 % i16);
        if (i17 < 0) {
            i17 += i16;
        }
        int i18 = i17;
        while (true) {
            int i19 = (i18 * 12) + i3;
            long j16 = this.mIndexBuffer.getLong(i19);
            int i26 = this.mIndexBuffer.getInt(i19 + 8);
            if (i26 == 0) {
                this.mSlotOffset = i19;
                return false;
            }
            if (j16 == j3) {
                this.mSlotOffset = i19;
                this.mFileOffset = i26;
                return true;
            }
            i18++;
            if (i18 >= this.mMaxEntries) {
                i18 = 0;
            }
            if (i18 == i17) {
                Log.w(TAG, "corrupted index: clear the slot.");
                this.mIndexBuffer.putInt((i18 * 12) + i3 + 8, 0);
            }
        }
    }

    static int readInt(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    private void resetCache(int i3, int i16) throws IOException {
        this.mIndexFile.setLength(0L);
        this.mIndexFile.setLength((i3 * 12 * 2) + 32);
        this.mIndexFile.seek(0L);
        byte[] bArr = this.mIndexHeader;
        writeInt(bArr, 0, MAGIC_INDEX_FILE);
        writeInt(bArr, 4, i3);
        writeInt(bArr, 8, i16);
        writeInt(bArr, 12, 0);
        writeInt(bArr, 16, 0);
        writeInt(bArr, 20, 4);
        writeInt(bArr, 24, this.mVersion);
        writeInt(bArr, 28, checkSum(bArr, 0, 28));
        this.mIndexFile.write(bArr);
        this.mDataFile0.setLength(0L);
        this.mDataFile1.setLength(0L);
        this.mDataFile0.seek(0L);
        this.mDataFile1.seek(0L);
        writeInt(bArr, 0, MAGIC_DATA_FILE);
        this.mDataFile0.write(bArr, 0, 4);
        this.mDataFile1.write(bArr, 0, 4);
    }

    private void setActiveVariables() throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        int i3 = this.mActiveRegion;
        if (i3 == 0) {
            randomAccessFile = this.mDataFile0;
        } else {
            randomAccessFile = this.mDataFile1;
        }
        this.mActiveDataFile = randomAccessFile;
        if (i3 == 1) {
            randomAccessFile2 = this.mDataFile0;
        } else {
            randomAccessFile2 = this.mDataFile1;
        }
        this.mInactiveDataFile = randomAccessFile2;
        randomAccessFile.setLength(this.mActiveBytes);
        this.mActiveDataFile.seek(this.mActiveBytes);
        this.mActiveHashStart = 32;
        this.mInactiveHashStart = 32;
        if (this.mActiveRegion == 0) {
            this.mInactiveHashStart = 32 + (this.mMaxEntries * 12);
        } else {
            this.mActiveHashStart = 32 + (this.mMaxEntries * 12);
        }
    }

    private void updateIndexHeader() {
        byte[] bArr = this.mIndexHeader;
        writeInt(bArr, 28, checkSum(bArr, 0, 28));
        this.mIndexBuffer.position(0);
        this.mIndexBuffer.put(this.mIndexHeader);
    }

    int checkSum(byte[] bArr) {
        this.mAdler32.reset();
        this.mAdler32.update(bArr);
        return (int) this.mAdler32.getValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        syncAll();
        closeAll();
    }

    public void insert(long j3, byte[] bArr) throws IOException {
        int length = bArr.length + 24;
        int i3 = this.mMaxBytes;
        if (length <= i3) {
            if (this.mActiveBytes + 20 + bArr.length > i3 || this.mActiveEntries * 2 >= this.mMaxEntries) {
                flipRegion();
            }
            if (!lookupInternal(j3, this.mActiveHashStart)) {
                int i16 = this.mActiveEntries + 1;
                this.mActiveEntries = i16;
                writeInt(this.mIndexHeader, 16, i16);
            }
            insertInternal(j3, bArr, bArr.length);
            updateIndexHeader();
            return;
        }
        throw new RuntimeException("blob is too large!");
    }

    public byte[] lookup(long j3) throws IOException {
        LookupRequest lookupRequest = this.mLookupRequest;
        lookupRequest.key = j3;
        lookupRequest.buffer = null;
        if (lookup(lookupRequest)) {
            return this.mLookupRequest.buffer;
        }
        return null;
    }

    public void syncAll() {
        syncIndex();
        try {
            this.mDataFile0.getFD().sync();
        } catch (Throwable th5) {
            Log.w(TAG, "sync data file 0 failed", th5);
        }
        try {
            this.mDataFile1.getFD().sync();
        } catch (Throwable th6) {
            Log.w(TAG, "sync data file 1 failed", th6);
        }
    }

    public void syncIndex() {
        try {
            this.mIndexBuffer.force();
        } catch (Throwable th5) {
            Log.w(TAG, "sync index failed", th5);
        }
    }

    public BlobCache(String str, int i3, int i16, boolean z16, int i17) throws IOException {
        this.mIndexHeader = new byte[32];
        this.mBlobHeader = new byte[20];
        this.mAdler32 = new Adler32();
        this.mLookupRequest = new LookupRequest();
        this.mIndexFile = new RandomAccessFile(str + ".idx", "rw");
        this.mDataFile0 = new RandomAccessFile(str + ".0", "rw");
        this.mDataFile1 = new RandomAccessFile(str + ".1", "rw");
        this.mVersion = i17;
        if (z16 || !loadIndex()) {
            resetCache(i3, i16);
            if (loadIndex()) {
                return;
            }
            closeAll();
            throw new IOException("unable to load index");
        }
    }

    private void clearHash(int i3) {
        byte[] bArr = new byte[1024];
        this.mIndexBuffer.position(i3);
        int i16 = this.mMaxEntries * 12;
        while (i16 > 0) {
            int min = Math.min(i16, 1024);
            this.mIndexBuffer.put(bArr, 0, min);
            i16 -= min;
        }
    }

    static long readLong(byte[] bArr, int i3) {
        long j3 = bArr[i3 + 7] & 255;
        for (int i16 = 6; i16 >= 0; i16--) {
            j3 = (j3 << 8) | (bArr[i3 + i16] & 255);
        }
        return j3;
    }

    int getActiveCount() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.mMaxEntries; i16++) {
            int i17 = this.mActiveHashStart + (i16 * 12);
            this.mIndexBuffer.getLong(i17);
            if (this.mIndexBuffer.getInt(i17 + 8) != 0) {
                i3++;
            }
        }
        if (i3 == this.mActiveEntries) {
            return i3;
        }
        Log.e(TAG, "wrong active count: " + this.mActiveEntries + " vs " + i3);
        return -1;
    }

    static void closeSilently(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    int checkSum(byte[] bArr, int i3, int i16) {
        this.mAdler32.reset();
        this.mAdler32.update(bArr, i3, i16);
        return (int) this.mAdler32.getValue();
    }

    public boolean lookup(LookupRequest lookupRequest) throws IOException {
        if (lookupInternal(lookupRequest.key, this.mActiveHashStart) && getBlob(this.mActiveDataFile, this.mFileOffset, lookupRequest)) {
            return true;
        }
        int i3 = this.mSlotOffset;
        if (!lookupInternal(lookupRequest.key, this.mInactiveHashStart) || !getBlob(this.mInactiveDataFile, this.mFileOffset, lookupRequest)) {
            return false;
        }
        int i16 = this.mActiveBytes + 20;
        int i17 = lookupRequest.length;
        if (i16 + i17 <= this.mMaxBytes && this.mActiveEntries * 2 < this.mMaxEntries) {
            this.mSlotOffset = i3;
            try {
                insertInternal(lookupRequest.key, lookupRequest.buffer, i17);
                int i18 = this.mActiveEntries + 1;
                this.mActiveEntries = i18;
                writeInt(this.mIndexHeader, 16, i18);
                updateIndexHeader();
            } catch (Throwable unused) {
                Log.e(TAG, "cannot copy over");
            }
        }
        return true;
    }

    static void writeInt(byte[] bArr, int i3, int i16) {
        for (int i17 = 0; i17 < 4; i17++) {
            bArr[i3 + i17] = (byte) (i16 & 255);
            i16 >>= 8;
        }
    }

    static void writeLong(byte[] bArr, int i3, long j3) {
        for (int i16 = 0; i16 < 8; i16++) {
            bArr[i3 + i16] = (byte) (255 & j3);
            j3 >>= 8;
        }
    }
}
