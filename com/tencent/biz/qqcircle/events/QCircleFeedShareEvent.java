package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedShareEvent extends SimpleBaseEvent {
    private boolean isShowShareSheet;
    private String mTargetFeedId;

    public QCircleFeedShareEvent(String str, boolean z16) {
        this.mTargetFeedId = str;
        this.isShowShareSheet = z16;
    }

    public String getTargetFeedId() {
        return this.mTargetFeedId;
    }

    public boolean isShowShareSheet() {
        return this.isShowShareSheet;
    }
}
