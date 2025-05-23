package com.tencent.thumbplayer.core.codec.tmediacodec.codec;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.codec.tmediacodec.reuse.ReuseHelper;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.TUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class VideoCodecWrapper extends ReuseCodecWrapper {
    public VideoCodecWrapper(@NonNull MediaCodec mediaCodec, @NonNull FormatWrapper formatWrapper) {
        super(mediaCodec, formatWrapper);
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper formatWrapper) {
        if (ReuseHelper.isSeamlessAdaptationSupported(this, formatWrapper)) {
            int i3 = formatWrapper.width;
            CodecMaxValues codecMaxValues = this.mCodecMaxValues;
            if (i3 <= codecMaxValues.width && formatWrapper.height <= codecMaxValues.height && TUtils.getMaxInputSize(this, formatWrapper) <= this.mCodecMaxValues.inputSize) {
                if (formatWrapper.initializationDataEquals(this.mFormat)) {
                    return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
                }
                return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;
            }
        }
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper
    public boolean isNeedKeep() {
        if (super.isNeedKeep() && this.mSurface != null && this.mFormat.rotationDegrees == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public String toString() {
        return "VideoCodecWrapper[" + hashCode() + ']';
    }
}
