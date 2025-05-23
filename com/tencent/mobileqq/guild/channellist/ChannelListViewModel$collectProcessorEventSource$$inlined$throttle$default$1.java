package com.tencent.mobileqq.guild.channellist;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.guild.channellist.process.ItemsProcessEvent;
import com.tencent.mobileqq.guild.channellist.process.Processors;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1", f = "ChannelListViewModel.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class ChannelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1 extends SuspendLambda implements Function2<ItemsProcessEvent<?>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $fireTime;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1(Ref.LongRef longRef, Continuation continuation, ChannelListViewModel channelListViewModel) {
        super(2, continuation);
        this.$fireTime = longRef;
        this.this$0 = channelListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1 channelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1 = new ChannelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1(this.$fireTime, continuation, this.this$0);
        channelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1.L$0 = obj;
        return channelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Processors processors;
        boolean z16;
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
            Object obj2 = this.L$0;
            this.$fireTime.element = SystemClock.uptimeMillis();
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.ChannelListViewModel", "update list");
            }
            this.this$0.v2("collectProcessorEventSource");
            processors = this.this$0.processors;
            List<? extends c> list = this.this$0.channelList;
            z16 = this.this$0.firstTimeUpdate;
            this.label = 1;
            if (processors.e(list, z16, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(ItemsProcessEvent<?> itemsProcessEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1) create(itemsProcessEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
