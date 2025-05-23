package org.tencwebrtc;

import org.tencwebrtc.VideoEncoder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LibvpxVp9Encoder extends WrappedNativeVideoEncoder {
    static native long nativeCreateEncoder();

    static native boolean nativeIsSupported();

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public long createNativeVideoEncoder() {
        return nativeCreateEncoder();
    }

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus encode(VideoFrame videoFrame, VideoEncoder.EncodeInfo encodeInfo) {
        return super.encode(videoFrame, encodeInfo);
    }

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public /* bridge */ /* synthetic */ String getImplementationName() {
        return super.getImplementationName();
    }

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoEncoder.ScalingSettings getScalingSettings() {
        return super.getScalingSettings();
    }

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        return super.initEncode(settings, callback);
    }

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus release() {
        return super.release();
    }

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public /* bridge */ /* synthetic */ VideoCodecStatus setRateAllocation(VideoEncoder.BitrateAllocation bitrateAllocation, int i3) {
        return super.setRateAllocation(bitrateAllocation, i3);
    }
}
