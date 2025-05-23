package org.tencwebrtc;

import org.tencwebrtc.VideoEncoder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoEncoderFallback extends WrappedNativeVideoEncoder {
    private final VideoEncoder fallback;
    private final VideoEncoder primary;

    public VideoEncoderFallback(VideoEncoder videoEncoder, VideoEncoder videoEncoder2) {
        this.fallback = videoEncoder;
        this.primary = videoEncoder2;
    }

    private static native long nativeCreateEncoder(VideoEncoder videoEncoder, VideoEncoder videoEncoder2);

    @Override // org.tencwebrtc.WrappedNativeVideoEncoder, org.tencwebrtc.VideoEncoder
    public long createNativeVideoEncoder() {
        return nativeCreateEncoder(this.fallback, this.primary);
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
        return this.primary.isHardwareEncoder();
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
