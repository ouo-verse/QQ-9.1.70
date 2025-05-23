package com.tencent.qav;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QavDef$MultiUserInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public boolean mMicOn;
    public String mOpenId;
    public long mUin;

    public QavDef$MultiUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void copyTo(QavDef$MultiUserInfo qavDef$MultiUserInfo, QavDef$MultiUserInfo qavDef$MultiUserInfo2) {
        qavDef$MultiUserInfo2.mUin = qavDef$MultiUserInfo.mUin;
        qavDef$MultiUserInfo2.mOpenId = qavDef$MultiUserInfo.mOpenId;
        qavDef$MultiUserInfo2.mMicOn = qavDef$MultiUserInfo.mMicOn;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MultiUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + "', mMicOn=" + this.mMicOn + '}';
    }
}
