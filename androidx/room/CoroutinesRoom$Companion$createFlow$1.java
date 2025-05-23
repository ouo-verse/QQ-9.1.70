package androidx.room;

import androidx.room.InvalidationTracker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u0001H\u0002H\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {121, 123}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $flowContext;
        final /* synthetic */ Ref.ObjectRef $observer;
        final /* synthetic */ Channel $observerChannel;
        final /* synthetic */ FlowCollector $this_flow;
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00581(Ref.ObjectRef objectRef, Continuation continuation) {
                super(2, continuation);
                this.$result = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                Intrinsics.checkNotNullParameter(completion, "completion");
                return new C00581(this.$result, completion);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    FlowCollector flowCollector = AnonymousClass1.this.$this_flow;
                    T t16 = this.$result.element;
                    this.label = 1;
                    if (flowCollector.emit(t16, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlowCollector flowCollector, Ref.ObjectRef objectRef, Channel channel, Ref.ObjectRef objectRef2, Continuation continuation) {
            super(2, continuation);
            this.$this_flow = flowCollector;
            this.$observer = objectRef;
            this.$observerChannel = channel;
            this.$flowContext = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass1(this.$this_flow, this.$observer, this.$observerChannel, this.$flowContext, completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x005b A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #0 {all -> 0x009d, blocks: (B:11:0x0045, B:16:0x0053, B:18:0x005b), top: B:10:0x0045 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
        /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0087 -> B:10:0x0045). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            AnonymousClass1 anonymousClass1;
            ChannelIterator it;
            Object hasNext;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
            } catch (Throwable th5) {
                th = th5;
                anonymousClass1 = this;
            }
            try {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ChannelIterator channelIterator = (ChannelIterator) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            it = channelIterator;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ChannelIterator channelIterator2 = (ChannelIterator) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        ChannelIterator channelIterator3 = channelIterator2;
                        anonymousClass1 = this;
                        if (!((Boolean) obj).booleanValue()) {
                            Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            objectRef.element = CoroutinesRoom$Companion$createFlow$1.this.$callable.call();
                            CoroutineContext coroutineContext = (CoroutineContext) anonymousClass1.$flowContext.element;
                            C00581 c00581 = new C00581(objectRef, null);
                            anonymousClass1.L$0 = channelIterator3;
                            anonymousClass1.label = 2;
                            if (BuildersKt.withContext(coroutineContext, c00581, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it = channelIterator3;
                            anonymousClass1.L$0 = it;
                            anonymousClass1.label = 1;
                            hasNext = it.hasNext(anonymousClass1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channelIterator3 = it;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                CoroutinesRoom$Companion$createFlow$1.this.$db.getInvalidationTracker().removeObserver((CoroutinesRoom$Companion$createFlow$1$observer$1) anonymousClass1.$observer.element);
                                return Unit.INSTANCE;
                            }
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutinesRoom$Companion$createFlow$1.this.$db.getInvalidationTracker().addObserver((CoroutinesRoom$Companion$createFlow$1$observer$1) this.$observer.element);
                    it = this.$observerChannel.iterator();
                }
                anonymousClass1.L$0 = it;
                anonymousClass1.label = 1;
                hasNext = it.hasNext(anonymousClass1);
                if (hasNext != coroutine_suspended) {
                }
            } catch (Throwable th6) {
                th = th6;
                CoroutinesRoom$Companion$createFlow$1.this.$db.getInvalidationTracker().removeObserver((CoroutinesRoom$Companion$createFlow$1$observer$1) anonymousClass1.$observer.element);
                throw th;
            }
            anonymousClass1 = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(String[] strArr, boolean z16, RoomDatabase roomDatabase, Callable callable, Continuation continuation) {
        super(2, continuation);
        this.$tableNames = strArr;
        this.$inTransaction = z16;
        this.$db = roomDatabase;
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, completion);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [T, androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1] */
    /* JADX WARN: Type inference failed for: r11v5, types: [T, kotlin.coroutines.CoroutineContext] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ContinuationInterceptor queryDispatcher;
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
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            final Channel Channel$default = ChannelKt.Channel$default(-1, null, null, 6, null);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final String[] strArr = this.$tableNames;
            objectRef.element = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(@NotNull Set<String> tables) {
                    Intrinsics.checkNotNullParameter(tables, "tables");
                    Channel$default.offer(Unit.INSTANCE);
                }
            };
            Channel$default.offer(Unit.INSTANCE);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = get$context();
            TransactionElement transactionElement = (TransactionElement) get$context().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (queryDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                if (this.$inTransaction) {
                    queryDispatcher = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
                } else {
                    queryDispatcher = CoroutinesRoomKt.getQueryDispatcher(this.$db);
                }
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, objectRef, Channel$default, objectRef2, null);
            this.label = 1;
            if (BuildersKt.withContext(queryDispatcher, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
