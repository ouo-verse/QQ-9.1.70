package org.tencwebrtc;

import org.tencwebrtc.VideoDecoder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoDecoderFallback extends WrappedNativeVideoDecoder {
    private final VideoDecoder fallback;
    private final VideoDecoder primary;

    public VideoDecoderFallback(VideoDecoder videoDecoder, VideoDecoder videoDecoder2) {
        this.fallback = videoDecoder;
        this.primary = videoDecoder2;
    }

    private static native long nativeCreateDecoder(VideoDecoder videoDecoder, VideoDecoder videoDecoder2);

    @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
    public long createNativeVideoDecoder() {
        return nativeCreateDecoder(this.fallback, this.primary);
    }

    @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
    public /* bridge */ /* synthetic */ VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        return super.decode(encodedImage, decodeInfo);
    }

    @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
    public /* bridge */ /* synthetic */ String getImplementationName() {
        return super.getImplementationName();
    }

    @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
    public /* bridge */ /* synthetic */ boolean getPrefersLateDecoding() {
        return super.getPrefersLateDecoding();
    }

    @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
    public /* bridge */ /* synthetic */ VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        return super.initDecode(settings, callback);
    }

    @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
    public /* bridge */ /* synthetic */ VideoCodecStatus release() {
        return super.release();
    }
}
