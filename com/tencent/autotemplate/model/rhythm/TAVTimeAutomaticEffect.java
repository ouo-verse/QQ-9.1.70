package com.tencent.autotemplate.model.rhythm;

import android.support.annotation.NonNull;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVTimeAutomaticEffect extends TAVEffectAutomaticEffect {
    static IPatchRedirector $redirector_;

    public TAVTimeAutomaticEffect(@NonNull String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TAVMovieTimeEffect convertToMovieTimeEffect(float f16) {
        long j3;
        float f17;
        TAVEffectParameter tAVEffectParameter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TAVMovieTimeEffect) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        }
        TAVMovieTimeEffect tAVMovieTimeEffect = new TAVMovieTimeEffect();
        long j16 = this.startOffset;
        long j17 = 0;
        if (j16 > -1 && this.endOffset == -1) {
            j3 = this.duration;
            if (j3 <= 0) {
                f17 = (float) j16;
                j3 = f16 - f17;
            }
            tAVEffectParameter = this.parameter;
            if (tAVEffectParameter != null) {
            }
            if (j16 >= 0) {
            }
            CMTimeRange cMTimeRange = new CMTimeRange(new CMTime(j17, 1000), new CMTime(j3, 1000));
            tAVMovieTimeEffect.setSourceTimeRange(cMTimeRange);
            tAVMovieTimeEffect.setTimeRange(cMTimeRange);
            tAVMovieTimeEffect.setSpeed(getSpeed());
            return tAVMovieTimeEffect;
        }
        if (j16 == -1) {
            long j18 = this.endOffset;
            if (j18 > -1) {
                j3 = this.duration;
                if (j3 > 0) {
                    j16 = (f16 - ((float) j18)) - ((float) j3);
                } else {
                    j3 = f16 - ((float) j18);
                    j16 = 0;
                }
                tAVEffectParameter = this.parameter;
                if (tAVEffectParameter != null) {
                    long j19 = tAVEffectParameter.rhythmOffset;
                    if (j19 > 0) {
                        j16 -= j19;
                    }
                }
                if (j16 >= 0) {
                    j17 = j16;
                }
                CMTimeRange cMTimeRange2 = new CMTimeRange(new CMTime(j17, 1000), new CMTime(j3, 1000));
                tAVMovieTimeEffect.setSourceTimeRange(cMTimeRange2);
                tAVMovieTimeEffect.setTimeRange(cMTimeRange2);
                tAVMovieTimeEffect.setSpeed(getSpeed());
                return tAVMovieTimeEffect;
            }
        }
        j3 = this.duration;
        if (j3 <= 0) {
            f16 -= (float) j16;
            f17 = (float) this.endOffset;
            j3 = f16 - f17;
        }
        tAVEffectParameter = this.parameter;
        if (tAVEffectParameter != null) {
        }
        if (j16 >= 0) {
        }
        CMTimeRange cMTimeRange22 = new CMTimeRange(new CMTime(j17, 1000), new CMTime(j3, 1000));
        tAVMovieTimeEffect.setSourceTimeRange(cMTimeRange22);
        tAVMovieTimeEffect.setTimeRange(cMTimeRange22);
        tAVMovieTimeEffect.setSpeed(getSpeed());
        return tAVMovieTimeEffect;
    }
}
