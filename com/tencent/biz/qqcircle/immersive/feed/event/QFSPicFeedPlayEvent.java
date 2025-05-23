package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPicFeedPlayEvent extends SimpleBaseEvent {
    public String feedId;
    public String globalKey;
    public int indexInFeed;
    public int progress;
}
