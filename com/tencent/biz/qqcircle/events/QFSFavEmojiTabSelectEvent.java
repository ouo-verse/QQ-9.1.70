package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFavEmojiTabSelectEvent extends SimpleBaseEvent {
    public boolean isTabExpose;

    public QFSFavEmojiTabSelectEvent(boolean z16) {
        this.isTabExpose = z16;
    }
}
