package com.tencent.tedger.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeFeedBackEvent extends TEdgeBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_NAME = "feed_back";
    public List<EdgePointWiseSample> samples;

    public EdgeFeedBackEvent(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
        } else {
            this.mCallBack = hVar;
        }
    }
}
