package com.tencent.msdk.dns.base.jni;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class Jni {
    static IPatchRedirector $redirector_;

    public Jni() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native byte[] aesCrypt(byte[] bArr, String str, int i3, byte[] bArr2);

    public static native byte[] desCrypt(byte[] bArr, String str, int i3);

    public static native int getNetworkStack();

    public static native int sendToUnity(String str);
}
