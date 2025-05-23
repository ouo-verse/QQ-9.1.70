package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class JpegOptions {
    static IPatchRedirector $redirector_;
    static final JpegOptions DEFAULT;
    public Bitmap inBitmap;
    public boolean inDither;
    public boolean inJustDecodeBounds;
    public boolean inPreferQualityOverSpeed;
    public Bitmap.Config inPreferredConfig;
    public int inSampleSize;
    public int outHeight;
    public int outWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEFAULT = new JpegOptions();
        }
    }

    public JpegOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.inBitmap = null;
        this.inJustDecodeBounds = false;
        this.inSampleSize = 1;
        this.inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.inPreferQualityOverSpeed = true;
        this.outWidth = 0;
        this.outHeight = 0;
        this.inDither = false;
    }
}
