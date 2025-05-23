package com.tencent.qqnt.aio.api;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&J\u0018\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H&J\u0018\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOExtBusinessVB;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "getPublicAccountInputBarVB", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getMultiSelectBarVB", "getLongShotBarVB", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOExtBusinessVB extends QRouteApi {
    @NotNull
    com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getLongShotBarVB();

    @NotNull
    com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getMultiSelectBarVB();

    @NotNull
    com.tencent.aio.base.mvvm.a<at.a, InputUIState> getPublicAccountInputBarVB();
}
