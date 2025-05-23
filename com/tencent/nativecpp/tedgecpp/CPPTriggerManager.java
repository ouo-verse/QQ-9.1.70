package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import ve4.f;

/* loaded from: classes21.dex */
public class CPPTriggerManager extends CPPBase implements f {
    static IPatchRedirector $redirector_;

    public CPPTriggerManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tedger.outapi.api.a
    public native ArrayList<Integer> dispatchAction(EdgeAction edgeAction, EdgeUser edgeUser, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.a
    public native void init(String str, EdgeStatus edgeStatus);
}
