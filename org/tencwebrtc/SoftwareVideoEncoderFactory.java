package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SoftwareVideoEncoderFactory implements VideoEncoderFactory {
    static VideoCodecInfo[] supportedCodecs() {
        ArrayList arrayList = new ArrayList();
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        return null;
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        return supportedCodecs();
    }
}
