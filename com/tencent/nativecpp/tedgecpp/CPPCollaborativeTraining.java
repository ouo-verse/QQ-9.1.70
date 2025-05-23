package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.jnishare.TEdgeRSSharedBase;
import java.util.List;
import ve4.d;

/* loaded from: classes21.dex */
public class CPPCollaborativeTraining extends TEdgeRSSharedBase implements d {
    static IPatchRedirector $redirector_;

    public CPPCollaborativeTraining() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tedger.outapi.api.c
    public native void init(String str, EdgeStatus edgeStatus);

    public native void saveModel(EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.c
    public native boolean train(List<EdgeListWiseSample> list, EdgeStatus edgeStatus);
}
