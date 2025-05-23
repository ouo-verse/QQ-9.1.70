package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.data.AIOMsgProcessorFactory;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOMsgProcessManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/aio/data/AIOMsgProcessorFactory;", "processor", "", "addAIOMsgProcessorFactory", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", OperateCustomButton.OPERATE_CREATE, "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOMsgProcessManager extends QRouteApi {
    void addAIOMsgProcessorFactory(@NotNull AIOMsgProcessorFactory processor);

    @NotNull
    List<AbsAIOMsgProcessor> create(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope);
}
