package com.tencent.mobileqq.vas.adv.preload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/api/IVasAdvPreloadApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addPreloadAd", "", "businessId", "", "posIdList", "", "getAdAsJson", "loadAd", "removeAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAdvPreloadApi extends QRouteApi {
    void addPreloadAd(@NotNull String businessId, @NotNull List<String> posIdList);

    @Nullable
    String getAdAsJson(@NotNull String businessId);

    void loadAd(@NotNull String businessId);

    @Nullable
    qq_ad_get.QQAdGetRsp removeAd(@NotNull String businessId);
}
