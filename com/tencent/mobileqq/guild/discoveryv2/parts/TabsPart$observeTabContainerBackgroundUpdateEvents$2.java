package com.tencent.mobileqq.guild.discoveryv2.parts;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$observeTabContainerBackgroundUpdateEvents$2", f = "TabsPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class TabsPart$observeTabContainerBackgroundUpdateEvents$2 extends SuspendLambda implements Function2<SimpleBaseEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TabsPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsPart$observeTabContainerBackgroundUpdateEvents$2(TabsPart tabsPart, Continuation<? super TabsPart$observeTabContainerBackgroundUpdateEvents$2> continuation) {
        super(2, continuation);
        this.this$0 = tabsPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TabsPart$observeTabContainerBackgroundUpdateEvents$2 tabsPart$observeTabContainerBackgroundUpdateEvents$2 = new TabsPart$observeTabContainerBackgroundUpdateEvents$2(this.this$0, continuation);
        tabsPart$observeTabContainerBackgroundUpdateEvents$2.L$0 = obj;
        return tabsPart$observeTabContainerBackgroundUpdateEvents$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SimpleBaseEvent simpleBaseEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((TabsPart$observeTabContainerBackgroundUpdateEvents$2) create(simpleBaseEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SimpleBaseEvent simpleBaseEvent = (SimpleBaseEvent) this.L$0;
            TabsPart tabsPart = this.this$0;
            String simpleName = simpleBaseEvent.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "event.javaClass.simpleName");
            tabsPart.ma(simpleName);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
