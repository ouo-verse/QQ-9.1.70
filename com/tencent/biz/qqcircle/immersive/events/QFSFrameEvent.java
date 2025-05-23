package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFrameEvent extends SimpleBaseEvent {
    public static final int REFRESH_ALL_TAB = 3;
    public static final int REFRESH_TAB_CURRENT_TAB = 0;
    public static final int REFRESH_TAB_INDEX_FOLLOW = 2;
    public static final int REFRESH_TAB_INDEX_RECOMMEND = 1;
    public int mRefreshTab;

    public QFSFrameEvent(int i3, int i16) {
        this.mHashCode = i3;
        this.mRefreshTab = i16;
    }
}
