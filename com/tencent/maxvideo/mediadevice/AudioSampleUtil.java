package com.tencent.maxvideo.mediadevice;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AudioSampleUtil {
    static IPatchRedirector $redirector_;

    public AudioSampleUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int bytesInMillisecond(int i3, int i16, int i17) {
        return bytesInSecond(i3, i16, i17) / 1000;
    }

    public static int bytesInSecond(int i3, int i16, int i17) {
        int i18;
        int i19 = 2;
        if (i16 != 12) {
            i18 = 1;
        } else {
            i18 = 2;
        }
        if (i17 != 2) {
            i19 = 1;
        }
        return i3 * i19 * i18;
    }
}
