package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/u;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.model.AbsDetailViewModel$collectEventFlow$1", f = "AbsDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class AbsDetailViewModel$collectEventFlow$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<u, Unit> $eventHandler;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AbsDetailViewModel$collectEventFlow$1(Function1<? super u, Unit> function1, Continuation<? super AbsDetailViewModel$collectEventFlow$1> continuation) {
        super(2, continuation);
        this.$eventHandler = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AbsDetailViewModel$collectEventFlow$1 absDetailViewModel$collectEventFlow$1 = new AbsDetailViewModel$collectEventFlow$1(this.$eventHandler, continuation);
        absDetailViewModel$collectEventFlow$1.L$0 = obj;
        return absDetailViewModel$collectEventFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull u uVar, @Nullable Continuation<? super Unit> continuation) {
        return ((AbsDetailViewModel$collectEventFlow$1) create(uVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$eventHandler.invoke((u) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
