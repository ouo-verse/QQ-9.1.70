package com.tencent.mobileqq.haoliyou.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UriQueryFileInfo {
    static IPatchRedirector $redirector_;
    public final long lastModified;
    public final String name;
    public final long size;

    public UriQueryFileInfo(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.name = str;
        this.size = j3;
        this.lastModified = j16;
    }
}
