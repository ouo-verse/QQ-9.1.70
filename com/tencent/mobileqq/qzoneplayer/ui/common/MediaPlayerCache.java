package com.tencent.mobileqq.qzoneplayer.ui.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class MediaPlayerCache {
    static IPatchRedirector $redirector_;

    /* loaded from: classes16.dex */
    public static class CachedMediaPlayer {
        static IPatchRedirector $redirector_;

        public CachedMediaPlayer() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public MediaPlayerCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
