package com.tencent.mobileqq.guild.home.viewmodels.header;

import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/c;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel$collectProcessorEventSource$3", f = "GuildHomeHeaderBarsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderBarsViewModel$collectProcessorEventSource$3 extends SuspendLambda implements Function3<FlowCollector<? super com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<?>>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildHomeHeaderBarsViewModel$collectProcessorEventSource$3(Continuation<? super GuildHomeHeaderBarsViewModel$collectProcessorEventSource$3> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String stackTraceToString;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th5 = (Throwable) this.L$0;
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th5);
            String str = "collectProcessorEventSource error " + th5 + " \n" + stackTraceToString;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildHomeHeaderBarsViewModel", 1, (String) it.next(), null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<?>> flowCollector, @NotNull Throwable th5, @Nullable Continuation<? super Unit> continuation) {
        GuildHomeHeaderBarsViewModel$collectProcessorEventSource$3 guildHomeHeaderBarsViewModel$collectProcessorEventSource$3 = new GuildHomeHeaderBarsViewModel$collectProcessorEventSource$3(continuation);
        guildHomeHeaderBarsViewModel$collectProcessorEventSource$3.L$0 = th5;
        return guildHomeHeaderBarsViewModel$collectProcessorEventSource$3.invokeSuspend(Unit.INSTANCE);
    }
}
