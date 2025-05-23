package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e extends h<ve4.d> implements ve4.d {
    static IPatchRedirector $redirector_;

    public e(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.c
    public void init(String str, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.d) this.f375322c).init(str, edgeStatus);
            I(edgeStatus);
        }
    }

    @Override // com.tencent.tedger.outapi.api.c
    public boolean train(List<EdgeListWiseSample> list, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) edgeStatus)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.d) this.f375322c).train(list, edgeStatus);
    }
}
