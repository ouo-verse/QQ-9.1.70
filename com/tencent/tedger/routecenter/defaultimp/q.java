package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;

/* compiled from: P */
/* loaded from: classes26.dex */
public class q extends c<ve4.o> implements ve4.o {
    static IPatchRedirector $redirector_;

    public q(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // ve4.o
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (v()) {
                return;
            }
            ((ve4.o) this.f375322c).b();
        }
    }

    @Override // com.tencent.tedger.outapi.api.o
    public void d(EdgeAction edgeAction, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) edgeAction, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.o) this.f375322c).d(edgeAction, edgeStatus);
        }
    }

    @Override // com.tencent.tedger.outapi.api.o
    public EdgeUser u(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EdgeUser) iPatchRedirector.redirect((short) 2, (Object) this, (Object) edgeStatus);
        }
        if (v()) {
            return null;
        }
        return ((ve4.o) this.f375322c).u(edgeStatus);
    }

    @Override // com.tencent.tedger.outapi.api.o
    public void updateUserBaseInfo(EdgeUser edgeUser, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) edgeUser, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.o) this.f375322c).updateUserBaseInfo(edgeUser, edgeStatus);
        }
    }
}
