package org.jf.dexlib2.dexbacked;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.Arrays;
import javax.annotation.Nonnull;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBuffer {
    final int baseOffset;

    @Nonnull
    final byte[] buf;

    public DexBuffer(@Nonnull byte[] bArr) {
        this(bArr, 0);
    }

    public int getBaseOffset() {
        return this.baseOffset;
    }

    @Nonnull
    public byte[] getBuf() {
        return this.buf;
    }

    public int readByte(int i3) {
        return this.buf[this.baseOffset + i3];
    }

    @Nonnull
    public byte[] readByteRange(int i3, int i16) {
        byte[] bArr = this.buf;
        int i17 = this.baseOffset;
        return Arrays.copyOfRange(bArr, i17 + i3, i17 + i3 + i16);
    }

    public int readInt(int i3) {
        byte[] bArr = this.buf;
        int i16 = i3 + this.baseOffset;
        return (bArr[i16 + 3] << 24) | (bArr[i16] & 255) | ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16 + 2] & 255) << 16);
    }

    public long readLong(int i3) {
        byte[] bArr = this.buf;
        int i16 = i3 + this.baseOffset;
        return (bArr[i16] & 255) | ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16 + 2] & 255) << 16) | ((bArr[i16 + 3] & 255) << 24) | ((bArr[i16 + 4] & 255) << 32) | ((bArr[i16 + 5] & 255) << 40) | ((bArr[i16 + 6] & 255) << 48) | (bArr[i16 + 7] << 56);
    }

    public int readLongAsSmallUint(int i3) {
        byte[] bArr = this.buf;
        int i16 = i3 + this.baseOffset;
        long j3 = (bArr[i16] & 255) | ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16 + 2] & 255) << 16) | ((bArr[i16 + 3] & 255) << 24) | ((bArr[i16 + 4] & 255) << 32) | ((bArr[i16 + 5] & 255) << 40) | ((bArr[i16 + 6] & 255) << 48) | (bArr[i16 + 7] << 56);
        if (j3 >= 0 && j3 <= TTL.MAX_VALUE) {
            return (int) j3;
        }
        throw new ExceptionWithContext("Encountered out-of-range ulong at offset 0x%x", Integer.valueOf(i16));
    }

    public int readOptionalUint(int i3) {
        byte[] bArr = this.buf;
        int i16 = i3 + this.baseOffset;
        int i17 = (bArr[i16 + 3] << 24) | (bArr[i16] & 255) | ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16 + 2] & 255) << 16);
        if (i17 >= -1) {
            return i17;
        }
        throw new ExceptionWithContext("Encountered optional uint that is out of range at offset 0x%x", Integer.valueOf(i16));
    }

    public int readShort(int i3) {
        byte[] bArr = this.buf;
        int i16 = i3 + this.baseOffset;
        return (bArr[i16 + 1] << 8) | (bArr[i16] & 255);
    }

    public int readSmallUint(int i3) {
        byte[] bArr = this.buf;
        int i16 = i3 + this.baseOffset;
        int i17 = (bArr[i16 + 3] << 24) | (bArr[i16] & 255) | ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16 + 2] & 255) << 16);
        if (i17 >= 0) {
            return i17;
        }
        throw new ExceptionWithContext("Encountered small uint that is out of range at offset 0x%x", Integer.valueOf(i16));
    }

    public int readUbyte(int i3) {
        return this.buf[i3 + this.baseOffset] & 255;
    }

    public int readUshort(int i3) {
        byte[] bArr = this.buf;
        int i16 = i3 + this.baseOffset;
        return ((bArr[i16 + 1] & 255) << 8) | (bArr[i16] & 255);
    }

    @Nonnull
    public DexReader<? extends DexBuffer> readerAt(int i3) {
        return new DexReader<>(this, i3);
    }

    public DexBuffer(@Nonnull byte[] bArr, int i3) {
        this.buf = bArr;
        this.baseOffset = i3;
    }
}
