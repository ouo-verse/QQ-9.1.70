package com.tencent.mobileqq.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.api.IZanRankingApi;
import com.tencent.mobileqq.profilecard.ipc.ZanRankingIpcServer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/profilecard/api/impl/ZanRankingApiImpl;", "Lcom/tencent/mobileqq/profilecard/api/IZanRankingApi;", "()V", "getZanRankingServerInstance", "Lcom/tencent/mobileqq/profilecard/ipc/ZanRankingIpcServer;", "kotlin.jvm.PlatformType", "getZanRankingServerName", "", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZanRankingApiImpl implements IZanRankingApi {
    @Override // com.tencent.mobileqq.profilecard.api.IZanRankingApi
    public String getZanRankingServerName() {
        return "ZanRankingIpcServer";
    }

    @Override // com.tencent.mobileqq.profilecard.api.IZanRankingApi
    public ZanRankingIpcServer getZanRankingServerInstance() {
        return ZanRankingIpcServer.getInstance();
    }
}
