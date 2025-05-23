package com.tencent.mobileqq.guild.home.viewmodels.header;

import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/c;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1", f = "GuildHomeHeaderBarsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<?>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildHomeHeaderBarsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1(GuildHomeHeaderBarsViewModel guildHomeHeaderBarsViewModel, Continuation<? super GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1> continuation) {
        super(2, continuation);
        this.this$0 = guildHomeHeaderBarsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1 guildHomeHeaderBarsViewModel$collectProcessorEventSource$1 = new GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1(this.this$0, continuation);
        guildHomeHeaderBarsViewModel$collectProcessorEventSource$1.L$0 = obj;
        return guildHomeHeaderBarsViewModel$collectProcessorEventSource$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.guild.home.viewmodels.header.processors.c<?> cVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildHomeHeaderBarsViewModel$collectProcessorEventSource$1) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m476constructorimpl;
        String stackTraceToString;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.mobileqq.guild.home.viewmodels.header.processors.c cVar = (com.tencent.mobileqq.guild.home.viewmodels.header.processors.c) this.L$0;
            GuildHomeHeaderBarsViewModel guildHomeHeaderBarsViewModel = this.this$0;
            try {
                Result.Companion companion = Result.INSTANCE;
                guildHomeHeaderBarsViewModel.f2(cVar);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                String str = "collectProcessorEventSource error. " + m479exceptionOrNullimpl + " " + stackTraceToString;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildHomeHeaderBarsViewModel", 1, (String) it.next(), null);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
