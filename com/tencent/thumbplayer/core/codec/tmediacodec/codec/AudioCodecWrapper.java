package com.tencent.thumbplayer.core.codec.tmediacodec.codec;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReuseHelper;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class AudioCodecWrapper extends ReuseCodecWrapper {
    public AudioCodecWrapper(@NonNull MediaCodec mediaCodec, @NonNull FormatWrapper formatWrapper) {
        super(mediaCodec, formatWrapper);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper formatWrapper) {
        if (ReuseHelper.isSeamlessAdaptationSupported(this, formatWrapper)) {
            return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
        }
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public String toString() {
        return "AudioCodecWrapper[" + hashCode() + ']';
    }
}
