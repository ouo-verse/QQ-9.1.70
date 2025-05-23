package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneRefreshDetailFeedEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/event/QzoneBaseEvent;", "unionID", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;)V", "getUnionID", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "setUnionID", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneRefreshDetailFeedEvent extends QzoneBaseEvent {
    private CommonUnionID unionID;

    public QzoneRefreshDetailFeedEvent(CommonUnionID commonUnionID) {
        this.unionID = commonUnionID;
    }

    public final CommonUnionID getUnionID() {
        return this.unionID;
    }

    public final void setUnionID(CommonUnionID commonUnionID) {
        this.unionID = commonUnionID;
    }
}
