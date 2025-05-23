package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.List;

/* loaded from: classes26.dex */
public class EdgePolicyRankEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_NAME = "edge_policy_rank";
    public List<EdgeItemInfer> itemInfers;
    public List<EdgeItem> itemList;
    public EdgeUser user;

    public EdgePolicyRankEvent(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        } else {
            this.mCallBack = hVar;
        }
    }
}
