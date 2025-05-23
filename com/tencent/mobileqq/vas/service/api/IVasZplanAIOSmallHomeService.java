package com.tencent.mobileqq.vas.service.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vas.data.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&J&\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/service/api/IVasZplanAIOSmallHomeService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "Lkotlin/Function1;", "", "", "callback", "requestEntranceInfo", "Lcom/tencent/mobileqq/vas/data/h;", "requestEntranceInfoV2", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasZplanAIOSmallHomeService extends QRouteApi {
    void requestEntranceInfo(long uin, @NotNull Function1<? super Boolean, Unit> callback);

    void requestEntranceInfoV2(long uin, @NotNull Function1<? super h, Unit> callback);
}
