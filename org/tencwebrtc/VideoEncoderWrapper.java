package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.nio.ByteBuffer;
import org.tencwebrtc.VideoEncoder;

/* compiled from: P */
/* loaded from: classes29.dex */
class VideoEncoderWrapper {
    VideoEncoderWrapper() {
    }

    @CalledByNative
    static VideoEncoder.Callback createEncoderCallback(final long j3) {
        return new VideoEncoder.Callback() { // from class: org.tencwebrtc.ah
            @Override // org.tencwebrtc.VideoEncoder.Callback
            public final void onEncodedFrame(EncodedImage encodedImage, VideoEncoder.CodecSpecificInfo codecSpecificInfo) {
                VideoEncoderWrapper.lambda$createEncoderCallback$0(j3, encodedImage, codecSpecificInfo);
            }
        };
    }

    @CalledByNative
    @Nullable
    static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.high;
    }

    @CalledByNative
    @Nullable
    static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.low;
    }

    @CalledByNative
    static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.f423851on;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createEncoderCallback$0(long j3, EncodedImage encodedImage, VideoEncoder.CodecSpecificInfo codecSpecificInfo) {
        nativeOnEncodedFrame(j3, encodedImage.buffer, encodedImage.encodedWidth, encodedImage.encodedHeight, encodedImage.captureTimeNs, encodedImage.frameType.getNative(), encodedImage.rotation, encodedImage.completeFrame, encodedImage.f423843qp);
    }

    private static native void nativeOnEncodedFrame(long j3, ByteBuffer byteBuffer, int i3, int i16, long j16, int i17, int i18, boolean z16, Integer num);
}
