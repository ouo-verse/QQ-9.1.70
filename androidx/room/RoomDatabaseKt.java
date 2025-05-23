package androidx.room;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.ThreadContextElementKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001a9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", BdhLogUtil.LogTag.Tag_Req, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RoomDatabaseKt {
    static final /* synthetic */ Object acquireTransactionThread(final Executor executor, final Job job, Continuation<? super ContinuationInterceptor> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        });
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2

                /* compiled from: P */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/room/RoomDatabaseKt$acquireTransactionThread$2$2$1"}, k = 3, mv = {1, 4, 2})
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabase.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    private /* synthetic */ Object L$0;
                    int label;

                    AnonymousClass1(Continuation continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                        Intrinsics.checkNotNullParameter(completion, "completion");
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                            CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                            CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                            Intrinsics.checkNotNull(element);
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(element));
                            Job job = job;
                            this.label = 1;
                            if (job.join(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
                }
            });
        } catch (RejectedExecutionException e16) {
            cancellableContinuationImpl.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e16));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object createTransactionContext(RoomDatabase roomDatabase, Continuation<? super CoroutineContext> continuation) {
        RoomDatabaseKt$createTransactionContext$1 roomDatabaseKt$createTransactionContext$1;
        Object coroutine_suspended;
        int i3;
        final CompletableJob Job$default;
        RoomDatabase roomDatabase2;
        CompletableJob completableJob;
        if (continuation instanceof RoomDatabaseKt$createTransactionContext$1) {
            roomDatabaseKt$createTransactionContext$1 = (RoomDatabaseKt$createTransactionContext$1) continuation;
            int i16 = roomDatabaseKt$createTransactionContext$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                roomDatabaseKt$createTransactionContext$1.label = i16 - Integer.MIN_VALUE;
                Object obj = roomDatabaseKt$createTransactionContext$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = roomDatabaseKt$createTransactionContext$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        completableJob = (CompletableJob) roomDatabaseKt$createTransactionContext$1.L$1;
                        roomDatabase2 = (RoomDatabase) roomDatabaseKt$createTransactionContext$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    Job job = (Job) roomDatabaseKt$createTransactionContext$1.get$context().get(Job.INSTANCE);
                    if (job != null) {
                        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$createTransactionContext$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@Nullable Throwable th5) {
                                Job.DefaultImpls.cancel$default((Job) CompletableJob.this, (CancellationException) null, 1, (Object) null);
                            }
                        });
                    }
                    Executor transactionExecutor = roomDatabase.getTransactionExecutor();
                    Intrinsics.checkNotNullExpressionValue(transactionExecutor, "transactionExecutor");
                    roomDatabaseKt$createTransactionContext$1.L$0 = roomDatabase;
                    roomDatabaseKt$createTransactionContext$1.L$1 = Job$default;
                    roomDatabaseKt$createTransactionContext$1.label = 1;
                    Object acquireTransactionThread = acquireTransactionThread(transactionExecutor, Job$default, roomDatabaseKt$createTransactionContext$1);
                    if (acquireTransactionThread == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    roomDatabase2 = roomDatabase;
                    completableJob = Job$default;
                    obj = acquireTransactionThread;
                }
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) obj;
                TransactionElement transactionElement = new TransactionElement(completableJob, continuationInterceptor);
                ThreadLocal<Integer> suspendingTransactionId = roomDatabase2.getSuspendingTransactionId();
                Intrinsics.checkNotNullExpressionValue(suspendingTransactionId, "suspendingTransactionId");
                return continuationInterceptor.plus(transactionElement).plus(ThreadContextElementKt.asContextElement(suspendingTransactionId, Boxing.boxInt(System.identityHashCode(completableJob))));
            }
        }
        roomDatabaseKt$createTransactionContext$1 = new RoomDatabaseKt$createTransactionContext$1(continuation);
        Object obj2 = roomDatabaseKt$createTransactionContext$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = roomDatabaseKt$createTransactionContext$1.label;
        if (i3 == 0) {
        }
        ContinuationInterceptor continuationInterceptor2 = (ContinuationInterceptor) obj2;
        TransactionElement transactionElement2 = new TransactionElement(completableJob, continuationInterceptor2);
        ThreadLocal<Integer> suspendingTransactionId2 = roomDatabase2.getSuspendingTransactionId();
        Intrinsics.checkNotNullExpressionValue(suspendingTransactionId2, "suspendingTransactionId");
        return continuationInterceptor2.plus(transactionElement2).plus(ThreadContextElementKt.asContextElement(suspendingTransactionId2, Boxing.boxInt(System.identityHashCode(completableJob))));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c A[PHI: r7
  0x007c: PHI (r7v11 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:18:0x0079, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withTransaction(@NotNull RoomDatabase roomDatabase, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1, @NotNull Continuation<? super R> continuation) {
        RoomDatabaseKt$withTransaction$1 roomDatabaseKt$withTransaction$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof RoomDatabaseKt$withTransaction$1) {
            roomDatabaseKt$withTransaction$1 = (RoomDatabaseKt$withTransaction$1) continuation;
            int i16 = roomDatabaseKt$withTransaction$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                roomDatabaseKt$withTransaction$1.label = i16 - Integer.MIN_VALUE;
                obj = roomDatabaseKt$withTransaction$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = roomDatabaseKt$withTransaction$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) roomDatabaseKt$withTransaction$1.L$1;
                    roomDatabase = (RoomDatabase) roomDatabaseKt$withTransaction$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    TransactionElement transactionElement = (TransactionElement) roomDatabaseKt$withTransaction$1.get$context().get(TransactionElement.INSTANCE);
                    if (transactionElement == null || (r7 = transactionElement.getTransactionDispatcher()) == null) {
                        roomDatabaseKt$withTransaction$1.L$0 = roomDatabase;
                        roomDatabaseKt$withTransaction$1.L$1 = function1;
                        roomDatabaseKt$withTransaction$1.label = 1;
                        obj = createTransactionContext(roomDatabase, roomDatabaseKt$withTransaction$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2(roomDatabase, function1, null);
                    roomDatabaseKt$withTransaction$1.L$0 = null;
                    roomDatabaseKt$withTransaction$1.L$1 = null;
                    roomDatabaseKt$withTransaction$1.label = 2;
                    obj = BuildersKt.withContext(r7, roomDatabaseKt$withTransaction$2, roomDatabaseKt$withTransaction$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                CoroutineContext transactionDispatcher = (CoroutineContext) obj;
                RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$22 = new RoomDatabaseKt$withTransaction$2(roomDatabase, function1, null);
                roomDatabaseKt$withTransaction$1.L$0 = null;
                roomDatabaseKt$withTransaction$1.L$1 = null;
                roomDatabaseKt$withTransaction$1.label = 2;
                obj = BuildersKt.withContext(transactionDispatcher, roomDatabaseKt$withTransaction$22, roomDatabaseKt$withTransaction$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        roomDatabaseKt$withTransaction$1 = new RoomDatabaseKt$withTransaction$1(continuation);
        obj = roomDatabaseKt$withTransaction$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = roomDatabaseKt$withTransaction$1.label;
        if (i3 == 0) {
        }
        CoroutineContext transactionDispatcher2 = (CoroutineContext) obj;
        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$222 = new RoomDatabaseKt$withTransaction$2(roomDatabase, function1, null);
        roomDatabaseKt$withTransaction$1.L$0 = null;
        roomDatabaseKt$withTransaction$1.L$1 = null;
        roomDatabaseKt$withTransaction$1.label = 2;
        obj = BuildersKt.withContext(transactionDispatcher2, roomDatabaseKt$withTransaction$222, roomDatabaseKt$withTransaction$1);
        if (obj == coroutine_suspended) {
        }
    }
}
