package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class JpegCompressOptions {
    static IPatchRedirector $redirector_;
    static final JpegCompressOptions DEFAULT;
    public int CompressQuality;
    public boolean isArithCode;
    public boolean isOptimize;
    public boolean isPreferQualityOverSpeed;
    public boolean isProgress;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEFAULT = new JpegCompressOptions();
        }
    }

    public JpegCompressOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.CompressQuality = 80;
        this.isOptimize = false;
        this.isProgress = true;
        this.isArithCode = false;
        this.isPreferQualityOverSpeed = false;
    }
}
