package com.tencent.mobileqq.profilecard.bussiness.stickynote;

import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class StickyNoteInfo implements IProfileBusinessInfo {
    static IPatchRedirector $redirector_;
    public int stickyNoteCount;

    public StickyNoteInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
