package com.tencent.sqshow.zootopia.operation.facead.web.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/web/event/ZplanWebPageLoadFinishedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "loadCostTime", "", WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT, "completeData", "", "(IILjava/lang/String;)V", "getCompleteData", "()Ljava/lang/String;", "getLoadCostTime", "()I", "getLoadResult", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanWebPageLoadFinishedEvent extends SimpleBaseEvent {
    private final String completeData;
    private final int loadCostTime;
    private final int loadResult;

    public ZplanWebPageLoadFinishedEvent(int i3, int i16, String completeData) {
        Intrinsics.checkNotNullParameter(completeData, "completeData");
        this.loadCostTime = i3;
        this.loadResult = i16;
        this.completeData = completeData;
    }

    public final String getCompleteData() {
        return this.completeData;
    }

    public final int getLoadCostTime() {
        return this.loadCostTime;
    }

    public final int getLoadResult() {
        return this.loadResult;
    }
}
