package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.video.decode.AVDecodeError;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class n extends c<ve4.n> implements ve4.n {
    static IPatchRedirector $redirector_;

    public n(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // ve4.n
    public void A(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) edgeStatus);
        } else if (v()) {
            edgeStatus.setCode(-1L);
        } else {
            ((ve4.n) this.f375322c).A(edgeStatus);
        }
    }

    @Override // com.tencent.tedger.outapi.api.n
    public void G(List<EdgePointWiseSample> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            if (v()) {
                return;
            }
            ((ve4.n) this.f375322c).G(list);
        }
    }

    @Override // ve4.n
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (v()) {
                return;
            }
            ((ve4.n) this.f375322c).b();
        }
    }

    @Override // com.tencent.tedger.outapi.api.n
    public void d(EdgeAction edgeAction, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) edgeAction, (Object) edgeStatus);
            return;
        }
        if (v()) {
            return;
        }
        try {
            ((ve4.n) this.f375322c).d(edgeAction, edgeStatus);
        } catch (Exception e16) {
            this.f375323d.e(this.f375320a, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, "addUserAction error " + e16);
        }
    }

    @Override // com.tencent.tedger.routecenter.defaultimp.c, com.tencent.tedger.outapi.api.i
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f375322c != 0) {
            ((ve4.n) this.f375322c).onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.tedger.outapi.api.n
    public void p(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.n) this.f375322c).p(edgeStatus);
        }
    }
}
