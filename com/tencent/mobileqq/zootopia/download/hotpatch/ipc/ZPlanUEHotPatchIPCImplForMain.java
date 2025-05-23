package com.tencent.mobileqq.zootopia.download.hotpatch.ipc;

import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/hotpatch/ipc/ZPlanUEHotPatchIPCImplForMain;", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/ipc/a;", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "notifyHotPatchProgress", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEHotPatchIPCImplForMain implements a {
    @Override // com.tencent.mobileqq.zootopia.download.hotpatch.ipc.a
    public void notifyHotPatchProgress(CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        ZPlanUEHotPatchForModProcess.f328061a.b().Q0(loadingData);
    }
}
