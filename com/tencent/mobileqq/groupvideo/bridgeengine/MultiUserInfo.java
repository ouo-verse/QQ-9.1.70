package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class MultiUserInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public boolean mMicOn;
    public String mOpenId;
    public long mUin;

    public MultiUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void copyTo(MultiUserInfo multiUserInfo, MultiUserInfo multiUserInfo2) {
        multiUserInfo2.mUin = multiUserInfo.mUin;
        multiUserInfo2.mOpenId = multiUserInfo.mOpenId;
        multiUserInfo2.mMicOn = multiUserInfo.mMicOn;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MultiUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + "', mMicOn=" + this.mMicOn + '}';
    }
}
