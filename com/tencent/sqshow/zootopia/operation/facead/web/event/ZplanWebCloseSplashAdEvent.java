package com.tencent.sqshow.zootopia.operation.facead.web.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/web/event/ZplanWebCloseSplashAdEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "showAgainStatus", "", "completeData", "", "(ILjava/lang/String;)V", "getCompleteData", "()Ljava/lang/String;", "getShowAgainStatus", "()I", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanWebCloseSplashAdEvent extends SimpleBaseEvent {
    private final String completeData;
    private final int showAgainStatus;

    public ZplanWebCloseSplashAdEvent(int i3, String completeData) {
        Intrinsics.checkNotNullParameter(completeData, "completeData");
        this.showAgainStatus = i3;
        this.completeData = completeData;
    }

    public final String getCompleteData() {
        return this.completeData;
    }

    public final int getShowAgainStatus() {
        return this.showAgainStatus;
    }
}
