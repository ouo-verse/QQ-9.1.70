package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.List;
import ve4.b;

/* loaded from: classes21.dex */
public class CPPActionsFeatureProvider extends CPPBase implements b {
    static IPatchRedirector $redirector_;

    public CPPActionsFeatureProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tedger.outapi.api.k
    public native List<EdgePointWiseSample> dump(String str, String str2, List<String> list, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.k
    public native void init(String str, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.k
    public native List<EdgeFeatureList> parseItemFeatures(String str, List<EdgeItem> list, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.k
    public native EdgeFeatureList parseUserFeatures(String str, EdgeUser edgeUser, EdgeStatus edgeStatus);
}
