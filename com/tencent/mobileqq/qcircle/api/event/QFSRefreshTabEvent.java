package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$Entry;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSRefreshTabEvent extends SimpleBaseEvent {
    private PBRepeatMessageField<FeedCloudCommon$Entry> mMapInfo;
    private boolean mNeedSaveRedPoint;
    private int mTabType;

    public QFSRefreshTabEvent(int i3, boolean z16) {
        this.mTabType = i3;
        this.mNeedSaveRedPoint = z16;
    }

    public PBRepeatMessageField<FeedCloudCommon$Entry> getMapInfo() {
        return this.mMapInfo;
    }

    public int getTabType() {
        return this.mTabType;
    }

    public boolean needSaveRedPoint() {
        return this.mNeedSaveRedPoint;
    }

    public void setMapInfo(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField) {
        this.mMapInfo = pBRepeatMessageField;
    }
}
