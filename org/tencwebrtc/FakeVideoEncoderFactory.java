package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.LinkedHashSet;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FakeVideoEncoderFactory implements VideoEncoderFactory {

    @Nullable
    private final VideoDecoderFactory defaultVideoDecoderFactory;

    public FakeVideoEncoderFactory(VideoDecoderFactory videoDecoderFactory) {
        this.defaultVideoDecoderFactory = videoDecoderFactory;
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        return null;
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        VideoDecoderFactory videoDecoderFactory = this.defaultVideoDecoderFactory;
        if (videoDecoderFactory != null) {
            linkedHashSet.addAll(Arrays.asList(videoDecoderFactory.getSupportedCodecs()));
        }
        return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
    }
}
