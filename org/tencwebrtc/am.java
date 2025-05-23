package org.tencwebrtc;

import android.support.annotation.Nullable;
import org.tencwebrtc.VideoProcessor;

/* compiled from: P */
/* loaded from: classes29.dex */
public final /* synthetic */ class am {
    public static void a(VideoProcessor videoProcessor, VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        VideoFrame b16 = b(videoFrame, frameAdaptationParameters);
        if (b16 != null) {
            videoProcessor.onFrameCaptured(b16);
            b16.release();
        }
    }

    @Nullable
    public static VideoFrame b(VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        if (frameAdaptationParameters.drop) {
            return null;
        }
        VideoFrame videoFrame2 = new VideoFrame(videoFrame.getBuffer().cropAndScale(frameAdaptationParameters.cropX, frameAdaptationParameters.cropY, frameAdaptationParameters.cropWidth, frameAdaptationParameters.cropHeight, frameAdaptationParameters.scaleWidth, frameAdaptationParameters.scaleHeight), videoFrame.getRotation(), frameAdaptationParameters.timestampNs);
        videoFrame2.setIsKeyFrame(videoFrame.getIsKeyFrame());
        videoFrame2.setSize(videoFrame.getSize());
        return videoFrame2;
    }
}
