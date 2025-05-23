package com.tencent.mobileqq.qqlive.api.room;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class QCircleLiveFeedsPlayerEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_FIX_XY = "setXYaxis";
    public static final String EVENT_IGNORE_LIFECYCLE = "ignore_lifecycle";
    public static final String EVENT_PAUSE = "pause";
    public static final String EVENT_RECEIVE_LIFECYCLE = "receive_lifecycle";
    public static final String EVENT_RELEASE = "release";
    public static final String EVENT_RESUME = "resume";
    public static final String EVENT_START = "start";
    public static final String EVENT_STOP = "stop";
    public static final String EVENT_SWITCH_DEFINITION = "switchDefinition";
    private String mEventType;
    private Bundle mParams;

    public QCircleLiveFeedsPlayerEvent(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) bundle);
        } else {
            this.mEventType = str;
            this.mParams = bundle;
        }
    }

    public String getEventType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mEventType;
    }

    public Bundle getParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bundle) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mParams;
    }
}
