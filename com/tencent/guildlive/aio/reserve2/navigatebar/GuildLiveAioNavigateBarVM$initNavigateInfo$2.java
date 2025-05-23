package com.tencent.guildlive.aio.reserve2.navigatebar;

import com.tencent.aio.msgservice.j;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/j;", "Ler0/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guildlive.aio.reserve2.navigatebar.GuildLiveAioNavigateBarVM$initNavigateInfo$2", f = "GuildLiveAioNavigateBarVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildLiveAioNavigateBarVM$initNavigateInfo$2 extends SuspendLambda implements Function2<j<er0.a>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildLiveAioNavigateBarVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLiveAioNavigateBarVM$initNavigateInfo$2(GuildLiveAioNavigateBarVM guildLiveAioNavigateBarVM, Continuation<? super GuildLiveAioNavigateBarVM$initNavigateInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = guildLiveAioNavigateBarVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildLiveAioNavigateBarVM$initNavigateInfo$2 guildLiveAioNavigateBarVM$initNavigateInfo$2 = new GuildLiveAioNavigateBarVM$initNavigateInfo$2(this.this$0, continuation);
        guildLiveAioNavigateBarVM$initNavigateInfo$2.L$0 = obj;
        return guildLiveAioNavigateBarVM$initNavigateInfo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull j<er0.a> jVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildLiveAioNavigateBarVM$initNavigateInfo$2) create(jVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.v((j) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
