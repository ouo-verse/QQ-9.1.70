package com.tencent.mobileqq.wink.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes21.dex */
public class PublishKeyboardEvent extends SimpleBaseEvent {
    public boolean showKeyboard;

    public PublishKeyboardEvent(boolean z16) {
        this.showKeyboard = z16;
    }
}
