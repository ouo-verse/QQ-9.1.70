package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFollowTabLiveListEvent extends SimpleBaseEvent {
    public static final boolean HIDE_LIVE_LIST = false;
    public static final boolean SHOW_LIVE_LIST = true;
    public boolean mIsShowLiveList;

    public QFSFollowTabLiveListEvent(boolean z16) {
        this.mIsShowLiveList = z16;
    }
}
