package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

@PluginInterface
/* loaded from: classes21.dex */
public class BoxProgressStatusEvent extends SimpleBaseEvent {
    public static final int CANCEL_UPLOAD = 1;
    public static final int NETWORK_NOT_AVAILABLE = 2;
    public static final int SHOW_CLOSE_BT = 0;
    protected int type;

    public BoxProgressStatusEvent(int i3) {
        this.type = i3;
    }

    public int getType() {
        return this.type;
    }
}
