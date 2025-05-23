package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.util.Objects;
import org.tencwebrtc.VideoProcessor;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoSource extends MediaSource {
    private final CapturerObserver capturerObserver;
    private boolean isCapturerRunning;
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;

    @Nullable
    private VideoProcessor videoProcessor;
    private final Object videoProcessorLock;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AspectRatio {
        public static final AspectRatio UNDEFINED = new AspectRatio(0, 0);
        public final int height;
        public final int width;

        public AspectRatio(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }
    }

    public VideoSource(long j3) {
        super(j3);
        this.videoProcessorLock = new Object();
        this.capturerObserver = new CapturerObserver() { // from class: org.tencwebrtc.VideoSource.1
            @Override // org.tencwebrtc.CapturerObserver
            public void onCapturerStarted(boolean z16) {
                VideoSource.this.nativeAndroidVideoTrackSource.setState(z16);
                synchronized (VideoSource.this.videoProcessorLock) {
                    VideoSource.this.isCapturerRunning = z16;
                    if (VideoSource.this.videoProcessor != null) {
                        VideoSource.this.videoProcessor.onCapturerStarted(z16);
                    }
                }
            }

            @Override // org.tencwebrtc.CapturerObserver
            public void onCapturerStopped() {
                VideoSource.this.nativeAndroidVideoTrackSource.setState(false);
                synchronized (VideoSource.this.videoProcessorLock) {
                    VideoSource.this.isCapturerRunning = false;
                    if (VideoSource.this.videoProcessor != null) {
                        VideoSource.this.videoProcessor.onCapturerStopped();
                    }
                }
            }

            @Override // org.tencwebrtc.CapturerObserver
            public void onFrameCaptured(VideoFrame videoFrame) {
                VideoProcessor.FrameAdaptationParameters adaptFrame = VideoSource.this.nativeAndroidVideoTrackSource.adaptFrame(videoFrame);
                synchronized (VideoSource.this.videoProcessorLock) {
                    if (VideoSource.this.videoProcessor != null) {
                        VideoSource.this.videoProcessor.onFrameCaptured(videoFrame, adaptFrame);
                        return;
                    }
                    VideoFrame b16 = am.b(videoFrame, adaptFrame);
                    if (b16 != null) {
                        VideoSource.this.nativeAndroidVideoTrackSource.onFrameCaptured(b16);
                        b16.release();
                    }
                }
            }
        };
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j3);
    }

    public void adaptOutputFormat(int i3, int i16, int i17) {
        int max = Math.max(i3, i16);
        int min = Math.min(i3, i16);
        adaptOutputFormat(max, min, min, max, i17);
    }

    @Override // org.tencwebrtc.MediaSource
    public void dispose() {
        setVideoProcessor(null);
        super.dispose();
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }

    public void setVideoProcessor(@Nullable VideoProcessor videoProcessor) {
        synchronized (this.videoProcessorLock) {
            VideoProcessor videoProcessor2 = this.videoProcessor;
            if (videoProcessor2 != null) {
                videoProcessor2.setSink(null);
                if (this.isCapturerRunning) {
                    this.videoProcessor.onCapturerStopped();
                }
            }
            this.videoProcessor = videoProcessor;
            if (videoProcessor != null) {
                final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource = this.nativeAndroidVideoTrackSource;
                Objects.requireNonNull(nativeAndroidVideoTrackSource);
                videoProcessor.setSink(new VideoSink() { // from class: org.tencwebrtc.an
                    @Override // org.tencwebrtc.VideoSink
                    public final void onFrame(VideoFrame videoFrame) {
                        NativeAndroidVideoTrackSource.this.onFrameCaptured(videoFrame);
                    }
                });
                if (this.isCapturerRunning) {
                    videoProcessor.onCapturerStarted(true);
                }
            }
        }
    }

    public void adaptOutputFormat(int i3, int i16, int i17, int i18, int i19) {
        adaptOutputFormat(new AspectRatio(i3, i16), Integer.valueOf(i3 * i16), new AspectRatio(i17, i18), Integer.valueOf(i17 * i18), Integer.valueOf(i19));
    }

    public void adaptOutputFormat(AspectRatio aspectRatio, @Nullable Integer num, AspectRatio aspectRatio2, @Nullable Integer num2, @Nullable Integer num3) {
        this.nativeAndroidVideoTrackSource.adaptOutputFormat(aspectRatio, num, aspectRatio2, num2, num3);
    }
}
