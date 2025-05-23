package com.tencent.qqnt.aio.helper;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.helper.AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1", f = "AIOAnimationHelper.kt", i = {0}, l = {69, 74}, m = "invokeSuspend", n = {"isDragonKing"}, s = {"L$0"})
/* loaded from: classes34.dex */
final class AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $memberUin;
    final /* synthetic */ String $troopUin;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.helper.AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1$1", f = "AIOAnimationHelper.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.helper.AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $isDragonKing;
        final /* synthetic */ String $memberUin;
        final /* synthetic */ String $troopUin;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.BooleanRef booleanRef, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isDragonKing = booleanRef;
            this.$troopUin = str;
            this.$memberUin = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isDragonKing, this.$troopUin, this.$memberUin, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Ref.BooleanRef booleanRef;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef2 = this.$isDragonKing;
                fn fnVar = fn.f350874a;
                String str = this.$troopUin;
                String str2 = this.$memberUin;
                this.L$0 = booleanRef2;
                this.label = 1;
                Object a16 = fnVar.a(str, str2, this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
                obj = a16;
            } else if (i3 == 1) {
                booleanRef = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef.element = ((Boolean) obj).booleanValue();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.helper.AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1$2", f = "AIOAnimationHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.helper.AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ Ref.BooleanRef $isDragonKing;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Boolean, Unit> function1, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$isDragonKing = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$callback, this.$isDragonKing, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(Boxing.boxBoolean(this.$isDragonKing.element));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1(String str, String str2, Function1<? super Boolean, Unit> function1, Continuation<? super AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1> continuation) {
        super(2, continuation);
        this.$troopUin = str;
        this.$memberUin = str2;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1(this.$troopUin, this.$memberUin, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Ref.BooleanRef booleanRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            booleanRef = new Ref.BooleanRef();
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanRef, this.$troopUin, this.$memberUin, null);
            this.L$0 = booleanRef;
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, booleanRef, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
