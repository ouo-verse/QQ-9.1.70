package com.tencent.dlsdk.yybutil.apkchannel.v2;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes5.dex */
abstract class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        c<ByteBuffer, Long> a16 = a(randomAccessFile, 0);
        return a16 != null ? a16 : a(randomAccessFile, 65535);
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
            if (byteBuffer.getInt(i17) == 101010256 && a(byteBuffer, i17 + 20) == i16) {
                return i17;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long c(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long d(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 12);
    }

    private static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i3) {
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
            return c.a(slice, Long.valueOf(capacity + b16));
        }
        throw new IllegalArgumentException("maxCommentSize: " + i3);
    }

    private static long b(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getInt(i3) & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean a(RandomAccessFile randomAccessFile, long j3) {
        long j16 = j3 - 20;
        if (j16 < 0) {
            return false;
        }
        randomAccessFile.seek(j16);
        return randomAccessFile.readInt() == 1347094023;
    }

    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int a(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getShort(i3) & 65535;
    }
}
