package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaServiceManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/ai;", "", "stopZPlanService", "", "shouldCheckFloat", "startZPlanService", "Lcom/tencent/mobileqq/zootopia/ipc/c;", "callback", "isEngineReady", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaServiceManagerImpl implements ai {
    @Override // com.tencent.mobileqq.zootopia.ipc.ai
    public void isEngineReady(c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.a(ZPlanServiceHelper.I.l0());
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ai
    public void startZPlanService() {
        QRouteApi api = QRoute.api(IZPlanApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
        IZPlanApi.b.c((IZPlanApi) api, null, "zootopia_serviceManager", 1, null);
    }

    public void stopZPlanService() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).stopZPlanEngine();
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ai
    public void stopZPlanService(boolean shouldCheckFloat) {
        if (shouldCheckFloat && ((f) k74.i.INSTANCE.a(f.class)).isFloat()) {
            return;
        }
        stopZPlanService();
    }
}
