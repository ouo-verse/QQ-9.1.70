package org.tencwebrtc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EncodedImage {
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final boolean completeFrame;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;

    /* renamed from: qp, reason: collision with root package name */
    public final Integer f423843qp;
    public int recvToDecodeMs;
    public final int rotation;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private ByteBuffer buffer;
        private long captureTimeNs;
        private boolean completeFrame;
        private int encodedHeight;
        private int encodedWidth;
        private FrameType frameType;

        /* renamed from: qp, reason: collision with root package name */
        private Integer f423844qp;
        private int rotation;

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.f423844qp);
        }

        public Builder setBuffer(ByteBuffer byteBuffer) {
            this.buffer = byteBuffer;
            return this;
        }

        @Deprecated
        public Builder setCaptureTimeMs(long j3) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j3);
            return this;
        }

        public Builder setCaptureTimeNs(long j3) {
            this.captureTimeNs = j3;
            return this;
        }

        public Builder setCompleteFrame(boolean z16) {
            this.completeFrame = z16;
            return this;
        }

        public Builder setEncodedHeight(int i3) {
            this.encodedHeight = i3;
            return this;
        }

        public Builder setEncodedWidth(int i3) {
            this.encodedWidth = i3;
            return this;
        }

        public Builder setFrameType(FrameType frameType) {
            this.frameType = frameType;
            return this;
        }

        public Builder setQp(Integer num) {
            this.f423844qp = num;
            return this;
        }

        public Builder setRotation(int i3) {
            this.rotation = i3;
            return this;
        }

        Builder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum FrameType {
        EmptyFrame(0),
        VideoFrameKey(3),
        VideoFrameDelta(4);

        private final int nativeIndex;

        FrameType(int i3) {
            this.nativeIndex = i3;
        }

        @CalledByNative("FrameType")
        static FrameType fromNativeIndex(int i3) {
            for (FrameType frameType : values()) {
                if (frameType.getNative() == i3) {
                    return frameType;
                }
            }
            throw new IllegalArgumentException("Unknown native frame type: " + i3);
        }

        public int getNative() {
            return this.nativeIndex;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @CalledByNative
    private void setRecvToDecodeTime(int i3) {
        this.recvToDecodeMs = i3;
    }

    @CalledByNative
    EncodedImage(ByteBuffer byteBuffer, int i3, int i16, long j3, FrameType frameType, int i17, boolean z16, Integer num) {
        this.buffer = byteBuffer;
        this.encodedWidth = i3;
        this.encodedHeight = i16;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(j3);
        this.captureTimeNs = j3;
        this.frameType = frameType;
        this.rotation = i17;
        this.completeFrame = z16;
        this.f423843qp = num;
    }
}
