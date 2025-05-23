package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/event/QFSRemoveFeedbackCardEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isRealFeedBack", "", "(Z)V", "()Z", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSRemoveFeedbackCardEvent extends SimpleBaseEvent {
    private final boolean isRealFeedBack;

    public QFSRemoveFeedbackCardEvent(boolean z16) {
        this.isRealFeedBack = z16;
    }

    /* renamed from: isRealFeedBack, reason: from getter */
    public final boolean getIsRealFeedBack() {
        return this.isRealFeedBack;
    }
}
