package com.tencent.mobileqq.fts.data.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FTSMessageDelete extends FTSMessageSync {
    static IPatchRedirector $redirector_ = null;
    public static final String MSG_DEL_LOG_TABLE = "msg_del_log";
    public long delCounter;
    public int mode;

    public FTSMessageDelete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void deleteAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mode = 3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.fts.FTSMessage", 2, "insert delete all uin:", String.valueOf(this.uin), " istroop:", String.valueOf(this.istroop));
        }
    }

    public void deleteEntire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mode = 4;
        }
    }

    public void deleteOne() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mode = 1;
        }
    }

    public void deletePatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mode = 2;
        }
    }

    @Override // com.tencent.mobileqq.fts.data.msg.FTSMessageSync, com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return MSG_DEL_LOG_TABLE;
    }
}
