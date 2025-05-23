package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RequestFilter extends RequestAck {
    static IPatchRedirector $redirector_;

    public RequestFilter(String str, int i3, byte[] bArr, long j3, IRequestCallback iRequestCallback, byte[] bArr2, byte[] bArr3, int i16) {
        super(str, i3, bArr, j3, iRequestCallback, bArr2, bArr3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), bArr, Long.valueOf(j3), iRequestCallback, bArr2, bArr3, Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.RequestAck, com.tencent.mobileqq.highway.segment.HwRequest
    public void onError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f236838cb.onFailed(i3);
            this.isCancel.set(true);
        }
    }
}
