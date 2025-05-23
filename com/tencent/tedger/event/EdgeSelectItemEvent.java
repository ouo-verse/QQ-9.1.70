package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeSelectItemEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_NAME = "edge_select_item";
    public List<EdgeItem> itemList;

    public EdgeSelectItemEvent(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        } else {
            this.mCallBack = hVar;
        }
    }
}
