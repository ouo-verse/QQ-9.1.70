package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRestartAudioEvent extends SimpleBaseEvent {
    public String mPageId;
    public String mTargetFeedId;

    public QFSRestartAudioEvent(String str, String str2) {
        this.mTargetFeedId = str;
        this.mPageId = str2;
    }
}
