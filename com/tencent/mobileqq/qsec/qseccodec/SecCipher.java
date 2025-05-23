package com.tencent.mobileqq.qsec.qseccodec;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SecCipher {
    static IPatchRedirector $redirector_ = null;
    private static final int SEC_INFO_TYPE_DECODE = 1;
    private static final int SEC_INFO_TYPE_ENCODE = 2;
    private static final String sVersion = "0.0.3";

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class SecInfo {
        static IPatchRedirector $redirector_;
        public int err;
        public Object result;
        public int ver;

        public SecInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SecCipher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private native Object codec(Object obj, int i3);

    public SecInfo decrypt(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SecInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        try {
            return (SecInfo) codec(str, 1);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public SecInfo encrypt(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SecInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        try {
            return (SecInfo) codec(str, 2);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return sVersion;
    }
}
