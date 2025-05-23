package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Timeval {
    static IPatchRedirector $redirector_;
    public final long tvSec;
    public final int tvUsec;

    public Timeval(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.tvSec = j3;
            this.tvUsec = i3;
        }
    }
}
