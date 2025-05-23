package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1<T> implements FlowCollector<T> {
    final /* synthetic */ CoroutineScope $$this$flowScope$inlined;
    final /* synthetic */ FlowCollector $collector$inlined;
    final /* synthetic */ Ref.ObjectRef $previousFlow$inlined;
    final /* synthetic */ ChannelFlowTransformLatest this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1", f = "Merge.kt", i = {0, 0}, l = {137}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(Ref.ObjectRef objectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector) {
        this.$previousFlow$inlined = objectRef;
        this.$$this$flowScope$inlined = coroutineScope;
        this.this$0 = channelFlowTransformLatest;
        this.$collector$inlined = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1<T> channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1;
        Job launch$default;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i16 = anonymousClass1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        t16 = (T) anonymousClass1.L$1;
                        channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = (ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Job job = (Job) this.$previousFlow$inlined.element;
                    if (job != null) {
                        job.cancel((CancellationException) new ChildCancelledException());
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = t16;
                        anonymousClass1.L$2 = job;
                        anonymousClass1.label = 1;
                        if (job.join(anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 = this;
                }
                Ref.ObjectRef objectRef = channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.$previousFlow$inlined;
                launch$default = BuildersKt__Builders_commonKt.launch$default(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.$$this$flowScope$inlined, null, CoroutineStart.UNDISPATCHED, new ChannelFlowTransformLatest$flowCollect$3$1$2(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.this$0, channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.$collector$inlined, t16, null), 1, null);
                objectRef.element = (T) launch$default;
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
        Ref.ObjectRef objectRef2 = channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.$previousFlow$inlined;
        launch$default = BuildersKt__Builders_commonKt.launch$default(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.$$this$flowScope$inlined, null, CoroutineStart.UNDISPATCHED, new ChannelFlowTransformLatest$flowCollect$3$1$2(channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.this$0, channelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1.$collector$inlined, t16, null), 1, null);
        objectRef2.element = (T) launch$default;
        return Unit.INSTANCE;
    }
}
