package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeItem;
import java.util.List;

/* loaded from: classes26.dex */
public class EdgeIndependentPolicyRankEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_NAME = "edge_independent_policy_rank";
    public List<EdgeItem> itemList;

    public EdgeIndependentPolicyRankEvent(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        } else {
            this.mCallBack = hVar;
            this.isMutex = true;
        }
    }

    public EdgeIndependentPolicyRankEvent(h hVar, EdgeAction edgeAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar, (Object) edgeAction);
            return;
        }
        this.mCallBack = hVar;
        this.isMutex = true;
        this.mAction = edgeAction;
    }
}
