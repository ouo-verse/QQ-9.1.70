package com.tencent.mobileqq.tianshu.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes18.dex */
public class TianShuAdPosItemData {
    static IPatchRedirector $redirector_;
    public HashMap<String, String> mExtraData;
    public int mNeedCnt;
    public int mPosId;

    public TianShuAdPosItemData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TianShuAdPosItemData{, mPosId=" + this.mPosId + ", mExtraData=" + this.mExtraData + '}';
    }
}
