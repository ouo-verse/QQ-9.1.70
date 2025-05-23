package com.tencent.mobileqq.guild.media.gift;

import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.gift.GuildFreeGiftView$initGiftCountView$1", f = "GuildFreeGiftView.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildFreeGiftView$initGiftCountView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ct1.a $giftInfo;
    final /* synthetic */ float $progress;
    int label;
    final /* synthetic */ GuildFreeGiftView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFreeGiftView$initGiftCountView$1(GuildFreeGiftView guildFreeGiftView, ct1.a aVar, float f16, Continuation<? super GuildFreeGiftView$initGiftCountView$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFreeGiftView;
        this.$giftInfo = aVar;
        this.$progress = f16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFreeGiftView$initGiftCountView$1(this.this$0, this.$giftInfo, this.$progress, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object O;
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
            this.this$0.mIsCheckRspReady = false;
            Logger.f235387a.d().i("GuildFreeGiftView", 1, "[initGiftCountView] start progress");
            float f16 = this.$progress;
            this.label = 1;
            O = this.this$0.O(this.$giftInfo.getFreeGiftCountDownSecond() * 1000, f16, this);
            if (O == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFreeGiftView$initGiftCountView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
