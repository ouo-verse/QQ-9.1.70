package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import org.tencwebrtc.EglBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DefaultVideoEncoderFactory implements VideoEncoderFactory {
    private final VideoEncoderFactory hardwareVideoEncoderFactory;
    private final VideoEncoderFactory softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();

    public DefaultVideoEncoderFactory(EglBase.Context context, boolean z16, boolean z17) {
        this.hardwareVideoEncoderFactory = new HardwareVideoEncoderFactory(context, z16, z17);
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    @Nullable
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        VideoEncoder createEncoder = this.softwareVideoEncoderFactory.createEncoder(videoCodecInfo);
        VideoEncoder createEncoder2 = this.hardwareVideoEncoderFactory.createEncoder(videoCodecInfo);
        if (createEncoder2 != null && createEncoder != null) {
            return new VideoEncoderFallback(createEncoder, createEncoder2);
        }
        if (createEncoder2 != null) {
            return createEncoder2;
        }
        return createEncoder;
    }

    @Override // org.tencwebrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(Arrays.asList(this.hardwareVideoEncoderFactory.getSupportedCodecs()));
        return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultVideoEncoderFactory(VideoEncoderFactory videoEncoderFactory) {
        this.hardwareVideoEncoderFactory = videoEncoderFactory;
    }
}
