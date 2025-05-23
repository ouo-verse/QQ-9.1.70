package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g extends c<ve4.h> implements ve4.h {
    static IPatchRedirector $redirector_;

    public g(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.e
    public List<EdgePointWiseSample> convertFeedBack(List<EdgePointWiseSample> list, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) edgeStatus);
        }
        if (v()) {
            return null;
        }
        return ((ve4.h) this.f375322c).convertFeedBack(list, edgeStatus);
    }

    @Override // com.tencent.tedger.outapi.api.e
    public void init(String str, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.h) this.f375322c).init(str, edgeStatus);
        }
    }
}
