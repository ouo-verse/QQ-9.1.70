package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSUpdateFeedListEvent extends SimpleBaseEvent {
    public static final int TYPE_INSERT_AND_UPDATE_INDEX = 1;
    public static final int TYPE_REPLACE_DATA = 2;
    private b mNextBlockData;
    private String mPreFeedId;
    private int mType;

    public QFSUpdateFeedListEvent(String str, b bVar, int i3) {
        this.mPreFeedId = str;
        this.mNextBlockData = bVar;
        this.mType = i3;
    }

    public b getNextBlockData() {
        return this.mNextBlockData;
    }

    public String getPreFeedId() {
        return this.mPreFeedId;
    }

    public int getType() {
        return this.mType;
    }
}
