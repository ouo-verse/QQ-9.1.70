package com.tencent.tedger.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedger.event.TEdgeBaseEvent;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeErrorEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_;
    public static final String TAG;
    public HashMap<String, String> extraInfo;
    public EdgeStatus mStatus;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            TAG = EdgeErrorEvent.class.getName();
        }
    }

    public EdgeErrorEvent(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) edgeStatus);
        } else {
            this.extraInfo = new HashMap<>();
            this.mStatus = edgeStatus;
        }
    }

    public EdgeErrorEvent(EdgeStatus edgeStatus, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) edgeStatus, (Object) str);
            return;
        }
        this.extraInfo = new HashMap<>();
        this.mStatus = edgeStatus;
        this.reqId = str;
    }
}
