package com.tencent.tmediacodec.codec;

import android.media.MediaCodec;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.util.TUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class VideoCodecWrapper extends ReuseCodecWrapper {
    static IPatchRedirector $redirector_;

    public VideoCodecWrapper(@NonNull MediaCodec mediaCodec, @NonNull FormatWrapper formatWrapper) {
        super(mediaCodec, formatWrapper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mediaCodec, (Object) formatWrapper);
        }
    }

    @Override // com.tencent.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper formatWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ReuseHelper.ReuseType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) formatWrapper);
        }
        if (ReuseHelper.isSeamlessAdaptationSupported(this, formatWrapper)) {
            int i3 = formatWrapper.width;
            CodecMaxValues codecMaxValues = this.codecMaxValues;
            if (i3 <= codecMaxValues.width && formatWrapper.height <= codecMaxValues.height && TUtils.getMaxInputSize(this, formatWrapper) <= this.codecMaxValues.inputSize) {
                if (formatWrapper.initializationDataEquals(this.format)) {
                    return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
                }
                return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;
            }
        }
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.tmediacodec.codec.ReuseCodecWrapper
    public boolean isNeedKeep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (super.isNeedKeep() && this.mSurface != null && this.format.rotationDegrees == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "VideoCodecWrapper[" + hashCode() + ']';
    }
}
