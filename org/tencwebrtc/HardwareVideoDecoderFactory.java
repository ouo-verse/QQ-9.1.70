package org.tencwebrtc;

import android.media.MediaCodecInfo;
import android.support.annotation.Nullable;
import java.util.Arrays;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.Predicate;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HardwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new Predicate<MediaCodecInfo>() { // from class: org.tencwebrtc.HardwareVideoDecoderFactory.1
        private String[] prefixBlacklist;

        {
            String[] strArr = MediaCodecUtils.SOFTWARE_IMPLEMENTATION_PREFIXES;
            this.prefixBlacklist = (String[]) Arrays.copyOf(strArr, strArr.length);
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
            for (String str : this.prefixBlacklist) {
                if (name.startsWith(str)) {
                    return false;
                }
            }
            return true;
        }
    };

    @Deprecated
    public HardwareVideoDecoderFactory() {
        this(null);
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

    public HardwareVideoDecoderFactory(@Nullable EglBase.Context context) {
        this(context, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HardwareVideoDecoderFactory(@Nullable EglBase.Context context, @Nullable Predicate<MediaCodecInfo> predicate) {
        super(context, r3);
        Predicate<MediaCodecInfo> and;
        if (predicate == null) {
            and = defaultAllowedPredicate;
        } else {
            and = predicate.and(defaultAllowedPredicate);
        }
    }
}
