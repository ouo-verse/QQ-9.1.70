package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.api.impl.GuildGProServiceImpl$getGuildInfo$1$job$1", f = "GuildGProServiceImpl.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class GuildGProServiceImpl$getGuildInfo$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<IGProGuildInfo> $$this$callbackFlow;
    final /* synthetic */ String $guildId;
    int label;
    final /* synthetic */ GuildGProServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildGProServiceImpl$getGuildInfo$1$job$1(GuildGProServiceImpl guildGProServiceImpl, String str, ProducerScope<? super IGProGuildInfo> producerScope, Continuation<? super GuildGProServiceImpl$getGuildInfo$1$job$1> continuation) {
        super(2, continuation);
        this.this$0 = guildGProServiceImpl;
        this.$guildId = str;
        this.$$this$callbackFlow = producerScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, int i3, String str, IGProGuildInfo iGProGuildInfo) {
        ChannelsKt.trySendBlocking(producerScope, iGProGuildInfo);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildGProServiceImpl$getGuildInfo$1$job$1(this.this$0, this.$guildId, this.$$this$callbackFlow, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IGPSService gproService;
        IGPSService gproService2;
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
            CompletableDeferred completableDeferred = this.this$0.isReady;
            this.label = 1;
            if (completableDeferred.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        gproService = this.this$0.getGproService();
        IGProGuildInfo guildInfo = gproService.getGuildInfo(this.$guildId);
        if (guildInfo == null) {
            gproService2 = this.this$0.getGproService();
            String str = this.$guildId;
            final ProducerScope<IGProGuildInfo> producerScope = this.$$this$callbackFlow;
            gproService2.fetchGuildInfoOnly(str, 99, new vh2.v() { // from class: com.tencent.mobileqq.guild.api.impl.m
                @Override // vh2.v
                public final void a(int i16, String str2, IGProGuildInfo iGProGuildInfo) {
                    GuildGProServiceImpl$getGuildInfo$1$job$1.b(ProducerScope.this, i16, str2, iGProGuildInfo);
                }
            });
            return Unit.INSTANCE;
        }
        ChannelsKt.trySendBlocking(this.$$this$callbackFlow, guildInfo);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildGProServiceImpl$getGuildInfo$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
