package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeAction;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeUserActionEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_NAME = "edge_user_action";

    public EdgeUserActionEvent(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mCallBack = hVar;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        }
    }

    public EdgeUserActionEvent(EdgeAction edgeAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mAction = edgeAction;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) edgeAction);
        }
    }
}
