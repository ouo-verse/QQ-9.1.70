package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes17.dex */
class TRTCMusicAccompany$1 extends TimerTask {
    static IPatchRedirector $redirector_;
    final /* synthetic */ j this$0;

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            j.e(null, j.d(null));
        }
    }
}
