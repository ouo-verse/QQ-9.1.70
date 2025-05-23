package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;
import ue4.a;

/* loaded from: classes21.dex */
public class CPPFeedBackCenter extends CPPBase implements a {
    static IPatchRedirector $redirector_;

    public CPPFeedBackCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public native List<EdgePointWiseSample> convert(List<EdgePointWiseSample> list, EdgeStatus edgeStatus);

    public native void init(String str, EdgeStatus edgeStatus);
}
