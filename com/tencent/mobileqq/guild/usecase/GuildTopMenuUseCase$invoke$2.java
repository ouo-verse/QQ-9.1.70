package com.tencent.mobileqq.guild.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.usecase.GuildTopMenuUseCase$invoke$2", f = "GuildTopMenuUseCase.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class GuildTopMenuUseCase$invoke$2 extends SuspendLambda implements Function2<FlowCollector<? super com.tencent.qqnt.chats.main.vm.usecase.result.a>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildTopMenuUseCase$invoke$2(Continuation<? super GuildTopMenuUseCase$invoke$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildTopMenuUseCase$invoke$2 guildTopMenuUseCase$invoke$2 = new GuildTopMenuUseCase$invoke$2(continuation);
        guildTopMenuUseCase$invoke$2.L$0 = obj;
        return guildTopMenuUseCase$invoke$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List emptyList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            com.tencent.qqnt.chats.main.vm.usecase.result.a aVar = new com.tencent.qqnt.chats.main.vm.usecase.result.a(emptyList);
            this.label = 1;
            if (flowCollector.emit(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super com.tencent.qqnt.chats.main.vm.usecase.result.a> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildTopMenuUseCase$invoke$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
