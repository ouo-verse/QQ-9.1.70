package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.h;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeGetItemListEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_NAME = "edge_get_item_list";
    public String requestType;

    public EdgeGetItemListEvent(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        } else {
            this.mCallBack = hVar;
        }
    }
}
