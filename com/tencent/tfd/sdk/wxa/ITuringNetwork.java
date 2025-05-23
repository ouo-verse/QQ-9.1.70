package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITuringNetwork {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Resp extends Cinstanceof {
        static IPatchRedirector $redirector_;

        public Resp(int i3, byte[] bArr) {
            super(i3, bArr);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
            }
        }
    }

    Resp onHttpPost(byte[] bArr);

    /* renamed from: onHttpPost, reason: collision with other method in class */
    /* synthetic */ Cinstanceof m284onHttpPost(byte[] bArr);
}
