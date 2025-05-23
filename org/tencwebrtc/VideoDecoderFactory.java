package org.tencwebrtc;

import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface VideoDecoderFactory {
    @Nullable
    @Deprecated
    VideoDecoder createDecoder(String str);

    @CalledByNative
    @Nullable
    VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
