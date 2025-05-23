package com.tencent.trackrecordlib.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.enums.EventTopic;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a extends b {
    static IPatchRedirector $redirector_;

    public a(EventTopic eventTopic) {
        super(eventTopic);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eventTopic);
        }
    }
}
