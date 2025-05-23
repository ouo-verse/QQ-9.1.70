package org.tencwebrtc;

import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoFrame implements RefCounted {
    private int bsSize;
    private final Buffer buffer;
    private boolean isKeyFrame;

    @Nullable
    private byte[] latencyTimestamp;
    private final int rotation;
    private final long timestampNs;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Buffer extends RefCounted {
        @CalledByNative("Buffer")
        Buffer cropAndScale(int i3, int i16, int i17, int i18, int i19, int i26);

        @CalledByNative("Buffer")
        int getHeight();

        @CalledByNative("Buffer")
        int getWidth();

        @Override // org.tencwebrtc.RefCounted
        @CalledByNative("Buffer")
        void release();

        @Override // org.tencwebrtc.RefCounted
        @CalledByNative("Buffer")
        void retain();

        @CalledByNative("Buffer")
        I420Buffer toI420();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface I420Buffer extends Buffer {
        @CalledByNative("I420Buffer")
        ByteBuffer getDataU();

        @CalledByNative("I420Buffer")
        ByteBuffer getDataV();

        @CalledByNative("I420Buffer")
        ByteBuffer getDataY();

        @CalledByNative("I420Buffer")
        int getStrideU();

        @CalledByNative("I420Buffer")
        int getStrideV();

        @CalledByNative("I420Buffer")
        int getStrideY();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface TextureBuffer extends Buffer {

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public enum Type {
            OES(36197),
            RGB(GLSLRender.GL_TEXTURE_2D);

            private final int glTarget;

            Type(int i3) {
                this.glTarget = i3;
            }

            public int getGlTarget() {
                return this.glTarget;
            }
        }

        int getTextureId();

        Matrix getTransformMatrix();

        Type getType();
    }

    @CalledByNative
    public VideoFrame(Buffer buffer, int i3, long j3) {
        if (buffer != null) {
            if (i3 % 90 == 0) {
                this.buffer = buffer;
                this.rotation = i3;
                this.timestampNs = j3;
                return;
            }
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        throw new IllegalArgumentException("buffer not allowed to be null");
    }

    @CalledByNative
    public Buffer getBuffer() {
        return this.buffer;
    }

    @CalledByNative
    public boolean getIsKeyFrame() {
        return this.isKeyFrame;
    }

    @CalledByNative
    @Nullable
    public byte[] getLatencyTimestamp() {
        return this.latencyTimestamp;
    }

    public int getRotatedHeight() {
        if (this.rotation % 180 == 0) {
            return this.buffer.getHeight();
        }
        return this.buffer.getWidth();
    }

    public int getRotatedWidth() {
        if (this.rotation % 180 == 0) {
            return this.buffer.getWidth();
        }
        return this.buffer.getHeight();
    }

    @CalledByNative
    public int getRotation() {
        return this.rotation;
    }

    @CalledByNative
    public int getSize() {
        return this.bsSize;
    }

    @CalledByNative
    public long getTimestampNs() {
        return this.timestampNs;
    }

    @Override // org.tencwebrtc.RefCounted
    @CalledByNative
    public void release() {
        this.buffer.release();
    }

    @Override // org.tencwebrtc.RefCounted
    public void retain() {
        this.buffer.retain();
    }

    @CalledByNative
    public void setIsKeyFrame(boolean z16) {
        this.isKeyFrame = z16;
    }

    @CalledByNative
    public void setLatencyTimestamp(byte[] bArr) {
        if (bArr != null) {
            this.latencyTimestamp = Arrays.copyOf(bArr, bArr.length);
        } else {
            this.latencyTimestamp = null;
        }
    }

    @CalledByNative
    public void setSize(int i3) {
        this.bsSize = i3;
    }
}
