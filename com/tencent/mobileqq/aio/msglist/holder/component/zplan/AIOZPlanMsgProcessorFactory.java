package com.tencent.mobileqq.aio.msglist.holder.component.zplan;

import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.data.AIOMsgProcessorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/AIOZPlanMsgProcessorFactory;", "Lcom/tencent/qqnt/aio/data/AIOMsgProcessorFactory;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOZPlanMsgProcessorFactory implements AIOMsgProcessorFactory {
    @Override // com.tencent.qqnt.aio.data.AIOMsgProcessorFactory
    @NotNull
    public AbsAIOMsgProcessor create(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new a(aioContext, scope);
    }
}
