package org.tencwebrtc;

import org.tencwebrtc.VideoFrame;
import org.tencwebrtc.VideoProcessor;

/* compiled from: P */
/* loaded from: classes29.dex */
class NativeCapturerObserver implements CapturerObserver {
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;

    @CalledByNative
    public NativeCapturerObserver(long j3) {
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j3);
    }

    @Override // org.tencwebrtc.CapturerObserver
    public void onCapturerStarted(boolean z16) {
        this.nativeAndroidVideoTrackSource.setState(z16);
    }

    @Override // org.tencwebrtc.CapturerObserver
    public void onCapturerStopped() {
        this.nativeAndroidVideoTrackSource.setState(false);
    }

    @Override // org.tencwebrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        VideoProcessor.FrameAdaptationParameters adaptFrame = this.nativeAndroidVideoTrackSource.adaptFrame(videoFrame);
        if (adaptFrame == null) {
            return;
        }
        VideoFrame.Buffer cropAndScale = videoFrame.getBuffer().cropAndScale(adaptFrame.cropX, adaptFrame.cropY, adaptFrame.cropWidth, adaptFrame.cropHeight, adaptFrame.scaleWidth, adaptFrame.scaleHeight);
        this.nativeAndroidVideoTrackSource.onFrameCaptured(new VideoFrame(cropAndScale, videoFrame.getRotation(), adaptFrame.timestampNs));
        cropAndScale.release();
    }
}
