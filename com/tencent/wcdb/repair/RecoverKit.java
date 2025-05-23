package com.tencent.wcdb.repair;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RecoverKit {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f384439a;

    private static native void nativeCancel(long j3);

    private static native int nativeFailureCount(long j3);

    private static native void nativeFinish(long j3);

    private static native long nativeInit(String str, byte[] bArr);

    private static native String nativeLastError(long j3);

    private static native int nativeRun(long j3, long j16, boolean z16);

    private static native int nativeSuccessCount(long j3);

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        long j3 = this.f384439a;
        if (j3 != 0) {
            nativeFinish(j3);
            this.f384439a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            a();
            super.finalize();
        }
    }
}
