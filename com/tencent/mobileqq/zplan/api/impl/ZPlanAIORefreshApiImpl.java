package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mobileqq.zplan.api.IZPlanAIORefreshApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIORefreshApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIORefreshApi;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "getAvatarEggRefresher", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAIORefreshApiImpl implements IZPlanAIORefreshApi {
    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIORefreshApi
    public com.tencent.mobileqq.aio.msglist.holder.external.c getAvatarEggRefresher(com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        return new fh3.g(helper);
    }
}
