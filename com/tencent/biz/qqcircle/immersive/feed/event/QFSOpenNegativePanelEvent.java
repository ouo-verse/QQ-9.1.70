package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class QFSOpenNegativePanelEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StFeed mFeed;
    private final List<String> mFirstCategoryList;
    private QCircleReportBean mReportBean;
    private final List<String> mSecondCategoryList;

    public QFSOpenNegativePanelEvent(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        this.mFirstCategoryList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.mSecondCategoryList = arrayList2;
        this.mFeed = feedCloudMeta$StFeed;
        arrayList.addAll(list);
        arrayList2.addAll(list2);
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public List<String> getFirstCategoryList() {
        return this.mFirstCategoryList;
    }

    public QCircleReportBean getReportBean() {
        return this.mReportBean;
    }

    public List<String> getSecondCategoryList() {
        return this.mSecondCategoryList;
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = qCircleReportBean;
    }
}
