package com.tencent.guild.aio.reserve2.busi.navigate.bar.holder;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarVM$handleNavigationBarData$1", f = "GuildAioNavigateBarVM.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildAioNavigateBarVM$handleNavigationBarData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildAioNavigateBarVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAioNavigateBarVM$handleNavigationBarData$1(GuildAioNavigateBarVM guildAioNavigateBarVM, Continuation<? super GuildAioNavigateBarVM$handleNavigationBarData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAioNavigateBarVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildAioNavigateBarVM$handleNavigationBarData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        long j3;
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
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GuildAioNavigateBarVM guildAioNavigateBarVM = this.this$0;
        arrayList = this.this$0.mNavigationInfoList;
        j3 = this.this$0.unreadCount;
        guildAioNavigateBarVM.updateUI(new GuildAioNavigateBarUIState(arrayList, j3));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAioNavigateBarVM$handleNavigationBarData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
