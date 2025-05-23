package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleFrameEvent extends SimpleBaseEvent {
    public static final int REFRESH_ALL_TAB = 4;
    public static final int REFRESH_TAB_CURRENT_TAB = 0;
    public static final int REFRESH_TAB_INDEX_FOLLOW = 2;
    public static final int REFRESH_TAB_INDEX_NEARBY = 3;
    public static final int REFRESH_TAB_INDEX_RECOMMEND = 1;
    public boolean mAddTab;
    public String mBackgroundColor;
    public boolean mIsNeedExposeTab;
    public boolean mIsRefreshRedNum;
    public int mRefreshTab;
    public int mSwitchTab;
    public boolean mTriggerSelectedQCircleTab;

    public QCircleFrameEvent() {
        this.mBackgroundColor = "#FAFAFB";
        this.mIsRefreshRedNum = false;
        this.mIsNeedExposeTab = false;
        this.mRefreshTab = -1;
        this.mTriggerSelectedQCircleTab = false;
        this.mAddTab = false;
        this.mSwitchTab = -1;
    }

    public QCircleFrameEvent(int i3, int i16) {
        this.mBackgroundColor = "#FAFAFB";
        this.mIsRefreshRedNum = false;
        this.mIsNeedExposeTab = false;
        this.mTriggerSelectedQCircleTab = false;
        this.mAddTab = false;
        this.mSwitchTab = -1;
        this.mHashCode = i3;
        this.mRefreshTab = i16;
    }
}
