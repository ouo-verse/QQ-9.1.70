package com.tencent.mobileqq.wink.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes21.dex */
public class PublishChangeTagPanelStateEvent extends SimpleBaseEvent {
    public static final int HIDE = 1;
    public static final int SHOW = 0;
    public int state;

    public PublishChangeTagPanelStateEvent(int i3) {
        this.state = i3;
    }
}
