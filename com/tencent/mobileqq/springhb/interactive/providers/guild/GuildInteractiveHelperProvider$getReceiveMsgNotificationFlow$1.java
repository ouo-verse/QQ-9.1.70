package com.tencent.mobileqq.springhb.interactive.providers.guild;

import com.tencent.qqnt.msg.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/msg/d;", "it", "Lkotlinx/coroutines/flow/Flow;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.springhb.interactive.providers.guild.GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1", f = "GuildInteractiveHelperProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1 extends SuspendLambda implements Function2<List<? extends d>, Continuation<? super Flow<? extends d>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1(Continuation<? super GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1 guildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1 = new GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1(continuation);
        guildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1.L$0 = obj;
        return guildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return FlowKt.asFlow((List) this.L$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends d> list, @Nullable Continuation<? super Flow<? extends d>> continuation) {
        return ((GuildInteractiveHelperProvider$getReceiveMsgNotificationFlow$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
