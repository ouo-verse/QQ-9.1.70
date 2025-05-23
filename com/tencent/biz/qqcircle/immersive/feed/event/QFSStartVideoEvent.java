package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSStartVideoEvent extends SimpleBaseEvent {
    public final String feedId;
    public final boolean play;

    public QFSStartVideoEvent(String str, boolean z16) {
        this.feedId = str;
        this.play = z16;
    }
}
