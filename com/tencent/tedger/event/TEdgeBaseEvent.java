package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.f;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgeAction;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TEdgeBaseEvent implements Serializable, f {
    static IPatchRedirector $redirector_;
    public String TAG;
    public boolean isMutex;
    protected EdgeAction mAction;
    public h mCallBack;
    public String reqId;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        protected static TEdgeBaseEvent a(int i3, EdgeAction edgeAction, h hVar) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return null;
                            }
                            return new EdgeIndependentCloudPolicyRankEvent(hVar, edgeAction);
                        }
                        return new EdgeIndependentPolicyRankEvent(hVar, edgeAction);
                    }
                    return new EdgeCloudAndClientRankEvent(hVar, edgeAction);
                }
                return new EdgeCloudRankEvent(hVar, edgeAction);
            }
            return new EdgeClientRankEvent(hVar, edgeAction);
        }
    }

    public TEdgeBaseEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = getClass().getSimpleName();
            this.isMutex = false;
        }
    }

    public static f getEventForName(int i3, EdgeAction edgeAction, h hVar) {
        return a.a(i3, edgeAction, hVar);
    }

    @Override // com.tencent.tedger.outapi.api.f
    public EdgeAction getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EdgeAction) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mAction;
    }

    @Override // com.tencent.tedger.outapi.api.f
    public int getEventType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        EdgeAction edgeAction = this.mAction;
        if (edgeAction == null || edgeAction.getEvents().size() <= 0) {
            return 0;
        }
        return this.mAction.getEvents().get(0).type.get();
    }

    @Override // com.tencent.tedger.outapi.api.f
    public String getReqId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.reqId;
    }

    @Override // com.tencent.tedger.outapi.api.f
    public boolean isMutex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isMutex;
    }
}
