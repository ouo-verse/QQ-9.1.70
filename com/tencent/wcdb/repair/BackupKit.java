package com.tencent.wcdb.repair;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BackupKit {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f384438a;

    private static native void nativeCancel(long j3);

    private static native void nativeFinish(long j3);

    private static native long nativeInit(String str, byte[] bArr, int i3);

    private static native String nativeLastError(long j3);

    private static native int nativeRun(long j3, long j16, String[] strArr);

    private static native int nativeStatementCount(long j3);

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        long j3 = this.f384438a;
        if (j3 != 0) {
            nativeFinish(j3);
            this.f384438a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            a();
            super.finalize();
        }
    }
}
