package com.tencent.mobileqq.guild.channellist;

import com.tencent.mobileqq.guild.channellist.process.ItemsProcessEvent;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/guild/channellist/process/b;", "", "e", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$4", f = "ChannelListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class ChannelListViewModel$collectProcessorEventSource$4 extends SuspendLambda implements Function3<FlowCollector<? super ItemsProcessEvent<?>>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListViewModel$collectProcessorEventSource$4(ChannelListViewModel channelListViewModel, Continuation<? super ChannelListViewModel$collectProcessorEventSource$4> continuation) {
        super(3, continuation);
        this.this$0 = channelListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Job job;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th5 = (Throwable) this.L$0;
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "collectProcessorEventSource error, " + th5;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.subFrag.ChannelListViewModel", 1, (String) it.next(), null);
            }
            com.tencent.mobileqq.guild.util.s.e("Guild.NewHome.subFrag.ChannelListViewModel", "GuildSubChannelList", th5);
            job = this.this$0.collectJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super ItemsProcessEvent<?>> flowCollector, @NotNull Throwable th5, @Nullable Continuation<? super Unit> continuation) {
        ChannelListViewModel$collectProcessorEventSource$4 channelListViewModel$collectProcessorEventSource$4 = new ChannelListViewModel$collectProcessorEventSource$4(this.this$0, continuation);
        channelListViewModel$collectProcessorEventSource$4.L$0 = th5;
        return channelListViewModel$collectProcessorEventSource$4.invokeSuspend(Unit.INSTANCE);
    }
}
