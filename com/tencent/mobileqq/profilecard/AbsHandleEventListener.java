package com.tencent.mobileqq.profilecard;

import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class AbsHandleEventListener {
    static IPatchRedirector $redirector_;

    public AbsHandleEventListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract boolean handleEvent(MotionEvent motionEvent);
}
