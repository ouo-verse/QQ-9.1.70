package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import ue4.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h<T extends ue4.a> extends c<T> {
    static IPatchRedirector $redirector_;

    public h(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) edgeStatus);
            return;
        }
        if (edgeStatus.getCode() != 0 && edgeStatus.mAutoPrintError) {
            this.f375323d.e(this.f375320a, 6, "NativeError: " + edgeStatus.getMsg() + "(" + edgeStatus.getCode() + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tedger.routecenter.defaultimp.c
    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        com.tencent.tedger.routecenter.a aVar = this.f375324e.get();
        if (!aVar.f375303a.w()) {
            aVar.f375318p.e(this.f375320a, 9, "can't call function in " + this.f375321b + " before enable ReRank.");
            return true;
        }
        if (!aVar.f375303a.o()) {
            aVar.f375318p.e(this.f375320a, 9, "can't call function in " + this.f375321b + " before enable edge ReRank.");
            return true;
        }
        return super.v();
    }
}
