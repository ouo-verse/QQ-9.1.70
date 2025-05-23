package org.tencwebrtc;

import org.tencwebrtc.VideoDecoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoDecoderWrapper {
    VideoDecoderWrapper() {
    }

    @CalledByNative
    static VideoDecoder.Callback createDecoderCallback(final long j3) {
        return new VideoDecoder.Callback() { // from class: org.tencwebrtc.af
            @Override // org.tencwebrtc.VideoDecoder.Callback
            public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
                VideoDecoderWrapper.nativeOnDecodedFrame(j3, videoFrame, num, num2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnDecodedFrame(long j3, VideoFrame videoFrame, Integer num, Integer num2);
}
