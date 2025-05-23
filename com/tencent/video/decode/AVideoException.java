package com.tencent.video.decode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AVideoException extends RuntimeException {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = -3387516993124229948L;
    public int mErrCode;
    public int mErrSubcode;

    public AVideoException(int i3, int i16, String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        } else {
            this.mErrCode = i3;
            this.mErrSubcode = i16;
        }
    }
}
