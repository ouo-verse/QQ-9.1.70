package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.nio.ByteBuffer;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NV12Buffer implements VideoFrame.Buffer {
    private final ByteBuffer buffer;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int sliceHeight;
    private final int stride;
    private final int width;

    public NV12Buffer(int i3, int i16, int i17, int i18, ByteBuffer byteBuffer, @Nullable Runnable runnable) {
        this.width = i3;
        this.height = i16;
        this.stride = i17;
        this.sliceHeight = i18;
        this.buffer = byteBuffer;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    private static native void nativeCropAndScale(int i3, int i16, int i17, int i18, int i19, int i26, ByteBuffer byteBuffer, int i27, int i28, int i29, int i36, ByteBuffer byteBuffer2, int i37, ByteBuffer byteBuffer3, int i38, ByteBuffer byteBuffer4, int i39);

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i3, int i16, int i17, int i18, int i19, int i26) {
        JavaI420Buffer allocate = JavaI420Buffer.allocate(i19, i26);
        nativeCropAndScale(i3, i16, i17, i18, i19, i26, this.buffer, this.width, this.height, this.stride, this.sliceHeight, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV());
        return allocate;
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
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
        int i3 = this.width;
        int i16 = this.height;
        return (VideoFrame.I420Buffer) cropAndScale(0, 0, i3, i16, i3, i16);
    }
}
