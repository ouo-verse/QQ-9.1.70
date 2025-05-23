package org.tencwebrtc;

import java.nio.ByteBuffer;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
class WrappedNativeI420Buffer implements VideoFrame.I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final long nativeBuffer;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    @CalledByNative
    WrappedNativeI420Buffer(int i3, int i16, ByteBuffer byteBuffer, int i17, ByteBuffer byteBuffer2, int i18, ByteBuffer byteBuffer3, int i19, long j3) {
        this.width = i3;
        this.height = i16;
        this.dataY = byteBuffer;
        this.strideY = i17;
        this.dataU = byteBuffer2;
        this.strideU = i18;
        this.dataV = byteBuffer3;
        this.strideV = i19;
        this.nativeBuffer = j3;
        retain();
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i3, int i16, int i17, int i18, int i19, int i26) {
        return JavaI420Buffer.cropAndScaleI420(this, i3, i16, i17, i18, i19, i26);
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
        JniCommon.nativeReleaseRef(this.nativeBuffer);
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer, org.tencwebrtc.RefCounted
    public void retain() {
        JniCommon.nativeAddRef(this.nativeBuffer);
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }
}
