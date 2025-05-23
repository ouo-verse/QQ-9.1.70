package com.tencent.mobileqq.qcircle.api.qqvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.qqvideo.data.QCircleFeedOperateFakeSyncExternalInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/qqvideo/event/QCircleFeedOperateFakeSyncExternalEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "operateSyncInfo", "Lcom/tencent/mobileqq/qcircle/api/qqvideo/data/QCircleFeedOperateFakeSyncInfo;", "(Lcom/tencent/mobileqq/qcircle/api/qqvideo/data/QCircleFeedOperateFakeSyncInfo;)V", "getOperateSyncInfo", "()Lcom/tencent/mobileqq/qcircle/api/qqvideo/data/QCircleFeedOperateFakeSyncInfo;", "setOperateSyncInfo", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCircleFeedOperateFakeSyncExternalEvent extends SimpleBaseEvent {

    @NotNull
    private QCircleFeedOperateFakeSyncExternalInfo operateSyncInfo;

    public QCircleFeedOperateFakeSyncExternalEvent(@NotNull QCircleFeedOperateFakeSyncExternalInfo operateSyncInfo) {
        Intrinsics.checkNotNullParameter(operateSyncInfo, "operateSyncInfo");
        this.operateSyncInfo = operateSyncInfo;
    }

    @NotNull
    public final QCircleFeedOperateFakeSyncExternalInfo getOperateSyncInfo() {
        return this.operateSyncInfo;
    }

    public final void setOperateSyncInfo(@NotNull QCircleFeedOperateFakeSyncExternalInfo qCircleFeedOperateFakeSyncExternalInfo) {
        Intrinsics.checkNotNullParameter(qCircleFeedOperateFakeSyncExternalInfo, "<set-?>");
        this.operateSyncInfo = qCircleFeedOperateFakeSyncExternalInfo;
    }
}
