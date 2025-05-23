package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCallFriendFollowBackEvent extends SimpleBaseEvent {
    public final String feedId;
    public final String friendUin;
    public final int scene;

    public QFSCallFriendFollowBackEvent(String str, String str2, int i3) {
        this.feedId = str;
        this.friendUin = str2;
        this.scene = i3;
    }
}
