package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SoftwareVideoDecoderFactory implements VideoDecoderFactory {
    static VideoCodecInfo[] supportedCodecs() {
        ArrayList arrayList = new ArrayList();
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return null;
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        return supportedCodecs();
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    @Nullable
    @Deprecated
    public VideoDecoder createDecoder(String str) {
        return createDecoder(new VideoCodecInfo(str, new HashMap()));
    }
}
