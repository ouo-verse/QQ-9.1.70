package com.tencent.mobileqq.guild.live.livemanager.gift;

import com.tencent.mobileqq.guild.gift.module.n;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.live.livemanager.gift.LiveGiftReceivePushModule$receiveGiftMessage$job$1", f = "LiveGiftReceivePushModule.kt", i = {1}, l = {67, 68}, m = "invokeSuspend", n = {"senderTinyId"}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class LiveGiftReceivePushModule$receiveGiftMessage$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GiftMessage $giftMessage;
    final /* synthetic */ int $seq;
    Object L$0;
    int label;
    final /* synthetic */ LiveGiftReceivePushModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftReceivePushModule$receiveGiftMessage$job$1(GiftMessage giftMessage, LiveGiftReceivePushModule liveGiftReceivePushModule, int i3, Continuation<? super LiveGiftReceivePushModule$receiveGiftMessage$job$1> continuation) {
        super(2, continuation);
        this.$giftMessage = giftMessage;
        this.this$0 = liveGiftReceivePushModule;
        this.$seq = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LiveGiftReceivePushModule$receiveGiftMessage$job$1(this.$giftMessage, this.this$0, this.$seq, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Long l3;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a g16;
        boolean m3;
        n nVar;
        HashMap hashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    l3 = (Long) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    g16 = this.this$0.g(l3, (Long) obj, this.$giftMessage);
                    m3 = this.this$0.m(this.$giftMessage.sender);
                    if (!m3 || this.$giftMessage.effectLevel != 1) {
                        z16 = false;
                    }
                    nVar = this.this$0.listener;
                    if (nVar != null) {
                        nVar.b(g16, this.$giftMessage, m3, z16);
                    }
                    hashMap = this.this$0.handleJobs;
                    hashMap.remove(Boxing.boxInt(this.$seq));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            g gVar = g.f226846a;
            long j3 = this.$giftMessage.sender;
            this.label = 1;
            obj = gVar.d(j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Long l16 = (Long) obj;
        g gVar2 = g.f226846a;
        long j16 = this.$giftMessage.receiver;
        this.L$0 = l16;
        this.label = 2;
        Object d16 = gVar2.d(j16, this);
        if (d16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        l3 = l16;
        obj = d16;
        g16 = this.this$0.g(l3, (Long) obj, this.$giftMessage);
        m3 = this.this$0.m(this.$giftMessage.sender);
        if (!m3) {
        }
        z16 = false;
        nVar = this.this$0.listener;
        if (nVar != null) {
        }
        hashMap = this.this$0.handleJobs;
        hashMap.remove(Boxing.boxInt(this.$seq));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LiveGiftReceivePushModule$receiveGiftMessage$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
