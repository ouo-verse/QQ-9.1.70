package com.tencent.mobileqq.nearbypro.aio.api.impl;

import com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi;
import com.tencent.qqnt.aio.helper.cw;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/api/impl/NearbyProAIOHelperApiImpl;", "Lcom/tencent/mobileqq/nearbypro/aio/api/INearbyProAIOHelperApi;", "()V", "getNearByProDisplayHelperId", "", "getNearbyProExitAIOJumpHelperId", "getNearbyProMsgHelperId", "getNearbyProTacitHelperId", "qq_nearby_pro_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class NearbyProAIOHelperApiImpl implements INearbyProAIOHelperApi {
    @Override // com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi
    public int getNearByProDisplayHelperId() {
        return cw.W0;
    }

    @Override // com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi
    public int getNearbyProExitAIOJumpHelperId() {
        return cw.X0;
    }

    @Override // com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi
    public int getNearbyProMsgHelperId() {
        return cw.Y0;
    }

    @Override // com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi
    public int getNearbyProTacitHelperId() {
        return cw.Z0;
    }
}
