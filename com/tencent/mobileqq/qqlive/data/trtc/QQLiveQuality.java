package com.tencent.mobileqq.qqlive.data.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveQuality {
    static IPatchRedirector $redirector_ = null;
    public static final int TRTC_QUALITY_BAD = 4;
    public static final int TRTC_QUALITY_DOWN = 6;
    public static final int TRTC_QUALITY_EXCELLENT = 1;
    public static final int TRTC_QUALITY_GOOD = 2;
    public static final int TRTC_QUALITY_POOR = 3;
    public static final int TRTC_QUALITY_UNKNOWN = 0;
    public static final int TRTC_QUALITY_VBAD = 5;
    public int quality;
    public String userId;

    public QQLiveQuality(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.userId = str;
            this.quality = i3;
        }
    }
}
