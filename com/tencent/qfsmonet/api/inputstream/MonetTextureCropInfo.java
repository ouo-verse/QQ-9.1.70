package com.tencent.qfsmonet.api.inputstream;

import androidx.annotation.IntRange;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetTextureCropInfo {
    static IPatchRedirector $redirector_;

    @IntRange(from = 0)
    private int mCropBottom;

    @IntRange(from = 0)
    private int mCropLeft;

    @IntRange(from = 0)
    private int mCropRight;

    @IntRange(from = 0)
    private int mCropTop;

    public MonetTextureCropInfo(@IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.mCropLeft = i3;
        this.mCropRight = i16;
        this.mCropTop = i17;
        this.mCropBottom = i18;
    }

    public int cropBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mCropBottom;
    }

    public int cropLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mCropLeft;
    }

    public int cropRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mCropRight;
    }

    public int cropTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mCropTop;
    }
}
