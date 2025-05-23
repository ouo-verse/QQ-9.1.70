package com.tencent.mobileqq.zplan.minixwconnected;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedEntrance$showEntrance$1", f = "MiniHomeConnectedEntrance.kt", i = {0, 1}, l = {77, 35, 44}, m = "invokeSuspend", n = {"show", "show"}, s = {"L$0", "L$0"})
/* loaded from: classes34.dex */
public final class MiniHomeConnectedEntrance$showEntrance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ long $friendUin;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedEntrance$showEntrance$1$1", f = "MiniHomeConnectedEntrance.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedEntrance$showEntrance$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ Ref.BooleanRef $show;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Boolean, Unit> function1, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$show = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$show, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(Boxing.boxBoolean(this.$show.element));
                QLog.w("MiniHomeConnectedEntrance", 1, "showEntrance result=" + this.$show.element + ".");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MiniHomeConnectedEntrance$showEntrance$1(long j3, Function1<? super Boolean, Unit> function1, Continuation<? super MiniHomeConnectedEntrance$showEntrance$1> continuation) {
        super(2, continuation);
        this.$friendUin = j3;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeConnectedEntrance$showEntrance$1(this.$friendUin, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
        Ref.BooleanRef booleanRef;
        MainCoroutineDispatcher main;
        AnonymousClass1 anonymousClass1;
        v45.b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            MiniHomeConnectedEntrance miniHomeConnectedEntrance = MiniHomeConnectedEntrance.f334439a;
            this.L$0 = booleanRef2;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            MiniHomeConnectedPermissions.f334440a.a(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedEntrance$allow$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            obj = result;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                bVar = (v45.b) obj;
                if (bVar != null) {
                    return Unit.INSTANCE;
                }
                if (bVar.f440971a) {
                    booleanRef.element = true;
                }
                main = Dispatchers.getMain();
                anonymousClass1 = new AnonymousClass1(this.$callback, booleanRef, null);
                this.L$0 = null;
                this.label = 3;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            MiniHomeConnectedEntrance miniHomeConnectedEntrance2 = MiniHomeConnectedEntrance.f334439a;
            long j3 = this.$friendUin;
            this.L$0 = booleanRef;
            this.label = 2;
            obj = miniHomeConnectedEntrance2.b(j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = (v45.b) obj;
            if (bVar != null) {
            }
        }
        main = Dispatchers.getMain();
        anonymousClass1 = new AnonymousClass1(this.$callback, booleanRef, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeConnectedEntrance$showEntrance$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
