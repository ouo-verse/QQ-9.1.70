package com.tencent.mobileqq.inject;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/inject/w;", "Lcom/tencent/mobileqq/inject/u;", "", "name", "", "fallBack", "isSwitchOn", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class w implements u {
    @Override // com.tencent.mobileqq.inject.u
    public boolean isSwitchOn(String name, boolean fallBack) {
        Intrinsics.checkNotNullParameter(name, "name");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(name, fallBack);
    }
}
