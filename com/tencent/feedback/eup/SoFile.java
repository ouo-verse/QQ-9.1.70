package com.tencent.feedback.eup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SoFile {
    static IPatchRedirector $redirector_;
    public final String arch;
    public final String fileName;
    public final String sha1;

    public SoFile(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        if (str != null && str2 != null && str3 != null) {
            this.fileName = str;
            this.arch = str2;
            this.sha1 = str3;
            return;
        }
        throw new RuntimeException("SoFile args should not be null!");
    }
}
