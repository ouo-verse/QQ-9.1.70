package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSHomePageSelectedEvent extends SimpleBaseEvent {
    public boolean mIsHomePageSelected;

    public QFSHomePageSelectedEvent(boolean z16) {
        this.mIsHomePageSelected = z16;
    }
}
