package com.tencent.dbfix;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DBFixResult {
    static IPatchRedirector $redirector_;
    public double duration;
    public long failPageCount;
    public int masterCorrupted;
    public long rowCount;
    public long sucPageCount;
    public long tableCount;

    public DBFixResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
