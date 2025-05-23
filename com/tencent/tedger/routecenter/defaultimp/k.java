package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.delegate.d;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class k extends c<ve4.k> implements ve4.k {
    static IPatchRedirector $redirector_;

    public k(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.l
    public void E(String str, d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
        } else {
            if (v()) {
                return;
            }
            ((ve4.k) this.f375322c).E(str, aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.l
    public void n(List<EdgeItem> list, Map<String, Object> map, d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, map, aVar);
        } else {
            if (v()) {
                return;
            }
            ((ve4.k) this.f375322c).n(list, map, aVar);
        }
    }

    @Override // com.tencent.tedger.routecenter.defaultimp.c, com.tencent.tedger.outapi.api.i
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (v()) {
                return;
            }
            ((ve4.k) this.f375322c).onDestroy();
        }
    }
}
