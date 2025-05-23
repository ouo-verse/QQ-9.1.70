package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QGameBusEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final int EVENT_VIDEO_ARK_PLAY = 4;
    public static final int EVENT_VIDEO_ARK_STOP = 3;
    public static final int EVENT_VIDEO_H5_PLAY = 2;
    public static final int EVENT_VIDEO_H5_STOP = 1;
    public static final int EVENT_VIDEO_NATIVE_PLAY = 6;
    public static final int EVENT_VIDEO_NATIVE_STOP = 5;
    public int eventType;

    public QGameBusEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.eventType = i3;
        }
    }
}
