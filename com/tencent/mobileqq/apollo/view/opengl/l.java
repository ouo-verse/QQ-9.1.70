package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l extends b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l(int i3, boolean z16) {
        super(i3, 8, 8, 8, 0, r6, 0);
        int i16;
        if (z16) {
            i16 = 16;
        } else {
            i16 = 0;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }
}
