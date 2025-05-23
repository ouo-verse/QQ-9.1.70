package com.tencent.mobileqq.vas.pendant.drawable.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/api/IPendantHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAvatarPendantManager", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IAvatarPendantManager;", "getDiyPendantFetcher", "Lcom/tencent/mobileqq/vas/pendant/drawable/api/IDiyPendantFetcher;", "getDiyPendantHandlerName", "", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IPendantHelperApi extends QRouteApi {
    @NotNull
    IAvatarPendantManager getAvatarPendantManager();

    @NotNull
    IDiyPendantFetcher getDiyPendantFetcher();

    @NotNull
    String getDiyPendantHandlerName();
}
