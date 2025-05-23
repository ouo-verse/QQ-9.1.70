package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u00052!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H&J\b\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasPageToggle;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isUseKuiklyShopPage", "", "schemeBuilder", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "configScheme", "success", ZPlanPublishSource.FROM_SCHEME, "", "troopNickUseShopListPage", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasPageToggle extends QRouteApi {
    boolean isUseKuiklyShopPage(@NotNull Function1<? super String, String> schemeBuilder, @NotNull Function1<? super String, Unit> success);

    boolean troopNickUseShopListPage();
}
