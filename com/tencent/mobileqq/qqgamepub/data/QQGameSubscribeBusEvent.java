package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameSubscribeBusEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_ = null;
    public static final int EVENT_GET_SUBSCRIBE_INFO_SUCCESS_SINGLE_MSG = 2;
    public static final int EVENT_NOTIFY_REFRESH_AIO_LIST = 1;
    public static final int EVENT_SET_SUBSCRIBE_FAILED = 6;
    public static final int EVENT_SET_SUBSCRIBE_INFO_SUCCESS_ALL_MSG = 4;
    public static final int EVENT_SET_SUBSCRIBE_INFO_SUCCESS_SINGLE_MSG = 3;
    public static final int EVENT_SET_SUBSCRIBE_SUCCESS_ALL_MSG_UPDATE_GRAY = 5;
    public int eventType;
    public long seq;
    public QQGamePubSubscribe$AppSubscribeInfo subscribeInfo;

    public QQGameSubscribeBusEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.eventType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQGameSubscribeBusEvent{eventType=" + this.eventType + ", subscribeInfo=" + this.subscribeInfo + '}';
    }
}
