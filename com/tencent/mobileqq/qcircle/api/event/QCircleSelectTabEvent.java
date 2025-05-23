package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleSelectTabEvent extends SimpleBaseEvent {
    public boolean fromSchema;
    public int tabType;
    public boolean needScrollTop = false;
    public boolean needSmoothScroll = false;
    public boolean needDownOnePage = false;
    public boolean needRefresh = false;

    public QCircleSelectTabEvent(int i3) {
        this.tabType = i3;
    }

    public QCircleSelectTabEvent needRefresh() {
        this.needRefresh = true;
        return this;
    }

    public QCircleSelectTabEvent needScrollTop() {
        this.needScrollTop = true;
        return this;
    }

    public QCircleSelectTabEvent needSmoothScroll() {
        this.needSmoothScroll = true;
        return this;
    }

    public void setIsFromSchema(boolean z16) {
        this.fromSchema = z16;
    }
}
