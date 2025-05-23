package com.tencent.guild.aio.input.realinput;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/msg/data/b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.input.realinput.GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1", f = "GuildAioDefaultInputViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1 extends SuspendLambda implements Function2<com.tencent.qqnt.msg.data.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildAioDefaultInputViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1(GuildAioDefaultInputViewModel guildAioDefaultInputViewModel, Continuation<? super GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAioDefaultInputViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1 guildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1 = new GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1(this.this$0, continuation);
        guildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1.L$0 = obj;
        return guildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.qqnt.msg.data.b bVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.k0((com.tencent.qqnt.msg.data.b) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
