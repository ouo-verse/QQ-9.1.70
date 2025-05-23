package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;
import ve4.c;

/* loaded from: classes21.dex */
public class CPPCollaborativeInference extends CPPBase implements c {
    static IPatchRedirector $redirector_;

    public CPPCollaborativeInference() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tedger.outapi.api.b
    public native List<EdgeItemInfer> inference(EdgeListWiseSample edgeListWiseSample, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.b
    public native void init(String str, EdgeStatus edgeStatus);

    @Override // com.tencent.tedger.outapi.api.b
    public native void reload(EdgeStatus edgeStatus);
}
