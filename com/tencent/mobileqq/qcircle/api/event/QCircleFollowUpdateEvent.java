package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleFollowUpdateEvent extends SimpleBaseEvent {
    public int mFollowStatus;
    public boolean mFromNetRsp;
    public String mUserId;

    public QCircleFollowUpdateEvent(int i3, String str) {
        this.mFollowStatus = i3;
        this.mUserId = str;
    }

    public QCircleFollowUpdateEvent(int i3, String str, boolean z16) {
        this(i3, str);
        this.mFromNetRsp = z16;
    }
}
