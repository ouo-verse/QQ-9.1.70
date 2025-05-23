package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class p extends h<ve4.f> implements ve4.f {
    static IPatchRedirector $redirector_;

    public p(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.a
    public List<Integer> dispatchAction(EdgeAction edgeAction, EdgeUser edgeUser, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, edgeAction, edgeUser, edgeStatus);
        }
        if (v()) {
            return new ArrayList(0);
        }
        return ((ve4.f) this.f375322c).dispatchAction(edgeAction, edgeUser, edgeStatus);
    }

    @Override // com.tencent.tedger.outapi.api.a
    public void init(String str, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.f) this.f375322c).init(str, edgeStatus);
        }
    }
}
