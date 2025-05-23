package com.tencent.mobileqq.zplan.hotpatch;

import ai3.b;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yh3.a;
import yh3.c;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/hotpatch/ZPlanHotPatchIPCImpl;", "Lyh3/a;", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "dispatchProgressEvent", "", "versionInfo", "dispatchStatusChangeEvent", "result", "dispatchHotPatchResult", "Lai3/b;", "cb", "dispatchLoadingError", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanHotPatchIPCImpl implements a {
    @Override // yh3.a
    public void dispatchHotPatchResult(String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        c.f450357a.b(result);
    }

    @Override // yh3.a
    public void dispatchLoadingError(String result, b cb5) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        c.f450357a.c(result, cb5);
    }

    @Override // yh3.a
    public void dispatchProgressEvent(CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        c.f450357a.d(loadingData);
    }

    @Override // yh3.a
    public void dispatchStatusChangeEvent(String versionInfo) {
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        c.f450357a.e(versionInfo);
    }
}
