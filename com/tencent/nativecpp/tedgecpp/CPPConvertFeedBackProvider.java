package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;
import ve4.h;

/* loaded from: classes21.dex */
public class CPPConvertFeedBackProvider extends CPPBase implements h {
    static IPatchRedirector $redirector_;

    public CPPConvertFeedBackProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tedger.outapi.api.e
    public native List<EdgePointWiseSample> convertFeedBack(List<EdgePointWiseSample> list, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.e
    public native void init(String str, EdgeStatus edgeStatus);
}
