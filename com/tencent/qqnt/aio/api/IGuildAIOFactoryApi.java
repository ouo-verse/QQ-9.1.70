package com.tencent.qqnt.aio.api;

import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H&J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/api/IGuildAIOFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "createGuildAIOForegroundContainerVB", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "getGuildAIOMsgProcessor", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IGuildAIOFactoryApi extends QRouteApi {
    @NotNull
    com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve2UIState> createGuildAIOForegroundContainerVB();

    @NotNull
    List<AbsAIOMsgProcessor> getGuildAIOMsgProcessor(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope);
}
