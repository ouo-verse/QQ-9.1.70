package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVipDataRequestProxy;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/av;", "Lcom/tencent/mobileqq/vas/api/IVipDataRequestProxy;", "", "uin", "", "requestAndUpdateData", "d", "Ljava/lang/String;", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class av implements IVipDataRequestProxy {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String managerName = "VipDataRequestProxy";

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        return this.managerName;
    }

    @Override // com.tencent.mobileqq.vas.api.IVipDataRequestProxy
    public void requestAndUpdateData(@Nullable String uin) {
        if (uin == null) {
            return;
        }
        ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).requestAndUpdateData(uin, null);
    }
}
