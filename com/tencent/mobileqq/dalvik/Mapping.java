package com.tencent.mobileqq.dalvik;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Mapping {
    static IPatchRedirector $redirector_;
    public final long beginAddr;
    public final long endAddr;
    public final String pathName;
    public final boolean readable;
    public final boolean useless;
    public final boolean writable;

    public Mapping(long j3, long j16, boolean z16, boolean z17, boolean z18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str);
            return;
        }
        this.beginAddr = j3;
        this.endAddr = j16;
        this.readable = z16;
        this.writable = z17;
        this.useless = z18;
        this.pathName = str;
    }
}
