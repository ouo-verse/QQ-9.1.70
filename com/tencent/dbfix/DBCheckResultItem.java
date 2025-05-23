package com.tencent.dbfix;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DBCheckResultItem {
    static IPatchRedirector $redirector_;
    public final String description;
    public final int errCode;

    public DBCheckResultItem(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.description = str;
            this.errCode = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DBIntegrityCheckResultItem{description='" + this.description + "', errCode=" + this.errCode + '}';
    }
}
