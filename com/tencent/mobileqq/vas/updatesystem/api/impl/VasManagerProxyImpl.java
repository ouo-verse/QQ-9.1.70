package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasManagerProxy;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import sw4.c;
import sw4.d;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/api/impl/VasManagerProxyImpl;", "Lcom/tencent/mobileqq/vas/updatesystem/api/IVasManagerProxy;", "Lsw4/c;", "getDbManager", "Lsw4/d;", "getHttpDownloader", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasManagerProxyImpl implements IVasManagerProxy {
    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasManagerProxy
    @Nullable
    public c getDbManager() {
        return new com.tencent.mobileqq.vas.updatesystem.impl.b();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasManagerProxy
    @Nullable
    public d getHttpDownloader() {
        return ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).getHttpDownloader();
    }
}
