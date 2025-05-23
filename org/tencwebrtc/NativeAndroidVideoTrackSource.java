package org.tencwebrtc;

import android.support.annotation.Nullable;
import org.tencwebrtc.VideoFrame;
import org.tencwebrtc.VideoProcessor;
import org.tencwebrtc.VideoSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class NativeAndroidVideoTrackSource {
    private final long nativeAndroidVideoTrackSource;

    public NativeAndroidVideoTrackSource(long j3) {
        this.nativeAndroidVideoTrackSource = j3;
    }

    @CalledByNative
    static VideoProcessor.FrameAdaptationParameters createFrameAdaptationParameters(int i3, int i16, int i17, int i18, int i19, int i26, long j3, boolean z16) {
        return new VideoProcessor.FrameAdaptationParameters(i3, i16, i17, i18, i19, i26, j3, z16);
    }

    @Nullable
    private static native VideoProcessor.FrameAdaptationParameters nativeAdaptFrame(long j3, int i3, int i16, int i17, long j16);

    private static native void nativeAdaptOutputFormat(long j3, int i3, int i16, @Nullable Integer num, int i17, int i18, @Nullable Integer num2, @Nullable Integer num3);

    private static native void nativeOnFrameCaptured(long j3, int i3, long j16, boolean z16, int i16, VideoFrame.Buffer buffer);

    private static native void nativeSetState(long j3, boolean z16);

    @Nullable
    public VideoProcessor.FrameAdaptationParameters adaptFrame(VideoFrame videoFrame) {
        return nativeAdaptFrame(this.nativeAndroidVideoTrackSource, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs());
    }

    public void adaptOutputFormat(VideoSource.AspectRatio aspectRatio, @Nullable Integer num, VideoSource.AspectRatio aspectRatio2, @Nullable Integer num2, @Nullable Integer num3) {
        nativeAdaptOutputFormat(this.nativeAndroidVideoTrackSource, aspectRatio.width, aspectRatio.height, num, aspectRatio2.width, aspectRatio2.height, num2, num3);
    }

    public void onFrameCaptured(VideoFrame videoFrame) {
        nativeOnFrameCaptured(this.nativeAndroidVideoTrackSource, videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getIsKeyFrame(), videoFrame.getSize(), videoFrame.getBuffer());
    }

    public void setState(boolean z16) {
        nativeSetState(this.nativeAndroidVideoTrackSource, z16);
    }
}
