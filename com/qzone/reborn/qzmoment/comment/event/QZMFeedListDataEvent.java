package com.qzone.reborn.qzmoment.comment.event;

import bn.b;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFeedListDataEvent extends SimpleBaseEvent {
    private List<b> mFeedsData;
    private String mPageFrom;

    public QZMFeedListDataEvent(List<b> list, String str) {
        this.mFeedsData = list;
        this.mPageFrom = str;
    }

    public List<b> getFeedsData() {
        return this.mFeedsData;
    }

    public String getPageType() {
        return this.mPageFrom;
    }

    public void setFeedsData(List<b> list) {
        this.mFeedsData = list;
    }

    public void setPageFrom(String str) {
        this.mPageFrom = str;
    }
}
