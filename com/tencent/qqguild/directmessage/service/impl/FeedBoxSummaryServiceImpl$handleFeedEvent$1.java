package com.tencent.qqguild.directmessage.service.impl;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl;
import com.tencent.qqnt.msg.data.FeedsBoxEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl$handleFeedEvent$1", f = "FeedBoxSummaryServiceImpl.kt", i = {0}, l = {124, 156}, m = "invokeSuspend", n = {"calculatedEvent"}, s = {"L$0"})
/* loaded from: classes22.dex */
public final class FeedBoxSummaryServiceImpl$handleFeedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedsBoxEvent $event;
    Object L$0;
    int label;
    final /* synthetic */ FeedBoxSummaryServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl$handleFeedEvent$1$1", f = "FeedBoxSummaryServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl$handleFeedEvent$1$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<FeedsBoxEvent> $calculatedEvent;
        final /* synthetic */ FeedsBoxEvent $event;
        int label;
        final /* synthetic */ FeedBoxSummaryServiceImpl this$0;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.qqguild.directmessage.service.impl.FeedBoxSummaryServiceImpl$handleFeedEvent$1$1$a */
        /* loaded from: classes22.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f345171a;

            static {
                int[] iArr = new int[FeedsBoxEvent.FromType.values().length];
                try {
                    iArr[FeedsBoxEvent.FromType.FIRST_VIEW_INIT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FeedsBoxEvent.FromType.UPDATE_EVENT_PUSH.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FeedsBoxEvent.FromType.READ_EVENT_PUSH.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FeedsBoxEvent.FromType.NOTIFY_SWITCH_PUSH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f345171a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FeedsBoxEvent feedsBoxEvent, FeedBoxSummaryServiceImpl feedBoxSummaryServiceImpl, Ref.ObjectRef<FeedsBoxEvent> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = feedsBoxEvent;
            this.this$0 = feedBoxSummaryServiceImpl;
            this.$calculatedEvent = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$event, this.this$0, this.$calculatedEvent, continuation);
        }

        /* JADX WARN: Type inference failed for: r13v3, types: [com.tencent.qqnt.msg.data.FeedsBoxEvent, T] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            FeedBoxSummaryServiceImpl.FeedBoxUnreadStore feedBoxUnreadStore;
            FeedBoxSummaryServiceImpl.FeedBoxUnreadStore feedBoxUnreadStore2;
            String determineSummary;
            long determineLastEventTime;
            FeedBoxSummaryServiceImpl.FeedBoxUnreadStore feedBoxUnreadStore3;
            FeedsBoxEvent feedsBoxEvent;
            FeedBoxSummaryServiceImpl.FeedBoxUnreadStore feedBoxUnreadStore4;
            FeedsBoxEvent feedsBoxEvent2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = this.$event.c();
                Logger logger = Logger.f235387a;
                FeedsBoxEvent feedsBoxEvent3 = this.$event;
                logger.d().i(FeedBoxSummaryServiceImpl.TAG, 1, "handleFeedEvent: fromType " + feedsBoxEvent3.d());
                int i3 = a.f345171a[this.$event.d().ordinal()];
                if (i3 == 1) {
                    feedBoxUnreadStore = this.this$0.feedBoxUnreadStore;
                    feedBoxUnreadStore.h(this.$event.h(), this.$event.e());
                } else if (i3 == 2) {
                    feedBoxUnreadStore3 = this.this$0.feedBoxUnreadStore;
                    feedBoxUnreadStore3.d(this.$event.f(), this.$event.e());
                    feedsBoxEvent = this.this$0.latestFeedsBoxEvent;
                    if (feedsBoxEvent != null) {
                        intRef.element = feedsBoxEvent.c();
                    }
                } else if (i3 == 3) {
                    feedBoxUnreadStore4 = this.this$0.feedBoxUnreadStore;
                    feedBoxUnreadStore4.e(this.$event.e());
                    feedsBoxEvent2 = this.this$0.latestFeedsBoxEvent;
                    if (feedsBoxEvent2 != null) {
                        intRef.element = feedsBoxEvent2.c();
                    }
                } else if (i3 != 4) {
                    s.f(FeedBoxSummaryServiceImpl.TAG, "unreachable", new IllegalStateException());
                }
                Ref.ObjectRef<FeedsBoxEvent> objectRef = this.$calculatedEvent;
                FeedsBoxEvent feedsBoxEvent4 = this.$event;
                feedBoxUnreadStore2 = this.this$0.feedBoxUnreadStore;
                int g16 = feedBoxUnreadStore2.g();
                determineSummary = this.this$0.determineSummary(this.$event);
                determineLastEventTime = this.this$0.determineLastEventTime(this.$event);
                ?? b16 = FeedsBoxEvent.b(feedsBoxEvent4, false, g16, determineSummary, determineLastEventTime, null, null, intRef.element, 49, null);
                this.this$0.latestFeedsBoxEvent = b16;
                objectRef.element = b16;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBoxSummaryServiceImpl$handleFeedEvent$1(FeedBoxSummaryServiceImpl feedBoxSummaryServiceImpl, FeedsBoxEvent feedsBoxEvent, Continuation<? super FeedBoxSummaryServiceImpl$handleFeedEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = feedBoxSummaryServiceImpl;
        this.$event = feedsBoxEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedBoxSummaryServiceImpl$handleFeedEvent$1(this.this$0, this.$event, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        Object dispatchEventOnMainThread;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            objectRef = new Ref.ObjectRef();
            executorCoroutineDispatcher = this.this$0.feedBoxStoreDispatcher;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$event, this.this$0, objectRef, null);
            this.L$0 = objectRef;
            this.label = 1;
            if (BuildersKt.withContext(executorCoroutineDispatcher, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        FeedBoxSummaryServiceImpl feedBoxSummaryServiceImpl = this.this$0;
        FeedsBoxEvent feedsBoxEvent = (FeedsBoxEvent) objectRef.element;
        this.L$0 = null;
        this.label = 2;
        dispatchEventOnMainThread = feedBoxSummaryServiceImpl.dispatchEventOnMainThread(feedsBoxEvent, this);
        if (dispatchEventOnMainThread == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedBoxSummaryServiceImpl$handleFeedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
