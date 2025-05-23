package com.tencent.ecommerce.base.ktx;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "com/tencent/ecommerce/base/ktx/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1 implements LifecycleEventObserver {
    final /* synthetic */ Ref.ObjectRef C;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lifecycle.Event f100728d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Mutex f100729e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Lifecycle.Event f100730f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation f100731h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1 f100732i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f100733m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/base/ktx/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {0, 1}, l = {191, 101}, m = "invokeSuspend", n = {"$this$withLock$iv", "$this$withLock$iv"}, s = {"L$0", "L$0"})
    /* renamed from: com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/base/ktx/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", "com/tencent/ecommerce/base/ktx/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$invokeSuspend$$inlined$withLock$lambda$1"}, k = 3, mv = {1, 4, 1})
        @DebugMetadata(c = "com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes32.dex */
        public static final class C10291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnonymousClass1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C10291(Continuation continuation, AnonymousClass1 anonymousClass1) {
                super(2, continuation);
                this.this$0 = anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C10291 c10291 = new C10291(continuation, this.this$0);
                c10291.L$0 = obj;
                return c10291;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C10291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Function2 function2 = RepeatOnLifecycleKt$repeatOnLifecycle$3.this.$block;
                    this.label = 1;
                    InlineMarker.mark(6);
                    InlineMarker.mark(6);
                    Object invoke = function2.invoke(coroutineScope, this);
                    InlineMarker.mark(7);
                    InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Mutex mutex;
            Mutex mutex2;
            Throwable th5;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1.this.f100729e;
                    this.L$0 = mutex;
                    this.label = 1;
                    if (mutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            mutex2 = (Mutex) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            } catch (Throwable th6) {
                                th5 = th6;
                                mutex2.unlock(null);
                                throw th5;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Mutex mutex3 = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                }
                C10291 c10291 = new C10291(null, this);
                this.L$0 = mutex;
                this.label = 2;
                if (CoroutineScopeKt.coroutineScope(c10291, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th7) {
                mutex2 = mutex;
                th5 = th7;
                mutex2.unlock(null);
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1(Lifecycle.Event event, Mutex mutex, Lifecycle.Event event2, CancellableContinuation cancellableContinuation, RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1 anonymousClass1, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.f100728d = event;
        this.f100729e = mutex;
        this.f100730f = event2;
        this.f100731h = cancellableContinuation;
        this.f100732i = anonymousClass1;
        this.f100733m = objectRef;
        this.C = objectRef2;
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [T, kotlinx.coroutines.Job] */
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ?? launch$default;
        if (event == this.f100728d) {
            Ref.ObjectRef objectRef = this.C;
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.f100732i.$this_coroutineScope, null, null, new AnonymousClass1(null), 3, null);
            objectRef.element = launch$default;
            return;
        }
        if (event == this.f100730f) {
            Job job = (Job) this.C.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.C.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f100731h.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
        }
    }
}
