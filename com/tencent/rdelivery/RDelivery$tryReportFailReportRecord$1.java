package com.tencent.rdelivery;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.raft.standard.task.IRTask;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/rdelivery/RDelivery$tryReportFailReportRecord$1", "Lcom/tencent/raft/standard/task/IRTask$Task;", "", TencentLocation.RUN_MODE, "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RDelivery$tryReportFailReportRecord$1 extends IRTask.Task {
    final /* synthetic */ RDelivery this$0;

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        RDeliverySetting rDeliverySetting = this.this$0.setting;
        aVar = this.this$0.dependencyInjector;
        rDeliverySetting.c0(aVar.getNetInterface());
    }
}
