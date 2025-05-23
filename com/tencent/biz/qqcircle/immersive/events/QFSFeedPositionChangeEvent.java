package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;

/* loaded from: classes4.dex */
public class QFSFeedPositionChangeEvent extends SimpleBaseEvent {
    private b feedData;
    private int mPosition;
    private int mTabType;

    public QFSFeedPositionChangeEvent(int i3) {
        this.mPosition = i3;
    }

    public b getFeedData() {
        return this.feedData;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public int getTabType() {
        return this.mTabType;
    }

    public QFSFeedPositionChangeEvent setFeedData(b bVar) {
        this.feedData = bVar;
        return this;
    }

    public void setPosition(int i3) {
        this.mPosition = i3;
    }

    public void setTabType(int i3) {
        this.mTabType = i3;
    }
}
