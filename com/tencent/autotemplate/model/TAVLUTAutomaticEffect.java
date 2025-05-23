package com.tencent.autotemplate.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.autotemplate.model.rhythm.TAVMovieFilterProxyWithTimeRange;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavmovie.filter.TAVMovieFilterProxy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVLUTAutomaticEffect extends TAVEffectAutomaticEffect {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TAVLUTAutomaticEffect";

    public TAVLUTAutomaticEffect(@NonNull String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public TAVMovieFilterProxy convertToMovieFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TAVMovieFilterProxy) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (!isAvailable()) {
            return null;
        }
        String fullPath = getFullPath();
        if (!TextUtils.isEmpty(fullPath)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(fullPath);
            if (decodeFile != null) {
                return new TAVMovieFilterProxy(0, decodeFile);
            }
            Logger.e(TAG, "this lut effect's bitmap is null.");
        } else {
            Logger.e(TAG, "this lut effect's filterPath is null.");
        }
        return null;
    }

    public TAVMovieFilterProxyWithTimeRange covertToMovieFilterWithDuraton(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TAVMovieFilterProxyWithTimeRange) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        }
        if (!isAvailable()) {
            return null;
        }
        CMTimeRange lutTimeRange = getLutTimeRange(f16);
        String fullPath = getFullPath();
        if (!TextUtils.isEmpty(fullPath)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(fullPath);
            if (decodeFile != null) {
                TAVMovieFilterProxyWithTimeRange tAVMovieFilterProxyWithTimeRange = new TAVMovieFilterProxyWithTimeRange(0, decodeFile);
                tAVMovieFilterProxyWithTimeRange.setTimeRange(lutTimeRange);
                return tAVMovieFilterProxyWithTimeRange;
            }
            Logger.e(TAG, "this lut effect's bitmap is null.");
        } else {
            Logger.e(TAG, "this lut effect's filterPath is null.");
        }
        return null;
    }

    public CMTimeRange getLutTimeRange(float f16) {
        float f17;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CMTimeRange) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        }
        long j16 = this.startOffset;
        if (j16 > -1 && this.endOffset == -1) {
            j3 = this.duration;
            if (j3 <= 0) {
                f17 = (float) j16;
                j3 = f16 - f17;
            }
            return new CMTimeRange(new CMTime(j16, 1000), new CMTime(j3, 1000));
        }
        if (j16 == -1) {
            long j17 = this.endOffset;
            if (j17 > -1) {
                j3 = this.duration;
                if (j3 > 0) {
                    j16 = (f16 - ((float) j17)) - ((float) j3);
                } else {
                    j3 = f16 - ((float) j17);
                    j16 = 0;
                }
                return new CMTimeRange(new CMTime(j16, 1000), new CMTime(j3, 1000));
            }
        }
        f16 -= (float) j16;
        f17 = (float) this.endOffset;
        j3 = f16 - f17;
        return new CMTimeRange(new CMTime(j16, 1000), new CMTime(j3, 1000));
    }
}
