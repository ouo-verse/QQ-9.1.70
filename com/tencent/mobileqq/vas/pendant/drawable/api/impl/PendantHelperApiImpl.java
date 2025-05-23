package com.tencent.mobileqq.vas.pendant.drawable.api.impl;

import com.tencent.mobileqq.vas.pendant.drawable.AvatarPendantManagerImpl;
import com.tencent.mobileqq.vas.pendant.drawable.DiyPendantHandler;
import com.tencent.mobileqq.vas.pendant.drawable.VasDiyPendantFetcher;
import com.tencent.mobileqq.vas.pendant.drawable.api.IDiyPendantFetcher;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/api/impl/PendantHelperApiImpl;", "Lcom/tencent/mobileqq/vas/pendant/drawable/api/IPendantHelperApi;", "()V", "getAvatarPendantManager", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IAvatarPendantManager;", "getDiyPendantFetcher", "Lcom/tencent/mobileqq/vas/pendant/drawable/api/IDiyPendantFetcher;", "getDiyPendantHandlerName", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PendantHelperApiImpl implements IPendantHelperApi {
    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi
    @NotNull
    public IAvatarPendantManager getAvatarPendantManager() {
        AvatarPendantManagerImpl c16 = AvatarPendantManagerImpl.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
        return c16;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi
    @NotNull
    public IDiyPendantFetcher getDiyPendantFetcher() {
        VasDiyPendantFetcher n3 = VasDiyPendantFetcher.n();
        Intrinsics.checkNotNullExpressionValue(n3, "getFetcher()");
        return n3;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi
    @NotNull
    public String getDiyPendantHandlerName() {
        String name = DiyPendantHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "DiyPendantHandler::class.java.name");
        return name;
    }
}
