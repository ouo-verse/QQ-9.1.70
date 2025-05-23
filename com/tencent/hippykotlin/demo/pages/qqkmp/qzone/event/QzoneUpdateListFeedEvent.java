package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneUpdateListFeedEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneBaseEvent;", "oldFeedId", "", "newFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "(Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "getNewFeed", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "setNewFeed", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "getOldFeedId", "()Ljava/lang/String;", "setOldFeedId", "(Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneUpdateListFeedEvent extends QzoneBaseEvent {
    private CommonFeed newFeed;
    private String oldFeedId;

    public QzoneUpdateListFeedEvent(String str, CommonFeed commonFeed) {
        this.oldFeedId = str;
        this.newFeed = commonFeed;
    }

    public final CommonFeed getNewFeed() {
        return this.newFeed;
    }

    public final String getOldFeedId() {
        return this.oldFeedId;
    }

    public final void setNewFeed(CommonFeed commonFeed) {
        this.newFeed = commonFeed;
    }

    public final void setOldFeedId(String str) {
        this.oldFeedId = str;
    }
}
