package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.nio.ByteBuffer;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    JavaI420Buffer(int i3, int i16, ByteBuffer byteBuffer, int i17, ByteBuffer byteBuffer2, int i18, ByteBuffer byteBuffer3, int i19, @Nullable Runnable runnable) {
        this.width = i3;
        this.height = i16;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i17;
        this.strideU = i18;
        this.strideV = i19;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static JavaI420Buffer allocate(int i3, int i16) {
        int i17 = (i16 + 1) / 2;
        int i18 = (i3 + 1) / 2;
        int i19 = i3 * i16;
        int i26 = i19 + 0;
        int i27 = i18 * i17;
        int i28 = i26 + i27;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i19 + (i18 * 2 * i17));
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i26);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i26);
        nativeAllocateByteBuffer.limit(i28);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i28);
        nativeAllocateByteBuffer.limit(i28 + i27);
        return new JavaI420Buffer(i3, i16, slice, i3, slice2, i18, nativeAllocateByteBuffer.slice(), i18, new Runnable() { // from class: org.tencwebrtc.q
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    private static void checkCapacity(ByteBuffer byteBuffer, int i3, int i16, int i17) {
        int i18 = (i17 * (i16 - 1)) + i3;
        if (byteBuffer.capacity() >= i18) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i18 + " bytes, but was " + byteBuffer.capacity());
    }

    public static VideoFrame.Buffer cropAndScaleI420(final VideoFrame.I420Buffer i420Buffer, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i17 == i19 && i18 == i26) {
            ByteBuffer dataY = i420Buffer.getDataY();
            ByteBuffer dataU = i420Buffer.getDataU();
            ByteBuffer dataV = i420Buffer.getDataV();
            dataY.position(i3 + (i420Buffer.getStrideY() * i16));
            int i27 = i3 / 2;
            int i28 = i16 / 2;
            dataU.position((i420Buffer.getStrideU() * i28) + i27);
            dataV.position(i27 + (i28 * i420Buffer.getStrideV()));
            i420Buffer.retain();
            return wrap(i19, i26, dataY.slice(), i420Buffer.getStrideY(), dataU.slice(), i420Buffer.getStrideU(), dataV.slice(), i420Buffer.getStrideV(), new Runnable() { // from class: org.tencwebrtc.r
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFrame.I420Buffer.this.release();
                }
            });
        }
        JavaI420Buffer allocate = allocate(i19, i26);
        nativeCropAndScaleI420(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), i3, i16, i17, i18, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), i19, i26);
        return allocate;
    }

    private static native void nativeCropAndScaleI420(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2, int i16, ByteBuffer byteBuffer3, int i17, int i18, int i19, int i26, int i27, ByteBuffer byteBuffer4, int i28, ByteBuffer byteBuffer5, int i29, ByteBuffer byteBuffer6, int i36, int i37, int i38);

    public static JavaI420Buffer wrap(int i3, int i16, ByteBuffer byteBuffer, int i17, ByteBuffer byteBuffer2, int i18, ByteBuffer byteBuffer3, int i19, @Nullable Runnable runnable) {
        if (byteBuffer != null && byteBuffer2 != null && byteBuffer3 != null) {
            if (byteBuffer.isDirect() && byteBuffer2.isDirect() && byteBuffer3.isDirect()) {
                ByteBuffer slice = byteBuffer.slice();
                ByteBuffer slice2 = byteBuffer2.slice();
                ByteBuffer slice3 = byteBuffer3.slice();
                int i26 = (i3 + 1) / 2;
                int i27 = (i16 + 1) / 2;
                checkCapacity(slice, i3, i16, i17);
                checkCapacity(slice2, i26, i27, i18);
                checkCapacity(slice3, i26, i27, i19);
                return new JavaI420Buffer(i3, i16, slice, i17, slice2, i18, slice3, i19, runnable);
            }
            throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
        }
        throw new IllegalArgumentException("Data buffers cannot be null.");
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i3, int i16, int i17, int i18, int i19, int i26) {
        return cropAndScaleI420(this, i3, i16, i17, i18, i19, i26);
    }

    @Override // org.tencwebrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // org.tencwebrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // org.tencwebrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.tencwebrtc.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // org.tencwebrtc.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // org.tencwebrtc.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer, org.tencwebrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer, org.tencwebrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }

    public static JavaI420Buffer allocate(int i3, int i16, int i17) {
        int i18 = i3 * i17;
        int i19 = i16 * i17;
        int i26 = (i19 + 1) / 2;
        int i27 = (i18 + 1) / 2;
        int i28 = i18 * i19;
        int i29 = i28 + 0;
        int i36 = i27 * i26;
        int i37 = i29 + i36;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i28 + (i27 * 2 * i26));
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i29);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i29);
        nativeAllocateByteBuffer.limit(i37);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i37);
        nativeAllocateByteBuffer.limit(i37 + i36);
        return new JavaI420Buffer(i18, i19, slice, i18, slice2, i27, nativeAllocateByteBuffer.slice(), i27, new Runnable() { // from class: org.tencwebrtc.p
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }
}
