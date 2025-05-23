package com.tencent.mobileqq.guild.channellist;

import android.util.Log;
import com.tencent.mobileqq.guild.channellist.process.ItemsProcessEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/b;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$2", f = "ChannelListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class ChannelListViewModel$collectProcessorEventSource$2 extends SuspendLambda implements Function2<ItemsProcessEvent<?>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListViewModel$collectProcessorEventSource$2(ChannelListViewModel channelListViewModel, Continuation<? super ChannelListViewModel$collectProcessorEventSource$2> continuation) {
        super(2, continuation);
        this.this$0 = channelListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelListViewModel$collectProcessorEventSource$2 channelListViewModel$collectProcessorEventSource$2 = new ChannelListViewModel$collectProcessorEventSource$2(this.this$0, continuation);
        channelListViewModel$collectProcessorEventSource$2.L$0 = obj;
        return channelListViewModel$collectProcessorEventSource$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ItemsProcessEvent<?> itemsProcessEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelListViewModel$collectProcessorEventSource$2) create(itemsProcessEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ItemsProcessEvent itemsProcessEvent = (ItemsProcessEvent) this.L$0;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.ChannelListViewModel", "updating items for " + itemsProcessEvent);
            }
            Iterator it = itemsProcessEvent.a().iterator();
            while (it.hasNext()) {
                this.this$0.D2(itemsProcessEvent, (Pair) it.next());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
