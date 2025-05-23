package com.tencent.mobileqq.wink.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes21.dex */
public class PublishAssociateTagEvent extends SimpleBaseEvent {
    public String tag;

    public PublishAssociateTagEvent(String str) {
        this.tag = str;
    }
}
