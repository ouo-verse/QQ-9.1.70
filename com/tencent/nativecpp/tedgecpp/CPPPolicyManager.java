package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;
import ve4.e;

/* loaded from: classes21.dex */
public class CPPPolicyManager extends CPPBase implements e {
    static IPatchRedirector $redirector_;

    public CPPPolicyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tedger.outapi.api.m
    public native void init(String str, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.m
    public native ArrayList<String> rank(EdgeUser edgeUser, List<EdgeItem> list, List<EdgeItemInfer> list2, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.m
    public native int[] select(List<EdgeItem> list, EdgeStatus edgeStatus);
}
