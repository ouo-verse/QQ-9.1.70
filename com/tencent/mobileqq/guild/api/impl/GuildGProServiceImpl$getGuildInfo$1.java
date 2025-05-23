package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.api.impl.GuildGProServiceImpl$getGuildInfo$1", f = "GuildGProServiceImpl.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class GuildGProServiceImpl$getGuildInfo$1 extends SuspendLambda implements Function2<ProducerScope<? super IGProGuildInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $guildId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildGProServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGProServiceImpl$getGuildInfo$1(GuildGProServiceImpl guildGProServiceImpl, String str, Continuation<? super GuildGProServiceImpl$getGuildInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = guildGProServiceImpl;
        this.$guildId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildGProServiceImpl$getGuildInfo$1 guildGProServiceImpl$getGuildInfo$1 = new GuildGProServiceImpl$getGuildInfo$1(this.this$0, this.$guildId, continuation);
        guildGProServiceImpl$getGuildInfo$1.L$0 = obj;
        return guildGProServiceImpl$getGuildInfo$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        final Deferred async$default;
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
            ProducerScope producerScope = (ProducerScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(producerScope, null, null, new GuildGProServiceImpl$getGuildInfo$1$job$1(this.this$0, this.$guildId, producerScope, null), 3, null);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.api.impl.GuildGProServiceImpl$getGuildInfo$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Job.DefaultImpls.cancel$default((Job) async$default, (CancellationException) null, 1, (Object) null);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super IGProGuildInfo> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildGProServiceImpl$getGuildInfo$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
