package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi;
import com.tencent.qqnt.aio.adapter.api.IAIOTroopBindGuildApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTroopBindGuildApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOTroopBindGuildApi;", "()V", "isTroopBindGuild", "", "troopUin", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOTroopBindGuildApiImpl implements IAIOTroopBindGuildApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTroopBindGuildApi
    public boolean isTroopBindGuild(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        ITroopBindGuildApi.TroopBindGuildInfo bindGuildInfoFromExtInfo = ((ITroopBindGuildApi) QRoute.api(ITroopBindGuildApi.class)).getBindGuildInfoFromExtInfo(troopUin);
        return (bindGuildInfoFromExtInfo == null || bindGuildInfoFromExtInfo.getGuildId() == 0) ? false : true;
    }
}
