package com.tencent.qzonehub.api.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes25.dex */
public class QZoneLocalPhotoRecommendScanFinishEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    public QZoneLocalPhotoRecommendScanFinishEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
