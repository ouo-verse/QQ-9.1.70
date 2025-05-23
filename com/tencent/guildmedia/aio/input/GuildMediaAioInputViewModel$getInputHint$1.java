package com.tencent.guildmedia.aio.input;

import com.tencent.guild.aio.usecase.channel.title.ChannelNameMviResult;
import com.tencent.guildmedia.aio.input.GuildMediaAioInputUIState;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/guild/aio/usecase/channel/title/b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guildmedia.aio.input.GuildMediaAioInputViewModel$getInputHint$1", f = "GuildMediaAioInputViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildMediaAioInputViewModel$getInputHint$1 extends SuspendLambda implements Function2<ChannelNameMviResult, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildMediaAioInputViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaAioInputViewModel$getInputHint$1(GuildMediaAioInputViewModel guildMediaAioInputViewModel, Continuation<? super GuildMediaAioInputViewModel$getInputHint$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMediaAioInputViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMediaAioInputViewModel$getInputHint$1 guildMediaAioInputViewModel$getInputHint$1 = new GuildMediaAioInputViewModel$getInputHint$1(this.this$0, continuation);
        guildMediaAioInputViewModel$getInputHint$1.L$0 = obj;
        return guildMediaAioInputViewModel$getInputHint$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ChannelNameMviResult channelNameMviResult, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaAioInputViewModel$getInputHint$1) create(channelNameMviResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateUI(new GuildMediaAioInputUIState.GuildInputHint(((ChannelNameMviResult) this.L$0).getName()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
