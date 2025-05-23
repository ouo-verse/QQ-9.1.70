package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes23.dex */
public class ParsableInputStreamWrapper implements Closeable, Parsable {
    private final IDataSource dataSource;
    private final byte[] intBuffer = new byte[4];
    private final byte[] longBuffer = new byte[8];
    private long position = 0;

    public ParsableInputStreamWrapper(IDataSource iDataSource) {
        this.dataSource = iDataSource;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long available() throws IOException {
        return this.dataSource.getSize() - this.position;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dataSource.close();
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public void readBytes(byte[] bArr, int i3, int i16) throws IOException {
        this.position = this.position + this.dataSource.readAt(r6, bArr, i3, i16);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public int readInt() throws IOException {
        IDataSource iDataSource = this.dataSource;
        long j3 = this.position;
        byte[] bArr = this.intBuffer;
        int readAt = iDataSource.readAt(j3, bArr, 0, bArr.length);
        this.position += readAt;
        byte[] bArr2 = this.intBuffer;
        if (readAt != bArr2.length) {
            return -1;
        }
        return ((bArr2[0] & 255) << 24) | ((bArr2[1] & 255) << 16) | ((bArr2[2] & 255) << 8) | (bArr2[3] & 255);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public int[] readIntArray(int i3) throws IOException {
        int[] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = readInt();
        }
        return iArr;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public void readIntArrayInterleaved(int i3, int[]... iArr) throws IOException {
        for (int i16 = 0; i16 < i3; i16++) {
            for (int[] iArr2 : iArr) {
                iArr2[i16] = readInt();
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long readLong() throws IOException {
        IDataSource iDataSource = this.dataSource;
        long j3 = this.position;
        byte[] bArr = this.longBuffer;
        int readAt = iDataSource.readAt(j3, bArr, 0, bArr.length);
        this.position += readAt;
        if (readAt != this.longBuffer.length) {
            return -1L;
        }
        return (r1[7] & 255) | ((r1[0] & 255) << 56) | ((r1[1] & 255) << 48) | ((r1[2] & 255) << 40) | ((r1[3] & 255) << 32) | ((r1[4] & 255) << 24) | ((r1[5] & 255) << 16) | ((r1[6] & 255) << 8);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long[] readLongArray(int i3) throws IOException {
        long[] jArr = new long[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            jArr[i16] = readLong();
        }
        return jArr;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public void readLongArrayInterleaved(int i3, long[]... jArr) throws IOException {
        for (int i16 = 0; i16 < i3; i16++) {
            for (long[] jArr2 : jArr) {
                jArr2[i16] = readLong();
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public String readString(int i3) throws IOException {
        byte[] bArr = new byte[i3];
        readBytes(bArr, 0, i3);
        return new String(bArr, Charset.defaultCharset());
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long skip(long j3) throws IOException {
        long available = available();
        if (available > j3) {
            this.position += j3;
            return j3;
        }
        this.position += available;
        return available;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.Parsable
    public long tell() {
        return this.position;
    }
}
