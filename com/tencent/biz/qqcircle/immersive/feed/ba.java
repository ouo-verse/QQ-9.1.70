package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ba extends QFSFeedChildVideoPresenter {
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: s1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) this.E.b("DITTO_FEED_PUBLISH_TEMPLATE");
        if (qQCircleDitto$StCircleDittoDataNew != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size() > 0 && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.size() > 0) {
            super.L0(qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.get(0), i3);
        } else {
            QLog.e("QFSFeedChildPublishVideoPresenter", 1, "onBindData  dittoData error");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildPublishVideoPresenter";
    }
}
