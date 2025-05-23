package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SQLiteCipherSpec {
    static IPatchRedirector $redirector_ = null;
    public static final int HMAC_DEFAULT = -1;
    public static final int HMAC_SHA1 = 0;
    public static final int HMAC_SHA256 = 1;
    public static final int HMAC_SHA512 = 2;
    public int hmacAlgorithm;
    public boolean hmacEnabled;
    public int kdfAlgorithm;
    public int kdfIteration;
    public int pageSize;

    public SQLiteCipherSpec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = SQLiteGlobal.f384390a;
    }

    public SQLiteCipherSpec(SQLiteCipherSpec sQLiteCipherSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sQLiteCipherSpec);
            return;
        }
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = SQLiteGlobal.f384390a;
        this.kdfIteration = sQLiteCipherSpec.kdfIteration;
        this.hmacEnabled = sQLiteCipherSpec.hmacEnabled;
        this.pageSize = sQLiteCipherSpec.pageSize;
    }
}
