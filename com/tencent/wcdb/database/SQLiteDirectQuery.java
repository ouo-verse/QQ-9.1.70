package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.database.SQLiteConnection;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SQLiteDirectQuery extends f {
    static IPatchRedirector $redirector_;
    private static final int[] G;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            G = new int[]{3, 1, 2, 3, 4, 0};
        }
    }

    private static native byte[] nativeGetBlob(long j3, int i3);

    private static native double nativeGetDouble(long j3, int i3);

    private static native long nativeGetLong(long j3, int i3);

    private static native String nativeGetString(long j3, int i3);

    private static native int nativeGetType(long j3, int i3);

    private static native int nativeStep(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.wcdb.database.f, com.tencent.wcdb.database.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        synchronized (this) {
            SQLiteConnection.d dVar = this.D;
            if (dVar != null) {
                dVar.q(null);
                this.D.r(null);
            }
        }
        super.e();
    }
}
