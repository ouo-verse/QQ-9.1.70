package com.tencent.sqshow.zootopia.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import pu4.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/event/ZPlanFeedsPublishSuccessEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lpu4/n;", QCircleScheme.AttrDetail.FEED_INFO, "Lpu4/n;", "getFeedInfo", "()Lpu4/n;", "<init>", "(Lpu4/n;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFeedsPublishSuccessEvent extends SimpleBaseEvent {
    private final n feedInfo;

    public ZPlanFeedsPublishSuccessEvent(n nVar) {
        this.feedInfo = nVar;
    }

    public final n getFeedInfo() {
        return this.feedInfo;
    }
}
