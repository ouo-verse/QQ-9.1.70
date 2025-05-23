package org.tencwebrtc;

import org.tencwebrtc.VideoDecoder;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class WrappedNativeVideoDecoder implements VideoDecoder {
    @Override // org.tencwebrtc.VideoDecoder
    public abstract long createNativeVideoDecoder();

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoDecoder
    public String getImplementationName() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus release() {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
