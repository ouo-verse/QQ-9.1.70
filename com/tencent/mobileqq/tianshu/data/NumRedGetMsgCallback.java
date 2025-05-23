package com.tencent.mobileqq.tianshu.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class NumRedGetMsgCallback {
    static IPatchRedirector $redirector_;
    private static int seed;
    public int key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34296);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            seed = 0;
        }
    }

    public NumRedGetMsgCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int i3 = seed;
        seed = i3 + 1;
        this.key = i3;
    }

    public abstract void updateNumMsg(String str, List<NumRedMsg.NumMsgBusi> list);
}
