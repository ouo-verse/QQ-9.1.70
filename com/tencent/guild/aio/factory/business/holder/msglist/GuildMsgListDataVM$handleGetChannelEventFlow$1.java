package com.tencent.guild.aio.factory.business.holder.msglist;

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
@DebugMetadata(c = "com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM$handleGetChannelEventFlow$1", f = "GuildMsgListDataVM.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMsgListDataVM$handleGetChannelEventFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.aio.api.runtime.a $context;
    int label;
    final /* synthetic */ GuildMsgListDataVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgListDataVM$handleGetChannelEventFlow$1(GuildMsgListDataVM guildMsgListDataVM, com.tencent.aio.api.runtime.a aVar, Continuation<? super GuildMsgListDataVM$handleGetChannelEventFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMsgListDataVM;
        this.$context = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMsgListDataVM$handleGetChannelEventFlow$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            if (DelayKt.delay(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.e0(this.$context, "isFin");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMsgListDataVM$handleGetChannelEventFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
