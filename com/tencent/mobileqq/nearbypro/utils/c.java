package com.tencent.mobileqq.nearbypro.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/b;", "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "b", "Lmqq/app/AppRuntime;", "a", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {
    @NotNull
    public static final AppRuntime a(@NotNull com.tencent.mobileqq.nearbypro.base.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime);
        return peekAppRuntime;
    }

    @NotNull
    public static final SelfUserInfo b(@NotNull com.tencent.mobileqq.nearbypro.base.b bVar) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IMapNearbyDataService.class, "");
        }
        Intrinsics.checkNotNull(iRuntimeService);
        return ((IMapNearbyDataService) iRuntimeService).getSelfUserInfo();
    }
}
