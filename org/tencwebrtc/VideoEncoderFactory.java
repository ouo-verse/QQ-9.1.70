package org.tencwebrtc;

import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface VideoEncoderFactory {
    @CalledByNative
    @Nullable
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
