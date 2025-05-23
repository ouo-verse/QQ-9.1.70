package com.tencent.dbfix;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
class DBFixCore {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DBFixCore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public native boolean doBackupMaster(String str, String str2);

    public native boolean doDBFixRepair(String str, String str2, String str3, DBFixResult dBFixResult);

    public native boolean doDumpRepair(String str, String str2, DBFixResult dBFixResult);

    public native ArrayList<DBCheckResultItem> doIntegrityCheck(String str);

    public native int doReindexRepair(String str, List<String> list);
}
