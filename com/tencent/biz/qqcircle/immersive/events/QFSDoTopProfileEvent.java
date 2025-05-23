package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSDoTopProfileEvent extends SimpleBaseEvent {
    public boolean isDoProfile;
    public String mTargetFeedId;

    public QFSDoTopProfileEvent(String str, boolean z16) {
        this.mTargetFeedId = str;
        this.isDoProfile = z16;
    }
}
