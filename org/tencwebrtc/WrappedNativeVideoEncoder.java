package org.tencwebrtc;

import org.tencwebrtc.VideoEncoder;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class WrappedNativeVideoEncoder implements VideoEncoder {
    @Override // org.tencwebrtc.VideoEncoder
    public abstract long createNativeVideoEncoder();

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoEncoder
    public String getImplementationName() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoEncoder.ScalingSettings getScalingSettings() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoEncoder
    public abstract boolean isHardwareEncoder();

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus release() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    @Override // org.tencwebrtc.VideoEncoder
    public VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i3) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
