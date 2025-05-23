package org.tencwebrtc;

import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public final /* synthetic */ class ae {
    @Nullable
    @Deprecated
    public static VideoDecoder a(VideoDecoderFactory videoDecoderFactory, String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @CalledByNative
    @Nullable
    public static VideoDecoder b(VideoDecoderFactory videoDecoderFactory, VideoCodecInfo videoCodecInfo) {
        return videoDecoderFactory.createDecoder(videoCodecInfo.getName());
    }

    @CalledByNative
    public static VideoCodecInfo[] c(VideoDecoderFactory videoDecoderFactory) {
        return new VideoCodecInfo[0];
    }
}
