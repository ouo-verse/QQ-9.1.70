package com.tencent.tedger.routecenter.defaultimp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.IInitStateManager;
import java.util.Map;
import ve4.j;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j extends c<ve4.j> implements ve4.j {
    static IPatchRedirector $redirector_;

    public j(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public void c(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) map);
        } else {
            if (v()) {
                return;
            }
            ((ve4.j) this.f375322c).c(map);
        }
    }

    @Override // ve4.j
    public void g(@NonNull j.a aVar, @Nullable IInitStateManager.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar, (Object) aVar2);
        } else {
            if (v()) {
                return;
            }
            ((ve4.j) this.f375322c).g(aVar, aVar2);
        }
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.j) this.f375322c).o();
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (v()) {
            return false;
        }
        return ((ve4.j) this.f375322c).w();
    }

    @Override // com.tencent.tedger.outapi.api.IInitStateManager
    public IInitStateManager.TEdgeRSInitStep y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IInitStateManager.TEdgeRSInitStep) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (v()) {
            return IInitStateManager.TEdgeRSInitStep.Begin;
        }
        return ((ve4.j) this.f375322c).y();
    }
}
