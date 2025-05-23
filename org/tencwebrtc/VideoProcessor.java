package org.tencwebrtc;

import android.support.annotation.Nullable;

/* loaded from: classes29.dex */
public interface VideoProcessor extends CapturerObserver {

    /* loaded from: classes29.dex */
    public static class FrameAdaptationParameters {
        public final int cropHeight;
        public final int cropWidth;
        public final int cropX;
        public final int cropY;
        public final boolean drop;
        public final int scaleHeight;
        public final int scaleWidth;
        public final long timestampNs;

        public FrameAdaptationParameters(int i3, int i16, int i17, int i18, int i19, int i26, long j3, boolean z16) {
            this.cropX = i3;
            this.cropY = i16;
            this.cropWidth = i17;
            this.cropHeight = i18;
            this.scaleWidth = i19;
            this.scaleHeight = i26;
            this.timestampNs = j3;
            this.drop = z16;
        }
    }

    void onFrameCaptured(VideoFrame videoFrame, FrameAdaptationParameters frameAdaptationParameters);

    void setSink(@Nullable VideoSink videoSink);
}
