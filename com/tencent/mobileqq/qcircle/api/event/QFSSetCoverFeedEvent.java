package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.data.QCircleFeedCoverBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/event/QFSSetCoverFeedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "coverBean", "Lcom/tencent/mobileqq/qcircle/api/data/QCircleFeedCoverBean;", "shouldFinishProfileCard", "", "(Lcom/tencent/mobileqq/qcircle/api/data/QCircleFeedCoverBean;Z)V", "getCoverBean", "()Lcom/tencent/mobileqq/qcircle/api/data/QCircleFeedCoverBean;", "getShouldFinishProfileCard", "()Z", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSSetCoverFeedEvent extends SimpleBaseEvent {

    @Nullable
    private final QCircleFeedCoverBean coverBean;
    private final boolean shouldFinishProfileCard;

    public QFSSetCoverFeedEvent() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final QCircleFeedCoverBean getCoverBean() {
        return this.coverBean;
    }

    public final boolean getShouldFinishProfileCard() {
        return this.shouldFinishProfileCard;
    }

    public /* synthetic */ QFSSetCoverFeedEvent(QCircleFeedCoverBean qCircleFeedCoverBean, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : qCircleFeedCoverBean, (i3 & 2) != 0 ? false : z16);
    }

    public QFSSetCoverFeedEvent(@Nullable QCircleFeedCoverBean qCircleFeedCoverBean, boolean z16) {
        this.coverBean = qCircleFeedCoverBean;
        this.shouldFinishProfileCard = z16;
    }
}
