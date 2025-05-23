package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i extends c<ve4.i> implements ve4.i {
    static IPatchRedirector $redirector_;

    public i(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.i
    public void F(com.tencent.tedger.outapi.api.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
        } else {
            if (v()) {
                return;
            }
            ((ve4.i) this.f375322c).F(gVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.i
    public void k(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            if (v() || this.f375322c == 0) {
                return;
            }
            ((ve4.i) this.f375322c).k(fVar);
        }
    }

    @Override // com.tencent.tedger.routecenter.defaultimp.c, com.tencent.tedger.outapi.api.i
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (v()) {
                return;
            }
            ((ve4.i) this.f375322c).onDestroy();
        }
    }

    @Override // com.tencent.tedger.outapi.api.i
    public void q(com.tencent.tedger.outapi.api.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else {
            if (v()) {
                return;
            }
            ((ve4.i) this.f375322c).q(gVar);
        }
    }
}
