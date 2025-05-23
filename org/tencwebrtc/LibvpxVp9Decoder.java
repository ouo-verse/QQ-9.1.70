package org.tencwebrtc;

import org.tencwebrtc.VideoDecoder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LibvpxVp9Decoder extends WrappedNativeVideoDecoder {
    static native long nativeCreateDecoder();

    static native boolean nativeIsSupported();

    @Override // org.tencwebrtc.WrappedNativeVideoDecoder, org.tencwebrtc.VideoDecoder
    public long createNativeVideoDecoder() {
        return nativeCreateDecoder();
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
