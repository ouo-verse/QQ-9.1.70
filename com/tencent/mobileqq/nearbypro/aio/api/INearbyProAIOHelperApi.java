package com.tencent.mobileqq.nearbypro.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/api/INearbyProAIOHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getNearByProDisplayHelperId", "", "getNearbyProExitAIOJumpHelperId", "getNearbyProMsgHelperId", "getNearbyProTacitHelperId", "qq_nearby_pro_df_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyProAIOHelperApi extends QRouteApi {
    int getNearByProDisplayHelperId();

    int getNearbyProExitAIOJumpHelperId();

    int getNearbyProMsgHelperId();

    int getNearbyProTacitHelperId();
}
