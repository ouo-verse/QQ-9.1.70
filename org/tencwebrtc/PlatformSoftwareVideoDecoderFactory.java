package org.tencwebrtc;

import android.media.MediaCodecInfo;
import android.support.annotation.Nullable;
import java.util.Arrays;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.Predicate;

/* loaded from: classes29.dex */
public class PlatformSoftwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new Predicate<MediaCodecInfo>() { // from class: org.tencwebrtc.PlatformSoftwareVideoDecoderFactory.1
        private String[] prefixWhitelist;

        {
            String[] strArr = MediaCodecUtils.SOFTWARE_IMPLEMENTATION_PREFIXES;
            this.prefixWhitelist = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        @Override // org.tencwebrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> and(Predicate<? super MediaCodecInfo> predicate) {
            return Predicate.CC.a(this, predicate);
        }

        @Override // org.tencwebrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> negate() {
            return Predicate.CC.b(this);
        }

        @Override // org.tencwebrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> or(Predicate<? super MediaCodecInfo> predicate) {
            return Predicate.CC.c(this, predicate);
        }

        @Override // org.tencwebrtc.Predicate
        public boolean test(MediaCodecInfo mediaCodecInfo) {
            String name = mediaCodecInfo.getName();
            for (String str : this.prefixWhitelist) {
                if (name.startsWith(str)) {
                    return true;
                }
            }
            return false;
        }
    };

    public PlatformSoftwareVideoDecoderFactory(@Nullable EglBase.Context context) {
        super(context, defaultAllowedPredicate);
    }

    @Override // org.tencwebrtc.MediaCodecVideoDecoderFactory, org.tencwebrtc.VideoDecoderFactory
    @Nullable
    public /* bridge */ /* synthetic */ VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return super.createDecoder(videoCodecInfo);
    }

    @Override // org.tencwebrtc.MediaCodecVideoDecoderFactory, org.tencwebrtc.VideoDecoderFactory
    public /* bridge */ /* synthetic */ VideoCodecInfo[] getSupportedCodecs() {
        return super.getSupportedCodecs();
    }
}
