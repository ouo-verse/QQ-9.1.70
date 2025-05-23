package androidx.lifecycle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {91, 95, 96}, m = "invokeSuspend", n = {"$this$flow", WadlProxyConsts.CHANNEL, "observer", "$this$flow", WadlProxyConsts.CHANNEL, "observer", "$this$flow", WadlProxyConsts.CHANNEL, "observer", "value"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes.dex */
public final class FlowLiveDataConversions$asFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveData $this_asFlow;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private FlowCollector p$;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Observer $observer;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Observer observer, Continuation continuation) {
            super(2, continuation);
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, completion);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowLiveDataConversions$asFlow$1.this.$this_asFlow.observeForever(this.$observer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Observer $observer;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Observer observer, Continuation continuation) {
            super(2, continuation);
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$observer, completion);
            anonymousClass2.p$ = (CoroutineScope) obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowLiveDataConversions$asFlow$1.this.$this_asFlow.removeObserver(this.$observer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, completion);
        flowLiveDataConversions$asFlow$1.p$ = (FlowCollector) obj;
        return flowLiveDataConversions$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowLiveDataConversions$asFlow$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(4:(1:(2:33|(1:(7:36|37|38|39|8|9|(1:11)(4:13|14|15|(2:17|(1:20)(4:19|8|9|(0)(0)))(2:21|22)))(2:40|41))(6:42|43|44|14|15|(0)(0)))(1:4))(2:47|(1:49)(1:50))|8|9|(0)(0))|5|6|7|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ea, code lost:
    
        r9 = r17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b6 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #1 {all -> 0x00e5, blocks: (B:15:0x00ae, B:17:0x00b6), top: B:14:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cd  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.lifecycle.Observer] */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.lifecycle.Observer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        Channel channel;
        Observer<T> observer;
        FlowLiveDataConversions$asFlow$1<T> flowLiveDataConversions$asFlow$1;
        Throwable th5;
        Object obj2;
        ?? r85;
        Channel channel2;
        ChannelIterator channelIterator;
        ChannelIterator channelIterator2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        ?? r56 = 1;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    try {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ChannelIterator channelIterator3 = (ChannelIterator) this.L$4;
                                Observer<T> observer2 = (Observer) this.L$2;
                                Channel channel3 = (Channel) this.L$1;
                                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                flowLiveDataConversions$asFlow$1 = this;
                                channelIterator2 = channelIterator3;
                                observer = observer2;
                                channel = channel3;
                                flowCollector = flowCollector2;
                                flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                                flowLiveDataConversions$asFlow$1.L$1 = channel;
                                flowLiveDataConversions$asFlow$1.L$2 = observer;
                                flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
                                flowLiveDataConversions$asFlow$1.label = 2;
                                obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Channel channel4 = channel;
                                r56 = observer;
                                channelIterator = channelIterator2;
                                r85 = flowCollector;
                                channel2 = channel4;
                                try {
                                    if (((Boolean) obj2).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r56, null), 2, null);
                                        return Unit.INSTANCE;
                                    }
                                    Object next = channelIterator.next();
                                    flowLiveDataConversions$asFlow$1.L$0 = r85;
                                    flowLiveDataConversions$asFlow$1.L$1 = channel2;
                                    flowLiveDataConversions$asFlow$1.L$2 = r56;
                                    flowLiveDataConversions$asFlow$1.L$3 = next;
                                    flowLiveDataConversions$asFlow$1.L$4 = channelIterator;
                                    flowLiveDataConversions$asFlow$1.label = 3;
                                    if (r85.emit(next, flowLiveDataConversions$asFlow$1) != coroutine_suspended) {
                                        FlowCollector flowCollector3 = r85;
                                        channelIterator2 = channelIterator;
                                        observer = r56;
                                        channel = channel2;
                                        flowCollector = flowCollector3;
                                        flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                                        flowLiveDataConversions$asFlow$1.L$1 = channel;
                                        flowLiveDataConversions$asFlow$1.L$2 = observer;
                                        flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
                                        flowLiveDataConversions$asFlow$1.label = 2;
                                        obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                                        if (obj2 == coroutine_suspended) {
                                        }
                                    } else {
                                        return coroutine_suspended;
                                    }
                                } catch (Throwable th6) {
                                    th5 = th6;
                                    BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r56, null), 2, null);
                                    throw th5;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            channelIterator = (ChannelIterator) this.L$3;
                            Observer observer3 = (Observer) this.L$2;
                            channel2 = (Channel) this.L$1;
                            FlowCollector flowCollector4 = (FlowCollector) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            obj2 = obj;
                            flowLiveDataConversions$asFlow$1 = this;
                            r56 = observer3;
                            r85 = flowCollector4;
                            if (((Boolean) obj2).booleanValue()) {
                            }
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        flowLiveDataConversions$asFlow$1 = this;
                        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r56, null), 2, null);
                        throw th5;
                    }
                } else {
                    observer = (Observer) this.L$2;
                    channel = (Channel) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = this.p$;
                final Channel Channel$default = ChannelKt.Channel$default(-1, null, null, 6, null);
                Observer<T> observer4 = new Observer<T>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(T t16) {
                        Channel.this.offer(t16);
                    }
                };
                MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(observer4, null);
                this.L$0 = flowCollector;
                this.L$1 = Channel$default;
                this.L$2 = observer4;
                this.label = 1;
                if (BuildersKt.withContext(immediate, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                channel = Channel$default;
                observer = observer4;
            }
            flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
            flowLiveDataConversions$asFlow$1.L$1 = channel;
            flowLiveDataConversions$asFlow$1.L$2 = observer;
            flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
            flowLiveDataConversions$asFlow$1.label = 2;
            obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
            if (obj2 == coroutine_suspended) {
            }
        } catch (Throwable th8) {
            th5 = th8;
            r56 = observer;
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r56, null), 2, null);
            throw th5;
        }
        channelIterator2 = channel.iterator();
        flowLiveDataConversions$asFlow$1 = this;
    }
}
