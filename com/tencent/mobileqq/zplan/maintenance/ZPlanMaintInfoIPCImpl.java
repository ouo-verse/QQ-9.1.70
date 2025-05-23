package com.tencent.mobileqq.zplan.maintenance;

import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/maintenance/ZPlanMaintInfoIPCImpl;", "Lcom/tencent/mobileqq/zplan/maintenance/a;", "", "asyncUpdateZPlanMaintManageConfig", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMaintInfoIPCImpl implements a {
    @Override // com.tencent.mobileqq.zplan.maintenance.a
    public void asyncUpdateZPlanMaintManageConfig() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ZPlanMaintInfoIPCImpl$asyncUpdateZPlanMaintManageConfig$1(null), 2, null);
    }
}
