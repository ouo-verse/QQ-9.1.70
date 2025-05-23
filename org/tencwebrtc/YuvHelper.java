package org.tencwebrtc;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class YuvHelper {
    public static void I420Copy(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, int i19) {
        int i26 = (i18 + 1) / 2;
        int i27 = i18 * i19;
        int i28 = ((i19 + 1) / 2) * i26;
        int i29 = (i28 * 2) + i27;
        if (byteBuffer4.capacity() >= i29) {
            byteBuffer4.position(0);
            ByteBuffer slice = byteBuffer4.slice();
            byteBuffer4.position(i27);
            ByteBuffer slice2 = byteBuffer4.slice();
            byteBuffer4.position(i28 + i27);
            nativeI420Copy(byteBuffer, i3, byteBuffer2, i16, byteBuffer3, i17, slice, i18, slice2, i26, byteBuffer4.slice(), i26, i18, i19);
            return;
        }
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i29 + " was " + byteBuffer4.capacity());
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, int i19, int i26) {
        int i27 = i26 % 180;
        int i28 = i27 == 0 ? i18 : i19;
        int i29 = i27 == 0 ? i19 : i18;
        int i36 = (i29 + 1) / 2;
        int i37 = (i28 + 1) / 2;
        int i38 = i29 * i28;
        int i39 = i36 * i37;
        int i46 = (i39 * 2) + i38;
        if (byteBuffer4.capacity() >= i46) {
            byteBuffer4.position(0);
            ByteBuffer slice = byteBuffer4.slice();
            byteBuffer4.position(i38);
            ByteBuffer slice2 = byteBuffer4.slice();
            byteBuffer4.position(i39 + i38);
            nativeI420Rotate(byteBuffer, i3, byteBuffer2, i16, byteBuffer3, i17, slice, i28, slice2, i37, byteBuffer4.slice(), i37, i18, i19, i26);
            return;
        }
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i46 + " was " + byteBuffer4.capacity());
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, int i19) {
        int i26 = (i18 + 1) / 2;
        int i27 = i18 * i19;
        int i28 = (((i19 + 1) / 2) * i26 * 2) + i27;
        if (byteBuffer4.capacity() >= i28) {
            byteBuffer4.position(0);
            ByteBuffer slice = byteBuffer4.slice();
            byteBuffer4.position(i27);
            nativeI420ToNV12(byteBuffer, i3, byteBuffer2, i16, byteBuffer3, i17, slice, i18, byteBuffer4.slice(), i26 * 2, i18, i19);
            return;
        }
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i28 + " was " + byteBuffer4.capacity());
    }

    public static void copyPlane(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, int i17, int i18) {
        nativeCopyPlane(byteBuffer, i3, byteBuffer2, i16, i17, i18);
    }

    private static native void nativeCopyPlane(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, int i17, int i18);

    private static native void nativeI420Copy(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, ByteBuffer byteBuffer5, int i19, ByteBuffer byteBuffer6, int i26, int i27, int i28);

    private static native void nativeI420Rotate(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, ByteBuffer byteBuffer5, int i19, ByteBuffer byteBuffer6, int i26, int i27, int i28, int i29);

    private static native void nativeI420ToNV12(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, ByteBuffer byteBuffer5, int i19, int i26, int i27);

    public static void I420ToNV12(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, ByteBuffer byteBuffer5, int i19, int i26, int i27) {
        nativeI420ToNV12(byteBuffer, i3, byteBuffer2, i16, byteBuffer3, i17, byteBuffer4, i18, byteBuffer5, i19, i26, i27);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, ByteBuffer byteBuffer5, int i19, ByteBuffer byteBuffer6, int i26, int i27, int i28) {
        nativeI420Copy(byteBuffer, i3, byteBuffer2, i16, byteBuffer3, i17, byteBuffer4, i18, byteBuffer5, i19, byteBuffer6, i26, i27, i28);
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, ByteBuffer byteBuffer4, int i18, ByteBuffer byteBuffer5, int i19, ByteBuffer byteBuffer6, int i26, int i27, int i28, int i29) {
        nativeI420Rotate(byteBuffer, i3, byteBuffer2, i16, byteBuffer3, i17, byteBuffer4, i18, byteBuffer5, i19, byteBuffer6, i26, i27, i28, i29);
    }
}
