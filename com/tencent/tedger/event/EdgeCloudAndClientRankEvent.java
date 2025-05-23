package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeAction;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeCloudAndClientRankEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_NAME = "edge_cloud_and_client_rank";

    public EdgeCloudAndClientRankEvent(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        } else {
            this.mCallBack = hVar;
            this.isMutex = true;
        }
    }

    public EdgeCloudAndClientRankEvent(h hVar, EdgeAction edgeAction) {
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
