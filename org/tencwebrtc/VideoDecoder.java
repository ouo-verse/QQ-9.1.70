package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface VideoDecoder {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Callback {
        void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface DecodeCallback {
        void onDecodeErrCodeReported(boolean z16, int i3, int i16, String str);

        void onFirstFrameDecoded();

        void onFrameResolutionChanged(int i3, int i16, int i17);

        void onOrientationChanged(int i3);

        void onPerfCb(byte[] bArr, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DecodeInfo {
        public final boolean isMissingFrames;
        public final long renderTimeMs;

        public DecodeInfo(boolean z16, long j3) {
            this.isMissingFrames = z16;
            this.renderTimeMs = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Settings {
        public final int height;
        public final int numberOfCores;
        public final int width;

        @CalledByNative("Settings")
        public Settings(int i3, int i16, int i17) {
            this.numberOfCores = i3;
            this.width = i16;
            this.height = i17;
        }
    }

    @CalledByNative
    long createNativeVideoDecoder();

    @CalledByNative
    VideoCodecStatus decode(EncodedImage encodedImage, DecodeInfo decodeInfo);

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    boolean getPrefersLateDecoding();

    @CalledByNative
    VideoCodecStatus initDecode(Settings settings, Callback callback);

    @CalledByNative
    VideoCodecStatus release();
}
