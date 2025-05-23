package com.tencent.mobileqq.guild.home.viewmodels.header;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@"}, d2 = {"T", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1", f = "GuildHomeHeaderBarsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<?>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $fireTime;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildHomeHeaderBarsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1(Ref.LongRef longRef, Continuation continuation, GuildHomeHeaderBarsViewModel guildHomeHeaderBarsViewModel) {
        super(2, continuation);
        this.$fireTime = longRef;
        this.this$0 = guildHomeHeaderBarsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1 guildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1 = new GuildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1(this.$fireTime, continuation, this.this$0);
        guildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1.L$0 = obj;
        return guildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            this.$fireTime.element = SystemClock.uptimeMillis();
            GuildHomeHeaderBarsViewModel.h2(this.this$0, "collectProcessorEventSource", false, false, 4, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<?> cVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeHeaderBarsViewModel$collectProcessorEventSource$$inlined$throttle$default$1) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
