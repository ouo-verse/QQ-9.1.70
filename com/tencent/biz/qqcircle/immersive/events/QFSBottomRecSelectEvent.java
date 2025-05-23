package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomRecSelectEvent extends SimpleBaseEvent {
    private int mClickPos;
    private b mFeedBlockData;
    private int mSourcePos;

    public int getClickPos() {
        return this.mClickPos;
    }

    public b getFeedBlockData() {
        return this.mFeedBlockData;
    }

    public int getSourcePos() {
        return this.mSourcePos;
    }

    public QFSBottomRecSelectEvent setClickPos(int i3) {
        this.mClickPos = i3;
        return this;
    }

    public QFSBottomRecSelectEvent setFeedBlockData(b bVar) {
        this.mFeedBlockData = bVar;
        return this;
    }

    public QFSBottomRecSelectEvent setSourcePos(int i3) {
        this.mSourcePos = i3;
        return this;
    }
}
