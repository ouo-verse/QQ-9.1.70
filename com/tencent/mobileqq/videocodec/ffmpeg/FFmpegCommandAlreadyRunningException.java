package com.tencent.mobileqq.videocodec.ffmpeg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FFmpegCommandAlreadyRunningException extends Exception {
    static IPatchRedirector $redirector_;

    public FFmpegCommandAlreadyRunningException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}
