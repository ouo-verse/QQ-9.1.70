package com.tencent.qphone.base.util.log.utils;

import java.nio.MappedByteBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MagicHeadWriter {
    public static final int MAGIC_ENCRYPT_CODE = -20190711;
    public static final int MAGIC_HEAD_COMPRESS = -21937241;
    public static final int MAGIC_HEAD_LENGTH = 8;
    public static final int MAGIC_HEAD_NO_COMPRESS = -18239;
    public static final byte MAGIC_VERSION_CODE = 1;
    private static final String TAG = "MagicHeadWriter";
    MappedByteBuffer cacheFileMmapBuffer;
    final boolean compress;

    public MagicHeadWriter(MappedByteBuffer mappedByteBuffer, boolean z16) {
        this.compress = z16;
        this.cacheFileMmapBuffer = mappedByteBuffer;
    }

    public boolean prepareToWrite() {
        int i3 = this.cacheFileMmapBuffer.getInt(0);
        int i16 = this.cacheFileMmapBuffer.getInt(4);
        if (i16 <= 0 || i16 >= this.cacheFileMmapBuffer.capacity() - 8 || !(i3 == -21937241 || i3 == -18239)) {
            return false;
        }
        this.cacheFileMmapBuffer.position(i16 + 8);
        prepareToWrite(i3 == -21937241);
        return true;
    }

    public void updateLength() {
        int i3;
        MappedByteBuffer mappedByteBuffer = this.cacheFileMmapBuffer;
        if (this.compress) {
            i3 = MAGIC_HEAD_COMPRESS;
        } else {
            i3 = MAGIC_HEAD_NO_COMPRESS;
        }
        mappedByteBuffer.putInt(0, i3);
        this.cacheFileMmapBuffer.putInt(4, r0.position() - 8);
    }

    public void writeInitLength() {
        int i3;
        MappedByteBuffer mappedByteBuffer = this.cacheFileMmapBuffer;
        if (this.compress) {
            i3 = MAGIC_HEAD_COMPRESS;
        } else {
            i3 = MAGIC_HEAD_NO_COMPRESS;
        }
        mappedByteBuffer.putInt(i3);
        this.cacheFileMmapBuffer.putInt(r0.position() - 8);
    }

    public void prepareToWrite(boolean z16) {
        this.cacheFileMmapBuffer.flip();
        if (z16) {
            return;
        }
        this.cacheFileMmapBuffer.position(8);
    }
}
