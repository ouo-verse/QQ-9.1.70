package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.instanceof, reason: invalid class name */
/* loaded from: classes26.dex */
public class Cinstanceof {
    static IPatchRedirector $redirector_;
    public final byte[] data;
    public final int errCode;

    public Cinstanceof(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
        } else {
            this.errCode = (i3 > 0 || i3 < -9999) ? -1 : i3;
            this.data = bArr;
        }
    }
}
