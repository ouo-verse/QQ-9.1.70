package com.tencent.mobileqq.app.db;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CompetitionThreadInfo {
    static IPatchRedirector $redirector_;
    public final long enterTime;
    public final long threadId;
    public final String threadName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompetitionThreadInfo(long j3, String str, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, Long.valueOf(j16));
            return;
        }
        this.threadId = j3;
        this.threadName = str;
        this.enterTime = j16;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof CompetitionThreadInfo) {
            if (((CompetitionThreadInfo) obj).threadId == this.threadId) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "CompetitionThreadInfo{threadId=" + this.threadId + ", threadName='" + this.threadName + "', enterTime=" + this.enterTime + '}';
    }
}
