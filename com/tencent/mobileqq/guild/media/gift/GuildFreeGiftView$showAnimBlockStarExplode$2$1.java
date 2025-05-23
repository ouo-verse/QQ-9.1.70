package com.tencent.mobileqq.guild.media.gift;

import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$showAnimBlockStarExplode$2$1", f = "GuildFreeGiftView.kt", i = {}, l = {com.tencent.mm.plugin.appbrand.jsapi.coverview.a.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildFreeGiftView$showAnimBlockStarExplode$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Boolean> $continuation;
    int label;
    final /* synthetic */ GuildFreeGiftView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildFreeGiftView$showAnimBlockStarExplode$2$1(GuildFreeGiftView guildFreeGiftView, CancellableContinuation<? super Boolean> cancellableContinuation, Continuation<? super GuildFreeGiftView$showAnimBlockStarExplode$2$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFreeGiftView;
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFreeGiftView$showAnimBlockStarExplode$2$1(this.this$0, this.$continuation, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object I;
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
            GuildFreeGiftView guildFreeGiftView = this.this$0;
            int dimensionPixelSize = guildFreeGiftView.getResources().getDimensionPixelSize(R.dimen.cdb);
            this.label = 1;
            I = guildFreeGiftView.I("https://downv6.qq.com/innovate/guild/avChannel/guild_free_gift_star_explode_anim.png", dimensionPixelSize, 1, this);
            if (I == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (this.$continuation.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFreeGiftView$showAnimBlockStarExplode$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
