package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.nio.ByteBuffer;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NV21Buffer implements VideoFrame.Buffer {
    private final byte[] data;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int width;

    public NV21Buffer(byte[] bArr, int i3, int i16, @Nullable Runnable runnable) {
        this.data = bArr;
        this.width = i3;
        this.height = i16;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    private static native void nativeCropAndScale(int i3, int i16, int i17, int i18, int i19, int i26, byte[] bArr, int i27, int i28, ByteBuffer byteBuffer, int i29, ByteBuffer byteBuffer2, int i36, ByteBuffer byteBuffer3, int i37);

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i3, int i16, int i17, int i18, int i19, int i26) {
        JavaI420Buffer allocate = JavaI420Buffer.allocate(i19, i26);
        nativeCropAndScale(i3, i16, i17, i18, i19, i26, this.data, this.width, this.height, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV());
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
