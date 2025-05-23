package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSLongPressOpenShareEvent extends SimpleBaseEvent {
    public int mContextHashcode;
    public String mFeedId;

    public QFSLongPressOpenShareEvent(int i3, String str) {
        this.mContextHashcode = i3;
        this.mFeedId = str;
    }
}
