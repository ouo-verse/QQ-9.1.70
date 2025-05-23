package com.tencent.guild.aio.article.input.slowmode;

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
@DebugMetadata(c = "com.tencent.guild.aio.article.input.slowmode.GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1", f = "GuildArticleSlowModeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1 extends SuspendLambda implements Function2<com.tencent.qqnt.msg.data.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildArticleSlowModeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1(GuildArticleSlowModeViewModel guildArticleSlowModeViewModel, Continuation<? super GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = guildArticleSlowModeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1 guildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1 = new GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1(this.this$0, continuation);
        guildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1.L$0 = obj;
        return guildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.qqnt.msg.data.b bVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildArticleSlowModeViewModel$channelFreqLimitInfoUpdate$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.D((com.tencent.qqnt.msg.data.b) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
