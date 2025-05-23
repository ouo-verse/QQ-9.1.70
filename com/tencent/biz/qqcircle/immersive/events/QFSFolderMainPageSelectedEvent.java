package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSFolderMainPageSelectedEvent extends SimpleBaseEvent {
    public boolean mIsFolderMainPageSelected;

    public QFSFolderMainPageSelectedEvent(boolean z16) {
        this.mIsFolderMainPageSelected = z16;
    }
}
