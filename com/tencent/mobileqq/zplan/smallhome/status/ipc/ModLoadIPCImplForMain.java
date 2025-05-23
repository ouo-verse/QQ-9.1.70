package com.tencent.mobileqq.zplan.smallhome.status.ipc;

import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForModProcess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sk3.a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/status/ipc/ModLoadIPCImplForMain;", "Lsk3/a;", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "statusInfo", "", "updateStatus", "clearLoadStatus", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModLoadIPCImplForMain implements a {
    @Override // sk3.a
    public void clearLoadStatus() {
        ZPlanModLoadStatusManagerForModProcess.f335710a.b();
    }

    @Override // sk3.a
    public void updateStatus(ZPlanModLoadStatusInfo statusInfo) {
        Intrinsics.checkNotNullParameter(statusInfo, "statusInfo");
        ZPlanModLoadStatusManagerForModProcess.f335710a.d(statusInfo);
    }
}
