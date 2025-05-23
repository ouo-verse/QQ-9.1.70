package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;
import ve4.a;

/* loaded from: classes21.dex */
public class CPPActionsFeature extends CPPBase implements a {
    static IPatchRedirector $redirector_;

    public CPPActionsFeature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tedger.outapi.api.j
    public native EdgeListWiseSample extractFeatures(EdgeFeatureList edgeFeatureList, List<EdgeFeatureList> list, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.j
    public native void init(String str, EdgeStatus edgeStatus);
}
