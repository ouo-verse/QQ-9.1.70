package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends h<ve4.c> implements ve4.c {
    static IPatchRedirector $redirector_;

    public d(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.b
    public List<EdgeItemInfer> inference(EdgeListWiseSample edgeListWiseSample, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) edgeListWiseSample, (Object) edgeStatus);
        }
        if (v()) {
            return new ArrayList();
        }
        List<EdgeItemInfer> inference = ((ve4.c) this.f375322c).inference(edgeListWiseSample, edgeStatus);
        I(edgeStatus);
        return inference;
    }

    @Override // com.tencent.tedger.outapi.api.b
    public void init(String str, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.c) this.f375322c).init(str, edgeStatus);
            I(edgeStatus);
        }
    }

    @Override // com.tencent.tedger.outapi.api.b
    public void reload(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.c) this.f375322c).reload(edgeStatus);
            I(edgeStatus);
        }
    }
}
