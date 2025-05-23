package com.tencent.guild.aio.title;

import com.tencent.guild.aio.usecase.channel.title.ChannelNameMviResult;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/guild/aio/usecase/channel/title/b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.title.GuildAioTitleViewModel$getChannelTitle$1", f = "GuildAioTitleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildAioTitleViewModel$getChannelTitle$1 extends SuspendLambda implements Function2<ChannelNameMviResult, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildAioTitleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAioTitleViewModel$getChannelTitle$1(GuildAioTitleViewModel guildAioTitleViewModel, Continuation<? super GuildAioTitleViewModel$getChannelTitle$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAioTitleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildAioTitleViewModel$getChannelTitle$1 guildAioTitleViewModel$getChannelTitle$1 = new GuildAioTitleViewModel$getChannelTitle$1(this.this$0, continuation);
        guildAioTitleViewModel$getChannelTitle$1.L$0 = obj;
        return guildAioTitleViewModel$getChannelTitle$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ChannelNameMviResult channelNameMviResult, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAioTitleViewModel$getChannelTitle$1) create(channelNameMviResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IGuildAioTitleUIState N;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelNameMviResult channelNameMviResult = (ChannelNameMviResult) this.L$0;
            GuildAioTitleViewModel guildAioTitleViewModel = this.this$0;
            N = guildAioTitleViewModel.N(channelNameMviResult);
            Intrinsics.checkNotNull(N, "null cannot be cast to non-null type com.tencent.guild.aio.title.GuildAioTitleTextUIState");
            guildAioTitleViewModel.updateUI((GuildAioTitleTextUIState) N);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
