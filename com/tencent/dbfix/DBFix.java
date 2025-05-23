package com.tencent.dbfix;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DBFix {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DBFix";
    private static final DBFix sInstance;
    private DBFixCore mCore;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sInstance = new DBFix();
        }
    }

    DBFix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCore = null;
            this.mCore = new DBFixCore();
        }
    }

    public static DBFix getInstance() {
        return sInstance;
    }

    public boolean doBackupMaster(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (!new File(str).exists()) {
            DBFixLog.d(TAG, " doDBFixRepair file not exist:", str);
            return false;
        }
        return this.mCore.doBackupMaster(str, str2);
    }

    public boolean doDBFixRepair(String str, String str2, String str3, DBFixResult dBFixResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, str2, str3, dBFixResult)).booleanValue();
        }
        if (!new File(str).exists()) {
            DBFixLog.d(TAG, " doDBFixRepair file not exist:", str);
            return false;
        }
        return this.mCore.doDBFixRepair(str, str2, str3, dBFixResult);
    }

    public boolean doDumpRepair(String str, String str2, DBFixResult dBFixResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, str2, dBFixResult)).booleanValue();
        }
        if (!new File(str).exists()) {
            DBFixLog.d(TAG, " doDumpRepair file not exist:", str);
            return false;
        }
        return this.mCore.doDumpRepair(str, str2, dBFixResult);
    }

    public ArrayList<DBCheckResultItem> doIntegrityCheck(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!new File(str).exists()) {
            DBFixLog.d(TAG, " doIntegrityCheck file not exist:", str);
            return new ArrayList<>();
        }
        return this.mCore.doIntegrityCheck(str);
    }

    public int doReindexRepair(String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) list)).intValue();
        }
        if (!new File(str).exists()) {
            DBFixLog.d(TAG, " doIntegrityCheck file not exist:", str);
            return -1;
        }
        return this.mCore.doReindexRepair(str, list);
    }
}
