package com.tencent.mobileqq.troop.exitoptimise.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.troop.exitoptimise.api.ITroopStateApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/exitoptimise/api/impl/TroopStateApiImpl;", "Lcom/tencent/mobileqq/troop/exitoptimise/api/ITroopStateApi;", "Lcom/tencent/aio/main/businesshelper/h;", "createJoinStateHelper", "createAioUIStateManageHelper", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopStateApiImpl implements ITroopStateApi {
    @Override // com.tencent.mobileqq.troop.exitoptimise.api.ITroopStateApi
    @NotNull
    public h createAioUIStateManageHelper() {
        return new TroopUiStateManageHelper();
    }

    @Override // com.tencent.mobileqq.troop.exitoptimise.api.ITroopStateApi
    @NotNull
    public h createJoinStateHelper() {
        return new TroopJoinStateHelper();
    }
}
