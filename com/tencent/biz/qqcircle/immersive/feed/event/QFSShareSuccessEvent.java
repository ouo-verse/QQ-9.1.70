package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSShareSuccessEvent extends SimpleBaseEvent {
    private final String mFeedId;
    private final Map<String, Long> mMsgIdMap;
    private final int mPageId;

    public QFSShareSuccessEvent(String str, int i3, Map<String, Long> map) {
        this.mFeedId = str;
        this.mPageId = i3;
        this.mMsgIdMap = map;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public Map<String, Long> getMsgIdMap() {
        return this.mMsgIdMap;
    }

    public int getPageId() {
        return this.mPageId;
    }
}
