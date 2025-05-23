package com.tencent.gamecenter.wadl.util;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes6.dex */
abstract class o {
    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i3 = capacity - 22;
        int min = Math.min(i3, 65535);
        for (int i16 = 0; i16 < min; i16++) {
            int i17 = i3 - i16;
            if (byteBuffer.getInt(i17) == 101010256 && e(byteBuffer, i17 + 20) == i16) {
                return i17;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> d16 = d(randomAccessFile, 0);
        if (d16 != null) {
            return d16;
        }
        return d(randomAccessFile, 65535);
    }

    private static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, int i3) throws IOException {
        if (i3 >= 0 && i3 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i3, length - 22)) + 22);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int b16 = b(allocate);
            if (b16 == -1) {
                return null;
            }
            allocate.position(b16);
            ByteBuffer slice = allocate.slice();
            slice.order(byteOrder);
            return Pair.create(slice, Long.valueOf(capacity + b16));
        }
        throw new IllegalArgumentException("maxCommentSize: " + i3);
    }

    private static int e(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getShort(i3) & 65535;
    }

    private static long f(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getInt(i3) & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long g(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return f(byteBuffer, byteBuffer.position() + 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long h(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return f(byteBuffer, byteBuffer.position() + 12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean i(RandomAccessFile randomAccessFile, long j3) throws IOException {
        long j16 = j3 - 20;
        if (j16 < 0) {
            return false;
        }
        randomAccessFile.seek(j16);
        if (randomAccessFile.readInt() != 1347094023) {
            return false;
        }
        return true;
    }
}
