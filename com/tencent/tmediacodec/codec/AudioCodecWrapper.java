package com.tencent.tmediacodec.codec;

import android.media.MediaCodec;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmediacodec.reuse.ReuseHelper;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class AudioCodecWrapper extends ReuseCodecWrapper {
    static IPatchRedirector $redirector_;

    public AudioCodecWrapper(@NonNull MediaCodec mediaCodec, @NonNull FormatWrapper formatWrapper) {
        super(mediaCodec, formatWrapper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mediaCodec, (Object) formatWrapper);
        }
    }

    @Override // com.tencent.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper formatWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ReuseHelper.ReuseType) iPatchRedirector.redirect((short) 1, (Object) this, (Object) formatWrapper);
        }
        if (ReuseHelper.isSeamlessAdaptationSupported(this, formatWrapper)) {
            return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
        }
        return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.tmediacodec.codec.ReuseCodecWrapper
    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AudioCodecWrapper[" + hashCode() + ']';
    }
}
