package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private r f288618a;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288618a = new r();
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public void a(LoadParam loadParam, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadParam, (Object) onLoadListener);
            return;
        }
        r rVar = this.f288618a;
        if (rVar != null) {
            rVar.m(loadParam, onLoadListener);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        r rVar = this.f288618a;
        if (rVar != null) {
            rVar.r(str);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public LoadExtResult c(LoadParam loadParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LoadExtResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) loadParam);
        }
        r rVar = this.f288618a;
        if (rVar == null) {
            return null;
        }
        return rVar.q(loadParam);
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        r rVar = this.f288618a;
        if (rVar != null && rVar.j(str)) {
            return true;
        }
        return false;
    }
}
