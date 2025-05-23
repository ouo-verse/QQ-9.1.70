package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.PausingDispatcherKt;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartMsgIntent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1", f = "FeedSquareListWorkerDelegate.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Flow $this_collectWithLifecycle;
    int label;
    final /* synthetic */ FeedSquareListWorkerDelegate this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1$1", f = "FeedSquareListWorkerDelegate.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow $this_collectWithLifecycle;
        int label;
        final /* synthetic */ FeedSquareListWorkerDelegate this$0;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1$1$a */
        /* loaded from: classes13.dex */
        public static final class a implements FlowCollector<FeedSectionListPartMsgIntent.OnScrolledChangeMsgIntent> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FeedSquareListWorkerDelegate f219036d;

            public a(FeedSquareListWorkerDelegate feedSquareListWorkerDelegate) {
                this.f219036d = feedSquareListWorkerDelegate;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(FeedSectionListPartMsgIntent.OnScrolledChangeMsgIntent onScrolledChangeMsgIntent, @NotNull Continuation continuation) {
                this.f219036d.H(onScrolledChangeMsgIntent);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow flow, Continuation continuation, FeedSquareListWorkerDelegate feedSquareListWorkerDelegate) {
            super(2, continuation);
            this.$this_collectWithLifecycle = flow;
            this.this$0 = feedSquareListWorkerDelegate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_collectWithLifecycle, continuation, this.this$0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
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
                Flow flow = this.$this_collectWithLifecycle;
                a aVar = new a(this.this$0);
                this.label = 1;
                if (flow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1(Lifecycle lifecycle, Lifecycle.State state, Flow flow, Continuation continuation, FeedSquareListWorkerDelegate feedSquareListWorkerDelegate) {
        super(2, continuation);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$this_collectWithLifecycle = flow;
        this.this$0 = feedSquareListWorkerDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1(this.$lifecycle, this.$minActiveState, this.$this_collectWithLifecycle, continuation, this.this$0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$minActiveState;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_collectWithLifecycle, null, this.this$0);
            this.label = 1;
            if (PausingDispatcherKt.whenStateAtLeast(lifecycle, state, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
