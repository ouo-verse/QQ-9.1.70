package com.tencent.tedger.item;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedgecontext.b;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.delegate.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ve4.k;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends b implements k {
    static IPatchRedirector $redirector_;

    public a(com.tencent.tedgecontext.a aVar) {
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
            getContext().k().b(str, null, new HashMap(), aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.l
    public void n(List<EdgeItem> list, Map<String, Object> map, d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, map, aVar);
        } else {
            getContext().k().b("cloud_rerank_data_source_type", list, map, aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.l
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
