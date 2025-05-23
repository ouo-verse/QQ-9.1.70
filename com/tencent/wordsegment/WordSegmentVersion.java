package com.tencent.wordsegment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
class WordSegmentVersion {
    static IPatchRedirector $redirector_ = null;
    public static final int WORDSEGMENT_BUILD_NO = 267650122;
    public static final long WORDSEGMENT_SO_CRC32_ARM64 = 1825769640;
    public static final long WORDSEGMENT_SO_CRC32_ARMV7 = 2769534433L;
    public static final int WORDSEGMENT_SO_SIZE_ARM64 = 148856;
    public static final int WORDSEGMENT_SO_SIZE_ARMV7 = 100496;

    WordSegmentVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
