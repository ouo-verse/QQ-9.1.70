package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMainTabSelectEvent extends SimpleBaseEvent {
    private boolean mIsSelected;
    private String mName;
    private int mTabSourceType;
    private int mTabType;

    public String getName() {
        return this.mName;
    }

    public int getTabSourceType() {
        return this.mTabSourceType;
    }

    public int getTabType() {
        return this.mTabType;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setIsSelected(boolean z16) {
        this.mIsSelected = z16;
    }

    public void setTabName(String str) {
        this.mName = str;
    }

    public void setTabSourceType(int i3) {
        this.mTabSourceType = i3;
    }

    public void setTabType(int i3) {
        this.mTabType = i3;
    }
}
